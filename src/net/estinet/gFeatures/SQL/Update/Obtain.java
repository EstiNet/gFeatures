package net.estinet.gFeatures.SQL.Update;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;

import net.estinet.gFeatures.Basic;
import net.estinet.gFeatures.SQL.Player.EstiPlayer;
import net.estinet.gFeatures.SQL.Player.EstiSet;

public class Obtain {
	static Connection c = new Connection();
	@SuppressWarnings("rawtypes")
	public static void start(){
		//if(Basic.getSQLState()){
		Bukkit.getLogger().info("[gFeatures] Initializing PlayerSQL API...");
		String Address, Port, Tablename, Username, Password;
		Address = Basic.getAddress();
		Port = Basic.getPort();
		Tablename = Basic.getTablename();
		Username = Basic.getUsername();
		Password = Basic.getPassword();
		String URL = c.toURL(Port, Address, Tablename);
		c.checkOnline(URL, Username, Password);
		c.Connect(URL, Username, Password, "CREATE TABLE IF NOT EXISTS People(id MEDIUMINT NOT NULL AUTO_INCREMENT, Name VARCHAR(200), Object blob, PRIMARY KEY (id))  ENGINE=InnoDB;");
		//c.Connect(URL, Username, Password, "ALTER TABLE People ADD UNIQUE INDEX(Name, Object);");
		
		List<EstiSet> sets = Basic.getSQLFields();
		
		List<EstiPlayer> players = new ArrayList<>();
		
		int i = Integer.parseInt(c.ConnectReturn(URL, Username, Password, "SELECT COUNT(*) FROM People").get(0));
		Bukkit.getLogger().info(Integer.toString(i));
		i++;
		
		for(int iter = 1; iter < i; iter++){
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
	//}
}
