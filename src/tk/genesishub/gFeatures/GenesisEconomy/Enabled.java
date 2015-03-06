package tk.genesishub.gFeatures.GenesisEconomy;

import java.io.IOException;
import java.sql.SQLException;

public class Enabled {
	public void Initialize() throws SQLException, IOException{
		ConfigManager cm = new ConfigManager();
		if(cm.check()){
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
		//c.tableExists(URL, Username, Password);
		c.Connect(URL, Username, Password, "CREATE TABLE IF NOT EXISTS People(Name VARCHAR(25), Money FLOAT) ENGINE=InnoDB;");
		//c.Connect(URL, Username, Password, "INSERT INTO People(Name, Money) VALUES('InDev', 1) IF NOT EXISTS;");
		c.Connect(URL, Username, Password, "UPDATE People SET Money = Money + 1\nWHERE Name = 'InDev';");
		}
	}
}
