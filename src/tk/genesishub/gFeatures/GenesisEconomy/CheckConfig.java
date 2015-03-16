package tk.genesishub.gFeatures.GenesisEconomy;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;

public class CheckConfig {
	File f = new File("plugins/gFeatures/gEconomy/Config.yml");
	YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(f);
	public String getPort(){
		return yamlFile.get("Config.MySQL.Port").toString();
	}
	public String getAddress(){
		return yamlFile.get("Config.MySQL.Address").toString();
	}
	public String getTablename(){
		return yamlFile.get("Config.MySQL.TableName").toString();
	}
	public String getUsername(){
		return yamlFile.get("Config.MySQL.Username").toString();
	}
	public String getPassword(){
		return yamlFile.get("Config.MySQL.Password").toString();
	}
	public String getRate(){
		return yamlFile.get("Config.Trade.Rate").toString();
	}
}
