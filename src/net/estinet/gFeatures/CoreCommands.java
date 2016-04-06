package net.estinet.gFeatures;

import java.util.List;

import net.estinet.gFeatures.API.PlayerStats.Load;
import net.estinet.gFeatures.API.PlayerStats.gPlayer;
import net.estinet.gFeatures.ClioteSky.ClioteInit;
import net.estinet.gFeatures.ClioteSky.Network.NetworkThread;
import net.estinet.gFeatures.Configuration.LoadConfig;
import net.estinet.gFeatures.Configuration.SetupConfig;
import net.estinet.gFeatures.SQL.Player.EstiPlayer;
import net.estinet.gFeatures.SQL.Player.EstiSet;
import net.estinet.gFeatures.SQL.Player.Key;
import net.estinet.gFeatures.SQL.Update.Obtain;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2016 EstiNet

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

public class CoreCommands{
	CommandLibrary cl = new CommandLibrary();
	public void onCommand(final CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("plugin")){
			if(sender.hasPermission("gFeatures.command.plugins")){
				String plugins = "EstiNet";
				for(Plugin plugin : Bukkit.getPluginManager().getPlugins()){
					plugins += ", " + plugin.getName();
				}
				sender.sendMessage("Plugins (" + Bukkit.getServer().getPluginManager().getPlugins().length + "): " + ChatColor.GREEN + plugins);
			}
			else{
				sender.sendMessage("Plugins (1): " + ChatColor.GREEN + "gFeatures");
			}
		}
		else if(cmd.getName().equalsIgnoreCase("gf") || cmd.getName().equalsIgnoreCase("gfeatures")){
			try {
				if(args.length == 0){
					if(cmd.getName().equalsIgnoreCase("gf") || cmd.getName().equalsIgnoreCase("gfeatures")){
						sender.sendMessage(ChatColor.GRAY + "Please do /gFeatures help.");
					}
				}
				else if(args.length == 1){
					switch(args[0]){
					case "version":
						sender.sendMessage(ChatColor.GRAY + "gFeatures Version " + Listeners.version);
						break;
					case "help":
						sender.sendMessage(ChatColor.GRAY + "------Help------");
						sender.sendMessage(ChatColor.GRAY + "/gFeatures version : States the version.");
						sender.sendMessage(ChatColor.GRAY + "/gFeatures list : Lists all features with their states and versions also.");
						sender.sendMessage(ChatColor.GRAY + "/gFeatures featurestate <Feature> : Gets the state of the feature.");
						sender.sendMessage(ChatColor.GRAY + "/gFeatures flush : Flushes the Player API.");
						sender.sendMessage(ChatColor.GRAY + "/gFeatures flushsql : Flushes the SQLPlayer API.");
						sender.sendMessage(ChatColor.GRAY + "/gFeatures loadedsql : Shows loaded SQL players.");
						sender.sendMessage(ChatColor.GRAY + "/gFeatures loadedsqlfields : Shows loaded SQL fields.");
						sender.sendMessage(ChatColor.GRAY + "/gFeatures send <Message> : Sends a manual message to the ClioteSky server.");
						sender.sendMessage(ChatColor.GRAY + "/gFeatures debug : Turns on debug messages.");
						sender.sendMessage(ChatColor.GRAY + "/gFeatures reload : Reloads the plugin.");
						break;
					case "list":
						List<gFeature> features = Basic.getFeatures();
						List<Extension> extensions = Basic.getExtensions();
						sender.sendMessage(ChatColor.GRAY + "Features:");
						sender.sendMessage(ChatColor.GRAY + "Enabled:");
						for(gFeature feature : features){
							if(feature.getState().equals(FeatureState.ENABLE)){
								sender.sendMessage(ChatColor.GRAY + " - " + feature.getName() + " " + feature.getVersion());
							}
						}
						sender.sendMessage(ChatColor.GRAY + "Disabled:");
						for(gFeature feature : features){
							if(feature.getState().equals(FeatureState.DISABLE)){
								sender.sendMessage(ChatColor.GRAY + " - " + feature.getName() + " " + feature.getVersion());
							}
						}
						sender.sendMessage(ChatColor.GRAY + "Extensions:");
						sender.sendMessage(ChatColor.GRAY + "Enabled:");
						for(Extension extension : extensions){
							if(extension.getState().equals(FeatureState.ENABLE)){
								sender.sendMessage(ChatColor.GRAY + " - " + extension.getName() + " " + extension.getVersion());
							}
						}
						sender.sendMessage(ChatColor.GRAY + "Disabled:");
						for(Extension extension : extensions){
							if(extension.getState().equals(FeatureState.DISABLE)){
								sender.sendMessage(ChatColor.GRAY + " - " + extension.getName() + " " + extension.getVersion());
							}
						}
						break;
					case "featurestate":
						sender.sendMessage(ChatColor.GRAY + "Usage: /gFeatures featurestate <Plugin>");
						break;
					case "gplist":
						sender.sendMessage(ChatColor.GRAY + "gPlayers initialized:");
						for(gPlayer gp : Basic.getgPlayers()){
							sender.sendMessage(ChatColor.GRAY + "- " + gp.getName());
						}
						break;
					case "reload":
						Enabler enable = new Enabler();
						Disabler disable = new Disabler();
						Setup setup = new Setup();
						Load load = new Load();
						ClioteInit ccu = new ClioteInit();
						Bukkit.getLogger().info("_________________________________________________________________________");
						Bukkit.getLogger().info("Stopping gFeatures!");
						Bukkit.getLogger().info("Current version: " + Listeners.version);
						Bukkit.getLogger().info("Turning off modules!");
						disable.onDisable();
						Bukkit.getLogger().info("Complete!");
						Bukkit.getLogger().info("_________________________________________________________________________");
						Bukkit.getLogger().info("_________________________________________________________________________");
						Bukkit.getLogger().info("Starting gFeatures!");
						Bukkit.getLogger().info("Current version: " + Listeners.version);
						Bukkit.getLogger().info("Starting modules!");
						setup.onSetup();
						SetupConfig.setup();
						LoadConfig.load();
						ccu.enable();
						enable.onEnable();
						Basic.addPlayerSection("Setup", "DO NOT REMOVE!");
						load.load();
						try{
							Obtain.start();
						}
						catch(Exception e){
							e.printStackTrace();
						}
						gLoop gl = new gLoop();
						gl.start();
						Bukkit.getLogger().info(" Complete!");
						Bukkit.getLogger().info("_________________________________________________________________________");
						sender.sendMessage(ChatColor.GRAY + "Reload complete.");
						break;
					case "flush":
						for(gPlayer gp : Basic.getgPlayers()){
							net.estinet.gFeatures.API.PlayerStats.Setup s = new net.estinet.gFeatures.API.PlayerStats.Setup();
							s.flushPlayer(gp);
						}
						sender.sendMessage(ChatColor.GRAY + "Player flush complete.");
						break;
					case "debug":
						if(Listeners.debug == true){
							Listeners.debug = false;
							sender.sendMessage(ChatColor.GRAY + "Turned off debugging.");
						}
						else{
							Listeners.debug = true;
							sender.sendMessage(ChatColor.GRAY + "Turned on debugging.");
						}
						break;
					case "flushsql":
						sender.sendMessage(ChatColor.GRAY + "Flushing SQL...");

						Thread thr = new Thread(new Runnable(){
							public void run(){
								Basic.recieveSQLPlayers();
								sender.sendMessage(ChatColor.GRAY + "Finished!");
							}
						});
						thr.start();
						break;
					case "loadedsql":
						sender.sendMessage(ChatColor.GRAY + "Loaded SQL Players:");
						for(EstiPlayer p : Basic.getEstiPlayers()){
							sender.sendMessage(ChatColor.GRAY + "- " + p.getName());
						}
						break;
					case "loadedsqlfields":
						sender.sendMessage(ChatColor.GRAY + "Loaded SQL Fields:");
						for(EstiSet set : Basic.getSQLFields()){
							sender.sendMessage(ChatColor.GRAY + "- " + set.getTag());
							for(Object key : set.getData().keySet()){
								Key keys = (Key) key;
								sender.sendMessage(ChatColor.GRAY + "    - " + keys.getKey().toString());
							}
						}
						break;
					default:
						if(cmd.getName().equalsIgnoreCase("gf") || cmd.getName().equalsIgnoreCase("gfeatures")){
							sender.sendMessage(ChatColor.GRAY + "Please do /gFeatures help.");
						}
						break;
					}
				}
				else if(args.length == 2){
					switch(args[0]){
					case "featurestate":
						gFeature feature = Basic.getFeature(args[1]);
						sender.sendMessage(ChatColor.GRAY + "Feature " + args[1] + " state is " + feature.getState().toString());
						break;
					case "send":
						NetworkThread nt = new NetworkThread();
						nt.sendOutput(args[1]);
						sender.sendMessage(ChatColor.GRAY + "Sent message " + args[1] + " to ClioteSky.");
						break;
					default:
						if(cmd.getName().equalsIgnoreCase("gf") || cmd.getName().equalsIgnoreCase("gfeatures")){
							sender.sendMessage(ChatColor.GRAY + "Please do /gFeatures help.");
						}
						break;
					}
				}
				else{
					switch(args[0]){
					case "send":
						String output = "";
						for(int i = 0; i < args.length-1; i++){
							output += args[i+1] + " ";
						}
						NetworkThread nt = new NetworkThread();
						nt.sendOutput(output);
						sender.sendMessage(ChatColor.GRAY + "Sent message " + output + "to ClioteSky.");
						break;
					default:
						sender.sendMessage(ChatColor.GRAY + "Please do /gFeatures help.");
						break;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
