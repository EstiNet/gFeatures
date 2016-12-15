package net.estinet.gFeatures.Feature.FusionPlay.GameUtil;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import net.estinet.gFeatures.gFeature;
import net.estinet.gFeatures.ClioteSky.API.CliotePing;
import net.estinet.gFeatures.Feature.FusionPlay.FusionPlay;
import org.bukkit.entity.Player;

public class FusionGame extends gFeature{
	protected List<FusionMap> maps = new ArrayList<>();
	protected FusionSettings settings = new FusionSettings();
	protected FusionState state = FusionState.NOTUSED;
	protected FusionMap currentMap = null;

	public GameMode defaultGameMode = GameMode.ADVENTURE;

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
	public void setFusionMap(FusionMap fm){
		currentMap = fm;
	}
	public FusionMap getFusionMap(){
		return currentMap;
	}
	/*
	 * Non-Overridable
	 * Please call this when the minigame is complete,
	 * under winning circumstances, or built-in timer finishes.
	 */
	public final void finishGame(boolean usedTimer){
		this.state = FusionState.ENDED;
		if(!settings.usesDependsOnTimer() && !usedTimer){
			timeCompleted(false);
		}
		else{
			timeCompleted(true);
		}
	}
	/*
	 * Called when there are enough players to start, and the
	 * waiting timer has started.
	 */
	public void enoughPlayers(){}
	/*
	 * Called when the server has been assigned to an ID,
	 * and is ready to accept players.
	 * Override to change assigning behaviour.
	 */
	public void gameAssigned(){}
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
	 * Override to add game start enable behaviour (does not override auto fusionplay processes & spawner).
	 */
	public void waitTimerComplete(){}
	/*
	 * Called if using the auto timer, and the timer ends, or the game is complete.
	 * Override to COMPLETELY change timer end behaviour.
	 */
	public void timeCompleted(boolean usedTimer){
		FusionPlay.currentGame.setFusionState(FusionState.ENDED);
		gameEnd();
		Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
			public void run(){
				absoluteGameEnd();
			}
		}, 60L);
	}
	/*
	 * Called if using the built in game stopper + auto timer,
	 * and the timer ends.
	 * Override to ADD-ON to the timer end behaviour.
	 */
	public void gameEnd(){}
	/*
	 * Called when the rewards are given out, and after a certain amount of time.
	 * Note: YOU MUST IMPLEMENT CLIOTE("fusionplay done") eventually
	 */
	public void absoluteGameEnd(){
		CliotePing cp = new CliotePing();
		cp.sendMessage("fusionplay done", "Bungee");
	}
	/*
	 * Called when spectator is added.
	 */
	public void setSpectator(Player p){}
	/*
	 * Called when spectator is removed.
	 */
	public void removeSpectator(Player p){}
	/*
	 * Called when default world is loaded.
	 */
	public void worldLoaded(){}
	/*
	 * Called when the timer moves down one second.
	 */
	public void timerOneSec(int seconds){}
}
