package net.estinet.gFeatures.ClioteSky;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;

public class ClioteConfigUtil {
	public void load(){
		File f = new File("plugins/gFeatures/Config.yml");
		YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(f);
		ClioteSky.setName(yamlFile.get("Config.ClioteSky.Name").toString());
		ClioteSky.setCategory(yamlFile.get("Config.ClioteSky.Category").toString());
		ClioteSky.setAddress(yamlFile.get("Config.ClioteSky.Address").toString());
		ClioteSky.setEnable(Boolean.parseBoolean(yamlFile.get("Config.ClioteSky.Enable").toString()));
		ClioteSky.setPassword(yamlFile.get("Config.ClioteSky.Name").toString());
		ClioteSky.setPort(yamlFile.get("Config.ClioteSky.Port").toString());
	}
}
