package net.estinet.gFeatures.Feature.gWarsSuite.MainMenu;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.estinet.gFeatures.Feature.gWarsSuite.Constants;
import net.estinet.gFeatures.Feature.gWarsSuite.Statistics;
import net.estinet.gFeatures.Feature.gWarsSuite.gWarsMode;
import net.estinet.gFeatures.Feature.gWarsSuite.Multiplayer.OrangeTeam;
import net.estinet.gFeatures.Feature.gWarsSuite.Multiplayer.Source;
import net.md_5.bungee.api.ChatColor;

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

public class Finish {
	Statistics stats = new Statistics();
	Join join = new Join();
	public void intialize(Player p){
		stats.setMode(p, gWarsMode.TEAM);
		join.end(p);
		p.teleport(new Location(Bukkit.getServer().getWorld("gWars"), Constants.spawndump.get(p.getName()).getX(), Constants.spawndump.get(p.getName()).getY(), Constants.spawndump.get(p.getName()).getZ()));
		Constants.spawndump.remove(p);
		Source s = new Source();
		s.flushAll();
		ItemStack compass = createItem(Material.COMPASS, ChatColor.AQUA + "Compass");
		p.getInventory().setItem(7, compass);
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "speed walking 5 "+ p.getName());
		if(OrangeTeam.hasPlayer(p)){
			ItemStack wool = new ItemStack(Material.STAINED_GLASS, 1, (byte)1);
			p.getInventory().setHelmet(wool);
		}
		else{
			ItemStack wool = new ItemStack(Material.STAINED_GLASS, 1, (byte)3);
			p.getInventory().setHelmet(wool);
		}
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
