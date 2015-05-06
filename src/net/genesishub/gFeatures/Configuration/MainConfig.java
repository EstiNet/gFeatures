package net.genesishub.gFeatures.Configuration;

import java.util.ArrayList;
import java.util.List;

import net.genesishub.gFeatures.Extension;
import net.genesishub.gFeatures.gFeature;

public class MainConfig {
	private static List<gFeature> features = new ArrayList<>();
	private static List<Extension> extensions = new ArrayList<>();
	public void addFeature(gFeature feature){
		features.add(feature);
	}
	public void addExtension(Extension extend){
		extensions.add(extend);
	}
	public void removeFeature(gFeature feature){
		features.remove(feature);
	}
	public void removeExtension(Extension extend){
		features.remove(extend);
	}
	public List<gFeature> getFeatures(){
		return features;
	}
	public List<Extension> getExtensions(){
		return extensions;
	}
}
