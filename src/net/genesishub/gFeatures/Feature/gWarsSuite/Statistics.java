package net.genesishub.gFeatures.Feature.gWarsSuite;

import net.genesishub.gFeatures.Basic;
import net.genesishub.gFeatures.API.PlayerStats.gPlayer;

import org.bukkit.entity.Player;

public class Statistics {
	public int getKills(Player p){
		return Integer.parseInt(Basic.getgPlayer(p.getName()).getValue("gWars.Kills"));
	}
	public int getDeaths(Player p){
		return Integer.parseInt(Basic.getgPlayer(p.getName()).getValue("gWars.Deaths"));
	}
	public void addKill(Player p){
		int kill = Integer.parseInt(Basic.getgPlayer(p.getName()).getValue("gWars.Kills"));
		kill += 1;
		gPlayer gplayer = Basic.getgPlayer(p.getName());
		gplayer.setValue("gWars.Kills", Integer.toString(kill));
		Basic.removegPlayer(Basic.getgPlayer(p.getName()));
		Basic.addgPlayer(gplayer);
		return;
	}
	public void addDeaths(Player p){
		int kill = Integer.parseInt(Basic.getgPlayer(p.getName()).getValue("gWars.Deaths"));
		kill += 1;
		gPlayer gplayer = Basic.getgPlayer(p.getName());
		gplayer.setValue("gWars.Deaths", Integer.toString(kill));
		Basic.removegPlayer(Basic.getgPlayer(p.getName()));
		Basic.addgPlayer(gplayer);
		return;
	}
	public void setKills(Player p, int value){
		int kill = value;
		gPlayer gplayer = Basic.getgPlayer(p.getName());
		gplayer.setValue("gWars.Kills", Integer.toString(kill));
		Basic.removegPlayer(Basic.getgPlayer(p.getName()));
		Basic.addgPlayer(gplayer);
		return;
	}
	public void setDeaths(Player p, int value){
		int kill = value;
		gPlayer gplayer = Basic.getgPlayer(p.getName());
		gplayer.setValue("gWars.Deaths", Integer.toString(kill));
		Basic.removegPlayer(Basic.getgPlayer(p.getName()));
		Basic.addgPlayer(gplayer);
		return;
	}
}
