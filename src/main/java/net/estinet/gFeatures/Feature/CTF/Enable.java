package net.estinet.gFeatures.Feature.CTF;

import net.estinet.gFeatures.ClioteSky.ClioteSky;
import org.bukkit.Bukkit;
import org.bukkit.WorldCreator;

import net.estinet.gFeatures.Feature.CTF.EventBase.GameFunc.Capture;

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

    public static void onEnable() {
        Bukkit.getLogger().info("[CTF] Enabled :D");
        ConfigHub.setupConfig();

        Capture.loop();
        Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), () -> {
            WorldCreator cs = new WorldCreator("MinigameSpawn");
            Bukkit.getServer().createWorld(cs);

            WorldCreator cs1 = new WorldCreator("CTF");
            Bukkit.getServer().createWorld(cs1);

            ClioteSky.getInstance().sendAsync(new byte[0], "mghello", "Bungee");
        }, 40L);
    }
}
