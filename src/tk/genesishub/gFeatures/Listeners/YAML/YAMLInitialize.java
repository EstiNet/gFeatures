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
import tk.genesishub.gFeatures.Presets.gDestroyPreset;
import tk.genesishub.gFeatures.Presets.gFactionsPreset;
import tk.genesishub.gFeatures.Presets.gHubPreset;
import tk.genesishub.gFeatures.Presets.gWarsPreset;
import tk.genesishub.gFeatures.Skript.Skripts;
import tk.genesishub.gFeatures.Skript.Java.SkriptManager;

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
public class YAMLInitialize {
	File f = new File("plugins/gFeatures/Config.yml");
	SkriptManager sm = new SkriptManager();
	gWarsPreset gwp = new gWarsPreset();
	gDestroyPreset gdp = new gDestroyPreset();
	gHubPreset ghp = new gHubPreset();
	gFactionsPreset gfp = new gFactionsPreset();
	gWarsSuitePlugin gwsp = new gWarsSuitePlugin();
	gDestroyCriticalPlugin gdcp = new gDestroyCriticalPlugin();
	GenesisAccessPlugin gap = new GenesisAccessPlugin();
	public void Enabler() throws IOException{
		YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(f); 
		Bukkit.getLogger().info((String) yamlFile.get("Config.Presets.gWars"));
		if(yamlFile.get("Config.Presets.gWars").equals("true")){
			gwp.Initialize();
			Bukkit.getLogger().info("Loaded gWars preset.");
		}
		if(yamlFile.get("Config.Presets.gDestroy").equals("true")){
			gdp.Initialize();
			Bukkit.getLogger().info("Loaded gDestroy preset.");
		}
		if(yamlFile.get("Config.Presets.gHub").equals("true")){
			ghp.Initialize();
			Bukkit.getLogger().info("Loaded gHub preset.");
		}
		if(yamlFile.get("Config.Presets.gFactions").equals("true")){
			gfp.Initialize();
			Bukkit.getLogger().info("Loaded gFactions preset.");
		}
		if(yamlFile.get("Config.Plugins.GenesisAccess").equals("true")){
			GenesisAccessPlugin.setPluginState(PluginState.ENABLE);
			Bukkit.getLogger().info("Loaded GenesisAccess.");
		}
		if(yamlFile.get("Config.Plugins.gHub").equals("true")){
			gHubPlugin.setPluginState(PluginState.ENABLE);
			Bukkit.getLogger().info("Loaded gHub.");
		}
		if(yamlFile.get("Config.Plugins.gFactions").equals("true")){
			gFactionsPlugin.setPluginState(PluginState.ENABLE);
			Bukkit.getLogger().info("Loaded gFactions.");
		}
		if(yamlFile.get("Config.Plugins.gDestroyCritical").equals("true")){
			gDestroyCriticalPlugin.setPluginState(PluginState.ENABLE);
			Bukkit.getLogger().info("Loaded gDestroyCritical.");
		}
		if(yamlFile.get("Config.Plugins.gWarsSuite").equals("true")){
			gWarsSuitePlugin.setPluginState(PluginState.ENABLE);
			Bukkit.getLogger().info("Loaded gWarsSuite.");
		}
		if(yamlFile.get("Config.Plugins.GenesisEconomy").equals("true")){
			GenesisEconomyPlugin.setPluginState(PluginState.ENABLE);
			Bukkit.getLogger().info("Loaded GenesisEconomy.");
		}
		if(yamlFile.get("Config.Plugins.GenesisBackup").equals("true")){
			GenesisBackupPlugin.setPluginState(PluginState.ENABLE);
			Bukkit.getLogger().info("Loaded GenesisBackup.");
		}
		if(yamlFile.get("Config.Skript.gEssentialsHub").equals("true")){
			sm.Enable(Skripts.gEssentialsHub);
			Bukkit.getLogger().info("Loaded gEssentialsHub.");
		}
		if(yamlFile.get("Config.Skript.gEssentialsMinigames").equals("true")){
			sm.Enable(Skripts.gEssentialsMinigames);
			Bukkit.getLogger().info("Loaded gEssentialsMinigames.");
		}
		if(yamlFile.get("Config.Skript.gMMO").equals("true")){
			sm.Enable(Skripts.gMMO);
			Bukkit.getLogger().info("Loaded gMMO.");
		}
		if(yamlFile.get("Config.Skript.gEssentialsFactions").equals("true")){
			sm.Enable(Skripts.gEssentialsFactions);
			Bukkit.getLogger().info("Loaded gEssentialsFactions.");
		}
		if(yamlFile.get("Config.Skript.gCrates").equals("true")){
			sm.Enable(Skripts.gCrates);
			Bukkit.getLogger().info("Loaded gCrates.");
		}
		if(yamlFile.get("Config.Skript.gEssentialsGlobal").equals("true")){
			sm.Enable(Skripts.gEssentialsGlobal);
			Bukkit.getLogger().info("Loaded gEssentialsGlobal.");
		}
	}
}
