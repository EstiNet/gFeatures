package net.estinet.gFeatures.Feature.ParkourRace.Logistics;

import org.bukkit.Bukkit;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import net.estinet.gFeatures.Feature.FusionPlay.FusionPlay;

public class ScoreboardCreator {
	public static Scoreboard getScoreboard(int seconds){
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard board = manager.getNewScoreboard();
		Objective objective = board.registerNewObjective("test", "dummy");
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		objective.setDisplayName(FusionPlay.currentGame.getSettings().getCoolGameName());
		Score score1 = objective.getScore("");
		score1.setScore(11);
		return board;
	}
}
