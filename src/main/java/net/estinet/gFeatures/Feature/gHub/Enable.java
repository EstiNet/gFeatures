package net.estinet.gFeatures.Feature.gHub;

import net.estinet.gFeatures.API.Inventory.ClearInventory;
import net.estinet.gFeatures.ClioteSky.ClioteSky;
import net.estinet.gFeatures.Feature.gHub.config.gHubConfig;

import net.estinet.gFeatures.gFeatures;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

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
    public void onEnable() {
        Bukkit.getLogger().info("[gHub] gHub is enabled! Hi!");
        Bukkit.getServer().setDefaultGameMode(GameMode.ADVENTURE);
        gHubConfig ghc = new gHubConfig();
        ghc.setup();

        ClioteSky.getInstance().sendAsync(new byte[0], "mgget", "Bungee");

        gFeatures.addPlayerSection("Settings", "");
        gFeatures.addPlayerSection("Settings.showChat", "true");
        gFeatures.addPlayerSection("Settings.scoreBoard", "true");

        Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), () -> {
            for (Player p : Bukkit.getOnlinePlayers()) {
                ClearInventory.clearInv(p);
                //p.getInventory().setItem(1, EventHub.friend);
                p.getInventory().setItem(4, EventHub.navigator);
                p.getInventory().setItem(3, EventHub.additions);
                p.getInventory().setItem(5, EventHub.settings);
            }
        }, 600L, 600L);
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), () -> {
            PreventFall pf = new PreventFall();
            pf.check();
        }, 10L, 10L);
    }
}
