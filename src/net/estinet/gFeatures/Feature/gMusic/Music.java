package net.estinet.gFeatures.Feature.gMusic;

import org.bukkit.ChatColor;
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

public class Music {
	public void sendMusic(Player p, String codename, int volume, String artist, String songname, String custommessage){
		p.playSound(p.getLocation(), codename, volume, 1);
		if(!custommessage.equals("") && !custommessage.equals(null)){
			p.sendMessage(custommessage);
		}
		else{
			p.sendMessage(ChatColor.BOLD + "-----" + ChatColor.GOLD + "" + ChatColor.BOLD + "Music" + ChatColor.WHITE + ChatColor.BOLD +  "-----");
			p.sendMessage(ChatColor.AQUA + "Song name: " + songname);
			p.sendMessage(ChatColor.AQUA + "Artist: " + artist);
			p.sendMessage(ChatColor.BOLD + "---------------");
		}
	}
}
