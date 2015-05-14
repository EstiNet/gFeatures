package net.genesishub.gFeatures;

public class Extension {
	private String name;
	private String version;
	private FeatureState state;
	
	public Extension(String featurename, String d){
		name = featurename;
		version = d;
	}
	public void setName(String featurename){
		name = featurename;
		return;
	}
	public void setVersion(String featureversion){
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
	public String getVersion(){
		return version;
	}
	public FeatureState getState(){
		return state;
	}
}
