package net.estinet.gFeatures.Feature.ServerQuery;

import net.estinet.gFeatures.API.Inventory.InventoryAPI;
import net.estinet.gFeatures.ClioteSky.ClioteSky;
import net.estinet.gFeatures.Command.CommandExecutable;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SurvivalCommand extends CommandExecutable {

    @Override
    public void run() {
        if (super.sender instanceof Player) {
            InventoryAPI open = makeInventory((Player) super.sender); 
            open.open((Player) super.sender);
            ((Player)super.sender).updateInventory();
        }
    }

    public InventoryAPI makeInventory(Player p){
        try {

            ItemStack lime = new ItemStack(Material.LIME_STAINED_GLASS_PANE, 1);
            ItemMeta limeM = lime.getItemMeta();
            limeM.setDisplayName(ChatColor.GREEN + "Survival (Lime)");
            limeM.setLore(Arrays.asList(ChatColor.WHITE + "Minecraft multiplayer as it was intended (with no PVP)."));
            lime.setItemMeta(limeM);

            ItemStack cyan = new ItemStack(Material.CYAN_STAINED_GLASS_PANE, 1);
            ItemMeta cyanM = cyan.getItemMeta();
            cyanM.setDisplayName(ChatColor.AQUA + "Survival (Cyan)");
            cyanM.setLore(Arrays.asList(ChatColor.WHITE + "Survival multiplayer with more addons (kits, economy, etc.)."));
            cyan.setItemMeta(cyanM);

            ItemStack pink = new ItemStack(Material.PINK_STAINED_GLASS_PANE, 1);
            ItemMeta pinkM = pink.getItemMeta();
            pinkM.setDisplayName(ChatColor.LIGHT_PURPLE + "Survival (Pink)");
            pinkM.setLore(Arrays.asList(ChatColor.WHITE + "Modded Survival multiplayer with FTB Revelation!"));
            pink.setItemMeta(pinkM);

            return new InventoryAPI(ChatColor.GREEN + "Survival Menu", 9, event -> {
                if(event.getName().equals(ChatColor.GREEN + "Survival (Lime)")){
                    event.getPlayer().closeInventory();
                    event.getPlayer().sendMessage(ChatColor.GREEN + "Attempting to connect you to Survival (Lime)...");
                    ClioteSky.getInstance().sendAsync(ClioteSky.stringToBytes(p.getName() + " Survival"), "redirect", "Bungee");
                }
                else if(event.getName().equals(ChatColor.AQUA + "Survival (Cyan)")){
                    event.getPlayer().closeInventory();
                    event.getPlayer().sendMessage(ChatColor.AQUA + "Attempting to connect you to Survival (Cyan)...");
                    ClioteSky.getInstance().sendAsync(ClioteSky.stringToBytes(p.getName() + " SurvivalO"), "redirect", "Bungee");
                }
                else if(event.getName().equals(ChatColor.LIGHT_PURPLE + "Survival (Pink)")){
                    event.getPlayer().closeInventory();
                    event.getPlayer().sendMessage(ChatColor.AQUA + "Attempting to connect you to Survival (Pink)...");
                    ClioteSky.getInstance().sendAsync(ClioteSky.stringToBytes(p.getName() + " SurvivalPink"), "redirect", "Bungee");
                }
                event.setWillClose(true);
            }, Bukkit.getServer().getPluginManager().getPlugin("gFeatures"))
                    .setOption(0, new ItemStack(Material.WHITE_STAINED_GLASS_PANE))
                    .setOption(1, new ItemStack(Material.WHITE_STAINED_GLASS_PANE))
                    .setOption(2, cyan)
                    .setOption(3, new ItemStack(Material.WHITE_STAINED_GLASS_PANE))
                    .setOption(4, lime)
                    .setOption(5, new ItemStack(Material.WHITE_STAINED_GLASS_PANE))
                    .setOption(6, pink)
                    .setOption(8, new ItemStack(Material.WHITE_STAINED_GLASS_PANE))
                    .setOption(7, new ItemStack(Material.WHITE_STAINED_GLASS_PANE));
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ItemStack createItem(Material material, String name, String ... lore){
        ItemStack item = new ItemStack(material, 1);
        List<String> lores = new ArrayList<>(Arrays.asList(lore));
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(lores);
        item.setItemMeta(meta);
        return item;
    }
}
