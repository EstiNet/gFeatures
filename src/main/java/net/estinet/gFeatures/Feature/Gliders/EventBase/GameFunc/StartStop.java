package net.estinet.gFeatures.Feature.Gliders.EventBase.GameFunc;

import java.util.UUID;

import net.estinet.gFeatures.ClioteSky.ClioteSky;
import net.estinet.gFeatures.Feature.EstiCoins.EstiCoins;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.EnderCrystal;
import org.bukkit.entity.Player;

import net.estinet.gFeatures.Feature.Gliders.Basic;
import net.estinet.gFeatures.Feature.Gliders.Mode;
import net.estinet.gFeatures.Feature.Gliders.PlayerMode;
import net.estinet.gFeatures.Feature.Gliders.Team;
import net.estinet.gFeatures.Feature.Gliders.EventBase.Spectate;
import net.estinet.gFeatures.Feature.Gliders.Holo.GlidersScore;
import net.estinet.gFeatures.Feature.Gliders.Holo.Lobby;
import net.estinet.gFeatures.Feature.Gliders.Holo.Loop;
import net.estinet.gFeatures.Feature.Gliders.MapsSpec.MapOne;

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

public class StartStop {
    static int tasknum;
    Loop loop = new Loop();
    Respawn respawn = new Respawn();
    Spectate s = new Spectate();
    Lobby l = new Lobby();

