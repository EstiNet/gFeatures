package tk.genesishub.gFeatures.gUtilities;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

public class Obtain {
	File f = new File("plugins/gFeatures/gUtilities/Config.yml");
	public void Throw() throws Exception{
		YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(f); 
		if(yamlFile.get("Config.gBroadcast.Enable").equals("true")){
			Bukkit.getLogger().info("Loaded gWars preset.");
		}
		yamlFile.createSection("Config");
		yamlFile.createSection("Config.gBroadcast");
		//Plugins
		yamlFile.createSection("Config.gBroadcast.Enable");
		yamlFile.createSection("Config.gBroadcast.TickDelay");
		yamlFile.createSection("Config.gBroadcast.Messages");
		//Plugins value
		yamlFile.set("Config.gBroadcast.Enable", "false");
		yamlFile.set("Config.gBroadcast.TickDelay", "2000");
	}
}
