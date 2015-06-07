package net.genesishub.gFeatures.Feature.gWarsSuite.Multiplayer;

import net.genesishub.gFeatures.Feature.gWarsSuite.Constants;
import net.genesishub.gFeatures.Feature.gWarsSuite.Statistics;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class Source {
	Statistics stats = new Statistics();
	public void setup(Player p){
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard board = manager.getNewScoreboard();
		Objective objective = board.registerNewObjective("test", "dummy");
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		objective.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + " _gWars_ ");
		Score score2 = objective.getScore(ChatColor.DARK_AQUA + "Kills:"); //Get a fake offline player
		score2.setScore(9);
		Score score3 = objective.getScore(ChatColor.AQUA + "" + stats.getKills(p)); //Get a fake offline player
		score3.setScore(8);
		Score score = objective.getScore(ChatColor.DARK_AQUA + "Deaths:"); //Get a fake offline player
		score.setScore(7);
		Score score5 = objective.getScore(ChatColor.AQUA + "" + stats.getDeaths(p)); //Get a fake offline player
		score5.setScore(6);
		Score score1 = objective.getScore(ChatColor.GRAY + "Current team:");
		score1.setScore(5);
		Score score7 = objective.getScore(ChatColor.AQUA + "" + stats.getStringTeam(p)); //Get a fake offline player
		score7.setScore(4);
		Score score8 = objective.getScore(ChatColor.LIGHT_PURPLE + "Points:");
		score8.setScore(3);
		if(Constants.multiplayerpossession.get(Constants.bridge).equals(Team.BLUE)){
		Score score9 = objective.getScore(ChatColor.DARK_AQUA + "Bridge");
		score9.setScore(2);
		}
		else if(Constants.multiplayerpossession.get(Constants.bridge).equals(Team.ORANGE)){
			Score score9 = objective.getScore(ChatColor.GOLD + "Bridge");
			score9.setScore(2);
		}
		else{
			Score score9 = objective.getScore(ChatColor.WHITE + "Bridge");
			score9.setScore(2);
		}
		
		if(Constants.multiplayerpossession.get(Constants.innisfilhighway).equals(Team.BLUE)){
			Score score9 = objective.getScore(ChatColor.DARK_AQUA + "Innisfil Highway Exit");
			score9.setScore(1);
		}
		else if(Constants.multiplayerpossession.get(Constants.innisfilhighway).equals(Team.ORANGE)){
			Score score9 = objective.getScore(ChatColor.GOLD + "Innisfil Highway Exit");
			score9.setScore(1);
		}
		else{
			Score score9 = objective.getScore(ChatColor.WHITE + "Innisfil Highway Exit");
			score9.setScore(1);
		}
		
		if(Constants.multiplayerpossession.get(Constants.kloynehighway).equals(Team.BLUE)){
			Score score9 = objective.getScore(ChatColor.DARK_AQUA + "Kloyne Highway Exit");
			score9.setScore(1);
		}
		else if(Constants.multiplayerpossession.get(Constants.kloynehighway).equals(Team.ORANGE)){
			Score score9 = objective.getScore(ChatColor.GOLD + "Kloyne Highway Exit");
			score9.setScore(1);
		}
		else{
			Score score9 = objective.getScore(ChatColor.WHITE + "Kloyne Highway Exit");
			score9.setScore(1);
		}
		p.setScoreboard(board);
	}
	public void flushAll(){
		for(Player player : Bukkit.getOnlinePlayers()){
			setup(player);
		}
	}
}
