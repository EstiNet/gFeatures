package net.estinet.gFeatures.SQL.Update;

import net.estinet.gFeatures.Basic;
import net.estinet.gFeatures.SQL.Player.EstiPlayer;

public class Write {
	public void writeToSQL(){
		//if(Basic.getSQLState()){
		for(EstiPlayer player : Basic.getEstiPlayers()){
			try {
				Serialization.writeJavaObject(player);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//}
	}
}
