package net.estinet.gFeatures.Feature.FusionPlay.GameUtil;

public class FusionSettings {
	
	/*
	 * FusionSettings Holder Variables
	 */
	
	public int minLeft = 0, secLeft = 0;
	public int waitingSecLeft = 0;
	
	/*
	 * FusionGame provided settings.
	 */
	
	protected boolean usesSpawns = true; //Whether or not to use the built-in spawn mechanics.
	protected boolean usesWaitingCounter = true; //Whether or not to use the built-in waiting counter. Must be supplied with waitingTimeManager and if overriden, check WaitingProcess.java
	protected boolean antiDeath = true; //Prevents death screen if enabled.
	protected boolean autoLoadMap = true; //Whether or not to use built in map-loader (loads before server is fully setup)
	protected boolean dependsOnTimer = true; //Whether or not the game depends on the timer, or winning circumstance.
	protected boolean allToSpectator = true; //Whether or not to set all players to Spectator after the game ends.
	protected String defaultMapName = "world";
	protected TimeManager timeManager = null;
	//Seshpenguin was here :D
	
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
	public boolean usesWaitingCounter(){
		return usesWaitingCounter;
	}
	public void setWaitingCounter(boolean usesWaitingCounter){
		this.usesWaitingCounter = usesWaitingCounter;
	}
	public int getWaitingSecLeft(){
		return waitingSecLeft;
	}
	public void setWaitingSecLeft(int sec){
		this.waitingSecLeft = sec;
	}
	public TimeManager getTimeManager(){
		return timeManager;
	}
	public void setTimeManager(TimeManager timeManager){
		this.timeManager = timeManager;
	}
	public boolean usesDependsOnTimer(){
		return dependsOnTimer;
	}
	public void setDependsOnTimer(boolean value){
		dependsOnTimer = value;
	}
	public boolean getAllToSpectator() { return allToSpectator; }
	public void setAllToSpectator(boolean value){ allToSpectator = value; }

}
