package net.genesishub.gFeatures.Feature.gRanks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permissible;
import org.bukkit.permissions.PermissionAttachment;

public class Basis {
	static HashMap<UUID,PermissionAttachment> permissions = new HashMap<>();
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
	public static void addPermissionAttach(UUID uuid, PermissionAttachment pa){
		permissions.put(uuid, pa);
	}
	public static void removeRank(Rank rank){
		ranks.remove(rank);
	}
	public static void removePermissionsAttach(UUID uuid){
		permissions.remove(uuid);
	}
	public static Rank getRank(String rankname){
		for(Rank r : ranks){
			if(r.getName().equalsIgnoreCase(rankname)){
				return r;
			}
		}
		return null;
	}
	public static PermissionAttachment getPermissionsAttach(UUID uuid){
		return permissions.get(uuid);
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
		int i = Integer.parseInt(c.ConnectReturn(URL, Username, Password, "SELECT COUNT(*) FROM Ranks").get(1));
		for(int iter = 1; iter<i; iter++){
			String name = c.ConnectReturn(URL, Username, Password, "SELECT Name FROM Ranks WHERE id='" + iter + "'").get(1);
			String prefix = c.ConnectReturn(URL, Username, Password, "SELECT Prefix FROM Ranks WHERE id='" + iter + "'").get(1);
			Rank newrank = new Rank(name, prefix);
			Basis.addRank(newrank);
		}
		try{
			int is = Integer.parseInt(c.ConnectReturn(URL, Username, Password, "SELECT COUNT(*) FROM People").get(1));
			for(int iter = 1; iter<is; iter++){
				String UUID = c.ConnectReturn(URL, Username, Password, "SELECT UUID FROM People WHERE id='" + iter + "'").get(1);
				String rank = c.ConnectReturn(URL, Username, Password, "SELECT Rank FROM People WHERE id='" + iter + "'").get(1);
				Basis.getRank(rank).addPerson(UUID);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		for(Player p : Bukkit.getOnlinePlayers()){
			Basis.removePermissionsAttach(p.getUniqueId());
			PermissionAttachment pa = p.addAttachment(Bukkit.getPluginManager().getPlugin("gFeatures"));
			for(String perm : Basis.getRank(r.getRank(p)).getPerms()){
				boolean isittrue;
				if(perm.contains("-")){
					isittrue = false;
				}
				else{
					isittrue = true;
				}
				pa.setPermission(perm, isittrue);
			}
			Basis.addPermissionAttach(p.getUniqueId(), pa);
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
