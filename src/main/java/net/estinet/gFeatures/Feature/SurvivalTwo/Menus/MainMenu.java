package net.estinet.gFeatures.Feature.SurvivalTwo.Menus;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.estinet.gFeatures.API.EssentialsHook.EssentialsEcoUtil;
import net.estinet.gFeatures.API.Inventory.InventoryAPI;

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

public class MainMenu {
    public void init(Player player) {
        InventoryAPI open = makeInventory(player);
        open.open(player);
        player.updateInventory();
    }

    public InventoryAPI makeInventory(Player p) {
        try {
            InventoryAPI menu = new InventoryAPI(ChatColor.AQUA + "Survival Menu", 9, event -> {
                if (event.getName().equalsIgnoreCase(ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "<---" + ChatColor.RESET + ChatColor.DARK_AQUA + "Teleport Home" + ChatColor.RESET + ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "--->")) {
                    p.performCommand("home");
                } else if (event.getName().equalsIgnoreCase(ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "<---" + ChatColor.RESET + ChatColor.GREEN + "Set Home" + ChatColor.RESET + ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "--->")) {
                    p.performCommand("sethome");
                } else if (event.getName().equalsIgnoreCase(ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "<---" + ChatColor.RESET + ChatColor.GOLD + "Open Shop" + ChatColor.RESET + ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "--->")) {
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), () -> {
                        Shop shop = new Shop();
                        shop.init(p);
                    }, 5L);
                } else if (event.getName().equalsIgnoreCase(ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "<---" + ChatColor.RESET + ChatColor.LIGHT_PURPLE + "Teleport to a Player" + ChatColor.RESET + ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "--->")) {
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), () -> {
                        TpaMenu tm = new TpaMenu();
                        tm.init(p);
                    }, 5L);
                } else if (event.getName().equalsIgnoreCase(ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "<---" + ChatColor.RESET + ChatColor.YELLOW + "Toggle the Scoreboard" + ChatColor.RESET + ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "--->")) {
                    p.performCommand("score");
                } else if (event.getName().equalsIgnoreCase(ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "<---" + ChatColor.RESET + ChatColor.DARK_BLUE + "Find the Recipe of an Item" + ChatColor.RESET + ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "--->")) {
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), () -> {
                        RecipeMenu tm = new RecipeMenu();
                        tm.init(p);
                    }, 5L);
                }
                event.setWillClose(true);
                event.setWillDestroy(true);
            }, Bukkit.getServer().getPluginManager().getPlugin("gFeatures"));

            menu.setOption(0, createItem(Material.WHITE_BED, ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "<---" + ChatColor.RESET + ChatColor.DARK_AQUA + "Teleport Home" + ChatColor.RESET + ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "--->", ChatColor.GRAY + "/home"));
            menu.setOption(1, createItem(Material.WHITE_BANNER, ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "<---" + ChatColor.RESET + ChatColor.GREEN + "Set Home" + ChatColor.RESET + ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "--->", ChatColor.GRAY + "Sets your home at your current location.", ChatColor.GRAY + "/sethome"));
            menu.setOption(2, createItem(Material.COMMAND_BLOCK, ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "<---" + ChatColor.RESET + ChatColor.GOLD + "Open Shop" + ChatColor.RESET + ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "--->", ChatColor.GRAY + "/shop"));
            menu.setOption(3, createItem(Material.EMERALD, ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "<---" + ChatColor.RESET + ChatColor.BLUE + "Balance: $" + EssentialsEcoUtil.getMoney(p.getUniqueId()) + ChatColor.RESET + ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "--->", ChatColor.GRAY + "/bal"));
//			menu.setOption(4, createItem(Material.LEGACY_SKULL_ITEM, ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "<---" + ChatColor.RESET + ChatColor.LIGHT_PURPLE + "Teleport to a Player" + ChatColor.RESET + ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "--->", ChatColor.GRAY + "/tpa [player]"));
            menu.setOption(4, createItem(Material.ANVIL, ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "<---" + ChatColor.RESET + ChatColor.YELLOW + "Toggle the Scoreboard" + ChatColor.RESET + ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "--->", ChatColor.GRAY + "/score"));
//			menu.setOption(6, createItem(Material.CRAFTING_TABLE, ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "<---" + ChatColor.RESET + ChatColor.DARK_BLUE + "Find the Recipe of an Item" + ChatColor.RESET + ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "--->", ChatColor.GRAY + "/recipe [item]"));

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
