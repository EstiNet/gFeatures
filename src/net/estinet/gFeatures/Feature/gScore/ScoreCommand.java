package net.estinet.gFeatures.Feature.gScore;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import net.estinet.gFeatures.Command.CommandExecutable;
import net.md_5.bungee.api.ChatColor;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2018 EstiNet

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

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
