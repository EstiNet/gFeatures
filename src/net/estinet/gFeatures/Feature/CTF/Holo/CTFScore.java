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

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2016 EstiNet

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

public class CTFScore {
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
		Score score = objective.getScore(ChatColor.AQUA + "Flags Captured (Blue):"); //Get a fake offline player
		score.setScore(8);
		Score score5 = objective.getScore(ChatColor.BOLD + "" + Basic.blueflags + " "); //Get a fake offline player
		score5.setScore(7);
		Score score8 = objective.getScore(ChatColor.GOLD + "Flags Captured (Orange):");
		score8.setScore(6);
		Score score9 = objective.getScore(ChatColor.BOLD + "" + Basic.orangeflags);
		score9.setScore(5);
		Score score12 = objective.getScore(ChatColor.AQUA + "Flag Taker (Blue):");
		score12.setScore(4);
		if(Basic.blueflagger == null){
		Score score13 = objective.getScore(ChatColor.BOLD + "No one.");
		score13.setScore(3);
		}
		else{
			Score score13 = objective.getScore(ChatColor.GOLD + "" + ChatColor.BOLD + Basic.blueflagger.getName());
			score13.setScore(3);
		}
		Score score14 = objective.getScore(ChatColor.GOLD + "Flag Taker (Orange):");
		score14.setScore(2);
		if(Basic.orangeflagger == null){
			Score score15 = objective.getScore(ChatColor.BOLD + "No one.");
			score15.setScore(1);
		}
		else{
			Score score15 = objective.getScore(ChatColor.AQUA + "" + ChatColor.BOLD + Basic.orangeflagger.getName());
			score15.setScore(1);
		}
		return board;
	}
}
