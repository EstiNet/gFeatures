package net.estinet.gFeatures.Feature.gHub;

import net.estinet.gFeatures.Basic;
import net.estinet.gFeatures.API.Inventory.ClearInventory;
import net.estinet.gFeatures.Command.RegisterCommand;
import net.estinet.gFeatures.Feature.gHub.command.Spawn;
import net.estinet.gFeatures.Feature.gHub.config.gHubConfig;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

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

public class Enable {
	public void onEnable(){
		Bukkit.getLogger().info("[gHub] gHub is enabled! Hi!");
		Bukkit.getServer().setDefaultGameMode(GameMode.ADVENTURE);
		RegisterCommand rc = new RegisterCommand();
		rc.register(new Spawn(), "spawn");
		gHubConfig ghc = new gHubConfig();
		ghc.setup();
		
		Basic.addPlayerSection("Settings", "");
		Basic.addPlayerSection("Settings.showChat", "true");
		Basic.addPlayerSection("Settings.scoreBoard", "true");
		
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
        	public void run(){
        		for(Player p : Bukkit.getOnlinePlayers()){
        			ClearInventory ci = new ClearInventory();
        			ci.clearInv(p);
        			p.getInventory().setItem(0, EventHub.pane);
        			p.getInventory().setItem(1, EventHub.pane);
        			p.getInventory().setItem(2, EventHub.pane);
        			p.getInventory().setItem(6, EventHub.pane);
        			p.getInventory().setItem(4, EventHub.navigator);	
        			p.getInventory().setItem(3, EventHub.additions);
        			p.getInventory().setItem(5, EventHub.settings);
        			p.getInventory().setItem(7, EventHub.pane);
        			p.getInventory().setItem(8, EventHub.pane);
        		}
        	}
        }, 600L, 600L);
	}
}
