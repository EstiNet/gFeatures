package net.estinet.gFeatures.Feature.gWarsSuite.Multiplayer;

import net.estinet.gFeatures.Feature.gWarsSuite.Constants;
import net.estinet.gFeatures.Feature.gWarsSuite.Statistics;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

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

public class Source {
	Statistics stats = new Statistics();
	public void setup(Player p){
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard board = manager.getNewScoreboard();
		Objective objective = board.registerNewObjective("Kills", "Stuff");
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		objective.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + " _gWars_ ");
		Score score2 = objective.getScore(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Kills:");
		score2.setScore(10);
		Score score69 = objective.getScore(ChatColor.AQUA + "" + stats.getKills(p)); 
		score69.setScore(9);
		Score score = objective.getScore(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Deaths:");
		score.setScore(8);
		Score score5 = objective.getScore(ChatColor.AQUA + "" + stats.getDeaths(p));
		score5.setScore(7);
		Score score1 = objective.getScore(ChatColor.GRAY + "" + ChatColor.BOLD + "Current team:");
		score1.setScore(6);
		Score score7 = objective.getScore(ChatColor.AQUA + "" + stats.getStringTeam(p));
		score7.setScore(5);
		Score score8 = objective.getScore(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Points:");
		score8.setScore(4);
		if(Constants.multiplayerpossession.get(Constants.bridge).equals(Team.BLUE)){
			Score score9 = objective.getScore(ChatColor.DARK_AQUA + "Bridge");
			score9.setScore(3);
		}
		else if(Constants.multiplayerpossession.get(Constants.bridge).equals(Team.ORANGE)){
			Score score9 = objective.getScore(ChatColor.GOLD + "Bridge");
			score9.setScore(3);
		}
		else{
			Score score9 = objective.getScore(ChatColor.WHITE + "Bridge");
			score9.setScore(3);
		}
		if(Constants.multiplayerpossession.get(Constants.innisfilhighway).equals(Team.BLUE)){
			Score score9 = objective.getScore(ChatColor.DARK_AQUA + "Innisfil Highway Exit");
			score9.setScore(2);
		}
		else if(Constants.multiplayerpossession.get(Constants.innisfilhighway).equals(Team.ORANGE)){
			Score score9 = objective.getScore(ChatColor.GOLD + "Innisfil Highway Exit");
			score9.setScore(2);
		}
		else{
			Score score9 = objective.getScore(ChatColor.WHITE + "Innisfil Highway Exit");
			score9.setScore(2);
		}
		
		if(Constants.multiplayerpossession.get(Constants.kloynehighway).equals(Team.BLUE)){
			Score score9 = objective.getScore(ChatColor.DARK_AQUA + "Kloyne Highway Exit");
			score9.setScore(1);
		}
		else if(Constants.multiplayerpossession.get(Constants.kloynehighway).equals(Team.ORANGE)){
			Score score9 = objective.getScore(ChatColor.GOLD + "Kloyne Highway Exit");
			score9.setScore(1);
		}
		else{
			Score score9 = objective.getScore(ChatColor.WHITE + "Kloyne Highway Exit");
			score9.setScore(1);
		}
		p.setScoreboard(board);
	}
	public void flushAll(){
		for(Player player : Bukkit.getOnlinePlayers()){
			setup(player);
		}
	}
}
