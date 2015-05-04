package net.genesishub.gFeatures;

public class gFeature {
	private static String name;
	private static float version;
	public gFeature(String featurename, float featureversion){
		name = featurename;
		version = featureversion;
	}
	public void setName(String featurename){
		name = featurename;
		return;
	}
	public void setVersion(float featureversion){
		version = featureversion;
		return;
	}
	public String getName(){
		return name;
	}
	public float getVersion(){
		return version;
	}
}
