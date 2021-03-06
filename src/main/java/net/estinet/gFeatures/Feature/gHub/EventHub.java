package net.estinet.gFeatures.Feature.gHub;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import net.estinet.gFeatures.API.Inventory.ClearInventory;
import net.estinet.gFeatures.Feature.Friendship.Menus.FriendsMenu;
import net.estinet.gFeatures.Feature.Shop.GUI.MainShop;
import net.estinet.gFeatures.Feature.gHub.config.gHubConfig;
import net.estinet.gFeatures.Feature.gHub.crystal.Crystal;
import net.estinet.gFeatures.Feature.gHub.crystal.CrystalInteract;

import net.estinet.gFeatures.Feature.gRanks.gRanks;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.event.world.WorldLoadEvent;
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

public class EventHub implements Listener {
    static ItemStack navigator, additions, settings, friend;
    Stacker st = new Stacker();

    public EventHub() {
        navigator = createItem(Material.COMPASS, ChatColor.GOLD + "Navigator");
        additions = createItem(Material.CHEST, ChatColor.BLUE + "Shop");
        settings = createItem(Material.FURNACE, ChatColor.GRAY + "Settings");
        friend = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
        ItemMeta ims = friend.getItemMeta();
        ims.setDisplayName(ChatColor.GOLD + "Friends");
        friend.setItemMeta(ims);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        p.teleport(gHub.spawn);
        ClearInventory.clearInv(p);
        p.setGameMode(GameMode.ADVENTURE);
        //p.getInventory().setItem(1, friend);
        p.getInventory().setItem(4, navigator);
        p.getInventory().setItem(3, additions);
        p.getInventory().setItem(5, settings);
        Constants.playerOn.put(p.getUniqueId(), true);
        event.setJoinMessage(ChatColor.GOLD + "[" + ChatColor.DARK_AQUA + "Join" + ChatColor.GOLD + "]" + ChatColor.RESET + " " + ChatColor.WHITE + p.getName());
        Bukkit.getScheduler().runTask(Bukkit.getPluginManager().getPlugin("gFeatures"), () -> {
            try {
                String prefixs = gRanks.getRankOfPlayer(event.getPlayer(), false).getPrefix();
                String prefix = prefixs.replace('&', '§');
                event.setJoinMessage(ChatColor.GOLD + "[" + ChatColor.DARK_AQUA + "Join" + ChatColor.GOLD + "]" + ChatColor.RESET + " " + prefix + "" + ChatColor.WHITE + p.getName());
            } catch (Exception e) {
                event.setJoinMessage(ChatColor.GOLD + "[" + ChatColor.DARK_AQUA + "Join" + ChatColor.GOLD + "]" + ChatColor.RESET + " " + ChatColor.WHITE + p.getName());
            }
        });
        for (UUID uuid : Constants.playerOn.keySet()) {
            if (!Constants.playerOn.get(uuid)) {
                Bukkit.getPlayer(uuid).hidePlayer(event.getPlayer());
            }
        }
    }

    @EventHandler
    public void onPlayerDrop(PlayerDropItemEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction().equals(Action.LEFT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK) || event.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
            switch (event.getPlayer().getInventory().getItemInMainHand().getType()) {
                case CHEST:
                    MainShop ms = new MainShop();
                    ms.init(event.getPlayer());
                    break;
                case FURNACE:
                    Settings s = new Settings();
                    s.init(event.getPlayer());
                    break;
                case LEGACY_SKULL_ITEM:
                    FriendsMenu fm = new FriendsMenu();
                    fm.init(event.getPlayer());
                    break;
                case COMPASS:
                    //Compass c = new Compass();
                    //c.init(event.getPlayer());
                    break;
                default:
                    break;
            }
        }
        st.onInteract(event);
        event.setCancelled(true);
    }

    @EventHandler
    public void onPlayerToggleFlight(PlayerToggleFlightEvent event) {
        Player player = event.getPlayer();
        if ((player.getGameMode() != GameMode.CREATIVE)) {
            event.setCancelled(true);
            player.setAllowFlight(false);
            player.setFlying(false);
            player.setVelocity(st.giveVector(player.getLocation()).multiply(3));
            player.getLocation().getWorld().playSound(player.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_LARGE_BLAST, 1.0F, -5.0F);
        }
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        event.getPlayer().setAllowFlight(true);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent event) {
        Player p = (Player) event.getEntity();
        p.setFoodLevel(20);
        event.setCancelled(true);
    }

    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
        st.onEntityInteract(event);
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getEntity().getType().equals(EntityType.ENDER_CRYSTAL)) {
            CrystalInteract ci = new CrystalInteract();
            ci.init(event.getEntity().getLocation(), (Player) event.getDamager());
        }
        event.setCancelled(true);
    }

    @EventHandler
    public void onWeatherChange(WeatherChangeEvent event) {
        boolean d = event.toWeatherState();
        if (d) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        try {
            String prefixs = gRanks.getRankOfPlayer(event.getPlayer(), false).getPrefix();
            String prefix = prefixs.replace('&', '§');
            event.setQuitMessage(ChatColor.GOLD + "[" + ChatColor.DARK_AQUA + "Leave" + ChatColor.GOLD + "]" + ChatColor.RESET + " " + prefix + "" + ChatColor.WHITE + event.getPlayer().getName());
        } catch (Exception e) {
            event.setQuitMessage(ChatColor.GOLD + "[" + ChatColor.DARK_AQUA + "Leave" + ChatColor.GOLD + "]" + ChatColor.RESET + " " + ChatColor.WHITE + event.getPlayer().getName());
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

    @EventHandler
    public void onInventoryInteract(InventoryInteractEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onWorldLoad(WorldLoadEvent event) {
        Crystal c = new Crystal();
        c.initCrystal();
        gHubConfig ghc = new gHubConfig();
        ghc.retrieve();
    }
}
