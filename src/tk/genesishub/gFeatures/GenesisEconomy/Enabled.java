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
		c.Connect(c.toURL(cc.getPort(), cc.getAddress(), cc.getTablename()), cc.getUsername(), cc.getPassword(), "IF NOT EXISTS ("+
				"SELECT * FROM information_schema.COLUMNS"+
				"WHERE column_name=Name"+
				"and table_name=geconomy"+
				"and table_schema=geconomy"+
				")"+
			"THEN"+
				"set @ddl=CONCAT('ALTER TABLE ',geconomy,'.',geconomy,"+
					"' ADD COLUMN ',Name,' ',fieldDef);"+
				"prepare stmt from @ddl;"+
				"execute stmt;"
			+"END IF");
		}
	}
}
