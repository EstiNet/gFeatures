package net.estinet.gFeatures.Feature.Spleef.Logistics;

import org.bukkit.Bukkit;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import net.estinet.gFeatures.Feature.Spleef.Spleef;
import net.md_5.bungee.api.ChatColor;

public class ScoreboardCreator {
	public static Scoreboard getScoreboard(int seconds){
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard board = manager.getNewScoreboard();
		Objective objective = board.registerNewObjective("test", "dummy");
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		objective.setDisplayName(ChatColor.GRAY + "(⌐■_■) Time Left: " + ChatColor.DARK_AQUA + seconds);
		Score score = objective.getScore("Players left: " + Spleef.stillIn.size());
		score.setScore(1);
		return board;
	}
}
