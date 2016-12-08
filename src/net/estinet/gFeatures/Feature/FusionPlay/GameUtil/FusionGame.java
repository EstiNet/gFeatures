package net.estinet.gFeatures.Feature.FusionPlay.GameUtil;

import java.util.ArrayList;
import java.util.List;

import net.estinet.gFeatures.gFeature;

public class FusionGame extends gFeature{
	protected List<FusionMap> maps = new ArrayList<>();
	
	/*
	 * FusionGame provided settings.
	 */
	
	protected boolean usesSpawns = true; //Whether or not to use the built-in spawn mechanics.
	protected boolean antiDeath = true; //Prevents death screen if enabled.
	
	public FusionGame(String featurename, String version) {
		super(featurename, version);
	}
	public List<FusionMap> getMaps(){
		return maps;
	}
	public void setMaps(List<FusionMap> maps){
		this.maps = maps;
	}
	/*
	 * Called when the server has been assigned to an ID,
	 * and is ready to accept players.
	 * Override to change assigning behaviour.
	 */
	public void gameAssigned(){
		
	}
	/*
	 * Called when the server 
	 */
	
	
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
	
}
