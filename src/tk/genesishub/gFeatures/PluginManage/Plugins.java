package tk.genesishub.gFeatures.PluginManage;

import java.util.ArrayList;
import java.util.List;

public enum Plugins {
	gWarsSuite, gFactions, gFeatures, gDestroyCritical, gHub, GenesisAccess, UnknownPlugin;
	public static String toString(Plugins plugin){
		String str = "Unknown Plugin";
		switch(plugin){
		case gWarsSuite:
			str = "gWarsSuite";
			break;
		case gFactions:
			str = "gFactions";
			break;
		case gFeatures:
			str = "gFeatures";
			break;
		case gDestroyCritical:
			str = "gDestroyCritical";
			break;
		case gHub:
			str = "gHub";
			break;
		case GenesisAccess:
			str = "GenesisAccess";
			break;
		case UnknownPlugin:
			break;
		default:
			break;
		}
		return str;
	}
	public static Plugins toPlugins(String str){
		Plugins plugin = UnknownPlugin;
		switch(str){
		case "gWarsSuite":
			plugin = gWarsSuite;
			break;
		case "gFactions":
			plugin = gFactions;
			break;
		case "gFeatures":
			plugin = gFeatures;
			break;
		case "gDestroyCritical":
			plugin = gDestroyCritical;
			break;
		case "gHub":
			plugin = gHub;
			break;
		case "GenesisAccess":
			plugin = GenesisAccess;
			break;
		}
		return plugin;
	}
	public static List<Plugins> getPlugins(){
		List<Plugins> list = new ArrayList<>();
		list.add(gWarsSuite);
		list.add(gFactions);
		list.add(gFeatures);
		list.add(gDestroyCritical);
		list.add(gHub);
		list.add(GenesisAccess);
		return list;
	}
}
