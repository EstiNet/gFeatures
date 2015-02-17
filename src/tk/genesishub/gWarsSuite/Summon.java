package tk.genesishub.gWarsSuite;

import org.bukkit.entity.Player;

public class Summon {
	AirplaneSummoner as = new AirplaneSummoner();
	BoatSummoner bs = new BoatSummoner();
	public void Initialize(Player p, String value){
		if(value.equals("airplane")){
		as.AirplaneSummon(p);
		}
		else if(value.equals("boat")){
		bs.BoatSummon(p);
		}
		}
}
