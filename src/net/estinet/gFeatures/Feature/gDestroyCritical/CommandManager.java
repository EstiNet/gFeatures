package net.estinet.gFeatures.Feature.gDestroyCritical;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;

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

public class CommandManager{
	 Constants cons = new Constants();
	 ArenaSetup w = new ArenaSetup();
	 GameEndure ge = new GameEndure();
	 TeamManager tm = new TeamManager();
    public boolean onCommands(final CommandSender sender, Command cmd, String label, String[] args) {
   	 if (cmd.getName().equalsIgnoreCase("join")){
   		 cons.Acceptance.add(sender.getName());
   		 if(Constants.arenaon == false){
   		 sender.sendMessage("Added you to the wait list!");
   		 int index = cons.Acceptance.indexOf(sender.getName());
   		 cons.BlockBroke.set(index, "0");
   		 w.run();
   		 }
   		 if(Constants.arenaon == true){
   			sender.sendMessage("Adding you to the game...");
   			int index = cons.Acceptance.indexOf(sender.getName());
      		cons.BlockBroke.set(index, "0");
      		if(tm.getTeam((Player)sender) == "orange"){
      			((Player) sender).teleport(cons.orangespawn);
      		}
      		else{
      			((Player) sender).teleport(cons.bluespawn);
      		}
   		 }
   		 return true;
   	 }
   	 try{
    	if (cmd.getName().equalsIgnoreCase("listteams")){
    		doorange((Player)sender);
    		BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
            scheduler.scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
               public void run(){
                 doblue((Player)sender);
                }
            }, 6L);
    	}
     }
      catch(Exception e){
        Bukkit.getLogger().info("UHOH");
     }
   	 return false;
    }
public void doorange(Player sender){
		try{
		orangelist((Player) sender);
		}
		catch(Exception e){
			Bukkit.getLogger().info("UHOH");
		}
	}
	public void doblue(Player sender){
		try{
		bluelist((Player) sender);
		}
		catch(Exception e){
			Bukkit.getLogger().info("UHOH");
		}
	}
	public void orangelist(Player sender){
	int positives = 0;
			sender.sendMessage("Orange Team Members:");
			sender.sendMessage("There are " + cons.ot.size() + " players on this team.");
			for(int iter = 0; iter <= cons.ot.size(); iter++){
				positives += ge.getBlockBroken(cons.bt.get(iter));
				sender.sendMessage(cons.ot.get(iter) + " with " + ge.getBlockBroken(cons.ot.get(iter)) + " block breaks.");
			}
			sender.sendMessage("The blue team has a total of " + positives + " blocks broken.");
			return;
		}
	public void bluelist(Player sender){
		int positives = 0;
		sender.sendMessage("Blue Team Members:");
		sender.sendMessage("There are " + cons.bt.size() + " players on this team.");
		for(int iter = 0; iter <= cons.bt.size(); iter++){
			positives += ge.getBlockBroken(cons.bt.get(iter));
			sender.sendMessage(cons.bt.get(iter) + " with " + ge.getBlockBroken(cons.bt.get(iter)) + " block breaks.");
		}
		sender.sendMessage("The blue team has a total of " + positives + " blocks broken.");
		return;
	}
	}