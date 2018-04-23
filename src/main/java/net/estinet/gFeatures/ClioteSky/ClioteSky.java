package net.estinet.gFeatures.ClioteSky;

import com.google.protobuf.ByteString;
import io.grpc.ConnectivityState;
import io.grpc.ManagedChannel;
import io.grpc.StatusRuntimeException;
import io.grpc.netty.shaded.io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;
import io.grpc.netty.shaded.io.netty.handler.ssl.SslProvider;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import net.estinet.gFeatures.API.Logger.Debug;
import net.estinet.gFeatures.FeatureState;
import net.estinet.gFeatures.Listeners;
import net.estinet.gFeatures.gFeatures;
import org.bukkit.Bukkit;

import javax.net.ssl.*;
import java.io.*;
import java.nio.file.Files;
import java.util.*;

public class ClioteSky {
    public static boolean enabled, checkTLS;

    private static String name, password, address, port, category;

    private static List<ClioteHook> clioteHookList = new ArrayList<>();

    private static ClioteSky clioteSky;

    public static ClioteSky getInstance() {
        return clioteSky;
    }

    public static void addHook(ClioteHook hook) {
        clioteHookList.add(hook);
    }

    /*
     * Called on enable of plugin.
     */

    public static void initClioteSky() {
        Bukkit.getLogger().info("Starting ClioteSky...");

        loadConfig();
        if (enabled) {
            clioteSky = new ClioteSky(address, Integer.parseInt(port));
            clioteSky.start();
            clioteSky.startEventLoop();
            Bukkit.getLogger().info("[ClioteSky] enabled!");
        }
    }

