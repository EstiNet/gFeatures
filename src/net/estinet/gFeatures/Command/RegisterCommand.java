package net.estinet.gFeatures.Command;

import java.lang.reflect.Field;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandMap;
import org.bukkit.craftbukkit.v1_11_R1.CraftServer;

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

public class RegisterCommand {
	private static CommandMap cmap;
	public void register(CommandExecutor executor, String cmdname){
	 try{
         if(Bukkit.getServer() instanceof CraftServer){
             final Field f = CraftServer.class.getDeclaredField("commandMap");
             f.setAccessible(true);
             cmap = (CommandMap)f.get(Bukkit.getServer());
         }
     } catch (Exception e){
         e.printStackTrace();
     }
	 gCommand gc = new gCommand(cmdname);
     cmap.register("", gc);
     gc.setExecutor(executor);
	}
}
