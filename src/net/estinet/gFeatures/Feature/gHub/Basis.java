package net.genesishub.gFeatures.Feature.gHub;

import java.util.ArrayList;
import java.util.List;

public class Basis {
	public static List<String> stacker = new ArrayList<>();
	public static void addStacker(String playername){
		stacker.add(playername);
	}
	public static void removeStacker(String playername){
		stacker.remove(playername);
	}
	public static boolean isInStacker(String playername){
		return stacker.contains(playername);
	}
	
}
