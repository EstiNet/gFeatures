package net.estinet.gFeatures.Feature.FusionPlay.ClioteResponse;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.bukkit.Bukkit;

import net.estinet.gFeatures.ClioteSky.API.CliotePing;
import net.estinet.gFeatures.Feature.FusionPlay.FusionPlay;

public class OtherResponse {
	public static void response(List<String> args, String categoryName, String clioteName){
		CliotePing cp = new CliotePing();
		cp.sendMessage("fusionplay otheralive " + args.get(1), "Bungee");
		File f = new File("plugins/gFeatures/FusionPlay/notminigame.txt");
		try {
			f.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		BufferedWriter output;
		try {
			output = new BufferedWriter(new FileWriter(f, true));
			output.write(FusionPlay.currentGame.getName());
			output.newLine();
			output.close();
		}
		catch(Exception e1){
			e1.printStackTrace();
		}
		Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "stop");
	}
}
