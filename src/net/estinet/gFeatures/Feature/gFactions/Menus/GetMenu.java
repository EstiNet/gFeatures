package net.estinet.gFeatures.Feature.gFactions.Menus;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import net.estinet.gFeatures.Basic;
import net.estinet.gFeatures.Feature.gFactions.Blaze;
import net.estinet.gFeatures.API.Inventory.InventoryAPI;

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

public class GetMenu {
	net.estinet.gFeatures.Feature.gFactions.Menus.Autorifle.Beginner autorifle = new net.estinet.gFeatures.Feature.gFactions.Menus.Autorifle.Beginner();
	net.estinet.gFeatures.Feature.gFactions.Menus.Shotgun.Beginner shotgun = new net.estinet.gFeatures.Feature.gFactions.Menus.Shotgun.Beginner();
	net.estinet.gFeatures.Feature.gFactions.Menus.Snipers.Beginner sniper = new net.estinet.gFeatures.Feature.gFactions.Menus.Snipers.Beginner();
	public void start(PlayerInteractEntityEvent event){
		Bukkit.getLogger().info(event.getPlayer().getUniqueId().toString());
		Bukkit.getLogger().info(event.getRightClicked().getUniqueId().toString());
		Bukkit.getLogger().info(Blaze.autorifles.toString());
		if(event.getRightClicked().getUniqueId().equals(Blaze.autorifles)){
			Bukkit.getLogger().info(Basic.getgPlayer(event.getPlayer().getUniqueId().toString()).getValue("gFactionsTier"));
			if(!(Basic.getgPlayer(event.getPlayer().getUniqueId().toString()).getValue("gFactionsTier").equals("autorifle"))){
				autorifle.makeInventory(event.getPlayer(), Basic.getgPlayer(event.getPlayer().getUniqueId().toString()));
				Blaze.invtrigger.add(event.getPlayer().getName());
			}
		}
		else if(event.getRightClicked().getUniqueId().equals(Blaze.shotguns)){
			
		}
		else if(event.getRightClicked().getUniqueId().equals(Blaze.snipers)){
			
		}
	}
	public void start(EntityDamageByEntityEvent event){
		Player pl = (Player) event.getDamager();
		if(event.getEntity().getUniqueId().toString().equals(Blaze.autorifles.toString())){
			if(!(Basic.getgPlayer(pl.getUniqueId().toString()).getValue("gFactionsTier").equals("autorifle"))){
				InventoryAPI iapi = autorifle.makeInventory(pl, Basic.getgPlayer(pl.getUniqueId().toString()));
				iapi.open(pl);
			}
		}
		else if(event.getEntity().getUniqueId().toString().equals(Blaze.shotguns.toString())){
			if(!(Basic.getgPlayer(pl.getUniqueId().toString()).getValue("gFactionsTier").equals("shotgun"))){
				InventoryAPI iapi = shotgun.makeInventory(pl, Basic.getgPlayer(pl.getUniqueId().toString()));
				iapi.open(pl);
			}
		}
		else if(event.getEntity().getUniqueId().toString().equals(Blaze.snipers.toString())){
			if(!(Basic.getgPlayer(pl.getUniqueId().toString()).getValue("gFactionsTier").equals("sniper"))){
				InventoryAPI iapi = sniper.makeInventory(pl, Basic.getgPlayer(pl.getUniqueId().toString()));
				iapi.open(pl);
			}
		}
	}
}
