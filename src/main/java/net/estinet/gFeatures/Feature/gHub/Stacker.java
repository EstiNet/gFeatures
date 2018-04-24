package net.estinet.gFeatures.Feature.gHub;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.EnderCrystal;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

import net.estinet.gFeatures.Feature.Gliders.Basic;

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

public class Stacker {
    public static List<String> right = new ArrayList<>();

    public void event(Player p) {
        if (Basis.isInStacker(p.getName())) {
            Basis.removeStacker(p.getName());
            p.sendMessage("[" + ChatColor.GOLD + "" + ChatColor.BOLD + "Esti" + ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Net" + ChatColor.RESET + "] " + ChatColor.GRAY + "Your stacker is now " + ChatColor.RED + "off" + ChatColor.GRAY + "!");
        } else {
            Basis.addStacker(p.getName());
            p.sendMessage("[" + ChatColor.GOLD + "" + ChatColor.BOLD + "Esti" + ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Net" + ChatColor.RESET + "] " + ChatColor.GRAY + "Your stacker is now " + ChatColor.GREEN + "on" + ChatColor.GRAY + "!");
        }
    }

    public Player checkPassenger(Player p) {
        if ((p.getPassenger() != null) && ((p.getPassenger() instanceof Player))) {
            return (Player) p.getPassenger();
        }
        return (Player) p.getPassenger();
    }

    public Vector giveVector(Location loc) {
        double pitch = (loc.getPitch() + 90.0F) * 3.141592653589793D / 180.0D;
        double yaw = (loc.getYaw() + 90.0F) * 3.141592653589793D / 180.0D;

        double x = Math.sin(pitch) * Math.cos(yaw);
        double y = Math.sin(pitch) * Math.sin(yaw);
        double z = Math.cos(pitch);

        Vector vector = new Vector(x, z, y);

        return vector;
    }

    public void onEntityInteract(PlayerInteractEntityEvent e) {
        Player p = e.getPlayer();
        if ((e.getRightClicked() instanceof Player)) {
            Player pl = (Player) e.getRightClicked();
            if (Basis.isInStacker(p.getName())) {
                if (Basis.isInStacker(pl.getName())) {
                    p.setPassenger(pl);

                } else {
                    if (!right.contains(p.getName())) {
                        p.sendMessage("[" + ChatColor.GOLD + "" + ChatColor.BOLD + "Esti" + ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Net" + ChatColor.RESET + "] " + ChatColor.GRAY + "The player isn't playing stacker right now!");
                        right.add(p.getName());
                        Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
                            public void run() {
                                right.remove(p.getName());
                            }
                        }, 5L);
                    }
                }
            } else {
                if (!right.contains(p.getName())) {
                    p.sendMessage("[" + ChatColor.GOLD + "" + ChatColor.BOLD + "Esti" + ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Net" + ChatColor.RESET + "] " + ChatColor.GRAY + "Your stacker needs to be on!");
                }
                right.add(p.getName());
                Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
                    public void run() {
                        right.remove(p.getName());
                    }
                }, 5L);
            }
        } else {
            p.sendMessage("[" + ChatColor.GOLD + "" + ChatColor.BOLD + "Esti" + ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Net" + ChatColor.RESET + "] " + ChatColor.GRAY + "Your stacker needs to be on!");
        }
    }

    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if ((p.getPassenger() instanceof Player)) {
            Player pass = (Player) p.getPassenger();
            pass.leaveVehicle();
            Location loc = p.getLocation();
            int strength = 5;
            if (strength > 0) {
                pass.setVelocity(giveVector(loc).multiply(strength));
            } else if (strength < -1) {
                pass.teleport(loc);
            }
        }
    }
}
