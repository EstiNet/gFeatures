package net.genesishub.gFeatures.Feature.gRanks;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Retrieve {
	File f = new File("plugins/gFeatures/gRanks/Config.yml");
	YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(f);
	SQLConnect sqlc = new SQLConnect();
	public String getPort(){
		if(yamlFile.get("Config.MySQL.Port") == null){
			return "";
		}
		return yamlFile.get("Config.MySQL.Port").toString();
	}
	public String getAddress(){
		if(yamlFile.get("Config.MySQL.Address") == null){
			return "";
		}
		return yamlFile.get("Config.MySQL.Address").toString();
	}
	public String getTablename(){
		if(yamlFile.get("Config.MySQL.TableName") == null){
			return "";
		}
		return yamlFile.get("Config.MySQL.TableName").toString();
	}
	public String getUsername(){
		if(yamlFile.get("Config.MySQL.Username") == null){
			return "";
		}
		return yamlFile.get("Config.MySQL.Username").toString();
	}
	public String getPassword(){
		if(yamlFile.get("Config.MySQL.Password") == null){
			return "";
		}
		return yamlFile.get("Config.MySQL.Password").toString();
	}
	String Address = getAddress();
	String Port = getPort();
	String Tablename = getTablename();
	String Username = getUsername();
	String Password = getPassword();
	String URL = sqlc.toURL(Port, Address, Tablename);
	public String getRank(Player p){
		List<String> rs = new ArrayList<>();
		rs = sqlc.ConnectReturn(URL, Username, Password, "SELECT UUID, Rank FROM People WHERE UUID = '" + p.getUniqueId().toString() + "';");
		return rs.get(1);
	}
	public String getRank(String UUID){
		List<String> rs = new ArrayList<>();
		rs = sqlc.ConnectReturn(URL, Username, Password, "SELECT UUID, Rank FROM People WHERE UUID = '" + UUID + "';");
		return rs.get(1);
	}
	public void setRank(Rank rank, Player p){
		sqlc.Connect(URL, Username, Password, "UPDATE People SET Rank = '" + rank.getName() + "' \nWHERE UUID = '" + p.getUniqueId().toString() + "';");
		Basis.getRank(rank.getName()).addPerson(p.getUniqueId().toString());
	}
	public void setRank(Rank rank, String UUID){
		sqlc.Connect(URL, Username, Password, "UPDATE People SET Rank = '" + rank.getName() + "' \nWHERE UUID = '" + UUID + "';");
		Basis.getRank(rank.getName()).addPerson(UUID);
	}
	public void addRank(Rank rank){
		sqlc.Connect(sqlc.toURL(getPort(), getAddress(), getTablename()), getUsername(), getPassword(), "INSERT INTO Ranks(Name, Prefix)\n"+
				"SELECT * FROM (SELECT '" + rank.getName() + "', '" + rank.getPrefix() + "') AS tmp\n"+
				"WHERE NOT EXISTS (\n"+
				"SELECT Name FROM Ranks WHERE Name = '" + rank.getPrefix() + "'\n"+
				") LIMIT 1;\n"
			);
		Basis.addRank(rank);
	}
	public void addgPerm(String perm, String rankname){
		sqlc.Connect(sqlc.toURL(getPort(), getAddress(), getTablename()), getUsername(), getPassword(), "INSERT INTO Perms(Perm, Rank)\n"+
				"SELECT * FROM (SELECT '" + perm + "', '" + rankname + "') AS tmp\n"+
				"WHERE NOT EXISTS (\n"+
				"SELECT Perm FROM Perms WHERE Perm = '" + rankname + "'\n"+
				") LIMIT 1;\n"
			);
		try{
		Basis.getRank(rankname).addPerm(perm);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void deleteRank(Rank rank){
		sqlc.Connect(sqlc.toURL(getPort(), getAddress(), getTablename()), getUsername(), getPassword(), "DELETE FROM Ranks WHERE Name = '" + rank.getName() + "';");
		Rank people = Basis.getRank(rank.getName());
		for(String uuid : people.getPersonList()){
			sqlc.Connect(URL, Username, Password, "UPDATE People SET Rank = 'Default' \nWHERE UUID = '" + uuid + "';");
			Basis.getRank("Default").addPerson(uuid);;
		}
		Basis.removeRank(rank);
	}
	public void deletegPerm(String perm, String rankname){
		sqlc.Connect(sqlc.toURL(getPort(), getAddress(), getTablename()), getUsername(), getPassword(), "DELETE FROM Perms WHERE Perm = '" + perm + "' Rank = '" + rankname + "';");
		try{
		Basis.getRank(rankname).removePerm(perm);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
