package tk.genesishub.gFeatures.GenesisEconomy;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigManager {
	File f = new File("plugins/gFeatures/gEconomy/Config.yml");
	public boolean check() throws IOException{
		if(!f.exists()){
			Bukkit.getLogger().info("[gEconomy] Setting up configs....");
			f.createNewFile();
			YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(f);
			yamlFile.createSection("Config");
			yamlFile.createSection("Config.MySQL");
			yamlFile.createSection("Config.MySQL.Address");
			yamlFile.createSection("Config.MySQL.Port");
			yamlFile.createSection("Config.MySQL.TableName");
			yamlFile.createSection("Config.MySQL.Username");
			yamlFile.createSection("Config.MySQL.Password");
			yamlFile.set("Config.MySQL.Port", "3306");
			yamlFile.set("Config.MySQL.Address", "localhost");
			yamlFile.set("Config.MySQL.TableName", "geconomy");
			yamlFile.set("Config.MySQL.Username", "root");
			yamlFile.set("Config.MySQL.Password", "pass123");
			yamlFile.save(f);
			Bukkit.getLogger().info("[gEconomy] Successfully added config!");
			return false;
		}
		return true;
	}
}
