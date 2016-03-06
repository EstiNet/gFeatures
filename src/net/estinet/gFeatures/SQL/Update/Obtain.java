package net.estinet.gFeatures.SQL.Update;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;

import net.estinet.gFeatures.Basic;
import net.estinet.gFeatures.SQL.Player.EstiPlayer;
import net.estinet.gFeatures.SQL.Player.EstiSet;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2016 EstiNet

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

public class Obtain {
	static Connection c = new Connection();
	@SuppressWarnings("rawtypes")
	public static void start(){
		if(Basic.getSQLState()){
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
		i++;
		
		for(int iter = 1; iter < i; iter++){
			try {
				Bukkit.getLogger().info(Serialization.readJavaObject(iter).getClass().getName());
				EstiPlayer player = Serialization.readJavaObject(iter);
				
				for(int it = 0; it < sets.size(); it++){
					if(!player.getData().containsValue(sets.get(it))){
						player.addSet(sets.get(it).getTag(), sets.get(it));
						
					}
				}
				players.add(player);
				Basic.syncSQLPlayers();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		Basic.setEstiPlayers(players);
		}
	}
}
