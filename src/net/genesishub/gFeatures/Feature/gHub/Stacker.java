package net.genesishub.gFeatures.Feature.gHub;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Stacker {
	public void event(Player p){
		if(Basis.isInStacker(p.getName())){
			Basis.removeStacker(p.getName());
			p.sendMessage(ChatColor.GOLD + "[" + ChatColor.AQUA + "GenesisHub" + ChatColor.GOLD + "] " + ChatColor.RED + "Your stacker is now off!");
		}
		else{
			Basis.removeStacker(p.getName());
			p.sendMessage(ChatColor.GOLD + "[" + ChatColor.AQUA + "GenesisHub" + ChatColor.GOLD + "] " + ChatColor.GREEN + "Your stacker is now on!");
		}
	}
	  public Player checkPassenger(Player p)
	  {
	    if ((p.getPassenger() != null) && ((p.getPassenger() instanceof Player))) {
	      return (Player)p.getPassenger();
	    }
	    return (Player)p.getPassenger();
	  }
}
