package net.estinet.gFeatures.Feature.Gliders.EventBase;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import net.estinet.gFeatures.Feature.Gliders.EventBase.GameFunc.Action;
import net.estinet.gFeatures.Feature.Gliders.Basic;
import net.estinet.gFeatures.Feature.Gliders.PlayerMode;
import net.estinet.gFeatures.Feature.Gliders.Team;
import net.estinet.gFeatures.Feature.Gliders.EventBase.GameFunc.Respawn;
import net.estinet.gFeatures.Feature.Gliders.EventBase.GameFunc.StartStop;
import net.estinet.gFeatures.Feature.Gliders.EventBase.GameFunc.Swap;

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

public class ConstantCheck {
    public void goThrough() {
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (Basic.modes.get(p.getUniqueId()).equals(PlayerMode.INGAME)) {
                try {
                    if ((p.getLocation().getY() < 10) && Basic.flagger.getName().equals(p.getName())) {
                        if (!Basic.swap) {
                            Basic.firstteam = Team.BLUE;
                            Action.sendAllTitle(ChatColor.BOLD + p.getName() + " has secured the flag!", ChatColor.AQUA + "Blue wins this round!", 20, 20, 20);
                            for (Player ps : Bukkit.getOnlinePlayers()) {
                                ps.setGameMode(GameMode.SPECTATOR);
                            }
                            Basic.flagger = null;
                            Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), () -> {
                                Swap swap = new Swap();
                                swap.init();
                            }, 80L);
                        } else {
                            Action.sendAllTitle(ChatColor.BOLD + p.getName() + " has secured the flag!", ChatColor.GOLD + "Orange wins this round!", 10, 10, 10);
                            if (Basic.firstteam.equals(Team.ORANGE)) {
                                StartStop ss = new StartStop();
                                ss.stopGame(Team.ORANGE);
                            } else {
                                StartStop ss = new StartStop();
                                ss.stopGame(Team.NONE);
                            }
                            Basic.flagger = null;
                        }
                    } else if (p.getLocation().getY() < 10) {
                        p.setGameMode(GameMode.SPECTATOR);
                        Respawn r = new Respawn();
                        r.respawn(p);
                        int deaths = Basic.deaths.get(p.getUniqueId());
                        deaths += 1;
                        Basic.deaths.remove(p.getUniqueId());
                        Basic.deaths.put(p.getUniqueId(), deaths);
                        Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "[" + ChatColor.DARK_AQUA + "Death" + ChatColor.GOLD + "] " + ChatColor.RESET + p.getDisplayName() + ChatColor.RESET + " fell off the map.");
                    }
                } catch (NullPointerException e) {
                    if (p.getLocation().getY() < 10) {
                        p.setGameMode(GameMode.SPECTATOR);
                        Respawn r = new Respawn();
                        r.respawn(p);
                        int deaths = Basic.deaths.get(p.getUniqueId());
                        deaths += 1;
                        Basic.deaths.remove(p.getUniqueId());
                        Basic.deaths.put(p.getUniqueId(), deaths);
                        Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "[" + ChatColor.DARK_AQUA + "Death" + ChatColor.GOLD + "] " + ChatColor.RESET + p.getDisplayName() + ChatColor.RESET + " fell off the map.");
                    }
                }
            } else if (Basic.modes.get(p.getUniqueId()).equals(PlayerMode.WAITING)) {
                if (p.getLocation().getY() < 10) {
                    p.setGameMode(GameMode.SPECTATOR);
                    p.setGameMode(GameMode.ADVENTURE);
                    p.teleport(Basic.waitspawn);
                }
            }
        }
    }
}
