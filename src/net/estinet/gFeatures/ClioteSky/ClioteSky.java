package net.estinet.gFeatures.ClioteSky;

public class ClioteSky {

    public ClioteSky(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port).usePlainText(true));
    }
    public static void start() {

    }
}
