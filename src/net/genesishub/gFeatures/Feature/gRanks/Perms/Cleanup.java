package net.genesishub.gFeatures.Feature.gRanks.Perms;

import java.util.HashMap;
import java.util.List;

import net.genesishub.gFeatures.Feature.gRanks.Retrieve;
import net.genesishub.gFeatures.Feature.gRanks.SQLConnect;

public class Cleanup {
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
			e.printStackTrace();
		}
		for(String perm : perms.keySet()){
			cc.deletegPerm(perm, perms.get(perm));
			cc.addgPerm(perm, perms.get(perm));
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
			cc.deletegInherit(inherit, inherits.get(inherit));
			cc.addgInherit(inherit, inherits.get(inherit));
		}
	}
}