    public void start() {
        tasknum = Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), () -> {
            boolean nu = true;
            if (Basic.countdown <= 0) {
                if (Bukkit.getServer().getOnlinePlayers().size() >= 2) {

                    //Initialize world finding
                    /*if(Bukkit.getServer().getOnlinePlayers().size() <= 4){
                        MapTwo mt = new MapTwo();
                        mt.justDoIt();
                        mt.reassign();
                    }
                    else{*/
                    MapOne mo = new MapOne();
                    mo.justDoIt();
                    mo.reassign();
                    //}

                    ClioteSky.getInstance().sendAsync(new byte[0], "mgstart", "Bungee");
                    Bukkit.getScheduler().cancelTask(tasknum);
                    Basic.mode = Mode.STARTED;
                    for (Player p : Bukkit.getOnlinePlayers()) {
                        p.setLevel(0);
                        if (Basic.getOrangeSize() >= Basic.getBlueSize()) {
                            Basic.teams.put(p.getUniqueId(), Team.BLUE);
                            p.sendActionBar(ChatColor.BLUE + "You are on the blue team! Glide down from the plane and steal the flag!");
                        } else {
                            Basic.teams.put(p.getUniqueId(), Team.ORANGE);
                            p.sendActionBar(ChatColor.GOLD + "You are on the orange team! Protect the flag from the gliders!");
                        }
                    }

                    for (UUID uuid : Basic.teams.keySet()) {
                        for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                            if (p.getUniqueId().equals(uuid)) {
                                respawn.respawn(p);
                            }
                        }
                    }

                    Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), () -> {
                        Bukkit.getWorld(Basic.mapName).spawn(Basic.flag, EnderCrystal.class);
                        Bukkit.getWorld(Basic.mapName).setSpawnLocation(Basic.towerspawn.get(0).getBlockX(), Basic.towerspawn.get(0).getBlockX(), Basic.towerspawn.get(0).getBlockX());
                    }, 45L);

                    Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), () -> {
                        if (!Basic.swap) {
                            Basic.firstteam = Team.ORANGE; //keep the first win team
                            Swap swap = new Swap();
                            swap.init();
                        }
                    }, 6000L);

                    FinishStart fs = new FinishStart();
                    fs.finish();
                    recursive();
                } else {
                    Bukkit.broadcastMessage(ChatColor.AQUA + "[Gliders] " + ChatColor.WHITE + "Not enough players! Counter restarting. :/");
                    Basic.mode = Mode.WAITING;
                    Basic.countdown = 60;
                    Bukkit.getScheduler().cancelTask(tasknum);
                    for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                        p.setScoreboard(l.Initialize(p));
                        p.setLevel(Basic.countdown);
                        p.playSound(p.getLocation(), Sound.BLOCK_PORTAL_TRAVEL, 25, 25);
                    }
                }
            } else {
                if (Bukkit.getServer().getOnlinePlayers().size() >= 2) {
                    loop.goThrough();
                    for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                        p.setScoreboard(l.Initialize(p));
                        p.setLevel(Basic.countdown);
                        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HARP, 50, 50);
                    }
                } else {
                    Bukkit.broadcastMessage(ChatColor.AQUA + "[Gliders] " + ChatColor.WHITE + "Not enough players! Counter restarting. :/");
                    Basic.mode = Mode.WAITING;
                    Basic.countdown = 60;
                    Bukkit.getScheduler().cancelTask(tasknum);
                    for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                        p.setScoreboard(l.Initialize(p));
                        p.setLevel(Basic.countdown);
                    }
                    nu = false;
                }
            }
            if (nu) {
                Basic.countdown--;
            }
        }, 0, 20L);
    }

    public void stopGame(Team winner) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            Basic.modes.remove(p.getUniqueId());
            Basic.modes.put(p.getUniqueId(), PlayerMode.SPECTATE);
            s.handler(p);
            //Show their stats
            p.sendMessage(ChatColor.STRIKETHROUGH + "" + ChatColor.BOLD + "-----" + ChatColor.RESET + ChatColor.GREEN + "" + ChatColor.BOLD + "Stats" + ChatColor.WHITE + "" + ChatColor.STRIKETHROUGH + "" + ChatColor.BOLD + "-----");
            p.sendMessage(ChatColor.AQUA + "Participation: +5 coins");
            p.sendMessage(ChatColor.AQUA + "Kills: " + Basic.kills.get(p.getUniqueId()));
            p.sendMessage(ChatColor.AQUA + "Deaths: " + Basic.deaths.get(p.getUniqueId()));
            int clupic = 0;
            if (winner.equals(Basic.teams.get(p.getUniqueId()))) {
                p.sendMessage(ChatColor.AQUA + "Won Game: +20 coins");
                clupic += 20;
            } else if (winner.equals(Team.NONE)) {
                p.sendMessage(ChatColor.AQUA + "Tie: +10 coins");
                clupic += 10;
            }
            clupic += (Basic.kills.get(p.getUniqueId()) * 5 + 5);
            p.sendMessage(ChatColor.GREEN + "Total Coins Earned: " + clupic);
            p.sendMessage(ChatColor.STRIKETHROUGH + "" + ChatColor.BOLD + "---------------");
            final int clupics = clupic;
            Thread thr = new Thread(() -> {
                try {
                    EstiCoins.giveMoney(p, clupics);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            thr.start();
        }
        Basic.mode = Mode.ENDED;
        if (winner.equals(Team.ORANGE)) {
            Action.sendAllTitle(ChatColor.GOLD + "The orange team won!", "Congrats!", 20, 40, 20);
        } else if (winner.equals(Team.BLUE)) {
            Action.sendAllTitle(ChatColor.DARK_AQUA + "The blue team won!", "Congrats!", 20, 40, 20);
        } else {
            Action.sendAllTitle(ChatColor.BOLD + "Both teams tied!", "", 20, 40, 20);
        }
        Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), () -> {
            for (Player p : Bukkit.getOnlinePlayers()) {
                ClioteSky.getInstance().sendAsync(ClioteSky.stringToBytes(p.getName() + " MinigameHub"), "redirect", "Bungee");
            }

            Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), () -> {
                if (Bukkit.getOnlinePlayers().size() == 0) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "stop");
                } else {
                    for (Player p : Bukkit.getOnlinePlayers()) {
                        ClioteSky.getInstance().sendAsync(ClioteSky.stringToBytes(p.getName() + " MinigameHub"), "redirect", "Bungee");
                    }
                }
            }, 80L, 80L);

        }, 1000L);
    }

    public void recursive() {
        Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), () -> {
            if (Basic.mode.equals(Mode.STARTED)) {
                if (Basic.seconds == 0) {
                    Basic.seconds = 50;
                    Basic.minutes -= 1;
                } else {
                    Basic.seconds -= 10;
                }
                for (Player p : Bukkit.getOnlinePlayers()) {
                    GlidersScore ctfs = new GlidersScore();
                    p.setScoreboard(ctfs.Initialize(p));
                }
                recursive();
            }
        }, 200L);
    }
}
