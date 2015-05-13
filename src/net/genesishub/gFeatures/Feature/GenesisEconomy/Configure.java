package net.genesishub.gFeatures.Feature.GenesisEconomy;

import net.genesishub.gFeatures.Basic;
import net.genesishub.gFeatures.Configs;
import net.genesishub.gFeatures.Configuration.Config;

public class Configure {
	@Configs
	public static void onSetup(){
		GenesisEconomy base = new GenesisEconomy("GenesisEconomy", 1.0);
		Basic.addFeature(base);
		Config con = new Config();
		con.createDirectory("plugins/gFeatures/gEconomy", "Created economy directory!");
	}
}
