package tk.genesishub.gFeatures.Commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import tk.genesishub.gFeatures.PluginManage.PluginManager;
import tk.genesishub.gFeatures.PluginManage.PluginState;
import tk.genesishub.gFeatures.PluginManage.Plugins;

public class gFeatureCore {
	public String CommandSwitch(final CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("gf") || cmd.getName().equalsIgnoreCase("gFeature") || cmd.getName().equalsIgnoreCase("gFeatures")){
			if(args.length == 0){
				sender.sendMessage(ChatColor.GRAY + "Please do /gFeatures help.");
			}
			else if(args.length == 1){
				switch(args[0]){
				case "version":
					sender.sendMessage(ChatColor.GRAY + "gFeatures Version 1.0.0");
					break;
				case "help":
					sender.sendMessage(ChatColor.GRAY + "------Help------");
					sender.sendMessage(ChatColor.GRAY + "/gFeatures version : States the plugin version.");
					sender.sendMessage(ChatColor.GRAY + "/gFeatures list : Lists all plugins with their states also.");
					sender.sendMessage(ChatColor.GRAY + "/gFeatures pluginstate <Plugin> : Gets the state of the plugin.");
					break;
				case "list":
					PluginManager pm = new PluginManager();
					List<Plugins> enabled = new ArrayList<>();
					List<Plugins> all = new ArrayList<>();
					enabled = pm.getEnabledPlugins();
					sender.sendMessage(ChatColor.GRAY + "Plugins:");
					sender.sendMessage(ChatColor.GRAY + "Enabled:");
					for(int i = 0; i<enabled.size(); i++){
						all.remove(i);
						sender.sendMessage(ChatColor.GRAY + "-" + Plugins.toString(enabled.get(i)));
					}
					sender.sendMessage(ChatColor.GRAY + "Disabled:");
					for(int i = 0; i<all.size(); i++){
						sender.sendMessage(ChatColor.GRAY + "-" + Plugins.toString(all.get(i)));
					}
					break;
				case "pluginstate":
					sender.sendMessage(ChatColor.GRAY + "Usage: /gFeatures pluginstate <Plugin>");
				default:
					sender.sendMessage(ChatColor.GRAY + "Please do /gFeatures help.");
					break;
				}
			}
			else if(args.length == 2){
				switch(args[0]){
				case "pluginstate":
					PluginManager pm = new PluginManager();
					PluginState ps = pm.getPluginState(Plugins.toPlugins(args[1]));
					sender.sendMessage(ChatColor.GRAY + "Plugin " + args[1] + " state is " + ps.toString());
					break;
				default:
					sender.sendMessage(ChatColor.GRAY + "Please do /gFeatures help.");
					break;
				}
			}
		}
		return null;
	}
}
