package tk.genesishub.gFeatures.PluginManage;

import java.util.ArrayList;
import java.util.List;

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

public enum Plugins {
	gWarsSuite, gFactions, gFeatures, gDestroyCritical, gHub, GenesisAccess, GenesisEconomy, GenesisBackup,gScore, UnknownPlugin;
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
		case GenesisEconomy:
			str = "GenesisEconomy";
			break;
		case GenesisBackup:
			str = "GenesisBackup";
			break;
		case gScore:
			str = "gScore";
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
		case "GenesisEconomy":
			plugin = GenesisEconomy;
			break;
		case "GenesisBackup":
			plugin = GenesisBackup;
			break;
		case "gScore":
			plugin = gScore;
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
		list.add(GenesisEconomy);
		list.add(GenesisBackup);
		list.add(gScore);
		return list;
	}
}
