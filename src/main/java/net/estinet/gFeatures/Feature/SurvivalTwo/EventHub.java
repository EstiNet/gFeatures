package net.estinet.gFeatures.Feature.SurvivalTwo;

import net.estinet.gFeatures.API.Logger.Debug;
import net.estinet.gFeatures.Listeners;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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

public class EventHub implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (Listeners.debug) {
            Bukkit.getLogger().info(!event.getPlayer().hasPlayedBefore() + " " + new File("plugins/gFeatures/Players/" + event.getPlayer().getUniqueId() + ".yml").exists());
        }
        if (!event.getPlayer().hasPlayedBefore() || !new File("plugins/gFeatures/Players/" + event.getPlayer().getUniqueId() + ".yml").exists()) {
            event.getPlayer().performCommand("rc");
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Block block = event.getPlayer().getTargetBlock(null, 5);

        List<Material> bannedBlocks = new ArrayList<>();
        bannedBlocks.add(Material.SUNFLOWER);
        bannedBlocks.add(Material.TALL_GRASS);
        bannedBlocks.add(Material.AIR);
        bannedBlocks.add(Material.GRASS);
        bannedBlocks.add(Material.WATER);
        bannedBlocks.add(Material.ACACIA_LEAVES);
        bannedBlocks.add(Material.BIRCH_LEAVES);
        bannedBlocks.add(Material.DARK_OAK_LEAVES);
        bannedBlocks.add(Material.JUNGLE_LEAVES);
        bannedBlocks.add(Material.OAK_LEAVES);
        bannedBlocks.add(Material.SPRUCE_LEAVES);

        for (Material m : bannedBlocks) {
            if (block.getType().equals(m)) {
                return;
            }
        }

        if (event.getAction().equals(Action.LEFT_CLICK_BLOCK) && block.getType().equals(Material.COMMAND_BLOCK)) {
            removeBlock(event, Material.COMMAND_BLOCK, block);
        } else if (event.getAction().equals(Action.LEFT_CLICK_BLOCK) && block.getType().equals(Material.CHAIN_COMMAND_BLOCK)) {
            removeBlock(event, Material.CHAIN_COMMAND_BLOCK, block);
        } else if (event.getAction().equals(Action.LEFT_CLICK_BLOCK) && block.getType().equals(Material.REPEATING_COMMAND_BLOCK)) {
            removeBlock(event, Material.REPEATING_COMMAND_BLOCK, block);
        } else if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK) && event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.COMMAND_BLOCK)) {
            placeBlock(event, Material.COMMAND_BLOCK, block);
        } else if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK) && event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.CHAIN_COMMAND_BLOCK)) {
            placeBlock(event, Material.CHAIN_COMMAND_BLOCK, block);
        } else if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK) && event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.REPEATING_COMMAND_BLOCK)) {
            placeBlock(event, Material.REPEATING_COMMAND_BLOCK, block);
        }
    }

    public void placeBlock(PlayerInteractEvent event, Material material, Block block) {
        Block b = getPlaceBlock(event.getBlockFace(), block);
        Debug.print("[SurvivalTwo] Placing command block.");
        if (!SurvivalTwo.playerPlace.contains(event.getPlayer().getUniqueId())) {
            Debug.print("[SurvivalTwo] Passed playerPlace array check.");
            if (b.getType().equals(Material.AIR) || b.getType().equals(Material.WATER)) {
                Debug.print("[SurvivalTwo] Passed AIR block and WATER check.");
                Material type = b.getType();
                b.setType(material);
                int amount = event.getPlayer().getInventory().getItemInMainHand().getAmount();
                if (amount == 1) {
                    event.getPlayer().getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                } else {
                    event.getPlayer().getInventory().setItemInMainHand(new ItemStack(material, amount - 1));
                }
                BlockPlaceEvent bpe = new BlockPlaceEvent(b, b.getState(), block, event.getPlayer().getInventory().getItemInMainHand(), event.getPlayer(), true, EquipmentSlot.HAND);
                Bukkit.getServer().getPluginManager().callEvent(bpe);
                SurvivalTwo.playerPlace.add(event.getPlayer().getUniqueId());
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), () -> {
                    if (bpe.isCancelled()) {
                        Debug.print("[SurvivalTwo] Event cancelled.");
                        String name = getCommandBlockName(material);
                        b.setType(type);
                        event.getPlayer().getInventory().addItem(createItem(material, name, ChatColor.GOLD + "ヾ(⌐■_■)ノ♪ Nobody's gonna touch my stuff!"));
                        event.getPlayer().sendMessage(SurvivalTwo.ESTIPREFIX + "" + ChatColor.AQUA + "Your claim is overlapping another claim.");
                    } else {
                        event.getPlayer().sendMessage(SurvivalTwo.ESTIPREFIX + "" + ChatColor.AQUA + "You've placed a protection stone.");
                    }
                }, 1L);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), () -> SurvivalTwo.playerPlace.remove(event.getPlayer().getUniqueId()), 10L);
            }
        }
    }

    public Block getPlaceBlock(BlockFace bf, Block block) {
        return block.getWorld().getBlockAt(block.getX() + bf.getModX(), block.getY() + bf.getModY(), block.getZ() + bf.getModZ());
    }

    public void removeBlock(PlayerInteractEvent event, Material material, Block block) { //TODO let plugin try and prevent breaking it
        try {
            Bukkit.getLogger().info(block.getX() + "." + block.getY() + "." + block.getZ());

            BlockBreakEvent blockevent = new BlockBreakEvent(block, event.getPlayer());
            Bukkit.getServer().getPluginManager().callEvent(blockevent);

            if (blockevent.isCancelled()) {
                event.getPlayer().sendMessage(SurvivalTwo.ESTIPREFIX + "" + ChatColor.AQUA + "This isn't your protection stone!");
            } else {
                event.getPlayer().sendMessage(SurvivalTwo.ESTIPREFIX + "" + ChatColor.AQUA + "You've removed your protection stone.");
                block.setType(Material.AIR);
            }
        } catch (NullPointerException e) {
            if (Listeners.debug) {
                e.printStackTrace();
            }
        }
    }

    public static String getCommandBlockName(Material m) {
        if (m.equals(Material.COMMAND_BLOCK)) {
            return SurvivalTwo.PROTECT32;
        } else if (m.equals(Material.CHAIN_COMMAND_BLOCK)) {
            return SurvivalTwo.PROTECT64;
        } else if (m.equals(Material.REPEATING_COMMAND_BLOCK)) {
            return SurvivalTwo.PROTECT128;
        }
        return SurvivalTwo.PROTECT32;
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

    //TODO DO NOT LET PEOPLE DO /RC IN THE NETHER OR END! THEY WILL DIEEEEEEEEEEEEEE

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        if (event.getPlayer().getBedSpawnLocation() == null) {
            event.getPlayer().performCommand("rc");
        }
    }

    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent event) {
        if (event.getEntity().getType().equals(EntityType.PHANTOM)) {
            event.setCancelled(true);
        }
    }
}
