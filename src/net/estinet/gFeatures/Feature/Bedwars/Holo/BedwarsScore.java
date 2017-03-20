package net.estinet.gFeatures.Feature.Bedwars.Holo;

import net.estinet.gFeatures.Feature.Bedwars.Basic;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

/**
 * Created by devin on 18/03/17.
 */
public class BedwarsScore {
    public Scoreboard Initialize(Player p) throws IllegalStateException, IllegalArgumentException{
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();
        Objective objective = board.registerNewObjective("test", "dummy");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "     _Esti" + ChatColor.DARK_AQUA + "" + ChatColor.BOLD +"Net_     ");
        Score score2 = objective.getScore(ChatColor.DARK_BLUE + "Online:"); //Get a fake offline player
        score2.setScore(12);
        Score score3 = objective.getScore(ChatColor.BOLD + "" + Integer.toString(Bukkit.getServer().getOnlinePlayers().size())); //Get a fake offline player
        score3.setScore(11);
        Score score7 = objective.getScore(ChatColor.GREEN + "Time left:"); //Get a fake offline player
        score7.setScore(10);
        Score score10 = objective.getScore(ChatColor.BOLD + "" + Basic.minutes + "m " + Basic.seconds + "s"); //Get a fake offline player
        score10.setScore(9);
        Score score = objective.getScore(ChatColor.AQUA + "Kills:"); //Get a fake offline player
        score.setScore(8);
        Score score5 = objective.getScore(ChatColor.BOLD + "" + Basic.kills.get(p.getUniqueId()) + " "); //Get a fake offline player
        score5.setScore(7);
        Score score8 = objective.getScore(ChatColor.GOLD + "Deaths:");
        score8.setScore(6);
        Score score9 = objective.getScore(ChatColor.BOLD + "" + Basic.deaths.get(p.getUniqueId()) + " ");
        score9.setScore(5);
        return board;
    }
}
