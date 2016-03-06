package net.estinet.gFeatures.SQL.Update;

import net.estinet.gFeatures.Basic;
import net.estinet.gFeatures.SQL.Player.EstiPlayer;

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

public class Write {
	public void writeToSQL(){
		if(Basic.getSQLState()){
		Connection c = new Connection();
		String Address, Port, Tablename, Username, Password;
		Address = Basic.getAddress();
		Port = Basic.getPort();
		Tablename = Basic.getTablename();
		Username = Basic.getUsername();
		Password = Basic.getPassword();
		String URL = c.toURL(Port, Address, Tablename);
		c.Connect(URL, Username, Password, "TRUNCATE People;");
		for(EstiPlayer player : Basic.getEstiPlayers()){
			try {
				Serialization.writeJavaObject(player.getUUID(), player);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} //MAKE SURE THAT NEW PLAYERS FROM OTHER SERVERS DONT GET ERASED WITH TRUNCATE WHILE THIS IS GOING
		}
	}
}
