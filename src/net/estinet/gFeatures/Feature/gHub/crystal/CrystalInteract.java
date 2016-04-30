package net.estinet.gFeatures.Feature.gHub.crystal;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.estinet.gFeatures.API.Inventory.EstiInventory;
import net.estinet.gFeatures.ClioteSky.API.CliotePing;
import net.estinet.gFeatures.Feature.gHub.Basis;

public class CrystalInteract {
	public void init(Location location, Player player){
		EstiInventory open = makeInventory(player, location);
		open.open(player);
	}
	public EstiInventory makeInventory(Player p, Location loc){
		MGServer mgs = Basis.crystals.get(loc);
		try{
			EstiInventory menu = new EstiInventory(ChatColor.GRAY + mgs.getName() + " Server Menu", 18, new EstiInventory.OptionClickEventHandler() {
				@Override
				public void onOptionClick(EstiInventory.OptionClickEvent event) {
					if(event.getName().contains(ChatColor.GREEN + "")){
						char[] subit = event.getName().toCharArray();
						List<Character> strs = new ArrayList<>();
						for(char ch : subit){
							strs.add(ch);
						}
						String cache = "";
						for(int i = 0; i < strs.size(); i++){
							if(Character.isDigit(strs.get(i))){
								cache += strs.get(i);
							}
						}
						CliotePing cp = new CliotePing();
						cp.sendMessage("redirect " + event.getPlayer().getName() + " " + mgs.getName() + cache, "Bungee");
						event.setWillClose(true);
					}
					else{
						
					}
				}
			}, Bukkit.getServer().getPluginManager().getPlugin("gFeatures"));
			int iter = 0;
			for(MGServerPlus mgsp : Basis.getServersWithType(mgs.getName())){
				if(mgsp.getState().equals("WAIT")){
					ItemStack ready = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 5);
					ItemMeta im = ready.getItemMeta();
					im.setDisplayName(ChatColor.GREEN + mgsp.getName() + ": Waiting!");
					ready.setItemMeta(im);
					menu.setOption(iter, ready);
				}
				else{
					ItemStack ready = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
					ItemMeta im = ready.getItemMeta();
					im.setDisplayName(ChatColor.RED + mgsp.getName() + ": Ingame!");
					ready.setItemMeta(im);
					menu.setOption(iter, ready);
				}
				iter++;
			}
			return menu;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	public ItemStack createItem(Material material, String name, String ... lore){
		ItemStack item = new ItemStack(material, 1);
		List<String> lores = new ArrayList<>();
		for(String lor : lore){
		lores.add(lor);
		}
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		meta.setLore(lores);
		item.setItemMeta(meta);
		return item;
	}
}
