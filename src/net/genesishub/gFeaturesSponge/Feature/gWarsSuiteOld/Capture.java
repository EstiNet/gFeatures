package net.genesishub.gFeatures.Feature.gWarsSuiteOld;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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

public class Capture{
	TeamManager tm = new TeamManager();
	@SuppressWarnings("deprecation")
	public void CaptureCommandInitiate(final CommandSender sender, Command cmd, String label, String[] args){
		Player p = (Player) sender;
		World world = Bukkit.getServer().getWorld("gWars");
		int X = (int) p.getLocation().getX();
		int Z = (int) p.getLocation().getZ();
		if((X==497 || X==496 || X== 495)&&(Z==176||Z==177||Z==178||Z==179)){
			Block block = world.getBlockAt(223, 3, 168);
			Block block1 = world.getBlockAt(497, 3, 176);
			Block block2 = world.getBlockAt(497, 3, 177);
			Block block3 = world.getBlockAt(497, 3, 178);
			Block block4 = world.getBlockAt(497, 3, 179);
			Block block5 = world.getBlockAt(496, 3, 176);
			Block block6 = world.getBlockAt(495, 3, 176);
			Block block7 = world.getBlockAt(496, 3, 179);
			Block block8 = world.getBlockAt(495, 3, 179);
			Block block9 = world.getBlockAt(495, 3, 178);
			Block block10 = world.getBlockAt(495, 3, 177);
			if((block.getType() == Material.STONE && tm.getTeam(p.getName()).equals(ChatColor.GOLD+"orange"))||(block.getType() == Material.GRASS && tm.getTeam(p.getName()).equals(ChatColor.DARK_AQUA+"blue"))){
			Bukkit.getServer().broadcastMessage(ChatColor.GRAY+p.getName()+ " has captured the town for the "+ChatColor.BOLD+  tm.getTeam(p.getName()) +ChatColor.RESET+" "+ChatColor.GRAY+"team!");
			if(tm.getTeam(p.getName()).equals(ChatColor.GOLD+"orange")){
				block.setType(Material.GRASS);
				block1.setData((byte) 1);
    			block2.setData((byte) 1);
    			block3.setData((byte) 1);
    			block4.setData((byte) 1);
    			block5.setData((byte) 1);
    			block6.setData((byte) 1);
    			block7.setData((byte) 1);
    			block8.setData((byte) 1);
    			block9.setData((byte) 1);
    			block10.setData((byte) 1);
    		}
    		else if(tm.getTeam(p.getName()).equals(ChatColor.DARK_AQUA+"blue")){	
    			block.setType(Material.STONE);
    			block1.setData((byte) 3);
        		block2.setData((byte) 3);
        		block3.setData((byte) 3);
        		block4.setData((byte) 3);
        		block5.setData((byte) 3);
        		block6.setData((byte) 3);
        		block7.setData((byte) 3);
        		block8.setData((byte) 3);
        		block9.setData((byte) 3);
        		block10.setData((byte) 3);
        	}
			}else{
				sender.sendMessage("Your team already captured the town!");
			}
			}
		
		else if((X == 551 || X == 550 || X == 552) && (Z == 421 || Z == 422 || Z == 420)){
			Block block = world.getBlockAt(223, 3, 169);
			Block block1 = world.getBlockAt(550, 3, 422);
			Block block2 = world.getBlockAt(550, 3, 421);
			Block block3 = world.getBlockAt(550, 3, 420);
			Block block4 = world.getBlockAt(551, 3, 422);
			Block block5 = world.getBlockAt(552, 3, 422);
			Block block6 = world.getBlockAt(551, 3, 420);
			Block block7 = world.getBlockAt(552, 3, 420);
			Block block8 = world.getBlockAt(552, 3, 421);
			if((block.getType() == Material.STONE && tm.getTeam(p.getName()).equals(ChatColor.GOLD+"orange"))||(block.getType() == Material.GRASS && tm.getTeam(p.getName()).equals(ChatColor.DARK_AQUA+"blue"))){
				Bukkit.getServer().broadcastMessage(ChatColor.GRAY+p.getName()+ " has captured the island for the "+ChatColor.BOLD+  tm.getTeam(p.getName()) +ChatColor.RESET+" "+ChatColor.GRAY+"team!");
			if(tm.getTeam(p.getName()).equals(ChatColor.GOLD+"orange")){
			block.setType(Material.GRASS);
			block1.setData((byte) 1);
			block2.setData((byte) 1);
			block3.setData((byte) 1);
			block4.setData((byte) 1);
			block5.setData((byte) 1);
			block6.setData((byte) 1);
			block7.setData((byte) 1);
			block8.setData((byte) 1);
			}
			else if(tm.getTeam(p.getName()).equals(ChatColor.DARK_AQUA+"blue")){	
			block.setType(Material.STONE);
			block1.setData((byte) 3);
    		block2.setData((byte) 3);
    		block3.setData((byte) 3);
    		block4.setData((byte) 3);
    		block5.setData((byte) 3);
    		block6.setData((byte) 3);
    		block7.setData((byte) 3);
    		block8.setData((byte) 3);
    		}
		}
			else{
				sender.sendMessage("Your team already captured the island!");
			}	
		}
		else{
			sender.sendMessage("You are not on a capture point!");
		}
	}
}
