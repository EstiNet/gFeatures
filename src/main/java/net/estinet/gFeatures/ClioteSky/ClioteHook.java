package net.estinet.gFeatures.ClioteSky;

public abstract class ClioteHook {
    protected String identifier, gFeatureName;
    public abstract void run(byte[] data, String sender);
}
