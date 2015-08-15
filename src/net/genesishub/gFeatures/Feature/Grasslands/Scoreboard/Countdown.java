package net.genesishub.gFeatures.Feature.Grasslands.Scoreboard;

import net.genesishub.gFeatures.Feature.GenesisEconomy.MoneyManager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class Countdown {
	MoneyManager mm = new MoneyManager();
	public Scoreboard get(Player p, int count) throws IllegalStateException, IllegalArgumentException{
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard board = manager.getNewScoreboard();
		Objective objective = board.registerNewObjective("test", "dummy");
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		objective.setDisplayName("[" + ChatColor.GREEN + "" + ChatColor.BOLD + "Grasslands" + ChatColor.RESET +"]");
		Score score1 = objective.getScore(""); //Get a fake offline player
		score1.setScore(10);
		Score score2 = objective.getScore(ChatColor.DARK_BLUE + "" + ChatColor.BOLD + "Online:"); //Get a fake offline player
		score2.setScore(9);
		Score score3 = objective.getScore("" + Integer.toString(Bukkit.getServer().getOnlinePlayers().size())); //Get a fake offline player
		score3.setScore(8);
		Score score11 = objective.getScore(""); //Get a fake offline player
		score11.setScore(7);
		Score score = objective.getScore(ChatColor.GREEN + "Clupic:"); //Get a fake offline player
		score.setScore(6);
		Score score5 = objective.getScore("" + Float.toString(mm.getMoney(p))); //Get a fake offline player
		score5.setScore(5);
		Score score12 = objective.getScore(""); //Get a fake offline player
		score12.setScore(4);
		Score score8 = objective.getScore(ChatColor.GOLD + "" + ChatColor.BOLD +  "Countdown:");
		score8.setScore(3);
		Score score9 = objective.getScore("" + count);
		score9.setScore(2);
		if(!(p.getName().length() >= 16)){
		Score score10 = objective.getScore(ChatColor.DARK_AQUA + p.getName().trim());
		score10.setScore(1);
		}
		return board;
	}
}
