package net.estinet.gFeatures.Feature.Spleef.Logistics;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import net.estinet.gFeatures.Feature.ParkourRace.ParkourRace;
import net.md_5.bungee.api.ChatColor;

public class ScoreboardCreator {
	public static Scoreboard getScoreboard(int seconds){
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard board = manager.getNewScoreboard();
		Objective objective = board.registerNewObjective("test", "dummy");
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		objective.setDisplayName(ChatColor.GRAY + "(⌐■_■) Time Left: " + ChatColor.DARK_AQUA + seconds);
		Object[] doo = ParkourRace.distances.keySet().toArray();
		Arrays.sort(doo);
		for(int i = 0; i < doo.length; i++){
			Score score = objective.getScore(Bukkit.getPlayer(ParkourRace.distances.get(doo[i])).getName());
			score.setScore((int) (double) doo[i]);
		}
		return board;
	}
}
