package net.genesishub.gFeatures.API.PlayerStats;

import java.io.File;
import java.io.IOException;

import net.genesishub.gFeatures.Basic;
import net.genesishub.gFeatures.Configuration.Config;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Setup {
	public void checkPlayer(Player p){
		Config config = new Config();
		File f = new File("plugins/gFeatures/Players/" + p.getUniqueId().toString() + ".yml");
		if(!f.exists()){
			config.createFile("plugins/gFeatures/Players/" + p.getUniqueId().toString() + ".yml", "Made player directory!");
			
			gPlayer gp = new gPlayer(p);
			YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(f);
			yamlFile.createSection("Config");
			yamlFile.createSection("Config.Name");
			yamlFile.set("Config.Name", p.getName());
			yamlFile.set("Config.UUID", p.getUniqueId().toString());
			for(String str : Basic.getPlayerSections().keySet()){
				try{
					if(yamlFile.get("Config." + str).equals(null)){
						//NOT NEEDED BLOCK
					}
				}
				catch(Exception e){
					yamlFile.createSection("Config." + str);
					yamlFile.set("Config." + str, Basic.getPlayerSections().get(str));
					if(!str.contains(".")){
					gp.addValue(str, yamlFile.get("Config." + str).toString());
					}
					else{
						String[] strs = str.split(".");
						for(String st : strs){
						Bukkit.getLogger().info(st);
						}//TODO DEPRECATE
						String build = "Config.";
						for(String st: strs){
							build.concat(st);
						}
						gp.addValue(str, yamlFile.get(build).toString());
					}
				}
			}
			Basic.addgPlayer(gp);
			try {
				yamlFile.save(f);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else{
			YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(f);
			gPlayer gp = Basic.getgPlayer(p.getUniqueId().toString());
			for(String str :  yamlFile.getConfigurationSection("Config").getKeys(false)){
				gp.setValue(str, yamlFile.get("Config." + str).toString());
			}
			for(String str : Basic.getPlayerSections().keySet()){
				try{
				if(yamlFile.get("Config." + str).equals(null)){
					yamlFile.createSection("Config." + str);
					yamlFile.set("Config." + str, Basic.getPlayerSections().get(str));
					gp.addValue(str, yamlFile.get("Config." + str).toString());
				}
				}catch(Exception e){
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
			gp.setPlayer(p);
			Basic.setgPlayer(Basic.getgPlayer(p.getUniqueId().toString()), gp);
		}
	}
	public void flushPlayer(gPlayer p){
		File f = new File("plugins/gFeatures/Players/" + p.getUUID().toString() + ".yml");
		YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(f);
		yamlFile.set("Config.Name", p.getName());
		for(String str : p.getValues().keySet()){
			if(yamlFile.get("Config." + str).equals(null)){
				yamlFile.createSection("Config." + str);
				yamlFile.set("Config." + str, p.getValue(str));
			}
			yamlFile.set("Config." + str, p.getValue(str));
		}
	}
}
