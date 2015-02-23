package tk.genesishub.gFeatures.Commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import tk.genesishub.gFeatures.PluginManage.PluginManager;
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
					List<Plugins> disabled = new ArrayList<>();
					enabled = pm.getEnabledPlugins();
					disabled = pm.getDisabledPlugins();
					sender.sendMessage(ChatColor.GRAY + "Plugins:");
					sender.sendMessage(ChatColor.GRAY + "Enabled:");
					for(int i = 0; i<enabled.size(); i++){
						sender.sendMessage(ChatColor.GRAY + "-" + Plugins.toString(enabled.get(i)));
					}
					sender.sendMessage(ChatColor.GRAY + "Disabled:");
					for(int i = 0; i<enabled.size(); i++){
						sender.sendMessage(ChatColor.GRAY + "-" + Plugins.toString(disabled.get(i)));
					}
					break;
				case "pluginstate":
					PluginManager pm2 = new PluginManager();
				}
			}
		}
		return null;
	}
}
