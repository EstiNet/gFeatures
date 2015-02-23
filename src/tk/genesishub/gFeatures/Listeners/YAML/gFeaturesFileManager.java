package tk.genesishub.gFeatures.Listeners.YAML;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.libs.jline.internal.Configuration;

import tk.genesishub.gFeatures.PluginManage.GenesisAccessPlugin;
import tk.genesishub.gFeatures.PluginManage.PluginState;
import tk.genesishub.gFeatures.PluginManage.gDestroyCriticalPlugin;
import tk.genesishub.gFeatures.PluginManage.gFactionsPlugin;
import tk.genesishub.gFeatures.PluginManage.gHubPlugin;
import tk.genesishub.gFeatures.PluginManage.gWarsSuitePlugin;

public class gFeaturesFileManager {
	gHubPlugin ghp = new gHubPlugin();
	gFactionsPlugin gfp = new gFactionsPlugin();
	gWarsSuitePlugin gwsp = new gWarsSuitePlugin();
	gDestroyCriticalPlugin gdcp = new gDestroyCriticalPlugin();
	File f = new File("plugins/gFeatures/Config.yml");
	File GenesisAccess = new File("./GenesisAccess");
	File main = new File("plugins/gFeatures");
	File gWars = new File("plugins/gFeatures/gWars");
	File gDestroyCritical = new File("plugins/gFeatures/gDestroyCritical");
	File gFactions = new File("plugins/gFeatures/gFactions");
	File gHub = new File("plugins/gFeatures/gHub");
	public void exists() throws IOException{
		try{
		if(!(main.isDirectory())){
			main.mkdir();
			Bukkit.getLogger().info("Seems like it's the first time you ran gFeatures...");
			Bukkit.getLogger().info("Successfully added plugin data folders!");
		}
		if(!(gWars.isDirectory()) && gWarsSuitePlugin.getState().equals(PluginState.ENABLE)){
			gWars.mkdir();
			Bukkit.getLogger().info("Seems like it's the first time you ran gWarsSuite...");
			Bukkit.getLogger().info("Successfully added plugin data folders!");
		}
		if(!(gDestroyCritical.isDirectory()) && gDestroyCriticalPlugin.getState().equals(PluginState.ENABLE)){
			gDestroyCritical.mkdir();
			Bukkit.getLogger().info("Seems like it's the first time you ran gDestroyCritical...");
			Bukkit.getLogger().info("Successfully added plugin data folders!");
		}
		if(!(main.isDirectory()) && gFactionsPlugin.getState().equals(PluginState.ENABLE)){
			gFactions.mkdir();
			Bukkit.getLogger().info("Seems like it's the first time you ran gFactions...");
			Bukkit.getLogger().info("Successfully added plugin data folders!");
		}
		if(!(main.isDirectory()) && gHubPlugin.getState().equals(PluginState.ENABLE)){
			gHub.mkdir();
			Bukkit.getLogger().info("Seems like it's the first time you ran gHub...");
			Bukkit.getLogger().info("Successfully added plugin data folders!");
		}
		if(!(GenesisAccess.isDirectory()) && GenesisAccessPlugin.getState().equals(PluginState.ENABLE)){
			GenesisAccess.mkdir();
			Bukkit.getLogger().info("Seems like it's the first time you ran GenesisAccess...");
			Bukkit.getLogger().info("Successfully added plugin data folders!");
		}
		if(!(f.exists())){
			f.createNewFile();
			YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(f);
			yamlFile.createSection("Config");
			yamlFile.createSection("Config.Presets");
			yamlFile.createSection("Config.Plugins");
			yamlFile.createSection("Config.Plugins.gWarsSuite");
			yamlFile.createSection("Config.Plugins.gHub");
			yamlFile.createSection("Config.Plugins.gFactions");
			yamlFile.createSection("Config.Plugins.GenesisAccess");
			yamlFile.createSection("Config.Plugins.gDestroyCritical");
			yamlFile.createSection("Config.Presets.gWars");
			yamlFile.createSection("Config.Presets.gDestroy");
			yamlFile.createSection("Config.Presets.gHub");
			yamlFile.createSection("Config.Presets.gFactions");
			yamlFile.set("Config.Presets.gWars", "false");
			yamlFile.set("Config.Presets.gDestroy", "false");
			yamlFile.set("Config.Presets.gHub", "false");
			yamlFile.set("Config.Presets.gFactions", "false");
			yamlFile.set("Config.Plugins.gWarsSuite", "false");
			yamlFile.set("Config.Plugins.gHub", "false");
			yamlFile.set("Config.Plugins.gFactions", "false");
			yamlFile.set("Config.Plugins.GenesisAccess", "false");
			yamlFile.set("Config.Plugins.gDestroyCritical", "false");
			yamlFile.save(f);
			Bukkit.getLogger().info("Successfully added plugin data folders!");
		}
		Bukkit.getLogger().info("Plugin data check completed.");
		}
		catch(NullPointerException e){
			
		}
	}
}
