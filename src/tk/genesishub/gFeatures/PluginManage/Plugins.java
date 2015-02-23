package tk.genesishub.gFeatures.PluginManage;

public enum Plugins {
	gWarsSuite, gFactions, gFeatures, gDestroyCritical, gHub, GenesisAccess;
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
		}
		return str;
	}
}
