package net.estinet.gFeatures.Feature.CTF.MapsSpec;

import java.io.File;
import java.io.IOException;

import net.estinet.gFeatures.ClioteSky.ClioteSky;
import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import net.estinet.gFeatures.Feature.CTF.Basic;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2017 EstiNet

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

public class MapOne implements CTFMap{

    File f = new File("plugins/gFeatures/CTF/CTF1");
    File fz = new File("./CTF");
    File fl = new File("plugins/gFeatures/CTF/MinigameSpawn");
    File flz = new File("./MinigameSpawn");

    public void justDoIt() {
        fz.delete();
        flz.delete();
        try {
            FileUtils.copyDirectory(f, fz);
            FileUtils.copyDirectory(fl, flz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ClioteSky.getInstance().sendAsync(ClioteSky.stringToBytes("Terra"), "mgmap", "Bungee");
        setPoints();
    }
    public void setPoints() {
        Basic.mapName = "Terra";
        Basic.orangespawn = new Location(Bukkit.getWorld("CTF"), -167.5, 29.5, 45.5);
        Basic.bluespawn = new Location(Bukkit.getWorld("CTF"), 105.5, 28.5, 13.5);
        Basic.orangeflag = new Location(Bukkit.getWorld("CTF"), -175.5, 26.5, 45.5);
        Basic.blueflag = new Location(Bukkit.getWorld("CTF"), 113.5, 25.5, 13.5);
        Basic.spectatespawn = new Location(Bukkit.getWorld("CTF"), -27, 35, 2);
        Basic.orangeafterspawn = new Location(Bukkit.getWorld("CTF"), -171, 21, 45);
        Basic.blueafterspawn = new Location(Bukkit.getWorld("CTF"), 110, 19, 13);
    }
}
