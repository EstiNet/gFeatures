package tk.genesishub.gFeatures.gDestroyCritical;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class TeamManager {
	Constants cons = new Constants();
	public void ChooseTeams(Player p){
		java.util.List<String> ot = cons.ot;
		java.util.List<String> bt = cons.bt;
		 if(ot.size() > bt.size()){
    		 bt.add(p.getName());
    		 Bukkit.getServer().broadcastMessage("Player " + p.getName() + " has joined the blue team!");
    		 p.teleport(cons.lobby);
    		 p.setGameMode(GameMode.SURVIVAL);
    		 p.sendMessage("To join the game, do the command /join!");
    	 }
    	 else{
    		 ot.add(p.getName());
    		 Bukkit.getServer().broadcastMessage("Player " + p.getName() + " has joined the orange team!");
    		 p.teleport(cons.lobby);
    		 p.setGameMode(GameMode.SURVIVAL);
    		 p.sendMessage("To join the game, do the command /join!");
    	 }
	}
	public String getTeam(Player p){
		if(cons.ot.contains(p.getName())){
			return "orange";
		}
		else{
			return "blue";
		}
	}
}
