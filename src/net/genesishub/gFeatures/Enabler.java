package net.genesishub.gFeatures;

import java.util.List;

public class Enabler {
	public void onEnable(){
		List<gFeature> features = Basic.getFeatures();
		for(gFeature feature : features){
			feature.enable();
		}
	}
}
