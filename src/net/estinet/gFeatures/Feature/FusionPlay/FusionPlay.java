package net.estinet.gFeatures.Feature.FusionPlay;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import net.estinet.gFeatures.Events;
import net.estinet.gFeatures.Retrieval;
import net.estinet.gFeatures.gFeature;
import net.estinet.gFeatures.API.Messaging.ActionAPI;
import net.estinet.gFeatures.Feature.FusionPlay.GameUtil.FusionGame;
import net.estinet.gFeatures.Feature.FusionPlay.GameUtil.FusionState;
import net.md_5.bungee.api.ChatColor;

public class FusionPlay extends gFeature implements Events{
	
	EventHub eh = new EventHub();
	
	public static List<FusionGame> games = new ArrayList<>();
	public static FusionGame currentGame = null;
	public static boolean otherup = false;
	public static boolean assigned = false;
	
	public FusionPlay(String featurename, String version) {
		super(featurename, version);
	}
	@Override
	public void enable(){
		Enable.onEnable();
	}
	@Override
	public void disable() {
		Disable.onDisable();
	}
	@Override
	public void eventTrigger(Event event) {
		if(event.getEventName().equalsIgnoreCase("playerjoinevent")){
			eh.onPlayerJoin((PlayerJoinEvent)event);
		}
		else if(event.getEventName().equalsIgnoreCase("playerinteractevent")){
			eh.onPlayerInteract((PlayerInteractEvent)event);
		}
		else if(event.getEventName().equalsIgnoreCase("foodlevelchangeevent")){
			eh.onFoodLevelChange((FoodLevelChangeEvent)event);
		}
		else if(event.getEventName().equalsIgnoreCase("entitydamageevent")){
			eh.onPlayerDamage((EntityDamageEvent) event);
		}
	}
	@Retrieval
	@Override
	public void onPlayerJoin(){}
	@Retrieval
	@Override
	public void onPlayerInteract(){}
	@Retrieval
	@Override
	public void onFoodLevelChange(){}
	
	public static void addGame(FusionGame fg){
		games.add(fg);
	}
	
	public static void selectGame(){
		File f = new File("plugins/gFeatures/FusionPlay/notminigame.txt");
		String not = "";
		boolean hmm = true;
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			not = br.readLine();
			br.close();
			f.delete();
		}
		catch (FileNotFoundException e){
			hmm = false;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		if(hmm){
			Bukkit.getLogger().info("[FusionPlay] Responding to server change type request.");
			assigned = true;
			otherup = true;
		}
		for(FusionGame fg : games){
			if(!fg.getName().equalsIgnoreCase(not)){
				fg.setFusionState(FusionState.LIMBO);
				currentGame = fg;
			}
		}
	}
	public static void winners(Player p1, Player p2, Player p3){
		for(Player p : Bukkit.getOnlinePlayers()){
			ActionAPI aapi = new ActionAPI();
			aapi.sendTitles(p, 3, 5, 3, ChatColor.DARK_AQUA + " (◕‿↼) Game Complete! （╯°□°）╯︵(\\ .o.)\\", ChatColor.GOLD + "1: " + p1.getName() + " 2: " + p2.getName() + " 3: " + p3.getName());
		}
	}
}
