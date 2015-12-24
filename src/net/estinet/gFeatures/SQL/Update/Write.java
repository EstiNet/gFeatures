package net.estinet.gFeatures.SQL.Update;

import net.estinet.gFeatures.Basic;
import net.estinet.gFeatures.SQL.Player.EstiPlayer;

public class Write {
	public void writeToSQL(){
		//if(Basic.getSQLState()){
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
		//}
	}
}
