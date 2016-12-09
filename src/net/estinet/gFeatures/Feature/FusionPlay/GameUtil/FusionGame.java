package net.estinet.gFeatures.Feature.FusionPlay.GameUtil;

import java.util.ArrayList;
import java.util.List;

import net.estinet.gFeatures.gFeature;
import net.estinet.gFeatures.ClioteSky.API.CliotePing;
import net.estinet.gFeatures.Feature.FusionPlay.FusionPlay;

public class FusionGame extends gFeature{
	protected List<FusionMap> maps = new ArrayList<>();
	protected FusionSettings settings = new FusionSettings();
	protected FusionState state = FusionState.NOTUSED;
	
	public FusionGame(String featurename, String version) {
		super(featurename, version);
	}
	public List<FusionMap> getMaps(){
		return maps;
	}
	public void setMaps(List<FusionMap> maps){
		this.maps = maps;
	}
	public FusionSettings getSettings(){
		return settings;
	}
	public void setSettings(FusionSettings settings){
		this.settings = settings;
	}
	public FusionState getFusionState(){
		return state;
	}
	public void setFusionState(FusionState state){
		this.state = state;
	}
	/*
	 * Called when the server has been assigned to an ID,
	 * and is ready to accept players.
	 * Override to change assigning behaviour.
	 */
	public void gameAssigned(){
		
	}
	/*
	 * Called when the server starts loading the map,
	 * before the server starts up.
	 * Override to change load map behaviour.
	 */
	public void loadMap(){
		if(settings.usesAutoLoadMap()){
			WorldUtil.initializeGame();
		}
	}
	/*
	 * Called if the waiting timer is complete.
	 * Override to add game start enable behaviour (does not override auto fusionplay processes).
	 */
	public void waitTimerComplete(){
		
	}
	/*
	 * Called if using the auto timer, and the timer ends.
	 * Override to COMPLETELY change timer end behaviour.
	 * Note: YOU MUST IMPLEMENT CLIOTE("fusionplay done") eventually
	 */
	public void timeCompleted(){
		//absoluteGameEnd() after certain amount of time
		FusionPlay.currentGame.setFusionState(FusionState.ENDED);
	}
	/*
	 * Called if using the built in game stopper + auto timer,
	 * and the timer ends.
	 * Override to ADD-ON to the timer end behaviour.
	 */
	public void gameEnd(){
		
	}
	/*
	 * Called when the rewards are given out, and after a certain amount of time.
	 */
	public void absoluteGameEnd(){
		CliotePing cp = new CliotePing();
		cp.sendMessage("fusionplay done", "Bungee");
		
	}
}
