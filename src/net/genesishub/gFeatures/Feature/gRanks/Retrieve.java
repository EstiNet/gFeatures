package net.genesishub.gFeatures.Feature.gRanks;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;

public class Retrieve {
	File f = new File("plugins/gFeatures/gRanks/Config.yml");
	YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(f);
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
}
