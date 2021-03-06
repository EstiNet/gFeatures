package net.estinet.gFeatures.Feature.Gliders;

import java.io.File;
import java.io.IOException;

import net.estinet.gFeatures.ClioteSky.ClioteSky;
import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.WorldCreator;

import net.estinet.gFeatures.Feature.Gliders.EventBase.ConstantCheck;
import net.estinet.gFeatures.Feature.Gliders.EventBase.GameFunc.Capture;

/*
 * gFeatures
 * https://github.com/EstiNet/gFeatures
 *
 *    Copyright 2019 EstiNet
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *
 */

public class Enable {
    static ConfigHub ch = new ConfigHub();

    public static void onEnable() {
        Bukkit.getLogger().info("[Gliders] Enabled :D");
        ch.setupConfig();

        File f = new File("plugins/gFeatures/Gliders/Gliders2");
        File fz = new File("./Gliders2");

        fz.delete();
        try {
            FileUtils.copyDirectory(f, fz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        f = new File("plugins/gFeatures/Gliders/Gliders1");
        fz = new File("./Gliders1");
        fz.delete();
        try {
            FileUtils.copyDirectory(f, fz);
        } catch (IOException e) {
            e.printStackTrace();
        }


        Capture c = new Capture();
        c.loop();
        Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), () -> {
            WorldCreator cs = new WorldCreator("MinigameSpawn");
            Bukkit.getServer().createWorld(cs);

            WorldCreator cs1 = new WorldCreator("Gliders1");
            Bukkit.getServer().createWorld(cs1);

            WorldCreator cs2 = new WorldCreator("Gliders2");
            Bukkit.getServer().createWorld(cs2);

            ClioteSky.getInstance().send(new byte[0], "mghello", "Bungee");
        }, 40L);
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), () -> {
            ConstantCheck cc = new ConstantCheck();
            cc.goThrough();
        }, 20L, 20L);
    }
}
