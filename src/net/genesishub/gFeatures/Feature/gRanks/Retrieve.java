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
	public String getRate(){
		if(yamlFile.get("Config.Trade.Rate") == null){
			return "";
		}
		return yamlFile.get("Config.Trade.Rate").toString();
	}
	String Address = getAddress();
	String Port = getPort();
	String Tablename = getTablename();
	String Username = getUsername();
	String Password = getPassword();
	String URL = sqlc.toURL(Port, Address, Tablename);
	public float getRank(Player p){
		List<String> rs = new ArrayList<>();
		rs = sqlc.ConnectReturn(URL, Username, Password, "SELECT Name, Money FROM Peoples WHERE Name = '" + p.getUniqueId().toString() + "';");
		return Float.parseFloat(rs.get(1));
	}
}
