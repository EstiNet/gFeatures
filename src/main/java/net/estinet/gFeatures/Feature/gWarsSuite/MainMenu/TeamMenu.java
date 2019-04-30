package net.estinet.gFeatures.Feature.gWarsSuite.MainMenu;

import net.estinet.gFeatures.API.Inventory.ClearInventory;
import net.estinet.gFeatures.Feature.gWarsSuite.Statistics;
import net.estinet.gFeatures.Feature.gWarsSuite.gWarsMode;
import net.estinet.gFeatures.Feature.gWarsSuite.Multiplayer.BlueTeam;
import net.estinet.gFeatures.Feature.gWarsSuite.Multiplayer.OrangeTeam;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

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

public class TeamMenu {
    Statistics stats = new Statistics();
    ClearInventory ci = new ClearInventory();

    ItemStack item1, item2;

    public TeamMenu() {
        item1 = new ItemStack(Material.ORANGE_STAINED_GLASS_PANE, 1);
        ItemMeta item1meta = item1.getItemMeta();
        item1meta.setDisplayName(ChatColor.GOLD + "Kloyne (Orange) Players: " + OrangeTeam.size());
        item1.setItemMeta(item1meta);

        item2 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1);
        ItemMeta item2meta = item2.getItemMeta();
        item2meta.setDisplayName(ChatColor.DARK_AQUA + "Innisfil (Blue) Players: " + BlueTeam.size());
        item2.setItemMeta(item2meta);
    }

    public void initialize(Player p) {
        ci.clearInv(p);

        Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), () -> {
            p.getInventory().setItem(0, item1);
            p.getInventory().setItem(1, item2);
        }, 2L);

    }

    public void interact(PlayerInteractEvent event) {
        if (event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.ORANGE_STAINED_GLASS)) {
            if (!(BlueTeam.size() < OrangeTeam.size())) {
                OrangeTeam.addPlayer(event.getPlayer());
                event.getPlayer().sendMessage(ChatColor.GRAY + "[Team] Joined " + ChatColor.GOLD + "Kloyne" + ChatColor.GRAY + ".");
                ItemStack wool = new ItemStack(Material.ORANGE_STAINED_GLASS, 1);
                event.getPlayer().getInventory().setHelmet(wool);
                finals(event.getPlayer());
            } else {
                event.getPlayer().sendMessage(ChatColor.GRAY + "[Team] Can't join " + ChatColor.GOLD + "Kloyne" + ChatColor.GRAY + " because the teams will be unfair!");
            }
        } else if (event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.LIGHT_BLUE_STAINED_GLASS_PANE)) {
            if (!(BlueTeam.size() > OrangeTeam.size())) {
                BlueTeam.addPlayer(event.getPlayer());
                event.getPlayer().sendMessage(ChatColor.GRAY + "[Team] Joined " + ChatColor.DARK_AQUA + "Innisfil" + ChatColor.GRAY + ".");
                ItemStack wool = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS, 1);
                event.getPlayer().getInventory().setHelmet(wool);
                finals(event.getPlayer());
            } else {
                event.getPlayer().sendMessage(ChatColor.GRAY + "[Team] Can't join " + ChatColor.GOLD + "Innisfil" + ChatColor.GRAY + " because the teams will be unfair!");
            }
        }
    }

    private void finals(Player p) {
		p.sendActionBar(ChatColor.AQUA + "Please select a place to spawn.");
        stats.setMode(p, gWarsMode.SPAWNMENU);
        SpawnMenu gm = new SpawnMenu(p);
        gm.intialize();
    }
}
