package net.estinet.gFeatures.Feature.CTF.EventBase;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerQuitEvent;

import net.estinet.gFeatures.ClioteSky.API.CliotePing;
import net.estinet.gFeatures.Feature.CTF.Basic;
import net.estinet.gFeatures.Feature.CTF.Mode;
import net.estinet.gFeatures.Feature.CTF.EventBase.GameFunc.Action;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2018 EstiNet

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

public class Leave {
    public void init(PlayerQuitEvent event) {
        Basic.modes.remove(event.getPlayer().getUniqueId());
        Basic.kills.remove(event.getPlayer().getUniqueId());
        Basic.deaths.remove(event.getPlayer().getUniqueId());
        Basic.flagcaptures.remove(event.getPlayer().getUniqueId());
        Basic.teams.remove(event.getPlayer().getUniqueId());
        try {
            if (Basic.blueflagger.getName().equals(event.getPlayer().getName())) {
                Basic.blueflagger = null;
                Action.sendAllTitle(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + event.getPlayer().getName() + " has left!", ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "The blue flag has been returned.", 20, 40, 20);
            }
        } catch (NullPointerException e) {
        }
        try {
            if (Basic.orangeflagger.getName().equals(event.getPlayer().getName())) {
                Basic.orangeflagger = null;
                Action.sendAllTitle(ChatColor.GOLD + "" + ChatColor.BOLD + event.getPlayer().getName() + " has left!", ChatColor.GOLD + "" + ChatColor.BOLD + "The orange flag has been returned.", 20, 40, 20);
            }
        } catch (NullPointerException e) {
        }
        if (Bukkit.getOnlinePlayers().size() == 2 && Basic.mode.equals(Mode.STARTED)) {
            Bukkit.broadcastMessage(ChatColor.AQUA + "[CTF] " + ChatColor.WHITE + "Not enough players! Server restarting. :/");
            CliotePing cp = new CliotePing();
            for (Player p : Bukkit.getOnlinePlayers()) {
                cp.sendMessage("redirect " + p.getName() + " MinigameHub", "Bungee");
            }
            Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
                public void run() {
                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "stop");
                }
            }, 100L);
        }
    }
}
