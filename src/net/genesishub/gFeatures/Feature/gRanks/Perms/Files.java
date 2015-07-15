package net.genesishub.gFeatures.Feature.gRanks.Perms;

import net.genesishub.gFeatures.Configuration.Config;
import net.genesishub.gFeatures.Feature.gRanks.Basis;
import net.genesishub.gFeatures.Feature.gRanks.Rank;
import net.genesishub.gFeatures.Feature.gRanks.Retrieve;

public class Files {
	Retrieve r = new Retrieve();
	public void setupFiles(){
		Config c = new Config();
		c.createDirectory("plugins/gFeatures/gRanks/perms", "Created Permissions folder!");
		for(Rank r : Basis.getRanks()){
			c.createFile("plugins/gFeatures/gRanks/perms/" + r.getName(), "Created permissions file for " + r.getName() + "!");
		}
	}
}