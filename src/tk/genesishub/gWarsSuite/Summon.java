package tk.genesishub.gWarsSuite;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Summon {
	AirplaneSummoner as = new AirplaneSummoner();
	public void Initialize(Player p, String value){
		if(value.equals("airplane")){
		as.AirplaneSummon(p);
		Bukkit.getLogger().info("airplane");
		}
		else if(value.equals("boat")){
			
		}
		}
}
