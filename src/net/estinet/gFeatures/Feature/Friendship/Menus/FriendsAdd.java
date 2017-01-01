package net.estinet.gFeatures.Feature.Friendship.Menus;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import net.estinet.gFeatures.API.Inventory.AnvilGUI;
import net.estinet.gFeatures.ClioteSky.API.CliotePing;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2017 EstiNet

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

public class FriendsAdd {
	public void init(Player p){
		AnvilGUI gui = new AnvilGUI(p, new AnvilGUI.AnvilClickEventHandler(){
			@Override
			public void onAnvilClick(AnvilGUI.AnvilClickEvent event){
				if(event.getSlot() == AnvilGUI.AnvilSlot.OUTPUT){
					event.setWillClose(true);
					event.setWillDestroy(true);

					CliotePing cp = new CliotePing();
					cp.sendMessage("friends request " + p.getName() + " " + event.getName(), "Bungee");
				} else {
					event.setWillClose(false);
					event.setWillDestroy(false);
				}
			}
		});

		gui.setSlot(AnvilGUI.AnvilSlot.INPUT_LEFT, new ItemStack(Material.NAME_TAG));

		gui.open();
	}
}
