package net.estinet.gFeatures.Feature.FusionPlay.GameUtil;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import net.estinet.gFeatures.API.Logger.Debug;
import net.estinet.gFeatures.Feature.FusionPlay.FusionPlay;

public class WorldUtil {
	public static int movingSpawnIndex = 0;
	public static void initializeGame(){
		FusionGame fg = FusionPlay.currentGame;
		int random = (int) Math.floor(Math.random() * fg.getMaps().size());
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
