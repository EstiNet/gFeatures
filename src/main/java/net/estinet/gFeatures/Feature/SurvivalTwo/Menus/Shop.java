package net.estinet.gFeatures.Feature.SurvivalTwo.Menus;

import java.util.ArrayList;
import java.util.List;

import net.estinet.gFeatures.Feature.SurvivalTwo.SurvivalTwo;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.estinet.gFeatures.API.Inventory.InventoryAPI;

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

public class Shop {
    public void init(Player player) {
        InventoryAPI open = makeInventory(player);
        open.open(player);
        player.updateInventory();
    }

    public InventoryAPI makeInventory(Player p) {
        try {
            InventoryAPI menu = new InventoryAPI(ChatColor.AQUA + "Survival Shop", 9, event -> {
                if (event.getPosition() == 0) {
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), () -> {
                        Confirm confirm = new Confirm();
                        confirm.init(p, "500", Material.COMMAND_BLOCK, ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "<---" + ChatColor.RESET + ChatColor.DARK_AQUA + "32x32 Protection Stone" + ChatColor.RESET + ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "--->");
                    }, 5L);
                } else if (event.getPosition() == 1) {
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), () -> {
                        Confirm confirm = new Confirm();
                        confirm.init(p, "1300", Material.CHAIN_COMMAND_BLOCK, ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "<---" + ChatColor.RESET + ChatColor.GREEN + "64x64 Protection Stone" + ChatColor.RESET + ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "--->");
                    }, 5L);
                } else if (event.getPosition() == 2) {
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), () -> {
                        Confirm confirm = new Confirm();
                        confirm.init(p, "2500", Material.REPEATING_COMMAND_BLOCK, ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "<---" + ChatColor.RESET + ChatColor.GOLD + "128x128 Protection Stone" + ChatColor.RESET + ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "--->");
                    }, 5L);
                }
                else if (event.getPosition() == 8) {
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), () -> {
                        p.performCommand("vote shop");
                    }, 5L);
                }
                event.setWillClose(true);
                event.setWillDestroy(true);
            }, Bukkit.getServer().getPluginManager().getPlugin("gFeatures"));

            menu.setOption(0, createItem(Material.COMMAND_BLOCK, SurvivalTwo.PROTECT32, ChatColor.GRAY + "Price: " + ChatColor.LIGHT_PURPLE + "$500"));
            menu.setOption(1, createItem(Material.CHAIN_COMMAND_BLOCK, SurvivalTwo.PROTECT64, ChatColor.GRAY + "Price: " + ChatColor.LIGHT_PURPLE + "$1300"));
            menu.setOption(2, createItem(Material.REPEATING_COMMAND_BLOCK, SurvivalTwo.PROTECT128, ChatColor.GRAY + "Price: " + ChatColor.LIGHT_PURPLE + "$2500"));
            menu.setOption(8, createItem(Material.CHEST, ChatColor.WHITE + "" + ChatColor.BOLD + "Vote Rewards Shop", ChatColor.GRAY + "Buy items from voting points!"));

            return menu;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ItemStack createItem(Material material, String name, String... lore) {
        ItemStack item = new ItemStack(material, 1);
        List<String> lores = new ArrayList<>();
        for (String lor : lore) {
            lores.add(lor);
        }
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(lores);
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack createItem(Material material, String name, short met, String... lore) {
        ItemStack item = new ItemStack(material, 1, met);
        List<String> lores = new ArrayList<>();
        for (String lor : lore) {
            lores.add(lor);
        }
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(lores);
        item.setItemMeta(meta);
        return item;
    }
}
