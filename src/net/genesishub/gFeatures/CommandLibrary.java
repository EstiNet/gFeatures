package net.genesishub.gFeatures;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;

import org.apache.commons.io.IOUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CommandLibrary {
	
	public void Commands(final CommandSender sender, Command cmd, String label, String[] args){
		try{
			onCommand(sender, cmd, label, args);
		}
		catch(Exception e){
			Bukkit.getLogger().info("Error occurred when executing a gFeatures command.");
			Bukkit.getLogger().info("Here's the error:");
			e.printStackTrace();
		}
	}
	
	public void onCommand(final CommandSender sender, Command cmd, String label, String[] args){}
	
	public boolean Check(String check, String command) throws IOException{
		Reader paramReader = new InputStreamReader(getClass().getResourceAsStream("/net/genesishub/gFeatures/Feature/Commands/" + check));
		StringWriter writer = new StringWriter();
		IOUtils.copy(paramReader, writer);
		String theString = writer.toString();
		String[] lines = theString.split("\n");
		for(int i = 0; i < lines.length; i++){
			if(lines[i].equals(command)){
				return true;
			}
		}
		return false;
	}
}
