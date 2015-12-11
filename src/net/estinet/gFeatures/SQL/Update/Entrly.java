package net.estinet.gFeatures.SQL.Update;

import org.bukkit.entity.Player;

import net.estinet.gFeatures.Basic;
import net.estinet.gFeatures.SQL.Player.EstiPlayer;

public class Entrly {
	public void join(Player p){
		for(int i = 0; i < Basic.getEstiPlayers().size(); i++){
			EstiPlayer player = Basic.getEstiPlayers().get(i);
		}
		for(EstiPlayer player : Basic.getEstiPlayers()){
			if(player.getUUID().equals(p.getUniqueId())){
				Basic.getEstiPlayers().set
				return;
			}
		}
	}
	public void leave(Player p){
		
	}
}
