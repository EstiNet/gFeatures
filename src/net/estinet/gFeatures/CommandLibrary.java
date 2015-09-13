package net.estinet.gFeatures;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2015 EstiNet

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
	
	public void onCommand(final CommandSender sender, Command cmd, String label, String[] args){
		List<gFeature> features = Basic.getFeatures();
		for(gFeature feature : features){
			if(feature.getState().equals(FeatureState.ENABLE)){
				try {
					if(Check(feature.getName(), cmd.getName())){
						feature.commandTrigger(sender, cmd, label, args);
					}
				} catch (Exception e) {}
			}
			try {
				if(Check(feature.getName(), cmd.getName()) && feature.getState().equals(FeatureState.DISABLE)){
					sender.sendMessage("EstiNet has never heard of this command. Do /help for help.");
				}
			} catch (Exception e) {
			}
		}
		List<Extension> extensions = Basic.getExtensions();
		List<gUtility> utilities = new ArrayList<>();
		for(Extension ext : extensions){
			if(ext.getType().equals(ExtensionsType.Utility)){
				utilities.add((gUtility) ext);
			}
		}
		for(gUtility uti : utilities){
			if(uti.getState().equals(FeatureState.ENABLE)){
				try {
					if(Check(uti.getName(), cmd.getName())){
						uti.commandTrigger(sender, cmd, label, args);
					}
				} catch (Exception e) {}
			}
			try {
				if(Check(uti.getName(), cmd.getName()) && uti.getState().equals(FeatureState.DISABLE)){
					sender.sendMessage("EstiNet has never heard of this command. Do /help for help.");
				}
			} catch (Exception e) {
			}
		}
		CoreCommands cc = new CoreCommands();
		cc.onCommand(sender, cmd, label, args);
	}
	
	public boolean Check(String filename, String command) throws IOException{
		Reader paramReader = new InputStreamReader(getClass().getResourceAsStream("/net/estinet/gFeatures/Feature/Commands/" + filename));
		StringWriter writer = new StringWriter();
		IOUtils.copy(paramReader, writer);
		String theString = writer.toString();
		String[] lines = theString.split("\n");
		for(int i = 0; i < lines.length; i++){
			if(lines[i].equalsIgnoreCase(command)){
				return true;
			}
		}
		return false;
	}
}
