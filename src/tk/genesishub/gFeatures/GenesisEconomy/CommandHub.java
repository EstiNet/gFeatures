package tk.genesishub.gFeatures.GenesisEconomy;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHub {
	MoneyManager mm = new MoneyManager();
	CheckConfig cc = new CheckConfig();
	Connection c = new Connection();
	@SuppressWarnings("deprecation")
	public void Intitiate(CommandSender sender, Command command, String commandLabel, String[] args) {
		String URL, Username, Password, Address, Port, Tablename;
		Password = cc.getPassword();
		Username = cc.getUsername();
		Address = cc.getAddress();
		Port = cc.getPort();
		Tablename = cc.getTablename();
		URL = c.toURL(Port, Address, Tablename);
		if(!(sender instanceof Player)) {
            Bukkit.getLogger().info("Only players are supported for this GenesisEconomy as of now.");
        }
        Player player = (Player) sender;
        if(command.getLabel().equals("clupic")) {
          if(args.length == 0){
        	  float m = mm.getMoney(player);
        	  if(m%0.1 == 0){
        		  sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "You have " + ChatColor.AQUA + "" + mm.getMoney(player) + "0" + ChatColor.GOLD + "" + ChatColor.BOLD + " clupic.");
        	  }
        	  else{
        		  sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "You have " + ChatColor.AQUA + mm.getMoney(player) + ChatColor.GOLD + "" + ChatColor.BOLD + " clupic");
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
           		  if(!op.equals(null)){
           			  Player p = (Player)op;
           			  float m = mm.getMoney(player);
           			  if(m%0.1 == 0){
                   		  sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Player " + p.getName() + " has " + ChatColor.AQUA + "" + mm.getMoney(player) + "0" + ChatColor.GOLD + "" + ChatColor.BOLD + " clupic.");
                   	  }
                   	  else{
                   	  sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Player " + p.getName() + " has " + ChatColor.AQUA + mm.getMoney(player) + ChatColor.GOLD + "" + ChatColor.BOLD + " clupic");
                   	  }
           		  }
           		  else{
           			  sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Player not found. :(");
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
          		try{
          		float m = Float.parseFloat(args[2]);
          		if(m > mm.getMoney((Player)sender)){
          			sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "You don't have enough money!");
          		}
          		else{
          			if(Bukkit.getPlayer(args[1]).isOnline()){
          				Player pl = Bukkit.getPlayer(args[1]);
          				mm.giveMoney(pl, m);
              			mm.takeMoney((Player)sender, m);
              			sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Sent " + m + " clupic to " + pl.getName());
              			pl.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "You recieved " + m + " clupic from " + sender.getName());
          			}
          			else{
          				OfflinePlayer op = Bukkit.getOfflinePlayer(args[1]);
          				mm.giveMoney((Player)op, m);
          				mm.takeMoney((Player)sender, m);
          				sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Sent " + m + " clupic to " + op.getName());
          			}
          		}
          		}catch(Exception e){
          			sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Problem with your input! Check what you entered.");
          			e.printStackTrace();
          		}
		  		break;
	  		case "set":
		  		if(sender.hasPermission("GenesisEconomy.admin")){
		  			try{
		  			mm.setMoney(Bukkit.getServer().getPlayer(args[1]), Float.parseFloat(args[2]));
			  		sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Set player " + Bukkit.getServer().getPlayer(args[1]).getName() + "'s balance to " + args[2]);
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
