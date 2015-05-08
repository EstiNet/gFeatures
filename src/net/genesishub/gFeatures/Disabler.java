package net.genesishub.gFeatures;

import java.util.List;

public class Disabler {
	public void onDisable(){
		List<gFeature> features = Basic.getFeatures();
		for(gFeature feature : features){
			feature.disable();
		}
	}
}
