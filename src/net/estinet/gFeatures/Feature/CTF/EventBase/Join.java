package net.estinet.gFeatures.Feature.CTF.EventBase;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;

import net.estinet.gFeatures.API.Inventory.ClearInventory;
import net.estinet.gFeatures.Feature.CTF.Basic;
import net.estinet.gFeatures.Feature.CTF.PlayerMode;
import net.estinet.gFeatures.Feature.CTF.EventBase.GameFunc.Action;
import net.estinet.gFeatures.Feature.CTF.EventBase.GameFunc.StartStop;
import net.estinet.gFeatures.Feature.CTF.Holo.CTFScore;
import net.estinet.gFeatures.Feature.CTF.Holo.Lobby;

public class Join {
	StartStop ss = new StartStop();
	Spectate s = new Spectate();
	Lobby l = new Lobby();
	CTFScore ctfs = new CTFScore();
	ClearInventory ci = new ClearInventory();
	public void init(PlayerJoinEvent event){
		ci.clearInv(event.getPlayer());
		event.getPlayer().setGameMode(GameMode.ADVENTURE);
		Basic.kills.put(event.getPlayer().getUniqueId(), 0);
		Basic.deaths.put(event.getPlayer().getUniqueId(), 0);
		Basic.flagcaptures.put(event.getPlayer().getUniqueId(), 0);
		switch(Basic.mode){
		case WAITING:
			for(Player p : Bukkit.getOnlinePlayers()){
				p.setScoreboard(l.Initialize(p));
			}
			Basic.modes.put(event.getPlayer().getUniqueId(), PlayerMode.WAITING);
			Basic.waitspawn = new Location(Bukkit.getWorld("MinigameSpawn"), 76.5, 96.5, 91.5);
			event.getPlayer().teleport(Basic.waitspawn);
			if(Bukkit.getOnlinePlayers().size() >= 2 && Basic.countdown == 60){
				Action.sendAll(ChatColor.AQUA + "Enough players! Game will be starting in 1 minute.");
				ss.start();
			}
			else if(Bukkit.getOnlinePlayers().size() >= 2 && Basic.countdown  == 5){
				//make sure you remove after we finish
				ss.start();
			}
			break;
		case ENDED:
			for(Player p : Bukkit.getOnlinePlayers()){
				p.setScoreboard(ctfs.Initialize(p));
			}
			event.getPlayer().teleport(Basic.spectatespawn);
			Basic.modes.put(event.getPlayer().getUniqueId(), PlayerMode.SPECTATE);
			s.handler(event.getPlayer());
			break;
		case STARTED:
			for(Player p : Bukkit.getOnlinePlayers()){
				p.setScoreboard(ctfs.Initialize(p));
			}
			event.getPlayer().teleport(Basic.spectatespawn);
			Basic.modes.put(event.getPlayer().getUniqueId(), PlayerMode.SPECTATE);
			s.handler(event.getPlayer());
			break;
		default:
			break;
		}
	}
}
