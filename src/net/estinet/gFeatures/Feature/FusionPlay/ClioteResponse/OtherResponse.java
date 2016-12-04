package net.estinet.gFeatures.Feature.FusionPlay.ClioteResponse;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.bukkit.Bukkit;

public class OtherResponse {
	public static void response(List<String> args, String categoryName, String clioteName){
		File f = new File("plugins/gFeatures/FusionPlay/notminigame.txt");
		try {
			f.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		BufferedWriter output;
		try {
			output = new BufferedWriter(new FileWriter(f, true));
			output.write("");
			output.newLine();
			output.close();
		}
		catch(Exception e1){
			Bukkit.getLogger().info("UHOH");
		}
		Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "stop");
	}
}
