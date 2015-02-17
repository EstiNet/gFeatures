package tk.genesishub.gWarsSuite;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TeamManager {
	Constants cons = new Constants();
	 public String getTeam(String playername){
     	if(Constants.bt.contains(playername)){
     		return ChatColor.DARK_AQUA+"blue";
     	}
     	if(Constants.ot.contains(playername)){
     		return ChatColor.GOLD+"orange";
     	}
			return "No team";
     }
	 @SuppressWarnings("deprecation")
	public void TeamSwitchInitiate(final CommandSender sender, Command cmd, String label, String[] args){
		 Player player = (Player)sender;
		 if(Constants.ot.contains(sender.getName()) && Constants.ot.size() > Constants.bt.size()){
				Bukkit.getServer().broadcastMessage(ChatColor.GRAY+player.getName()+ " has switched to the "+ ChatColor.BLUE +"blue"+ ChatColor.GRAY +" team!");
				Constants.bt.add(player.getName());
				Constants.ot.remove(player.getName());
				player.setHealth(0);
			}
			else if(Constants.bt.contains(sender.getName()) && Constants.ot.size() < Constants.bt.size()){
				Bukkit.getServer().broadcastMessage(ChatColor.GRAY+player.getName()+ " has switched to the "+ ChatColor.GOLD +"orange"+ ChatColor.GRAY +" team!");
				Constants.ot.add(player.getName());
				Constants.bt.remove(player.getName());
				player.setHealth(0);
			}
			else{
				sender.sendMessage("You can't switch teams: teams will be uneven!");
			}
	 }
}
