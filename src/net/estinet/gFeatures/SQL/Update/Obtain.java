package net.estinet.gFeatures.SQL.Update;

import net.estinet.gFeatures.Basic;

public class Obtain {
	static Connection c = new Connection();
	public static void start(){
		String Address, Port, Tablename, Username, Password;
		Address = Basic.getAddress();
		Port = Basic.getPort();
		Tablename = Basic.getTablename();
		Username = Basic.getUsername();
		Password = Basic.getPassword();
		String URL = c.toURL(Port, Address, Tablename);
		c.checkOnline(URL, Username, Password);
		c.Connect(URL, Username, Password, "CREATE TABLE IF NOT EXISTS People(id MEDIUMINT NOT NULL AUTO_INCREMENT, Object blob, PRIMARY KEY (id))  ENGINE=InnoDB;");
	}
}
