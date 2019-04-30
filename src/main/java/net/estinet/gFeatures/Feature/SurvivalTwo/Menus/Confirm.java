package net.estinet.gFeatures.Feature.SurvivalTwo.Menus;

import java.util.ArrayList;
import java.util.List;

import net.estinet.gFeatures.Feature.SurvivalTwo.SurvivalTwo;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import net.estinet.gFeatures.API.EssentialsHook.EssentialsEcoUtil;
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

public class Confirm {
    public void init(Player player, String price, Material give, String name) {
        InventoryAPI open = makeInventory(player, price, give, name);
        open.open(player);
        player.updateInventory();
    }

    public InventoryAPI makeInventory(Player p, String price, Material give, String name) {
        try {
            InventoryAPI menu = new InventoryAPI(ChatColor.GOLD + "Buy protection stone? It's " + ChatColor.DARK_AQUA + "$" + price, 9, event -> {
                if (event.getPosition() >= 0 && event.getPosition() <= 3) {
                    if (EssentialsEcoUtil.getMoney(p.getUniqueId()) >= Double.parseDouble(price)) {
                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "eco take " + p.getName() + " " + Double.parseDouble(price));
                        if (p.getInventory().firstEmpty() == -1) {
                            Location l = p.getLocation();
                            l.add(0, 1, 0);
                            p.getWorld().dropItem(l, createItem(give, name, ChatColor.GOLD + "ヾ(⌐■_■)ノ♪ Nobody's gonna touch my stuff!"));
                        } else {
                            p.getInventory().addItem(createItem(give, name, ChatColor.GOLD + "ヾ(⌐■_■)ノ♪ Nobody's gonna touch my stuff!"));
                        }
                        p.sendMessage(SurvivalTwo.ESTIPREFIX + "" + ChatColor.AQUA + "You got a protection stone!");
                    } else {
                        p.sendMessage(SurvivalTwo.ESTIPREFIX + "" + ChatColor.AQUA + "You don't have enough money!");
                    }
                } else if (event.getPosition() >= 5 && event.getPosition() <= 8) {
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), () -> {
                        Shop shop = new Shop();
                        shop.init(p);
                    }, 5L);
                }
                event.setWillClose(true);
                event.setWillDestroy(true);
            }, Bukkit.getServer().getPluginManager().getPlugin("gFeatures"));
            ItemStack pane = new ItemStack(Material.LIME_STAINED_GLASS_PANE, 1);
            ItemMeta im = pane.getItemMeta();
            im.setDisplayName(ChatColor.GREEN + "Yes");
            pane.setItemMeta(im);

            ItemStack pane1 = new ItemStack(Material.RED_STAINED_GLASS_PANE, 1);
            ItemMeta im1 = pane1.getItemMeta();
            im1.setDisplayName(ChatColor.RED + "No");
            pane1.setItemMeta(im1);

            menu.setOption(0, pane);
            menu.setOption(1, pane);
            menu.setOption(2, pane);
            menu.setOption(3, pane);
            menu.setOption(4, createItem(give, name));
            menu.setOption(5, pane1);
            menu.setOption(6, pane1);
            menu.setOption(7, pane1);
            menu.setOption(8, pane1);

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
}
