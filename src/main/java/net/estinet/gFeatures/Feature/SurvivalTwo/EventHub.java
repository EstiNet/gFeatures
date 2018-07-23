package net.estinet.gFeatures.Feature.SurvivalTwo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.estinet.gFeatures.Listeners;
import net.estinet.gFeatures.API.Logger.Debug;
import net.md_5.bungee.api.ChatColor;

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

public class EventHub {
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (!event.getPlayer().hasPlayedBefore() || !new File("plugins/gFeatures/Players/" + event.getPlayer().getUniqueId() + ".yml").exists()) {
            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "rc player " + event.getPlayer().getName());
        }
    }

    public void onPlayerInteract(PlayerInteractEvent event) {
        Block block = event.getPlayer().getTargetBlock(null, 5);

        if (block.getType().equals(Material.SUNFLOWER) || block.getType().equals(Material.TALL_GRASS) || block.getType().equals(Material.GRASS)) {
            return; //prevent 2 tall glitch
        }

        if (event.getAction().equals(Action.LEFT_CLICK_BLOCK) && block.getType().equals(Material.COMMAND_BLOCK)) {
            removeBlock(event, Material.COMMAND_BLOCK, block);
        } else if (event.getAction().equals(Action.LEFT_CLICK_BLOCK) && block.getType().equals(Material.CHAIN_COMMAND_BLOCK)) {
            removeBlock(event, Material.CHAIN_COMMAND_BLOCK, block);
        } else if (event.getAction().equals(Action.LEFT_CLICK_BLOCK) && block.getType().equals(Material.REPEATING_COMMAND_BLOCK)) {
            removeBlock(event, Material.REPEATING_COMMAND_BLOCK, block);
        } else if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK) && event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.COMMAND_BLOCK)) {
            placeBlock(event, Material.COMMAND_BLOCK, block, true);
        } else if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK) && event.getPlayer().getInventory().getItemInOffHand().getType().equals(Material.COMMAND_BLOCK)) {
            placeBlock(event, Material.COMMAND_BLOCK, block, false);
        } else if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK) && event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.CHAIN_COMMAND_BLOCK)) {
            placeBlock(event, Material.CHAIN_COMMAND_BLOCK, block, true);
        } else if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK) && event.getPlayer().getInventory().getItemInOffHand().getType().equals(Material.CHAIN_COMMAND_BLOCK)) {
            placeBlock(event, Material.CHAIN_COMMAND_BLOCK, block, false);
        } else if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK) && event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.REPEATING_COMMAND_BLOCK)) {
            placeBlock(event, Material.REPEATING_COMMAND_BLOCK, block, true);
        } else if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK) && event.getPlayer().getInventory().getItemInOffHand().getType().equals(Material.REPEATING_COMMAND_BLOCK)) {
            placeBlock(event, Material.REPEATING_COMMAND_BLOCK, block, false);
        }
    }

    public void placeBlock(PlayerInteractEvent event, Material material, Block block, boolean hand) {
        Block b = getPlaceBlock(event.getBlockFace(), block);
        Debug.print("[SurvivalTwo] Placing command block.");
        if (!SurvivalTwo.playerPlace.contains(event.getPlayer().getUniqueId())) {
            Debug.print("[SurvivalTwo] Passed playerPlace array check.");
            if (b.getType().equals(Material.AIR) || b.getType().equals(Material.WATER)) {
                Debug.print("[SurvivalTwo] Passed AIR block and WATER check.");
                Material type = b.getType();
                b.setType(material);
                if (hand) {
                    Debug.print("[SurvivalTwo] Main Hand.");
                    int amount = event.getPlayer().getInventory().getItemInMainHand().getAmount();
                    if (amount == 1) {
                        event.getPlayer().getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                    } else {
                        event.getPlayer().getInventory().setItemInMainHand(new ItemStack(material, amount - 1));
                    }
                    BlockPlaceEvent bpe = new BlockPlaceEvent(b, b.getState(), block, event.getPlayer().getInventory().getItemInMainHand(), event.getPlayer(), true, EquipmentSlot.HAND);
                    Bukkit.getServer().getPluginManager().callEvent(bpe);
                    SurvivalTwo.playerPlace.add(event.getPlayer().getUniqueId());
                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
                        public void run() {
                            if (bpe.isCancelled()) {
                                Debug.print("[SurvivalTwo] Event cancelled.");
                                String name = "";
                                if (material.equals(Material.COMMAND_BLOCK)) {
                                    name = ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "<---" + ChatColor.RESET + ChatColor.DARK_AQUA + "32x32 Protection Stone" + ChatColor.RESET + ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "--->";
                                } else if (material.equals(Material.CHAIN_COMMAND_BLOCK)) {
                                    name = ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "<---" + ChatColor.RESET + ChatColor.GREEN + "64x64 Protection Stone" + ChatColor.RESET + ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "--->";
                                } else if (material.equals(Material.REPEATING_COMMAND_BLOCK)) {
                                    name = ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "<---" + ChatColor.RESET + ChatColor.GOLD + "128x128 Protection Stone" + ChatColor.RESET + ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "--->";
                                }
                                b.setType(type);
                                event.getPlayer().getInventory().addItem(createItem(material, name, ChatColor.GOLD + "ヾ(⌐■_■)ノ♪ Nobody's gonna touch my stuff!"));
                                event.getPlayer().sendMessage(ChatColor.BOLD + "[" + ChatColor.DARK_AQUA + "Esti" + ChatColor.GOLD + "Net" + ChatColor.RESET + "" + ChatColor.BOLD + "] " + ChatColor.RESET + "" + ChatColor.AQUA + "Your claim is overlapping another claim.");
                            } else {
                                YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(new File("plugins/gFeatures/SurvivalTwo/data.yml"));
                                if (!yamlFile.contains(block.getX() + "." + block.getY() + "." + block.getZ())) {
                                    yamlFile.createSection(block.getX() + "." + block.getY() + "." + block.getZ());
                                }
                                yamlFile.set(block.getX() + "." + (block.getY() + 1) + "." + block.getZ(), event.getPlayer().getUniqueId().toString());
                                try {
                                    yamlFile.save(new File("plugins/gFeatures/SurvivalTwo/data.yml"));
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                Debug.print("[SurvivalTwo] Event not cancelled.");
                                event.getPlayer().sendMessage(ChatColor.BOLD + "[" + ChatColor.DARK_AQUA + "Esti" + ChatColor.GOLD + "Net" + ChatColor.RESET + "" + ChatColor.BOLD + "] " + ChatColor.RESET + "" + ChatColor.AQUA + "You've placed a protection stone.");
                            }
                        }
                    }, 1L);
                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), () -> SurvivalTwo.playerPlace.remove(event.getPlayer().getUniqueId()), 10L);
                } else {
                    Debug.print("[SurvivalTwo] Off hand.");
                    int amount = event.getPlayer().getInventory().getItemInOffHand().getAmount();
                    if (amount == 1) {
                        event.getPlayer().getInventory().setItemInOffHand(new ItemStack(Material.AIR));
                    } else {
                        event.getPlayer().getInventory().setItemInOffHand(new ItemStack(material, amount - 1));
                    }
                    BlockPlaceEvent bpe = new BlockPlaceEvent(b, b.getState(), block, event.getPlayer().getInventory().getItemInOffHand(), event.getPlayer(), true, EquipmentSlot.OFF_HAND);
                    Bukkit.getServer().getPluginManager().callEvent(bpe);
                    SurvivalTwo.playerPlace.add(event.getPlayer().getUniqueId());
                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), () -> {
                        if (bpe.isCancelled()) {
                            Debug.print("[SurvivalTwo] Event cancelled.");
                            String name = "";
                            if (material.equals(Material.COMMAND_BLOCK)) {
                                name = ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "<---" + ChatColor.RESET + ChatColor.DARK_AQUA + "32x32 Protection Stone" + ChatColor.RESET + ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "--->";
                            } else if (material.equals(Material.CHAIN_COMMAND_BLOCK)) {
                                name = ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "<---" + ChatColor.RESET + ChatColor.GREEN + "64x64 Protection Stone" + ChatColor.RESET + ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "--->";
                            } else if (material.equals(Material.REPEATING_COMMAND_BLOCK)) {
                                name = ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "<---" + ChatColor.RESET + ChatColor.GOLD + "128x128 Protection Stone" + ChatColor.RESET + ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "--->";
                            }
                            b.setType(type);
                            event.getPlayer().getInventory().addItem(createItem(material, name, ChatColor.GOLD + "ヾ(⌐■_■)ノ♪ Nobody's gonna touch my stuff!"));
                            event.getPlayer().sendMessage(ChatColor.BOLD + "[" + ChatColor.DARK_AQUA + "Esti" + ChatColor.GOLD + "Net" + ChatColor.RESET + "" + ChatColor.BOLD + "] " + ChatColor.RESET + "" + ChatColor.AQUA + "Your claim is overlapping another claim.");
                        } else {
                            YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(new File("plugins/gFeatures/SurvivalTwo/data.yml"));
                            if (!yamlFile.contains(block.getX() + "." + block.getY() + "." + block.getZ())) {
                                yamlFile.createSection(block.getX() + "." + block.getY() + "." + block.getZ());
                            }
                            yamlFile.set(block.getX() + "." + (block.getY()) + "." + block.getZ(), event.getPlayer().getUniqueId().toString());
                            try {
                                yamlFile.save(new File("plugins/gFeatures/SurvivalTwo/data.yml"));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            Debug.print("[SurvivalTwo] Event not cancelled.");
                            event.getPlayer().sendMessage(ChatColor.BOLD + "[" + ChatColor.DARK_AQUA + "Esti" + ChatColor.GOLD + "Net" + ChatColor.RESET + "" + ChatColor.BOLD + "] " + ChatColor.RESET + "" + ChatColor.AQUA + "You've placed a protection stone.");
                        }
                    }, 5L);
                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
                        public void run() {
                            SurvivalTwo.playerPlace.remove(event.getPlayer().getUniqueId());
                        }
                    }, 10L);
                }
            }
        }
    }

    public Block getPlaceBlock(BlockFace bf, Block block) {
        if (bf.equals(BlockFace.DOWN)) {
            return block.getWorld().getBlockAt(block.getX(), block.getY() - 1, block.getZ());
        } else if (bf.equals(BlockFace.UP)) {
            return block.getWorld().getBlockAt(block.getX(), block.getY() + 1, block.getZ());
        } else if (bf.equals(BlockFace.EAST)) {
            return block.getWorld().getBlockAt(block.getX() + 1, block.getY(), block.getZ());
        } else if (bf.equals(BlockFace.WEST)) {
            return block.getWorld().getBlockAt(block.getX() - 1, block.getY(), block.getZ());
        } else if (bf.equals(BlockFace.NORTH)) {
            return block.getWorld().getBlockAt(block.getX(), block.getY(), block.getZ() - 1);
        } else if (bf.equals(BlockFace.SOUTH)) {
            return block.getWorld().getBlockAt(block.getX(), block.getY(), block.getZ() + 1);
        } else {
            return block.getWorld().getBlockAt(block.getX(), block.getY(), block.getZ());
        }
    }

    public void removeBlock(PlayerInteractEvent event, Material material, Block block) {
        YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(new File("plugins/gFeatures/SurvivalTwo/data.yml"));
        try {
            Bukkit.getLogger().info(block.getX() + "." + block.getY() + "." + block.getZ());
            if (!yamlFile.get(block.getX() + "." + block.getY() + "." + block.getZ()).equals(event.getPlayer().getUniqueId().toString()) && !event.getPlayer().hasPermission("gFeatures.admin")) {
                event.getPlayer().sendMessage(ChatColor.BOLD + "[" + ChatColor.DARK_AQUA + "Esti" + ChatColor.GOLD + "Net" + ChatColor.RESET + "" + ChatColor.BOLD + "] " + ChatColor.RESET + "" + ChatColor.AQUA + "This isn't your protection stone!");
            } else {
                yamlFile.set(block.getX() + "." + block.getY() + "." + block.getZ(), null);
                try {
                    yamlFile.save(new File("plugins/gFeatures/SurvivalTwo/data.yml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                BlockBreakEvent blockevent = new BlockBreakEvent(block, event.getPlayer());
                event.getPlayer().sendMessage(ChatColor.BOLD + "[" + ChatColor.DARK_AQUA + "Esti" + ChatColor.GOLD + "Net" + ChatColor.RESET + "" + ChatColor.BOLD + "] " + ChatColor.RESET + "" + ChatColor.AQUA + "You've removed your protection stone.");
                String name = "";
                if (material.equals(Material.COMMAND_BLOCK)) {
                    name = ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "<---" + ChatColor.RESET + ChatColor.DARK_AQUA + "32x32 Protection Stone" + ChatColor.RESET + ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "--->";
                } else if (material.equals(Material.CHAIN_COMMAND_BLOCK)) {
                    name = ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "<---" + ChatColor.RESET + ChatColor.GREEN + "64x64 Protection Stone" + ChatColor.RESET + ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "--->";
                } else if (material.equals(Material.REPEATING_COMMAND_BLOCK)) {
                    name = ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "<---" + ChatColor.RESET + ChatColor.GOLD + "128x128 Protection Stone" + ChatColor.RESET + ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "--->";
                }
                block.getWorld().dropItem(block.getLocation(), createItem(material, name, ChatColor.GOLD + "ヾ(⌐■_■)ノ♪ Nobody's gonna touch my stuff!"));
                Bukkit.getServer().getPluginManager().callEvent(blockevent);
            }
        } catch (NullPointerException e) {
            if (Listeners.debug) {
                e.printStackTrace();
            }
        }
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

    public void onPlayerDeath(PlayerRespawnEvent event) {
        if (event.getPlayer().getBedSpawnLocation() == null) {
            event.getPlayer().performCommand("rc");
        }
    }

    public void onCreatureSpawn(CreatureSpawnEvent event) {
        if (event.getEntity().getType().equals(EntityType.PHANTOM)) {
            event.setCancelled(true);
        }
    }
}
