package net.estinet.gFeatures.Feature.CTF.EventBase.GameFunc;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import net.estinet.gFeatures.API.Messaging.ActionAPI;

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

public class Action {
	static ActionAPI aapi = new ActionAPI();
	public static void sendAll(String message){
		for(Player p : Bukkit.getOnlinePlayers()){
			aapi.sendActionbar(p, message);
		}
	}
	public static void sendAllTitle(String title, String subtitle, int fadeIn, int stay, int fadeOut){
		for(Player p : Bukkit.getOnlinePlayers()){
			aapi.sendTitles(p, fadeIn, stay, fadeOut, title, subtitle);
		}
	}
}
