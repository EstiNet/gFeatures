package tk.genesishub.gWarsSuite;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TeamManager {
	Constants cons = new Constants();
	 public String getTeam(String playername){
     	if(Constants.bt.contains(playername)){
     		return "blue";
     	}
     	if(Constants.ot.contains(playername)){
     		return "orange";
     	}
			return "No team";
     }
	 @SuppressWarnings("deprecation")
	public void TeamSwitchInitiate(final CommandSender sender, Command cmd, String label, String[] args){
		 Player player = (Player)sender;
		 if(Constants.ot.contains(sender.getName()) && Constants.ot.size() > Constants.bt.size()){
				Bukkit.getServer().broadcastMessage(player.getName()+ " has switched to the blue team!");
				Constants.bt.add(player.getName());
				Constants.ot.remove(player.getName());
				player.setHealth(0);
			}
			else if(Constants.bt.contains(sender.getName()) && Constants.ot.size() < Constants.bt.size()){
				Bukkit.getServer().broadcastMessage(player.getName()+ " has switched to the orange team!");
				Constants.ot.add(player.getName());
				Constants.bt.remove(player.getName());
				player.setHealth(0);
			}
			else{
				sender.sendMessage("You can't switch teams, the teams will be unfair!");
			}
	 }
}
