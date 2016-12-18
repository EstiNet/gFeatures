package net.estinet.gFeatures.Feature.ParkourRace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.Scoreboard;

import net.estinet.gFeatures.Events;
import net.estinet.gFeatures.Retrieval;
import net.estinet.gFeatures.Feature.FusionPlay.FusionPlay;
import net.estinet.gFeatures.Feature.FusionPlay.GameUtil.FusionGame;
import net.estinet.gFeatures.Feature.ParkourRace.Logistics.DetermineWinner;
import net.estinet.gFeatures.Feature.ParkourRace.Logistics.ScoreboardCreator;
import net.estinet.gFeatures.Feature.ParkourRace.Maps.PRMap;
import net.estinet.gFeatures.Feature.gScore.ActionAPI;
import net.md_5.bungee.api.ChatColor;

public class ParkourRace extends FusionGame implements Events{
	
	public static List<UUID> start = new ArrayList<>();
	public static List<UUID> checkpoint = new ArrayList<>();
	public static HashMap<Double, UUID> distances = new HashMap<>();
	
	EventHub eh = new EventHub();
	
	public ParkourRace(String featurename, String d) {
		super(featurename, d);
	}
	@Override
	public void enable(){
		Enable.onEnable();
	}
	@Override
	public void disable(){
		Disable.onDisable();
	}
	@Override
	public void eventTrigger(Event event) {
		if(event.getEventName().equalsIgnoreCase("playerjoinevent")){
			eh.onPlayerJoin((PlayerJoinEvent)event);
		}
	}
	@Retrieval
	public void onPlayerJoin(){}
	@Override
	public void waitTimerComplete(){
		
	}
	@Override
	public void gameAssigned(){}
    @Override
    public void gameEnd(boolean usedTimer){
    	for(Player p : Bukkit.getOnlinePlayers()){
    		p.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
    		FusionPlay.winners(DetermineWinner.determine(0), DetermineWinner.determine(1), DetermineWinner.determine(2));
    	}
    }
    @Override
    public void timerOneSec(int seconds){
    	Scoreboard sb = ScoreboardCreator.getScoreboard(seconds);
    	for(Player p : Bukkit.getOnlinePlayers()){
    		p.setScoreboard(sb);
    		PRMap map = (PRMap) this.currentMap;
    		if(p.getLocation().getY() < map.lowDistance){
    			if(start.contains(p.getUniqueId())){
    				int random = (int )(Math.random() * (map.getSpawns().size()-1) + 1);
    				p.teleport(map.getSpawns().get(random));
    			}
    			else if(checkpoint.contains(p.getUniqueId())){
    				int random = (int )(Math.random() * (map.checkpointSpawns.size()-1) + 1);
    				p.teleport(map.checkpointSpawns.get(random));
    			}
    		}
    		if(p.getLocation().getZ() > getDistance(p.getUniqueId()) && (start.contains(p.getUniqueId()) || checkpoint.contains(p.getUniqueId()))){
    			distances.remove(getDistance(p.getUniqueId()));
    			distances.put(p.getLocation().getY(), p.getUniqueId());
    		}
    		if(p.getLocation().getZ() > map.checkPointZ && start.contains(p.getUniqueId())){
    			start.remove(p.getUniqueId());
    			checkpoint.add(p.getUniqueId());
    			ActionAPI.sendActionBar(p, ChatColor.AQUA + "(づ｡◕‿‿◕｡)づ You passed the checkpoint!");
    		}
    		if(p.getLocation().getZ() > map.pastDistanceZ && (start.contains(p.getUniqueId()) || checkpoint.contains(p.getUniqueId()))){
    			this.finishGame(false);
    		}
    	}
    }
    public double getDistance(UUID uuid){
    	for(int i = 0; i < distances.values().size(); i++){
    		if(distances.values().toArray()[i].equals(uuid)){
    			return (double) distances.keySet().toArray()[i];
    		}
    	}
    	return 0;
    }
}
