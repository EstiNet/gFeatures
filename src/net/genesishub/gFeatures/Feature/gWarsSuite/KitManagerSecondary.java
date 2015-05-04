package net.genesishub.gFeatures.Feature.gWarsSuite;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import com.shampaggon.crackshot.CSUtility;

/*
gFeatures
https://github.com/Seshpenguin/gFeatures

   Copyright 2015 DolphinBox

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

public class KitManagerSecondary {
	Constants cons = new Constants();
	public void gunKitsSetup(Player player, String gunName){
    	if(Constants.bt.contains(player.getName())){
    		 double x1 = Double.parseDouble("134");//insert x
               double y1 = Double.parseDouble("61");//insert y
               double z1 = Double.parseDouble("283");//insert z
               Location e1 = new Location(player.getWorld(), x1, y1, z1);
               player.teleport(e1);//tp's to orangetp
    	}
    	else if(Constants.ot.contains(player.getName())){
    		 double x1 = Double.parseDouble("134");//insert x
               double y1 = Double.parseDouble("19");//insert y
               double z1 = Double.parseDouble("283");//insert z
               Location e1 = new Location(player.getWorld(), x1, y1, z1);
               player.teleport(e1);//tp's to bluetp
    	}
    	CSUtility cs = new CSUtility();
    	cs.giveWeapon(player, gunName, 1);
    }
}
