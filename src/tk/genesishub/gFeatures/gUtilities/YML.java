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
			yamlFile.createSection("Config.Presets");
			yamlFile.createSection("Config.Plugins");
			yamlFile.createSection("Config.Skript");
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
			//Presets
			yamlFile.createSection("Config.Presets.gWars");
			yamlFile.createSection("Config.Presets.gDestroy");
			yamlFile.createSection("Config.Presets.gHub");
			yamlFile.createSection("Config.Presets.gFactions");
			//Skript
			yamlFile.createSection("Config.Skript.gEssentialsHub");
			yamlFile.createSection("Config.Skript.gEssentialsMinigames");
			yamlFile.createSection("Config.Skript.gMMO");
			yamlFile.createSection("Config.Skript.gEssentialsFactions");
			yamlFile.createSection("Config.Skript.gCrates");
			yamlFile.createSection("Config.Skript.gEssentialsGlobal");
			//Presets value
			yamlFile.set("Config.Presets.gWars", "false");
			yamlFile.set("Config.Presets.gDestroy", "false");
			yamlFile.set("Config.Presets.gHub", "false");
			yamlFile.set("Config.Presets.gFactions", "false");
			//Plugins value
			yamlFile.set("Config.Plugins.gWarsSuite", "false");
			yamlFile.set("Config.Plugins.gHub", "false");
			yamlFile.set("Config.Plugins.gFactions", "false");
			yamlFile.set("Config.Plugins.GenesisAccess", "true");
			yamlFile.set("Config.Plugins.gDestroyCritical", "false");
			yamlFile.set("Config.Plugins.GenesisEconomy", "false");
			yamlFile.set("Config.Plugins.GenesisBackup", "false");
			yamlFile.set("Config.Plugins.gScore", "false");
            yamlFile.set("Config.Plugins.HideAndSeek", "false");
            yamlFile.set("Config.Plugins.gMusic", "false");
            yamlFile.set("Config.Plugins.gUtilities", "false");
            yamlFile.set("Config.Plugins.CTF", "false");
			//Skript value
			yamlFile.set("Config.Skript.gEssentialsHub", "false");
			yamlFile.set("Config.Skript.gEssentialsMinigames", "false");
			yamlFile.set("Config.Skript.gMMO", "false");
			yamlFile.set("Config.Skript.gEssentialsFactions", "false");
			yamlFile.set("Config.Skript.gCrates", "false");
			yamlFile.set("Config.Skript.gEssentialsGlobal", "true");
			yamlFile.save(f);
			Bukkit.getLogger().info("Successfully added plugin data folders!");
	}
}
