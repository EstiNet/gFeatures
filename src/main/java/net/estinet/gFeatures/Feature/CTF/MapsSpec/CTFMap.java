package net.estinet.gFeatures.Feature.CTF.MapsSpec;

import net.estinet.gFeatures.ClioteSky.ClioteSky;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public abstract class CTFMap {
    public File directory = new File("");
    File ctfWorld = new File("./CTF");
    File mgDirectory = new File("plugins/gFeatures/CTF/MinigameSpawn");
    File minigameSpawnWorld = new File("./MinigameSpawn");

    public String mapName = "Map Name";

    public void pullWorld() {
        ctfWorld.delete();
        mgDirectory.delete();
        try {
            FileUtils.copyDirectory(directory, ctfWorld);
            FileUtils.copyDirectory(mgDirectory, minigameSpawnWorld);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ClioteSky.getInstance().sendAsync(ClioteSky.stringToBytes(mapName), "mgmap", "Bungee");
        setPoints();
    }
    public abstract void setPoints();
}
