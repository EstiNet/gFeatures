package net.genesishub.gFeatures.Feature.gRanks;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Basis {
	static Retrieve r = new Retrieve();
	SQLConnect c = new SQLConnect();
	String Address = r.getAddress();
	String Port = r.getPort();
	String Tablename = r.getTablename();
	String Username = r.getUsername();
	String Password = r.getPassword();
	String URL = c.toURL(Port, Address, Tablename);
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
	public static Rank getRank(String rankname){
		for(Rank r : ranks){
			if(r.getName().equalsIgnoreCase(rankname)){
				return r;
			}
		}
		return null;
	}
	public static boolean isRank(String rankname){
		for(Rank r : ranks){
			if(r.getName().equalsIgnoreCase(rankname)){
				return true;
			}
		}
		return false;
	}
	public static void resetAll(){
		ranks = new ArrayList<>();
	}	
	public void resetDisplayName(Player p){
		p.setDisplayName(Basis.getRank(r.getRank(p)).getPrefix() + p.getName());
	}
	public void initializeQuery(){
		int i = Integer.parseInt(c.ConnectReturn(URL, Username, Password, "SELECT COUNT(*) FROM Ranks(Name, Prefix)").get(1));
		for(int iter = 0; iter>i; iter++){
			String name = c.ConnectReturn(URL, Username, Password, "SELECT Name FROM Ranks WHERE id='" + iter + "'").get(1);
			String prefix = c.ConnectReturn(URL, Username, Password, "SELECT Prefix FROM Ranks WHERE id='" + iter + "'").get(1);
			Rank newrank = new Rank(name, prefix);
			Basis.addRank(newrank);
		}
	}
	public static boolean hasRank(Player p){
		try{
			r.getRank(p);
		}
		catch(Exception e){
			return false;
		}
		return true;
	}
}
