package net.estinet.gFeatures.Feature.gRanks;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import net.estinet.gFeatures.Feature.gRanks.Global.FileSync;
import net.estinet.gFeatures.Feature.gRanks.Global.GlobalPerm;
import net.estinet.gFeatures.Feature.gRanks.Global.InheritSync;
import net.estinet.gFeatures.Feature.gRanks.Perms.Files;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2016 EstiNet

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

public class Basis {
	public static ConcurrentHashMap<UUID,PermissionAttachment> permissions = new ConcurrentHashMap<>();
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
		try{
		permissions.remove(uuid);
		}
		catch(Exception e){
			e.printStackTrace();
		}
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
		if(!r.getClioteSkySupport()){
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
		Files f = new Files();
		f.setupFiles();
		FileSync fs = new FileSync();
		fs.start();
		InheritSync is = new InheritSync();
		is.start();
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
