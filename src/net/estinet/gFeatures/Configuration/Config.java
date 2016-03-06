package net.estinet.gFeatures.Configuration;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

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

public class Config {
	public void createDirectory(String path, String message){
		File f = new File(path);
		if(!(f.isDirectory())){
			f.mkdir();
			Bukkit.getLogger().info(ChatColor.GOLD + "[gFeatures] " + message);
			return;
		}
		else{
			return;
		}
	}
	public void createFile(String path, String message){
		File f = new File(path);
		if(!(f.exists())){
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			Bukkit.getLogger().info(ChatColor.GOLD + "[gFeatures] " + message);
			return;
		}
		else{
			return;
		}
	}
}
