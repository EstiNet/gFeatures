package net.genesishub.gFeatures;

public class Extension {
	private String name;
	private String version;
	private FeatureState state;
	private ExtensionsType type;
	
	public Extension(String featurename, String d, ExtensionsType ex){
		name = featurename;
		version = d;
		type = ex;
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
	public void setType(ExtensionsType ex){
		type = ex;
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
	public ExtensionsType getType(){
		return type;
	}
}
