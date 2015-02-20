package tk.genesishub.gFeatures.Listeners.YAML;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;

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
	File main = new File("plugins/gFeatures");
	File gWars = new File("plugins/gFeatures/gWars");
	File gDestroyCritical = new File("plugins/gFeatures/gDestroyCritical");
	File gFactions = new File("plugins/gFeatures/gFactions");
	File gHub = new File("plugins/gFeatures/gHub");
	public void exists() throws IOException{
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
		if(!(f.exists())){
			f.createNewFile();
			Bukkit.getLogger().info("Successfully added plugin data folders!");
		}
		Bukkit.getLogger().info("Plugin data check completed.");
	}
}
