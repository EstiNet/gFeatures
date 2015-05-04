package net.genesishub.gFeatures;

public class gFeature {
	private static String name;
	private static float version;
	private static FeatureState state;
	private static String commandlabel;
	
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
	public void setState(FeatureState states){
		state = states;
		return;
	}
	public void setCommandLabel(String label){
		commandlabel = label;
		return;
	}
	public String getName(){
		return name;
	}
	public float getVersion(){
		return version;
	}
	public FeatureState getState(){
		return state;
	}
	public String getCommandLabel(){
		return commandlabel;
	}
}
