package tk.genesishub.gFeatures.gHub;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.event.player.PlayerJoinEvent;

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

public class Listeners {
	public void onEnable(){
		
	}
	public void onDisable(){
		
	}
	@SuppressWarnings("deprecation")
	public void onPlayerJoin(PlayerJoinEvent event){
		event.getPlayer().playEffect(event.getPlayer().getLocation(), Effect.RECORD_PLAY, 2262);
		event.getPlayer().sendMessage(ChatColor.DARK_AQUA + "Now playing: Vexento-Pixel Party");
		event.getPlayer().sendMessage(ChatColor.DARK_AQUA + "Make sure you get the resource pack!");
	}
}
