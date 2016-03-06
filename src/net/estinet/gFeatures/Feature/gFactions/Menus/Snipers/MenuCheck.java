package net.estinet.gFeatures.Feature.gFactions.Menus.Snipers;

import org.bukkit.entity.Player;

import net.estinet.gFeatures.Basic;
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

public class MenuCheck {
	TierOne to = new TierOne();
	TierTwo tt = new TierTwo();
	TierThree tth = new TierThree();
	TierFour tf = new TierFour();
	public void check(Player p){/*
		if((Basic.getgPlayer(p.getUniqueId().toString()).getValue("gFactionsTier").equals("1"))){
			InventoryAPI iapi = TierOne.makeInventory(p, Basic.getgPlayer(p.getUniqueId().toString()));
			iapi.open(p);
		}
		else if((Basic.getgPlayer(p.getUniqueId().toString()).getValue("gFactionsTier").equals("1"))){
			InventoryAPI iapi = TierTwo.makeInventory(p, Basic.getgPlayer(p.getUniqueId().toString()));
			iapi.open(p);
		}
		else if((Basic.getgPlayer(p.getUniqueId().toString()).getValue("gFactionsTier").equals("1"))){
			InventoryAPI iapi = TierThree.makeInventory(p, Basic.getgPlayer(p.getUniqueId().toString()));
			iapi.open(p);
		}
		else if((Basic.getgPlayer(p.getUniqueId().toString()).getValue("gFactionsTier").equals("1"))){
			InventoryAPI iapi = TierFour.makeInventory(p, Basic.getgPlayer(p.getUniqueId().toString()));
			iapi.open(p);
		}*/
	}
}
