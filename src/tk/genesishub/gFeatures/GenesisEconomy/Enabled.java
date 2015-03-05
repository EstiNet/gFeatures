package tk.genesishub.gFeatures.GenesisEconomy;

import java.sql.SQLException;

public class Enabled {
	public void Initialize() throws SQLException{
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
		c.tableExists(URL, Username, Password);
	}
}
