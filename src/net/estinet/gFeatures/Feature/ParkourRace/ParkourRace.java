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

import io.netty.util.internal.chmv8.ConcurrentHashMapV8.Action;
import net.estinet.gFeatures.Events;
import net.estinet.gFeatures.Retrieval;
import net.estinet.gFeatures.API.Messaging.ActionAPI;
import net.estinet.gFeatures.Feature.FusionPlay.FusionPlay;
import net.estinet.gFeatures.Feature.FusionPlay.GameUtil.FusionGame;
import net.estinet.gFeatures.Feature.ParkourRace.Logistics.DetermineWinner;
import net.estinet.gFeatures.Feature.ParkourRace.Logistics.ScoreboardCreator;

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
	public void waitTimerComplete(){}
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
    	}
    }
}
