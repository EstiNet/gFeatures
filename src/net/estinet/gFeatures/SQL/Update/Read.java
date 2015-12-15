package net.estinet.gFeatures.SQL.Update;

import java.util.ArrayList;
import java.util.List;

import net.estinet.gFeatures.Basic;
import net.estinet.gFeatures.SQL.Player.EstiPlayer;
import net.estinet.gFeatures.SQL.Player.EstiSet;

public class Read {
	Connection c = new Connection();
	public void read(){
		String Address, Port, Tablename, Username, Password;
		Address = Basic.getAddress();
		Port = Basic.getPort();
		Tablename = Basic.getTablename();
		Username = Basic.getUsername();
		Password = Basic.getPassword();
		
		String URL = c.toURL(Port, Address, Tablename);
		List<EstiSet> sets = Basic.getSQLFields();
		
		List<EstiPlayer> players = new ArrayList<>();
		
		int i = Integer.parseInt(c.ConnectReturn(URL, Username, Password, "SELECT COUNT(*) FROM People").get(1));
		
		for(int iter = 0; iter < i; iter++){
			try {
				EstiPlayer player = (EstiPlayer) Serialization.readJavaObject(iter);
				
				for(int it = 0; it < sets.size(); it++){
					if(!player.getData().containsValue(sets.get(it))){
						player.addSet(sets.get(it).getTag().getName(), sets.get(it));
					}
				}
				players.add(player);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		Basic.setEstiPlayers(players);
	}
}
