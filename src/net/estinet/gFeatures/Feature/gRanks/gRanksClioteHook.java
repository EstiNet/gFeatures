package net.estinet.gFeatures.Feature.gRanks;

import java.util.List;

import org.bukkit.Bukkit;

import net.estinet.gFeatures.gFeature;
import net.estinet.gFeatures.API.Logger.Debug;
import net.estinet.gFeatures.ClioteSky.API.ClioteHook;
import net.estinet.gFeatures.Feature.gRanks.Global.GlobalPerm;
import net.estinet.gFeatures.Feature.gRanks.Perms.Cleanup;

public class gRanksClioteHook extends ClioteHook{

	public gRanksClioteHook(gFeature feature) {
		super(feature, "granks");
	}
	@Override
	public void run(List<String> args, String categoryName, String clioteName){
		Retrieve r = new Retrieve();
		SQLConnect c = new SQLConnect();
		String Address = r.getAddress();
		String Port = r.getPort();
		String Tablename = r.getTablename();
		String Username = r.getUsername();
		String Password = r.getPassword();
		String URL = c.toURL(Port, Address, Tablename);
		if(args.get(0).equals("sync")){
			try{
				Bukkit.getLogger().info("[gRanks] Syncing permissions database...");
				Thread th = new Thread(new Cleanup());
				th.start();
				Basis b = new Basis();
				b.initializeQuery();
				int i = Integer.parseInt(c.ConnectReturn(URL, Username, Password, "SELECT COUNT(*) FROM Ranks").get(1));
				int cache = 0;
				List<String> ranksdata = c.ConnectReturnRanks(URL, Username, Password, "SELECT * FROM Ranks;");
				for(int iter = 0; iter<i; iter++){
					String name = ranksdata.get(cache);
					cache += 1;
					String prefix = ranksdata.get(cache);
					cache += 1;
					Rank newrank = new Rank(name, prefix);
					Basis.addRank(newrank);
				}
				cache = 0;
				try{
					int is = Integer.parseInt(c.ConnectReturn(URL, Username, Password, "SELECT COUNT(*) FROM People").get(1));
					List<String> peopledata = c.ConnectReturnPeople(URL, Username, Password, "SELECT * FROM People;");
					for(int iter = 0; iter<is; iter++){
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
				GlobalPerm gp = new GlobalPerm();
				gp.start();
			}
			catch(Exception e){
				Debug.print(e.getMessage());
			}
		}
	}
}
