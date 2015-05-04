package net.genesishub.gFeatures.Feature.HideAndSeek;

import org.bukkit.entity.Player;

import net.genesishub.gFeatures.API.Minigame.Teams;

public class TeamManager {
	net.genesishub.gFeatures.Feature.HideAndSeek.Listeners Listeners = new net.genesishub.gFeatures.Feature.HideAndSeek.Listeners();
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
