package net.estinet.gFeatures.Feature.FusionPlay.GameUtil;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import net.estinet.gFeatures.API.Logger.Debug;
import net.estinet.gFeatures.Feature.FusionPlay.FusionPlay;

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

public class WorldUtil {
	public static int movingSpawnIndex = 0;
	public static void initializeGame(){
		FusionGame fg = FusionPlay.currentGame;
		int random = (int )(Math.random() * (fg.getMaps().size()));
		Debug.print("[FusionPlay] World magic number: " + random);
		FusionPlay.currentGame.setFusionMap(fg.getMaps().get(random));
		copyWorld(fg.getMaps().get(random).getFile());
	}
	public static void copyWorld(File f){
		Bukkit.getLogger().info("[FusionPlay] Loading world " + f.getName() + "...");
		File fz = new File("./world");
		fz.delete();
		try {
			FileUtils.copyDirectory(f, fz);
			Bukkit.getLogger().info("[FusionPlay] World loading completed.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void movePlayer(Player p){
		p.teleport(FusionPlay.currentGame.getFusionMap().getSpawns().get(movingSpawnIndex));
		if(movingSpawnIndex == FusionPlay.currentGame.getFusionMap().getSpawns().size()-2){
			movingSpawnIndex = 0;
		}
		else{
			movingSpawnIndex++;
		}
	}
}
