package net.estinet.gFeatures.Feature.GenesisAccess;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerQuitEvent;

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

public class Main {
	File f = new File("plugins/gFeatures/GenesisAccess/chat.txt");
    public void onEnable() { //What to do on server load/reload
    	ConfigHub ch = new ConfigHub();
    	ch.setupConfig();
        Bukkit.getLogger().info("GenesisAccess 1.3 is enabled. All clear for take off!");
        int num = 0;
        boolean b = false;
    	while(b == false){
        if(!f.exists()){
	         try {
	        	 Bukkit.getLogger().info("Creating a new file...");
	        	 b=true;
	        	 f.createNewFile();
	         }
	         catch(Exception e){
	        	 Bukkit.getLogger().info("File could not be created.");	 
	         }
	         }
        
    	else{
    		num += 1;
    		f=new File("GenesisAccess/chat"+num+".txt");
    	}
        }
        }
    public void onDisable() { //What to do on server unload/reload
       Bukkit.getLogger().info("GenesisAccess is disabled. Bye!");
    }
    
    public void PlayerChatEvent(AsyncPlayerChatEvent e){
   	 String message = e.getMessage();
   	 String playername = e.getPlayer().getName();
   	 BufferedWriter output;
		try {
			output = new BufferedWriter(new FileWriter(f, true));
			output.write(playername + ": " + message +"\n");
			output.newLine();
        output.close();
		}
		catch(Exception e1){
			Bukkit.getLogger().info("UHOH");
		}
    }
    
    public void PlayerCommandEvent(PlayerCommandPreprocessEvent e){
   	 String message = e.getMessage();
   	 String playername = e.getPlayer().getName();
   	 BufferedWriter output;
		try {
			output = new BufferedWriter(new FileWriter(f, true));
			output.write(playername + ": executed command " + message +"\n");
			output.newLine();
        output.close();
		}
		catch(Exception e1){
			Bukkit.getLogger().info("UHOH");
		}
    }
    
    public void PlayerJoinEvent(org.bukkit.event.player.PlayerJoinEvent playerjoin){
   	 String playername = playerjoin.getPlayer().getName();
   	 BufferedWriter output;
		try {
			output = new BufferedWriter(new FileWriter(f, true));
			output.write(playername + ": joined the game");
			output.newLine();
        output.close();
		}
		catch(Exception e1){
			Bukkit.getLogger().info("UHOH");
		}
    }

    
    public void PlayerSlainEvent(PlayerDeathEvent e){
   	 if(e.getEntity() instanceof Player){
   	 String playername = e.getEntity().getName();
   	 BufferedWriter output;
		try {
			output = new BufferedWriter(new FileWriter(f, true));
			output.write(playername + " was slain by "+ e.getEntity().getKiller());
			output.newLine();
			output.close();
		}
		catch(Exception e1){
			Bukkit.getLogger().info("UHOH");
		}
		}
    }
    
    public void PlayerleaveEvent(PlayerQuitEvent e){
   	 String playername = e.getPlayer().getName();
   	 BufferedWriter output;
		try {
			output = new BufferedWriter(new FileWriter(f, true));
			output.write(playername + ": left the game");
			output.newLine();
			output.close();
		}
		catch(Exception e1){
			Bukkit.getLogger().info("UHOH");
		}
    }
}
