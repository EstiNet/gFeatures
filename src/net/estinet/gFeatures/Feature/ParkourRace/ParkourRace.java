package net.estinet.gFeatures.Feature.ParkourRace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
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
		PRMap map = (PRMap) this.currentMap;
		for(Block block : blocksFromTwoPoints(map.p1, map.p2)){
			Bukkit.getScheduler().runTaskLater(Bukkit.getPluginManager().getPlugin("gFeatures"), new Runnable(){
				public void run(){
					block.setType(Material.AIR);
				}
			}, 1L);
		}
	}
	public static List<Block> blocksFromTwoPoints(Location loc1, Location loc2){
		List<Block> blocks = new ArrayList<Block>();

		int topBlockX = (loc1.getBlockX() < loc2.getBlockX() ? loc2.getBlockX() : loc1.getBlockX());
		int bottomBlockX = (loc1.getBlockX() > loc2.getBlockX() ? loc2.getBlockX() : loc1.getBlockX());

		int topBlockY = (loc1.getBlockY() < loc2.getBlockY() ? loc2.getBlockY() : loc1.getBlockY());
		int bottomBlockY = (loc1.getBlockY() > loc2.getBlockY() ? loc2.getBlockY() : loc1.getBlockY());

		int topBlockZ = (loc1.getBlockZ() < loc2.getBlockZ() ? loc2.getBlockZ() : loc1.getBlockZ());
		int bottomBlockZ = (loc1.getBlockZ() > loc2.getBlockZ() ? loc2.getBlockZ() : loc1.getBlockZ());

		for(int x = bottomBlockX; x <= topBlockX; x++){
			for(int z = bottomBlockZ; z <= topBlockZ; z++){
				for(int y = bottomBlockY; y <= topBlockY; y++){
					Block block = loc1.getWorld().getBlockAt(x, y, z);
					blocks.add(block);
				}
			}
		}
		return blocks;
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
		Bukkit.getLogger().info(seconds + "");
		//Bukkit.getScheduler().runTask(Bukkit.getPluginManager().getPlugin("gFeatures"), new Runnable(){
			//public void run(){
				Scoreboard sb = ScoreboardCreator.getScoreboard(seconds);
				for(Player p : Bukkit.getOnlinePlayers()){
					p.setScoreboard(sb);
					PRMap map = (PRMap) currentMap;
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
					if(p.getLocation().getX() > getDistance(p.getUniqueId()) && (start.contains(p.getUniqueId()) || checkpoint.contains(p.getUniqueId()))){
						distances.remove(getDistance(p.getUniqueId()));
						distances.put(p.getLocation().getY(), p.getUniqueId());
					}
					if(p.getLocation().getX() > map.checkPointZ && start.contains(p.getUniqueId())){
						start.remove(p.getUniqueId());
						checkpoint.add(p.getUniqueId());
						ActionAPI.sendActionBar(p, ChatColor.AQUA + "(づ｡◕‿‿◕｡)づ You passed the checkpoint!");
					}
					if(p.getLocation().getX() > map.pastDistanceZ && (start.contains(p.getUniqueId()) || checkpoint.contains(p.getUniqueId()))){
						finishGame(false);
					}
				}
			//}
		//});

	}
	public static double getDistance(UUID uuid){
		for(int i = 0; i < distances.values().size(); i++){
			if(distances.values().toArray()[i].equals(uuid)){
				return (double) distances.keySet().toArray()[i];
			}
		}
		return 0;
	}
}