    private static void loadConfig() {
        Properties prop = new Properties();
        InputStream input = null;

        try {

            input = new FileInputStream("plugins/gFeatures/Config.yml");

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            ClioteSky.name = prop.getProperty("ClioteSky.Name");
            ClioteSky.category = prop.getProperty("ClioteSky.Category");
            ClioteSky.address = prop.getProperty("ClioteSky.Address");
            ClioteSky.enabled = Boolean.parseBoolean(prop.getProperty("ClioteSky.Enable"));
            ClioteSky.port = prop.getProperty("ClioteSky.Port");
            ClioteSky.checkTLS = Boolean.parseBoolean(prop.getProperty("ClioteSky.CheckTLS"));

            File f = new File("plugins/gFeatures/masterkey.key"); //get master key password
            if (f.exists()) {
                ClioteSky.password = new String(Files.readAllBytes(f.toPath()));
            } else {
                Bukkit.getLogger().info("No masterkey.key file found! Please add the key file.");
                f.createNewFile();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
     * String helpers
     */

    public static List<String> parseBytesToStringList(byte[] data) {
        try {
            return Arrays.asList(new String(data, "UTF-8").split(" "));//fix warning
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] stringToBytes(String str) {
        //lol
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
     * ClioteSky Object
     */

    public ManagedChannel channel;
    private ClioteSkyServiceGrpc.ClioteSkyServiceBlockingStub blockingStub;
    private ClioteSkyServiceGrpc.ClioteSkyServiceStub asyncStub;
    public boolean continueEventLoop = true;
    public boolean offline = false;

    private String authToken;

    public ClioteSky(String host, int port) {
        //this(ManagedChannelBuilder.forAddress(host, port));

        if(!checkTLS) {
            // Create all-trusting host name verifier
            HostnameVerifier allHostsValid = new HostnameVerifier() {
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            };
            // Install the all-trusting host verifier
            HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
            try {
                channel = NettyChannelBuilder.forAddress(host, port).useTransportSecurity().sslContext(GrpcSslContexts.forClient().sslProvider(SslProvider.OPENSSL).trustManager(InsecureTrustManagerFactory.INSTANCE).build()).build();
            } catch (SSLException e) {
                e.printStackTrace();
            }
        } else {
            channel = NettyChannelBuilder.forAddress(host, port).useTransportSecurity().build();
        }
        blockingStub = ClioteSkyServiceGrpc.newBlockingStub(channel);
        asyncStub = ClioteSkyServiceGrpc.newStub(channel);
    }

    /*
     * Authenticates with the server and obtains a new auth token
     */

    public void start() {
        offline = false;
        ClioteSkyRPC.AuthRequest req = ClioteSkyRPC.AuthRequest.newBuilder().setUser(name).setPassword(password).setCategory(category).build();
        try {
            boolean nameTaken = blockingStub.checkNameTaken(net.estinet.gFeatures.ClioteSky.ClioteSkyRPC.String.newBuilder().setStr(name).build()).getB();
            if (nameTaken) {
                Bukkit.getLogger().warning("ClioteSky name has already been taken. Be careful!");
            }
            authToken = blockingStub.auth(req).getToken();
            Bukkit.getLogger().info("[ClioteSky] Authenticated!");
        } catch (StatusRuntimeException e) {
            Bukkit.getLogger().severe("[ClioteSky] RPC failed: " + e.getStatus());
        }
        channel.notifyWhenStateChanged(ConnectivityState.READY, () -> {
            Bukkit.getLogger().warning("[ClioteSky] RPC state changed: " + channel.getState(true));
        });
    }

    /*
     * Async event loop to check if there are new messages
     */

    public void startEventLoop() {
        continueEventLoop = true;
        Runnable run = () -> {
            boolean speedup = false; //check for messages faster if a message was received
            int speedupCount = 0;

            while (continueEventLoop) {
                Iterator<ClioteSkyRPC.ClioteMessage> iterator;

                try {
                    iterator = blockingStub.request(ClioteSkyRPC.Token.newBuilder().setToken(authToken).build());

                    while (iterator.hasNext()) {
                        speedup = true;
                        speedupCount = 0;
                        ClioteSkyRPC.ClioteMessage m = iterator.next();

                        Debug.print("[ClioteSky] Received " + m.getIdentifier() + " identifier from " + m.getSender() + ". Contents: " + m.getData());

                        for (ClioteHook hook : clioteHookList) {
                            //check if cliotehook has matching identifier, and call
                            if (hook.identifier.equals(m.getIdentifier()) && gFeatures.getFeature(hook.gFeatureName).getState() == FeatureState.ENABLE) {
                                Bukkit.getScheduler().runTaskAsynchronously(Bukkit.getPluginManager().getPlugin("gFeatures"), () -> hook.run(m.getData().toByteArray(), m.getSender()));
                            }
                        }
                    }

                } catch (StatusRuntimeException e) {

                    boolean printError = true;

                    if (e.getStatus().getDescription().equals("io exception")) {
                        if (!offline) {
                            Bukkit.getLogger().severe("[ClioteSky] Can't establish connection to server!");
                        }
                        offline = true;
                        printError = Listeners.debug;
                    }

                    if (printError)
                        Bukkit.getLogger().severe("[ClioteSky] RPC failed!: " + e.getStatus());
                    if (e.getStatus().getDescription().equals("invalid authentication token")) {
                        start();
                    }
                }

                if (speedupCount < 20) {
                    speedupCount++;
                } else {
                    speedup = false;
                }

                try {
                    if (speedup) {
                        Thread.sleep(200);
                    } else {
                        Thread.sleep(800);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(run).start();
    }

    /*
     * Send bytes to cliote synchronously.
     */

    public void send(byte[] data, String identifier, String recipient) {
        try {
            blockingStub.send(ClioteSkyRPC.ClioteSend.newBuilder().setData(ByteString.copyFrom(data)).setIdentifier(identifier).setRecipient(recipient).setToken(this.authToken).build());
        } catch (StatusRuntimeException e) {
            Bukkit.getLogger().severe("[ClioteSky] RPC failed: " + e.getStatus());
        }
    }

    /*
     * Send bytes to cliote asynchronously.
     */

    public void sendAsync(byte[] data, String identifier, String recipient) {
        Bukkit.getScheduler().runTaskAsynchronously(Bukkit.getPluginManager().getPlugin("gFeatures"), () -> send(data, identifier, recipient));
    }
}
