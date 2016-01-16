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
		score2.setScore(6);
		Score score3 = objective.getScore(ChatColor.DARK_BLUE + "" + Integer.toString(Bukkit.getServer().getOnlinePlayers().size())); //Get a fake offline player
		score3.setScore(5);
		Score score = objective.getScore(ChatColor.AQUA + "Flags Captured (Blue):"); //Get a fake offline player
		score.setScore(4);
		Score score5 = objective.getScore(ChatColor.BOLD + "" + Basic.blueflags + " "); //Get a fake offline player
		score5.setScore(3);
		Score score8 = objective.getScore(ChatColor.GOLD + "Flags Captured (Orange):");
		score8.setScore(2);
		Score score9 = objective.getScore(ChatColor.BOLD + "" + Basic.orangeflags);
		score9.setScore(1);
		return board;
	}
}
