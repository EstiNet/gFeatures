package net.genesishub.gFeatures.Configuration;

import java.util.ArrayList;
import java.util.List;

import net.genesishub.gFeatures.Extension;
import net.genesishub.gFeatures.Features;

public class MainConfig {
	private static List<Features> features = new ArrayList<>();
	private static List<Extension> extensions = new ArrayList<>();
	public void addFeature(Features feature){
		features.add(feature);
	}
	public void addExtension(Extension extend){
		extensions.add(extend);
	}
	public void removeFeature(Features feature){
		features.remove(feature);
	}
	public void removeExtension(Extension extend){
		features.remove(extend);
	}
	public List<Features> getFeatures(){
		return features;
	}
	public List<Extension> getExtensions(){
		return extensions;
	}
}
