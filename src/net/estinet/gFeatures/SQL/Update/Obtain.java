package net.estinet.gFeatures.SQL.Update;

import java.util.ArrayList;
import java.util.List;

import net.estinet.gFeatures.Basic;
import net.estinet.gFeatures.SQL.Player.EstiPlayer;
import net.estinet.gFeatures.SQL.Player.EstiSet;

public class Obtain {
	static Connection c = new Connection();
	@SuppressWarnings("rawtypes")
	public static void start(){
		if(Basic.getSQLState()){
		String Address, Port, Tablename, Username, Password;
		Address = Basic.getAddress();
		Port = Basic.getPort();
		Tablename = Basic.getTablename();
		Username = Basic.getUsername();
		Password = Basic.getPassword();
		String URL = c.toURL(Port, Address, Tablename);
		c.checkOnline(URL, Username, Password);
		c.Connect(URL, Username, Password, "CREATE TABLE IF NOT EXISTS People(Name VARCHAR(200), Object blob)  ENGINE=InnoDB;");
		
		List<EstiSet> sets = Basic.getSQLFields();
		
		List<EstiPlayer> players = new ArrayList<>();
		
		int i = Integer.parseInt(c.ConnectReturn(URL, Username, Password, "SELECT COUNT(*) FROM Ranks").get(1));
		
		for(int iter = 0; iter < i; iter++){
			try {
				EstiPlayer player = (EstiPlayer) Serialization.readJavaObject(iter);
				
				for(int it = 0; it < sets.size(); it++){
					if(!player.getData().containsValue(sets.get(it))){
						player.addSet(sets.get(it).getTag(), sets.get(it));
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
}
