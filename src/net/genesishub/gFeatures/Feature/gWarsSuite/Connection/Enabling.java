package net.genesishub.gFeatures.Feature.gWarsSuite.Connection;

public class Enabling {
	public void start(){
		Connection c = new Connection();
		CheckConfig cc = new CheckConfig();
		String Address, Port, Tablename, Username, Password;
		Address = cc.getAddress();
		Port = cc.getPort();
		Tablename = cc.getTablename();
		Username = cc.getUsername();
		Password = cc.getPassword();
		String URL = c.toURL(Port, Address, Tablename);
		c.checkOnline(URL, Username, Password);
		c.Connect(URL, Username, Password, "CREATE TABLE IF NOT EXISTS Peoples(Name VARCHAR(200), Kills FLOAT, Deaths FLOAT) ENGINE=InnoDB;");
	}
}
