package net.estinet.gFeatures.Feature.FusionPlay.GameUtil;

public class FusionSettings {
	
	/*
	 * FusionGame provided settings.
	 */
	
	protected boolean usesSpawns = true; //Whether or not to use the built-in spawn mechanics.
	protected boolean antiDeath = true; //Prevents death screen if enabled.
	protected boolean autoLoadMap = true; //Whether or not to use built in map-loader (loads before server is fully setup)
	protected String defaultMapName = "world";
	protected TimeManager timeManager = null;
	
	/*
	 * FusionGame Settings
	 */
	
	public boolean usesSpawns(){
		return usesSpawns;
	}
	public void setUsesSpawns(boolean usesSpawns){
		this.usesSpawns = usesSpawns;
	}
	public boolean usesAntiDeathScr(){
		return antiDeath;
	}
	public void setUsesAntiDeathScr(boolean antiDeath){
		this.antiDeath = antiDeath;
	}
	public boolean usesAutoLoadMap(){
		return autoLoadMap;
	}
	public void setAutoLoadMap(boolean autoLoadMap){
		this.autoLoadMap = autoLoadMap;
	}
	public String getDefaultMapName(){
		return defaultMapName;
	}
	public void setDefaultMapName(String defaultMapName){
		this.defaultMapName = defaultMapName;
	}
	public TimeManager getTimeManager(){
		return timeManager;
	}
	public void setTimeManager(TimeManager timeManager){
		this.timeManager = timeManager;
	}
}
