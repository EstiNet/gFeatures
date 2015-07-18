package net.genesishub.gFeatures.Feature.gRanks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import net.genesishub.gFeatures.Feature.gRanks.Perms.Files;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permissible;
import org.bukkit.permissions.Permission;
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
		Basis.resetAll();
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
		Files f = new Files();
		f.setupFiles();
		for(Player p : Bukkit.getOnlinePlayers()){
			Basis.removePermissionsAttach(p.getUniqueId());
			PermissionAttachment pa = p.addAttachment(Bukkit.getPluginManager().getPlugin("gFeatures"));
			for(String perm : Basis.getRank(r.getRank(p)).getPerms()){
				if(perm.equals("'*'")){
					for(Permission permsa : Bukkit.getPluginManager().getPermissions()){
						pa.setPermission(permsa, true);
					}
				}
				else{
				boolean isittrue;
				if(perm.contains("-")){
					isittrue = false;
					perm = perm.replace("-", "");
				}
				else{
					isittrue = true;
				}
				pa.setPermission(perm, isittrue);
				}
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
