package net.estinet.gFeatures.Feature.CTF;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;

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

public class Enable{
	static ConfigHub ch = new ConfigHub();
	public static void onEnable(){
		Bukkit.getLogger().info("[CTF] Enabled :D");
		ch.setupConfig();
		Bukkit.getServer().createWorld(new WorldCreator("MinigameSpawn"));
		Bukkit.getServer().createWorld(new WorldCreator("CTF"));
	}
}
