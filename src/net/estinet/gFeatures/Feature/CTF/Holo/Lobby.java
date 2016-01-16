package net.estinet.gFeatures.Feature.CTF.Holo;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import net.estinet.gFeatures.Feature.CTF.Basic;

public class Lobby {
	public Scoreboard Initialize(Player p) throws IllegalStateException, IllegalArgumentException{
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard board = manager.getNewScoreboard();
		Objective objective = board.registerNewObjective("test", "dummy");
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		objective.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "     _Esti" + ChatColor.DARK_AQUA + "" + ChatColor.BOLD +"Net_     ");
		Score score2 = objective.getScore(ChatColor.DARK_BLUE + "Online:"); //Get a fake offline player
		score2.setScore(4);
		Score score3 = objective.getScore(ChatColor.BOLD + "" + Integer.toString(Bukkit.getServer().getOnlinePlayers().size())); //Get a fake offline player
		score3.setScore(3);
		Score score = objective.getScore(ChatColor.AQUA + "Time before game starts:"); //Get a fake offline player
		score.setScore(2);
		Score score5 = objective.getScore(ChatColor.BOLD + "" + Basic.countdown + " "); //Get a fake offline player
		score5.setScore(1);
		return board;
	}
}
