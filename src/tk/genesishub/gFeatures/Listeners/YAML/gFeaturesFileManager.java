package tk.genesishub.gFeatures.Listeners.YAML;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import tk.genesishub.gFeatures.PluginManage.GenesisAccessPlugin;
import tk.genesishub.gFeatures.PluginManage.GenesisBackupPlugin;
import tk.genesishub.gFeatures.PluginManage.GenesisEconomyPlugin;
import tk.genesishub.gFeatures.PluginManage.PluginState;
import tk.genesishub.gFeatures.PluginManage.gDestroyCriticalPlugin;
import tk.genesishub.gFeatures.PluginManage.gFactionsPlugin;
import tk.genesishub.gFeatures.PluginManage.gHubPlugin;
import tk.genesishub.gFeatures.PluginManage.gWarsSuitePlugin;

/*
gFeatures
https://github.com/Seshpenguin/gFeatures

   Copyright 2015 DolphinBox

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

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
	File gEconomy = new File("plugins/gFeatures/GenesisEconomy");
	File gBackup = new File("plugins/gFeatures/gBackup");
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
		if(!(gEconomy.isDirectory()) && GenesisEconomyPlugin.getState().equals(PluginState.ENABLE)){
			gHub.mkdir();
			Bukkit.getLogger().info("Seems like it's the first time you ran GenesisEconomy...");
			Bukkit.getLogger().info("Successfully added plugin data folders!");
		}
		if(!(gBackup.isDirectory()) && GenesisBackupPlugin.getState().equals(PluginState.ENABLE)){
			gHub.mkdir();
			Bukkit.getLogger().info("Seems like it's the first time you ran GenesisBackup...");
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
			yamlFile.createSection("Config.Plugins.GenesisEconomy");
			yamlFile.createSection("Config.Plugins.GenesisBackup");
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
			yamlFile.set("Config.Plugins.GenesisEconomy", "false");
			yamlFile.set("Config.Plugins.GenesisBackup", "false");
			yamlFile.save(f);
			Bukkit.getLogger().info("Successfully added plugin data folders!");
		}
		Bukkit.getLogger().info("Plugin data check completed.");
		}
		catch(NullPointerException e){
			
		}
	}
}
