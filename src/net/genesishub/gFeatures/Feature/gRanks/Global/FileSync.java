package net.genesishub.gFeatures.Feature.gRanks.Global;

import java.io.File;
import java.util.List;

import net.genesishub.gFeatures.Feature.gRanks.Basis;
import net.genesishub.gFeatures.Feature.gRanks.Rank;
import net.genesishub.gFeatures.Feature.gRanks.Retrieve;
import net.genesishub.gFeatures.Feature.gRanks.SQLConnect;

public class FileSync {
	SQLConnect c = new SQLConnect();
	Retrieve cc = new Retrieve();
	public void start(){
		String Address, Port, Tablename, Username, Password;
		Address = cc.getAddress();
		Port = cc.getPort();
		Tablename = cc.getTablename();
		Username = cc.getUsername();
		Password = cc.getPassword();
		String URL = c.toURL(Port, Address, Tablename);
		for(Rank r : Basis.getRanks()){
			File file = new File("plugins/gFeatures/gRanks/gperms/" + r.getName());
			
		}
		int cache = 0;
		try{
			int i = Integer.parseInt(c.ConnectReturn(URL, Username, Password, "SELECT COUNT(*) FROM Perms").get(1));
			List<String> permdata = c.ConnectReturnPerm(URL, Username, Password, "SELECT * FROM Perms;");
			for(int iter = 0; iter<i; iter++){
				String perm = permdata.get(cache);
				cache += 1;
				String rank = permdata.get(cache);
				cache += 1;
				File f = new File("plugins/gFeatures/gRanks/gperms");
				
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}	
