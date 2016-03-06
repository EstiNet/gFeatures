package net.estinet.gFeatures.Feature.gRanks.Perms;

import java.util.HashMap;
import java.util.List;

import net.estinet.gFeatures.API.Logger.Debug;
import net.estinet.gFeatures.Feature.gRanks.Retrieve;
import net.estinet.gFeatures.Feature.gRanks.SQLConnect;

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

public class Cleanup implements Runnable{
	SQLConnect c = new SQLConnect();
	Retrieve cc = new Retrieve();
	public void cleanAll(){
		String Address, Port, Tablename, Username, Password;
		Address = cc.getAddress();
		Port = cc.getPort();
		Tablename = cc.getTablename();
		Username = cc.getUsername();
		Password = cc.getPassword();
		String URL = c.toURL(Port, Address, Tablename);
		HashMap<String, String> perms = new HashMap<>();
		c.Connect(URL, Username, Password, "SET @count = 0;");
		// Maybe later? c.Connect(URL, Username, Password, "UPDATE `perms` SET `perms`.`id` = @count:= @count + 1;");
		c.Connect(URL, Username, Password, "ALTER TABLE `perms` AUTO_INCREMENT = 1;");
		int cache = 0;
		try{
			int i = Integer.parseInt(c.ConnectReturn(URL, Username, Password, "SELECT COUNT(*) FROM Perms").get(1));
			List<String> permdata = c.ConnectReturnPerm(URL, Username, Password, "SELECT * FROM Perms;");
			for(int iter = 0; iter<i; iter++){
				String perm = permdata.get(cache);
				cache += 1;
				String rank = permdata.get(cache);
				cache += 1;
				perms.put(perm, rank);
			}
		}
		catch(Exception e){
			Debug.print(e.getMessage());
		}
		for(String perm : perms.keySet()){
			try{
			cc.deletegPerm(perm, perms.get(perm));
			}
			catch(Exception e){}
			try{
			cc.addgPerm(perm, perms.get(perm));
			}
			catch(Exception e){}
		}
		HashMap<String, String> inherits = new HashMap<>();
		cache = 0;
		try{
			int i = Integer.parseInt(c.ConnectReturn(URL, Username, Password, "SELECT COUNT(*) FROM Inherits").get(1));
			List<String> permdata = c.ConnectReturnInherit(URL, Username, Password, "SELECT * FROM Inherits;");
			for(int iter = 0; iter<i; iter++){
				String inherit = permdata.get(cache);
				cache += 1;
				String rank = permdata.get(cache);
				cache += 1;
				inherits.put(inherit, rank);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		for(String inherit : inherits.keySet()){
			try{
			cc.deletegInherit(inherit, inherits.get(inherit));
			}catch(Exception e){}
			try{
			cc.addgInherit(inherit, inherits.get(inherit));
			}catch(Exception e){}
		}
	}
	@Override
	public void run() {
		cleanAll();
	}
}
