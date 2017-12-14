package net.estinet.gFeatures.Feature.gScore;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import net.estinet.gFeatures.Command.CommandExecutable;
import net.md_5.bungee.api.ChatColor;

public class ScoreCommand extends CommandExecutable{
	@Override
	public void run() {
		Player p = (Player) sender;
		if (gScore.people.contains(p.getUniqueId())) {
			gScore.people.remove(p.getUniqueId());
			p.setScoreboard(Bukkit.getServer().getScoreboardManager().getNewScoreboard());
		}
		else {
			p.setScoreboard(Scored.getScore(p));
			gScore.people.add(p.getUniqueId());
		}
		p.sendMessage(ChatColor.BOLD + "[" + ChatColor.DARK_AQUA + "Esti" + ChatColor.GOLD + "Net" + ChatColor.RESET + "" + ChatColor.BOLD + "] " + ChatColor.RESET + "" + ChatColor.AQUA + "Toggled scoreboard.");
	}
}
