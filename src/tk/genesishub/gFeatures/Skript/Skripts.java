package tk.genesishub.gFeatures.Skript;

import java.util.ArrayList;
import java.util.List;

public enum Skripts {
	gEssentialsHub, gEssentialsMinigames;
	public static List<Skripts> getList(){
		List<Skripts> list = new ArrayList<>();
		list.add(gEssentialsHub);
		list.add(gEssentialsMinigames);
		return list;
	}
}
