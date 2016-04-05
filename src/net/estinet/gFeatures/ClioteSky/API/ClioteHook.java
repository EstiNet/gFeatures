package net.estinet.gFeatures.ClioteSky.API;

import java.util.List;

import net.estinet.gFeatures.gFeature;

public class ClioteHook{
	private gFeature gf;
	private String argument;
	public ClioteHook(gFeature feature, String coreArgument){
		gf = feature;
		argument = coreArgument;
	}
	public gFeature getgFeature(){
		return gf;
	}
	public String getCoreArgument(){
		return argument;
	}
	public void setgFeature(gFeature gf){
		this.gf = gf;
	}
	public void setCoreArgument(String coreArg){
		argument = coreArg;
	}
	//Must override
	public void run(List<String> args, String categoryName, String clioteName){}
}
