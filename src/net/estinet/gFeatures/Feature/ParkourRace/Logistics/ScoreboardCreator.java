package net.estinet.gFeatures.Feature.ParkourRace.Logistics;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import net.estinet.gFeatures.Feature.ParkourRace.ParkourRace;
import net.md_5.bungee.api.ChatColor;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2017 EstiNet

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
