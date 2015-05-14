package net.genesishub.gFeatures;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;

public class Basic {
	public static List<gFeature> features = new ArrayList<>();
	private static List<Extension> extensions = new ArrayList<>();
	public static void addFeature(gFeature feature){
		features.add(feature);
		Bukkit.getLogger().info(feature.getName());
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
	public static gFeature getFeature(String name){
		for(gFeature feature : features){
			if(feature.getName().equalsIgnoreCase(name)){
				return feature;
			}
		}
		return null;
	}
	public static Extension getExtension(String name){
		for(Extension extend : extensions){
			if(extend.getName().equalsIgnoreCase(name)){
				return extend;
			}
		}
		return null;
	}
	public static List<gFeature> getFeatures(){
		return features;
	}
	public static List<Extension> getExtensions(){
		return extensions;
	}
}
