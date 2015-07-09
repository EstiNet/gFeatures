package net.genesishub.gFeatures.Feature.gRanks;

import java.util.ArrayList;
import java.util.List;

public class Basis {
	private static List<Rank> ranks = new ArrayList<>();
	public static List<Rank> getRanks(){
		return ranks;
	}
	public static void addRank(Rank rank){
		ranks.add(rank);
	}
	public static void removeRank(Rank rank){
		ranks.remove(rank);
	}
	
	public static void resetAll(){
		ranks = new ArrayList<>();
	}	
}
