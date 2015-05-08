package net.genesishub.gFeatures;

public class Extension {
	private static String name;
	private static double version;
	private static FeatureState state;
	
	public Extension(String featurename, double d){
		name = featurename;
		version = d;
	}
	public void setName(String featurename){
		name = featurename;
		return;
	}
	public void setVersion(double featureversion){
		version = featureversion;
		return;
	}
	public void setState(FeatureState states){
		state = states;
		return;
	}
	public String getName(){
		return name;
	}
	public double getVersion(){
		return version;
	}
	public FeatureState getState(){
		return state;
	}
}
