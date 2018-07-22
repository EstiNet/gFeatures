package net.estinet.gFeatures.Feature.gWarsSuite.Multiplayer;

import org.bukkit.Material;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

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

public class Death {

	public void init(PlayerDeathEvent event) {
		if (event.getEntity().getInventory().contains(Material.LIGHT_BLUE_STAINED_GLASS)) {
			event.getDrops().remove(new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS));
		}
		if (event.getEntity().getInventory().contains(Material.ORANGE_STAINED_GLASS)) {
			event.getDrops().remove(new ItemStack(Material.ORANGE_STAINED_GLASS));
		}
	}
}
