package tk.genesishub.gFeatures.gUtilities;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

public class YML {
	File f = new File("plugins/gFeatures/gUtilities");
	public void create() throws IOException{
			YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(f);
			yamlFile.createSection("Config");
			yamlFile.createSection("Config.gBroadcast");
			//Plugins
			yamlFile.createSection("Config.Plugins.gWarsSuite");
			yamlFile.createSection("Config.Plugins.gHub");
			yamlFile.createSection("Config.Plugins.gFactions");
			yamlFile.createSection("Config.Plugins.GenesisAccess");
			yamlFile.createSection("Config.Plugins.gDestroyCritical");
			yamlFile.createSection("Config.Plugins.GenesisEconomy");
			yamlFile.createSection("Config.Plugins.GenesisBackup");
			yamlFile.createSection("Config.Plugins.gScore");
            yamlFile.createSection("Config.Plugins.HideAndSeek");
            yamlFile.createSection("Config.Plugins.gMusic");
            yamlFile.createSection("Config.Plugins.gUtilities");
            yamlFile.createSection("Config.Plugins.CTF");
			//Plugins value
			yamlFile.set("Config.Presets.gWars", "false");
			yamlFile.set("Config.Presets.gDestroy", "false");
			yamlFile.set("Config.Presets.gHub", "false");
			yamlFile.set("Config.Presets.gFactions", "false");
			yamlFile.save(f);
			Bukkit.getLogger().info("Successfully added plugin data folders!");
	}
}
