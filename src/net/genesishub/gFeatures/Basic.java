package net.genesishub.gFeatures;

import java.util.ArrayList;
import java.util.List;

public class Basic {
	private static List<gFeature> features = new ArrayList<>();
	private static List<Extension> extensions = new ArrayList<>();
	public static void addFeature(gFeature feature){
		features.add(feature);
	}
	public static void addExtension(Extension extend){
		extensions.add(extend);
	}
	public static void removeFeature(gFeature feature){
		features.remove(feature);
	}
	public static void removeExtension(Extension extend){
		features.remove(extend);
	}
	public static List<gFeature> getFeatures(){
		return features;
	}
	public static List<Extension> getExtensions(){
		return extensions;
	}
}
