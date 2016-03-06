package net.estinet.gFeatures.Feature.gDestroyCritical;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
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

public class Listeners{
	Constants cons = new Constants();
	List<String> Acceptance = cons.Acceptance;
	CommandManager cm = new CommandManager();
	GameEndure ge = new GameEndure();
	EntryExitHandler as = new EntryExitHandler();
    
    
     public void onEnable() { //What to do on server load/reload
         Bukkit.getLogger().info("gDestroyCritical is enabled. All clear for take off!");
         FileManager fm = new FileManager();
         fm.checkDirectories();
         if(!cons.f.exists()){
	       fm.AssembleFile(cons.f);
	}
         }
  
     public void onDisable() { //What to do on server unload/reload
        Bukkit.getLogger().info("gDestroyCritical is disabled. Bye!");
     }
     @EventHandler
     public void playerJoinEvent(PlayerJoinEvent e){
    	as.onJoin(e.getPlayer());
     }
     @EventHandler
     public void playerLeaveEvent(PlayerQuitEvent e){
    	 as.onLeave(e.getPlayer());
     }
     public boolean onCommand(final CommandSender sender, Command cmd, String label, String[] args) {
    	cm.onCommands(sender, cmd, label, args);
    	 return true;
     }
     @EventHandler
     public void blockbreakevent(BlockBreakEvent e){
    	ge.onBlockBreak(e.getPlayer());
     }
     //MAKE SURE U RESTRICT BLOCK PLACING TO ONLY CRAFTING TABLES FURNACES AND DIRT AND COBBLE.
}
