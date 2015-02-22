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
			try{
				/*BufferedWriter output;
				output = new BufferedWriter(new FileWriter(f, true));
				output.write("# Welcome to the gFeatures Main Config!\n"+
						"# Configure stuff here! (NO DUH)\n"+
						"#Specific plugins\n"+
						"gWarsSuite: false\n"+
						"gDestroyCritical: false\n"+
						"gHub: false\n"+
						"gFactions: false\n"+
						"#Presets\n"+
						"gWars: false\n"+
						"gDestroy: false\n"+
						"gHub: false\n"+
						"gFactions: false\n");
				output.newLine();
				output.close();*/
			}
			catch(Exception e1){
				Bukkit.getLogger().info("UHOH");
			}
			YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(f);
			yamlFile.createSection("Config");
			yamlFile.createSection("Config.Presets");
			yamlFile.createSection("Config.Plugins");
			List<String> values = new ArrayList<String>();
			yamlFile.set("Config.Presets", values);
			yamlFile.save(f);
			Bukkit.getLogger().info("Successfully added plugin data folders!");
		}
		Bukkit.getLogger().info("Plugin data check completed.");
		}
		catch(NullPointerException e){
			
		}
	}
}
