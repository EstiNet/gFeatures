package net.genesishub.gFeatures.API.PlayerStats;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;

import net.genesishub.gFeatures.Basic;
import net.genesishub.gFeatures.Configuration.Config;

public class Load {
	File f = new File("plugins/gFeatures/Players");
	public void load(){
		Config config = new Config();
		config.createDirectory("plugins/gFeatures/Players", "Players directory created!");
		for(File file : f.listFiles()){
			YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(file);
			gPlayer gp = new gPlayer(yamlFile.get("Config.UUID").toString() , yamlFile.get("Config.Name").toString());
			for(String str :  yamlFile.getConfigurationSection("Config").getKeys(false)){
				gp.addValue(str, yamlFile.get("Config." + str).toString());
			}
			for(String str : Basic.getPlayerSections().keySet()){
				if(yamlFile.get("Config." + str).equals(null)){
					yamlFile.createSection("Config." + str);
					yamlFile.set("Config." + str, Basic.getPlayerSections().get(str));
					gp.addValue(str, yamlFile.get("Config." + str).toString());
				}
			}
			try {
				yamlFile.save(f);
			} catch (IOException e) {
				e.printStackTrace();
			}
			Basic.addgPlayer(gp);
		}
	}
}
