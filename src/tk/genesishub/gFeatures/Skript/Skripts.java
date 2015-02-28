package tk.genesishub.gFeatures.Skript;

import java.util.ArrayList;
import java.util.List;

public enum Skripts {
	gEssentialsHub, gEssentialsMinigames, gMMO, gEssentialsFactions, gCrates, gEssentialsGlobal;
	public static List<Skripts> getList(){
		List<Skripts> list = new ArrayList<>();
		list.add(gEssentialsHub);
		list.add(gEssentialsMinigames);
		list.add(gMMO);
		list.add(gEssentialsFactions);
		list.add(gCrates);
		list.add(gEssentialsGlobal);
		return list;
	}
}
