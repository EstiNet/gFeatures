package net.estinet.gFeatures.Feature.gScore;

import org.bukkit.entity.Player;

import net.estinet.gFeatures.Command.CommandExecutable;

public class ScoreCommand extends CommandExecutable{
	@Override
	public void run() {
		Player p = (Player) sender;
		if(gScore.people.contains(p.getUniqueId())){
			gScore.people.remove(p.getUniqueId());
		}
	}
}
