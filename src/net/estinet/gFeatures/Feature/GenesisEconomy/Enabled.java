package net.estinet.gFeatures.Feature.GenesisEconomy;

import java.io.IOException;
import java.sql.SQLException;

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
		c.Connect(URL, Username, Password, "CREATE TABLE IF NOT EXISTS Peoples(Name VARCHAR(200), Money FLOAT) ENGINE=InnoDB;");
		//c.Connect(URL, Username, Password, "INSERT INTO People(Name, Money) VALUES('InDev', 1) IF NOT EXISTS;");
		c.Connect(URL, Username, Password, "UPDATE Peoples SET Money = Money + 1\nWHERE Name = 'InDev';");
		}
	}
}
