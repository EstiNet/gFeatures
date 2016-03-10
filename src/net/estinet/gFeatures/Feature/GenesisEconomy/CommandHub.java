package net.estinet.gFeatures.Feature.GenesisEconomy;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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

public class CommandHub {
	MoneyManager mm = new MoneyManager();
	CheckConfig cc = new CheckConfig();
	Connection c = new Connection();
	@SuppressWarnings({ "deprecation", "unused" })
	public void Intitiate(CommandSender sender, Command command, String commandLabel, String[] args) throws IllegalArgumentException, IllegalStateException {
		String URL, Username, Password, Address, Port, Tablename;
		Password = cc.getPassword();
		Username = cc.getUsername();
		Address = cc.getAddress();
		Port = cc.getPort();
		Tablename = cc.getTablename();
		URL = c.toURL(Port, Address, Tablename);
		if(!(sender instanceof Player)) {
			if(!(args.length == 3)){
            Bukkit.getLogger().info("Only players are supported for this GenesisEconomy as of now.");
            }
        }
        if(command.getLabel().equals("clupic")) {
          if(args.length == 0){
        	  float m = mm.getMoney((Player)sender);
        	  if(m%0.1 == 0){
        		  sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "You have " + ChatColor.AQUA + "" + mm.getMoney((Player)sender) + "0" + ChatColor.GOLD + "" + ChatColor.BOLD + " clupic.");
        	  }
        	  else{
        		  sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "You have " + ChatColor.AQUA + mm.getMoney((Player)sender) + ChatColor.GOLD + "" + ChatColor.BOLD + " clupic.");
        	  }
          }
          if(args.length == 1){
        	  switch(args[0]){
        	  case "help":
        		  sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD +"-----Help-----");
        		  sender.sendMessage(ChatColor.AQUA + "/clupic | Views how much clupic you have.");
        		  sender.sendMessage(ChatColor.AQUA + "/clupic get <player>| Views how much clupic the player has.");
        		  sender.sendMessage(ChatColor.AQUA + "/clupic pay <player> <amount>| Pays a player.");
        		  sender.sendMessage(ChatColor.AQUA + "/clupic set <player> <amount>| Admin command.");
        		  sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD +"-----Help-----");
        		  break;
        	  case "pay":
        		  sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Usage: /clupic pay <player> <amount>");
        		  break;
        	  case "set":
        		  if(sender.hasPermission("GenesisEconomy.admin")){
        			  sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Usage: /clupic set <player> <amount>");
        		  }
        		  else{
        			  sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Beep bop. No access to the command!");
        		  }
        		  break;
        	  case "top":
        		  sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "This feature is not available yet.");
        		  break;
        	  case "get":
        		  sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "/clupic get <player>");
        		  break;
        	  default:
        		  sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "/clupic help");
        		  break;
        	  }
          }
          if(args.length == 2){
        	  switch(args[0]){
        	  	case "pay":
        	  		sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Usage: /clupic pay <player> <amount>");
    		  		break;
    	  		case "set":
    		  		if(sender.hasPermission("GenesisEconomy.admin")){
    			  		sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Usage: /clupic set <player> <amount>");
    		  		}
    		  		else{
    			  		sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Beep bop. No access to the command!");
    		  		}
    		  		break;
    	  		 case "get":
           		  OfflinePlayer op = Bukkit.getOfflinePlayer(args[1]);
           		  try{
           		  if(mm.playerExists(op)){
           			  float m = mm.getMoney((Player)sender);
           			  if(m%0.1 == 0){
                   		  sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Player " + op.getName() + " has " + ChatColor.AQUA + "" + mm.getMoney(op) + "0" + ChatColor.GOLD + "" + ChatColor.BOLD + " clupic.");
                   	  }
                   	  else{
                   	  sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Player " + op.getName() + " has " + ChatColor.AQUA + mm.getMoney(op) + ChatColor.GOLD + "" + ChatColor.BOLD + " clupic.");
                   	  }
           		  }
           		  else{
           			  sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Player not found. :(");
           		  }
           		  }catch(Exception e){
           			  sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Error in your input. Try again!");
           			  e.printStackTrace();
           		  }
           		  break;
    	  		default:
          		  sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "/clupic help");
          		  break;
    		  }
          }
          if(args.length == 3){
          	switch(args[0]){
          	case "pay":
          		if(!(Float.parseFloat(args[2]) < 0)){
          		if(sender instanceof Player){
          		try{
          		float m = Float.parseFloat(args[2]);
          		if(m > mm.getMoney((Player)sender)){
          			sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "You don't have enough clupic!");
          		}
          		else{
          			if(mm.playerOnline(args[1])){
          				Player pl = Bukkit.getPlayer(args[1]);
          				mm.giveMoney(pl, m);
              			mm.takeMoney((Player)sender, m);
              			sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Sent " + m + " clupic to " + pl.getName());
              			pl.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "You recieved " + m + " clupic from " + sender.getName());
          			}
          			else{
          				OfflinePlayer op = Bukkit.getOfflinePlayer(args[1]);
          				mm.giveMoney(op, m);
          				mm.takeMoney((Player)sender, m);
          				sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Sent " + m + " clupic to " + op.getName());
          			}
          		}
          		}catch(Exception e){
          			sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Problem with your input! Check what you entered.");
          			e.printStackTrace();
          		}
          		}
          		else{
          			float m = Float.parseFloat(args[2]);
          			Player pl = Bukkit.getPlayer(args[1]);
          			try {
						mm.giveMoney(pl, m);
					} catch (Exception e) {
						e.printStackTrace();
					}
          			sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Gave " + args[2] + " clupic to player " + pl.getName());
          			pl.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Recieved " + args[2] + " clupic.");
          		}
          		}
          		else{
          			sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "No negative integers!");
          		}
		  		break;
	  		case "set":
		  		if(sender.hasPermission("GenesisEconomy.admin")){
		  			try{
		  			mm.setMoney(Bukkit.getServer().getOfflinePlayer(args[1]), Float.parseFloat(args[2]));
			  		sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Set player " + Bukkit.getServer().getOfflinePlayer(args[1]).getName() + "'s balance to " + args[2]);
		  			}catch(Exception e){
	          			sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Problem with your input! Check what you entered.");
	          		}
		  		}
		  		else{
			  		sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Beep bop. No access to the command!");
		  		}
		  		break;
	  		default:
    		  sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "/clupic help");
    		  break;
          	}
          }
        }
	}
}
