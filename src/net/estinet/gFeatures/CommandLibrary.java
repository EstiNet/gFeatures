package net.estinet.gFeatures;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import net.estinet.gFeatures.Command.EstiCommand;

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
		for(EstiCommand commandd : Basic.getCommands()){
			if(commandd.getName().equals(cmd.getName())){
				try{
					commandd.execute(sender, label, args);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		
		CoreCommands cc = new CoreCommands();
		cc.onCommand(sender, cmd, label, args);
	}
}
