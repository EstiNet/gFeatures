package net.estinet.gFeatures.Feature.gRanks;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import net.estinet.gFeatures.API.Logger.Debug;

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
	public boolean getClioteSkySupport(){
		if(yamlFile.get("Config.ClioteSky.Enable") == null){
			return false;
		}
		return Boolean.parseBoolean(yamlFile.get("Config.ClioteSky.Enable").toString());
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
			Debug.print(rankname + " is adding " + perm);
		Basis.getRank(rankname).addPerm(perm);
		}
		catch(Exception e){
		}
	}
	public void addgInherit(String inherit, String rankname){
		sqlc.Connect(sqlc.toURL(getPort(), getAddress(), getTablename()), getUsername(), getPassword(), "INSERT INTO Inherits(Inherit, Rank)\n"+
				"SELECT * FROM (SELECT '" + inherit + "', '" + rankname + "') AS tmp\n"+
				"WHERE NOT EXISTS (\n"+
				"SELECT Inherit FROM Inherits WHERE Inherit = '" + rankname + "'\n"+
				") LIMIT 1;\n"
			);
		try{
		Basis.getRank(rankname).addInherit(Basis.getRank(inherit));
		}
		catch(Exception e){
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
		sqlc.Connect(sqlc.toURL(getPort(), getAddress(), getTablename()), getUsername(), getPassword(), "DELETE FROM Perms WHERE Perm = '" + perm + "' AND Rank = '" + rankname + "';");
		try{
		Basis.getRank(rankname).removePerm(perm);
		}
		catch(Exception e){
		}
	}
	public void deletegInherit(String inherit, String rankname){
		sqlc.Connect(sqlc.toURL(getPort(), getAddress(), getTablename()), getUsername(), getPassword(), "DELETE FROM Inherits WHERE Inherit = '" + inherit + "' AND Rank = '" + rankname + "';");
		try{
		Basis.getRank(rankname).removeInherit(Basis.getRank(rankname));
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
