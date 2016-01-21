package net.estinet.gFeatures.Feature.CTF.EventBase;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import net.estinet.gFeatures.API.Messaging.ActionAPI;
import net.estinet.gFeatures.Feature.CTF.Basic;
import net.estinet.gFeatures.Feature.CTF.Team;
import net.estinet.gFeatures.Feature.CTF.EventBase.GameFunc.Action;
import net.estinet.gFeatures.Feature.CTF.Holo.CTFScore;

public class FlagHit {
	ActionAPI aapi = new ActionAPI();
	CTFScore ctfs = new CTFScore();
	public void init(Location loc, Player p){
		if(loc.getBlockX() == Basic.blueflag.getBlockX() && loc.getBlockY() == Basic.blueflag.getBlockY() && loc.getBlockX() == Basic.blueflag.getBlockZ() && Basic.teams.get(p.getUniqueId()).equals(Team.ORANGE)){
			Action.sendAllTitle(ChatColor.GOLD + "" + ChatColor.BOLD + p.getName() + " has taken the blue flag!", ChatColor.BOLD + "Fireworks will trace " + p.getName() + "!", 20, 40, 20);
			aapi.sendActionbar(p, ChatColor.AQUA + "Get back to your base and punch the ender crystal to capture the flag!");
			Basic.blueflagger = p;
			//Captured the blue flag
		}
		else if(loc.getBlockX() == Basic.orangeflag.getBlockX() && loc.getBlockY() == Basic.orangeflag.getBlockY() && loc.getBlockX() == Basic.orangeflag.getBlockZ() && Basic.teams.get(p.getUniqueId()).equals(Team.BLUE)){
			Action.sendAllTitle(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + p.getName() + " has taken the orange flag!", ChatColor.BOLD + "Fireworks will trace " + p.getName() + "!", 20, 40, 20);
			aapi.sendActionbar(p, ChatColor.AQUA + "Get back to your base and punch the ender crystal to capture the flag!");
			Basic.orangeflagger = p;
			//Captured the orange flag
		}
		else if(loc.getBlockX() == Basic.blueflag.getBlockX() && loc.getBlockY() == Basic.blueflag.getBlockY() && loc.getBlockX() == Basic.blueflag.getBlockZ() && Basic.teams.get(p.getUniqueId()).equals(Team.BLUE) && Basic.orangeflagger.getName().equals(p.getName())){
			Action.sendAllTitle(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + p.getName() + " has captured the orange flag!", "", 20, 40, 20);
			Basic.orangeflagger = null;
			Basic.blueflags += 1;
			Integer capture = Basic.flagcaptures.get(p.getUniqueId());
			Basic.flagcaptures.put(p.getUniqueId(), capture++);
			for(Player ps : Bukkit.getOnlinePlayers()){
				ps.setScoreboard(ctfs.Initialize(ps));
			}
			//Fully Captured the orange flag
		}
		else if(loc.getBlockX() == Basic.orangeflag.getBlockX() && loc.getBlockY() == Basic.orangeflag.getBlockY() && loc.getBlockX() == Basic.orangeflag.getBlockZ() && Basic.teams.get(p.getUniqueId()).equals(Team.ORANGE) && Basic.blueflagger.getName().equals(p.getName())){
			Action.sendAllTitle(ChatColor.GOLD + "" + ChatColor.BOLD + p.getName() + " has captured the blue flag!", "", 20, 40, 20);
			Basic.blueflagger = null;
			Basic.orangeflags += 1;
			Integer capture = Basic.flagcaptures.get(p.getUniqueId());
			Basic.flagcaptures.put(p.getUniqueId(), capture++);
			for(Player ps : Bukkit.getOnlinePlayers()){
				ps.setScoreboard(ctfs.Initialize(ps));
			}
			//Fully Captured the blue flag
		}
	}
}
