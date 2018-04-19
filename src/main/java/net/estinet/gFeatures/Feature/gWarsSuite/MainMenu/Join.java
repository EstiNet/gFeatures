package net.estinet.gFeatures.Feature.gWarsSuite.MainMenu;

import net.estinet.gFeatures.API.Inventory.ClearInventory;
import net.estinet.gFeatures.Feature.gWarsSuite.Constants;
import net.estinet.gFeatures.Feature.gWarsSuite.Statistics;
import net.estinet.gFeatures.Feature.gWarsSuite.gWarsMode;

import java.util.ArrayList;
import java.util.List;

import net.estinet.gFeatures.gFeatures;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.util.Vector;

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

public class Join {
    Statistics stats = new Statistics();

    public void start(PlayerJoinEvent event) {
        event.getPlayer().sendActionBar(ChatColor.AQUA + "Welcome to the " + ChatColor.GOLD + "gWars " + ChatColor.AQUA + "Beta! Code version: " + gFeatures.getFeature("gWarsSuite").getVersion());
        Player p = event.getPlayer();
        ClearInventory ci = new ClearInventory();
        ci.clearInv(event.getPlayer());
        Location spawnonjoin = new Location(Bukkit.getServer().getWorld("gWars"), 350.3, 103.0, -59.3);
        p.teleport(spawnonjoin);
        p.setGameMode(GameMode.ADVENTURE);

        p.setWalkSpeed((float) 0.5);

        for (Player sp : Bukkit.getOnlinePlayers()) {
            if (stats.getMode(sp).equals(gWarsMode.MAINMENU) || stats.getMode(sp).equals(gWarsMode.GUNMENU) || stats.getMode(sp).equals(gWarsMode.SPAWNMENU) || stats.getMode(sp).equals(gWarsMode.TEAMMENU)) {
                p.hidePlayer(sp);
            }
        }
        for (Player players : Bukkit.getOnlinePlayers()) {
            players.hidePlayer(p);
        }

        Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
            public void run() {
                algore(p);
            }
        }, 160L);


        ItemStack item1 = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.CREEPER.ordinal());
        SkullMeta item1meta = (SkullMeta) item1.getItemMeta();
        item1meta.setDisplayName(ChatColor.GOLD + "Singleplayer");
        item1.setItemMeta(item1meta);

        ItemStack item2 = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
        SkullMeta item2meta = (SkullMeta) item2.getItemMeta();
        item2meta.setDisplayName(ChatColor.GOLD + "Multiplayer");
        item2.setItemMeta(item2meta);

        p.getInventory().setItem(0, item1);
        p.getInventory().setItem(1, item2);

        Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
            public void run() {
                p.setGameMode(GameMode.ADVENTURE);
            }
        }, 20L);
    }

    public void end(Player p) {
        for (Player players : Bukkit.getOnlinePlayers()) {
            players.showPlayer(p);
        }
    }

    public void algore(Player player) {
        List<Location> locs = new ArrayList<>();
        locs.add(Constants.teleport1);
        List<Location> tps = new ArrayList<>();
        locs.add(Constants.teleport2);
        locs.add(Constants.teleport3);
        locs.add(Constants.teleport4);
        locs.add(Constants.teleport5);
        locs.add(Constants.teleport6);
        locs.add(Constants.teleport7);
        locs.add(Constants.teleport8);
        locs.add(Constants.teleport9);
        locs.add(Constants.teleport10);
        locs.add(Constants.teleport11);
        locs.add(Constants.teleport12);
        locs.add(Constants.teleport13);
        locs.add(Constants.teleport14);
        locs.add(Constants.teleport15);
        locs.add(Constants.teleport16);
        locs.add(Constants.teleport17);
        World w = player.getWorld();
        for (int i = 0; i < locs.size() - 1; i++) {
            Location s = (Location) locs.get(i);
            Location n = (Location) locs.get(i + 1);
            int t = ((Integer) 100).intValue();

            double moveX = n.getX() - s.getX();
            double moveY = n.getY() - s.getY();
            double moveZ = n.getZ() - s.getZ();
            for (int x = 0; x < t; x++) {
                Location l = new Location(w, s.getX() + moveX / t * x, s.getY() + moveY / t * x, s.getZ() + moveZ / t * x);
                tps.add(l);
            }
        }
        try {
            player.setAllowFlight(true);
            player.teleport((Location) tps.get(0));
            player.setFlying(true);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getPluginManager().getPlugin("gFeatures"), new Runnable() {
                private int ticks = 0;

                public void run() {
                    if (this.ticks < tps.size()) {
                        Vector vector;
                        if (stats.getMode(player).equals(gWarsMode.MAINMENU) || stats.getMode(player).equals(gWarsMode.GUNMENU) || stats.getMode(player).equals(gWarsMode.SPAWNMENU) || stats.getMode(player).equals(gWarsMode.TEAMMENU)) {
                            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getPluginManager().getPlugin("gFeatures"), this, 1L);
                            try {
                                vector = tps.get(this.ticks).toVector().subtract(player.getLocation().toVector());
                                player.setVelocity(vector);
                                player.setPassenger(player);
                            } catch (Exception e) {
                            }
                        } else {
                            player.setAllowFlight(false);
                            player.setFlying(false);

                        }
                        this.ticks += 1;
                    }
                    if (this.ticks == tps.size()) {
                        player.teleport((Location) tps.get(0));
                        this.ticks = 0;
                        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getPluginManager().getPlugin("gFeatures"), this, 1L);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            player.sendMessage(ChatColor.RED + "An error occured during traveling");
        }
    }
}
