package net.genesishub.gFeatures;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Event;

public class gFeature {
	private String name;
	private double version;
	private FeatureState state;
	private String commandlabel;
	
	public gFeature(String featurename, double d){
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
	public void setCommandLabel(String label){
		commandlabel = label;
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
	public String getCommandLabel(){
		return commandlabel;
	}
	public void enable(){}
	public void disable(){}
	public void eventTrigger(Event event){}
	public void commandTrigger(CommandSender sender, Command cmd, String label, String[] args){}
}
