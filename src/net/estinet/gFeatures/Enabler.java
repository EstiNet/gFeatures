package net.estinet.gFeatures;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;

import net.estinet.gFeatures.Command.EstiCommand;
import net.estinet.gFeatures.Plus.Skript.SkriptManager;

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

public class Enabler {
	public void onEnable(){
		List<gFeature> features = Basic.getFeatures();
		List<Extension> extensions = Basic.getExtensions();
		for(gFeature feature : features){
			if(feature.getState().equals(FeatureState.ENABLE)){
				try{
					feature.enable();
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		for(Extension extension : extensions){
			if(extension.getState().equals(FeatureState.ENABLE) && extension.getType().equals(ExtensionsType.Skript)){
				SkriptManager sm = new SkriptManager();
				try {
					Bukkit.getLogger().info(extension.getName() + " is ENABLED.");
					sm.Enable(extension, extension.getName());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else if(extension.getState().equals(FeatureState.ENABLE) && extension.getType().equals(ExtensionsType.Utility)){
				gUtility gu = (gUtility) extension;
				gu.enable();
			}
		}

		for(EstiCommand command : Basic.getCommands()){
			if(Basic.getFeature(command.getFeature().getName()).getState().equals(FeatureState.ENABLE)){
				try{
					Method commandMap = Bukkit.getServer().getClass().getMethod("getCommandMap", null);
					Object cmdmap = commandMap.invoke(Bukkit.getServer(), null);
					Method register = cmdmap.getClass().getMethod("register", String.class, Command.class);
					register.invoke(cmdmap, command.getName(), command);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}
}
