package net.estinet.gFeatures.SQL.Update;

import org.bukkit.entity.Player;

import net.estinet.gFeatures.Basic;
import net.estinet.gFeatures.SQL.Player.EstiPlayer;

public class Entrly {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void join(Player p){
		if(Basic.getSQLState()){
		for(int i = 0; i < Basic.getEstiPlayers().size(); i++){
			EstiPlayer player = Basic.getEstiPlayers().get(i);
			if(player.getUUID().equals(p.getUniqueId())){
				player.setName(player.getName());
				player.setPlayer(p);
				Basic.getEstiPlayers().set(i, player);
				return;
			}
		}
		
		EstiPlayer player = new EstiPlayer(p, Basic.getHashFromEstiSet(Basic.getSQLFields()));
		Basic.addEstiPlayer(player);
		Thread thr = new Thread(new Runnable(){
			public void run(){
				Basic.syncSQLPlayers();
			}
		});
		thr.start();
		}
	}
}
