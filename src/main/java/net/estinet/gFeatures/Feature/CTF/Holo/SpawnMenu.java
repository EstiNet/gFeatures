package net.estinet.gFeatures.Feature.CTF.Holo;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.shampaggon.crackshot.CSUtility;

import net.estinet.gFeatures.API.Inventory.ClearInventory;
import net.estinet.gFeatures.Feature.CTF.EventBase.GameFunc.Respawn;

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

public class SpawnMenu {
    private static ItemStack item1, item2, item3, item4, item5;
    static {
        item1 = new ItemStack(Material.IRON_PICKAXE, 1);
        ItemMeta item1meta = item1.getItemMeta();
        item1meta.setDisplayName(ChatColor.RESET + "" + ChatColor.BOLD + "Plasma Sniper");
        item1.setItemMeta(item1meta);

        item2 = new ItemStack(Material.IRON_SHOVEL, 1);
        ItemMeta item2meta = item2.getItemMeta();
        item2meta.setDisplayName(ChatColor.RESET + "" + ChatColor.BOLD + "Plasma Shotgun");
        item2.setItemMeta(item2meta);

        item3 = new ItemStack(Material.IRON_AXE, 1);
        ItemMeta item3meta = item3.getItemMeta();
        item3meta.setDisplayName(ChatColor.RESET + "" + ChatColor.BOLD + "Laser Rifle");
        item3.setItemMeta(item3meta);

        item4 = new ItemStack(Material.IRON_HOE, 1);
        ItemMeta item4meta = item4.getItemMeta();
        item4meta.setDisplayName(ChatColor.RESET + "" + ChatColor.BOLD + "Dual Laser Pistols");
        item4.setItemMeta(item4meta);

        item5 = new ItemStack(Material.IRON_AXE, 1);
        ItemMeta item5meta = item5.getItemMeta();
        item5meta.setDisplayName(ChatColor.RESET + "" + ChatColor.BOLD + "Mini Gun");
        item5.setItemMeta(item5meta);
    }

    public static void init(Player p) {
        ClearInventory.clearInv(p);

        p.getInventory().setItem(0, item1);
        p.getInventory().setItem(1, item2);
        p.getInventory().setItem(2, item3);
        p.getInventory().setItem(3, item4);
        p.getInventory().setItem(4, item5);
    }

    public static void interact(PlayerInteractEvent event) {
        Player p = event.getPlayer();

        CSUtility cs = new CSUtility();
        if (p.getInventory().getItemInMainHand().equals(item1)) {
            finishPlayerInteraction(p);
            cs.giveWeapon(p, "PlasmaSniper", 1);
        } else if (p.getInventory().getItemInMainHand().equals(item2)) {
            finishPlayerInteraction(p);
            cs.giveWeapon(p, "PlasmaShotgun", 1);
        } else if (p.getInventory().getItemInMainHand().equals(item3)) {
            finishPlayerInteraction(p);
            cs.giveWeapon(p, "LaserRifle", 1);
        } else if (p.getInventory().getItemInMainHand().equals(item4)) {
            finishPlayerInteraction(p);
            cs.giveWeapon(p, "DualLaserPistols", 1);
        } else if (p.getInventory().getItemInMainHand().equals(item5)) {
            finishPlayerInteraction(p);
            cs.giveWeapon(p, "MiniGun", 1);
        }
    }

    public static void finishPlayerInteraction(Player p) {
        ClearInventory.clearInv(p);
        Respawn.fullrespawn(p);
    }
}
