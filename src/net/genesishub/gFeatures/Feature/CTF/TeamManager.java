package net.genesishub.gFeatures.Feature.CTF;

import org.bukkit.entity.Player;

import tk.genesishub.gFeatures.API.MinigameBase.Teams;

public class TeamManager {
	net.genesishub.gFeatures.Feature.CTF.Listeners Listeners = new net.genesishub.gFeatures.Feature.CTF.Listeners();
	public void onJoinTeam(Player player, Teams team) throws Exception{
		if(team.equals(Listeners.hideandseek.getTeam(0))){
			Listeners.hideandseek.getTeam(0).addPlayer(player);
			if(Listeners.checkStartTwo()){
			Listeners.hideandseek.checkStart();
			}
		}
		else if(team.equals(Listeners.hideandseek.getTeam(1))){
			Listeners.hideandseek.getTeam(1).addPlayer(player);
			if(Listeners.checkStartTwo()){
				Listeners.hideandseek.checkStart();
			}
		}
		else{
			Exception exception = new Exception();;
			throw exception;
		}
	}
}
