package net.estinet.gFeatures.Feature.gHub;

import net.estinet.gFeatures.API.Inventory.EstiInventory;
import net.estinet.gFeatures.API.Inventory.InventoryAPI;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2016 EstiNet

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

public class Settings {
	public void init(Player p){
		EstiInventory open = makeInventory(p);
		open.open(p);
	}
	public EstiInventory makeInventory(Player p){
		try{
			EstiInventory menu = new EstiInventory(ChatColor.GRAY + "Settings for " + p.getDisplayName(), 9, new EstiInventory.OptionClickEventHandler() {
				@Override
				public void onOptionClick(EstiInventory.OptionClickEvent event) {
					if(event.getName().equals(ChatColor.AQUA + "Show Players") || event.getName().equals(ChatColor.AQUA + "Hide Players")){
						if(Constants.playerOn.get(p.getUniqueId())){
							HidePlayers hp = new HidePlayers();
							hp.hide(p);
						}
						else{
							HidePlayers hp = new HidePlayers();
							hp.show(p);
						}
					}
					else if(event.getName().equals(ChatColor.DARK_AQUA+"Stacker")){
						Stacker st = new Stacker();
						st.event(p);
						event.getPlayer().closeInventory();
					}
					event.setWillClose(true);
				}
			}, Bukkit.getServer().getPluginManager().getPlugin("gFeatures"))
					.setOption(0, Constants.getPlayersOnSetting(p))
					.setOption(1, new ItemStack(Material.WATCH, 1), ChatColor.DARK_AQUA+"Stacker");
			return menu;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
