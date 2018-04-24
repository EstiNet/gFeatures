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
import org.bukkit.configuration.file.YamlConfiguration;

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
        try {

            YamlConfiguration prop = YamlConfiguration.loadConfiguration(new File("plugins/gFeatures/Config.yml"));

            // get the property value and print it out
            ClioteSky.name = prop.getString("ClioteSky.Name");
            ClioteSky.category = prop.getString("ClioteSky.Category");
            ClioteSky.address = prop.getString("ClioteSky.Address");
            ClioteSky.enabled = Boolean.parseBoolean(prop.getString("ClioteSky.Enable"));
            ClioteSky.port = prop.getString("ClioteSky.Port");
            ClioteSky.checkTLS = Boolean.parseBoolean(prop.getString("ClioteSky.CheckTLS"));

            File f = new File("plugins/gFeatures/masterkey.key"); //get master key password
            if (f.exists()) {
                ClioteSky.password = new String(Files.readAllBytes(f.toPath()));
            } else {
                Bukkit.getLogger().info("No masterkey.key file found! Please add the key file.");
                f.createNewFile();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
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
    private boolean offline = false, slowCheck = true;

    private String authToken = "";

    public ClioteSky(String host, int port) {
        //this(ManagedChannelBuilder.forAddress(host, port));

        initConnection(host, port);
    }

    private void initConnection(String host, int port) {
        if(!checkTLS) {
            // Create all-trusting host name verifier
            HostnameVerifier allHostsValid = (hostname, session) -> true;
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

                    slowCheck = false; //the server is online

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
                } catch (NullPointerException e) { // if the initial connection couldn't be reached on server start
                    if (Listeners.debug) {
                        Bukkit.getLogger().severe("Can't establish connection with server. Attempting again...");
                        e.printStackTrace();
                    }
                    initConnection(ClioteSky.address, Integer.parseInt(ClioteSky.port));
                }

                if (speedupCount < 20) {
                    speedupCount++;
                } else {
                    speedup = false;
                }

                try {
                    if(slowCheck) {
                        Thread.sleep(2000);
                    }
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
            Debug.print("[ClioteSky] sent " + identifier + " to " + recipient);
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
