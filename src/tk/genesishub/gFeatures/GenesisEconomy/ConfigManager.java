package tk.genesishub.gFeatures.GenesisEconomy;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigManager {
	File f = new File("plugins/gFeatures/gEconomy/Config.yml");
	public void check() throws IOException{
		if(!f.exists()){
			Bukkit.getLogger().info("[gEconomy]Setting up configs....");
			f.createNewFile();
			YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(f);
			yamlFile.createSection("Config");
			yamlFile.createSection("Config.MySQL");
		}
	}
}
