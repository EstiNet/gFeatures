package net.estinet.gFeatures.Feature.CTF.MapsSpec;

import net.estinet.gFeatures.ClioteSky.ClioteSky;
import net.estinet.gFeatures.Feature.CTF.Basic;
import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.io.File;
import java.io.IOException;

public class MapThree implements CTFMap{
    File f = new File("plugins/gFeatures/CTF/CTF3");
    File fz = new File("./CTF");
    File fl = new File("plugins/gFeatures/CTF/MinigameSpawn");
    File flz = new File("./MinigameSpawn");

    public void justDoIt(){
        fz.delete();
        flz.delete();
        try {
            FileUtils.copyDirectory(f, fz);
            FileUtils.copyDirectory(fl, flz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ClioteSky.getInstance().sendAsync(ClioteSky.stringToBytes("Ridge"), "mgmap", "Bungee");
        setPoints();
    }
    public void setPoints() {
        Basic.mapName = "Ridge";
        Basic.orangespawn = new Location(Bukkit.getWorld("CTF"), -948.5, 113.5, 224.5);
        Basic.bluespawn = new Location(Bukkit.getWorld("CTF"), -682.5, 113.5, 242.5);
        Basic.orangeflag = new Location(Bukkit.getWorld("CTF"), -914.5, 70.5, 229.5);
        Basic.blueflag = new Location(Bukkit.getWorld("CTF"), -716.5, 70.5, 237.5);
        Basic.spectatespawn = new Location(Bukkit.getWorld("CTF"), -800, 90, 233);
        Basic.orangeafterspawn = new Location(Bukkit.getWorld("CTF"), -969.5, 94.5, 224.5);
        Basic.blueafterspawn = new Location(Bukkit.getWorld("CTF"), -661.5, 94.5, 242.5);
    }
}
