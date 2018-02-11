package net.estinet.gFeatures.Feature.gScore;

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

import net.estinet.gFeatures.Feature.EstiCoins.EstiCoins;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import net.estinet.gFeatures.Feature.ServerQuery.ServerQuery;

public class Scored {
	public static Scoreboard getScore(Player p) throws IllegalStateException, IllegalArgumentException{
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard board = manager.getNewScoreboard();
		Objective objective = board.registerNewObjective("test", "dummy");
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		objective.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "     Esti" + ChatColor.DARK_AQUA + "" + ChatColor.BOLD +"Net     ");
		Score score1 = objective.getScore("");
		score1.setScore(11);
		Score score2 = objective.getScore(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Online");
		score2.setScore(10);
		Score score3 = objective.getScore(ChatColor.GRAY + "" + ServerQuery.getPlayerCount());
		score3.setScore(9);
		Score score12 = objective.getScore(" ");
		score12.setScore(8);
		Score score = objective.getScore(ChatColor.GOLD + "" + ChatColor.BOLD + "Coins ⛀⛁⛃⛂");
		score.setScore(7);
		Score score5 = objective.getScore(ChatColor.GRAY + "" + EstiCoins.getMoney(p));
		score5.setScore(6);
		Score score11 = objective.getScore("  ");
		score11.setScore(5);
		Score score8 = objective.getScore(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Random Word");
		score8.setScore(4);
		String[] str = {"Awesome!", "Epic!", "Amazing!", "Cool!", "I caz spll", "Dude!", "EstiNet!", "Hi!", "Different!", "Oink." , "Beep!", "Welcome!", "Yo.", "LOL!", "wut", "Play!", "toes"};
		Score score9 = objective.getScore(ChatColor.GRAY + str[(int) Math.floor(Math.random() * 17)]);
		score9.setScore(3);
		Score score100 = objective.getScore("   ");
		score100.setScore(2);
		if(!(p.getName().length() >= 16)){
			Score score10 = objective.getScore(ChatColor.DARK_AQUA + p.getName().trim());
			score10.setScore(1);
		}
		return board;
	}
}
