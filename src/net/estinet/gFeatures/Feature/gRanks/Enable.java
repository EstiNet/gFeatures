package net.estinet.gFeatures.Feature.gRanks;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import net.estinet.gFeatures.API.MojangAPI.UUIDFetcher;
import net.estinet.gFeatures.Feature.gRanks.Global.FileSync;
import net.estinet.gFeatures.Feature.gRanks.Global.GlobalInherit;
import net.estinet.gFeatures.Feature.gRanks.Global.GlobalPerm;
import net.estinet.gFeatures.Feature.gRanks.Perms.Files;

import org.bukkit.Bukkit;

public class Enable{
	static ConfigHub ch = new ConfigHub();
	static LoopCheck lc = new LoopCheck();
	public static void onEnable(){
		Bukkit.getLogger().info("[gRanks] Plugin enabled!");
		ch.setupConfig();
		SQLConnect c = new SQLConnect();
		Retrieve cc = new Retrieve();
		String Address, Port, Tablename, Username, Password;
		Address = cc.getAddress();
		Port = cc.getPort();
		Tablename = cc.getTablename();
		Username = cc.getUsername();
		Password = cc.getPassword();
		String URL = c.toURL(Port, Address, Tablename);
		Basis.pexenabled = cc.getPexEnabled();
		c.checkOnline(URL, Username, Password);
		c.Connect(URL, Username, Password, "CREATE TABLE IF NOT EXISTS People(id MEDIUMINT NOT NULL AUTO_INCREMENT, UUID VARCHAR(200), Rank VARCHAR(200), PRIMARY KEY (id))  ENGINE=InnoDB;");
		c.Connect(URL, Username, Password, "CREATE TABLE IF NOT EXISTS Ranks(id MEDIUMINT NOT NULL AUTO_INCREMENT, Name VARCHAR(200), Prefix VARCHAR(200), PRIMARY KEY (id))  ENGINE=InnoDB;");
		c.Connect(URL, Username, Password, "CREATE TABLE IF NOT EXISTS Perms(id MEDIUMINT NOT NULL AUTO_INCREMENT, Perm VARCHAR(200), Rank VARCHAR(200), PRIMARY KEY (id))  ENGINE=InnoDB;");
		c.Connect(URL, Username, Password, "CREATE TABLE IF NOT EXISTS Inherits(id MEDIUMINT NOT NULL AUTO_INCREMENT, Inherit VARCHAR(200), Rank VARCHAR(200), PRIMARY KEY (id))  ENGINE=InnoDB;");
		int cache = 0;
		try{
		int i = Integer.parseInt(c.ConnectReturn(URL, Username, Password, "SELECT COUNT(*) FROM Ranks").get(1));
		Basis.resetAll();
	
		List<String> ranksdata = c.ConnectReturnRanks(URL, Username, Password, "SELECT * FROM Ranks;");
		for(int iter = 0; iter<i; iter++){
			String name = ranksdata.get(cache);
			cache += 1;
			String prefix = ranksdata.get(cache);
			cache += 1;
			Rank newrank = new Rank(name, prefix);
			Basis.addRank(newrank);
			Bukkit.getLogger().info("[gRanks] Adding rank " + name + " with prefix of " + prefix);
		}
		}
		catch(Exception e){
			e.printStackTrace();
				Rank r = new Rank("Default", "[&aPlayer&f]");
				Retrieve rs = new Retrieve();
				rs.addRank(r);
				Basis.addRank(r);
		}
		cache = 0;
		try{
		int i = Integer.parseInt(c.ConnectReturn(URL, Username, Password, "SELECT COUNT(*) FROM People").get(1));
		List<String> peopledata = c.ConnectReturnPeople(URL, Username, Password, "SELECT * FROM People;");
		for(int iter = 0; iter<i; iter++){
			String UUID = peopledata.get(cache);
			cache += 1;
			String rank = peopledata.get(cache);
			cache += 1;
			Basis.getRank(rank).addPerson(UUID);
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		lc.start();
		Files f = new Files();
		f.setupFiles();
		GlobalPerm gp = new GlobalPerm();
		gp.start();
		GlobalInherit gi = new GlobalInherit();
		gi.start();
		FileSync fs = new FileSync();
		fs.start();
		if(Basis.pexenabled){
		for(Rank r : Basis.getRanks()){
			for(String uuids : r.getPersonList()){
				UUIDFetcher uuid = new UUIDFetcher(Arrays.asList(uuids));
				Map<String, UUID> response = null;
				try {
					response = uuid.call();
				} catch (Exception e) {
					continue;
				}
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user "+ response.get(uuids) + " set " + r.getName());
			}
		}
		}
	}
}
