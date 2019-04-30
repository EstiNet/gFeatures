package net.estinet.gFeatures.SQL.Update;

import java.util.ArrayList;
import java.util.List;

import net.estinet.gFeatures.SQL.Player.EstiPlayer;
import net.estinet.gFeatures.SQL.Player.EstiSet;
import net.estinet.gFeatures.gFeatures;

/*
 * gFeatures
 * https://github.com/EstiNet/gFeatures
 *
 *    Copyright 2019 EstiNet
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *
 */

public class Read {
	Connection c = new Connection();
	public void read(){
		String Address, Port, Tablename, Username, Password;
		Address = gFeatures.getAddress();
		Port = gFeatures.getPort();
		Tablename = gFeatures.getTablename();
		Username = gFeatures.getUsername();
		Password = gFeatures.getPassword();
		
		String URL = c.toURL(Port, Address, Tablename);
		List<EstiSet> sets = gFeatures.getSQLFields();
		
		List<EstiPlayer> players = new ArrayList<>();
		
		int i = Integer.parseInt(c.ConnectReturn(URL, Username, Password, "SELECT COUNT(*) FROM People").get(1));
		
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
		gFeatures.setEstiPlayers(players);
	}
}
