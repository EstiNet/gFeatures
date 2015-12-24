package tk.genesishub.gFeatures.gUtilities;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

public class YML {
	File f = new File("plugins/gFeatures/gUtilities/Config.yml");
	public void create() throws IOException{
			YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(f);
			yamlFile.createSection("Config");
			yamlFile.createSection("Config.gBroadcast");
			//Plugins
			yamlFile.createSection("Config.gBroadcast.Enable");
			yamlFile.createSection("Config.gBroadcast.TickDelay");
			yamlFile.createSection("Config.gBroadcast.Messages");
			//Plugins value
			yamlFile.set("Config.gBroadcast.Enable", "false");
			yamlFile.set("Config.gBroadcast.TickDelay", "2000");
			yamlFile.save(f);
			Bukkit.getLogger().info("Successfully added plugin data folders!");
	}
}
