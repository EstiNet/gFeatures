package net.genesishub.gFeatures.Feature.gScore;

/*
gFeatures
https://github.com/GenesisHub/gFeatures

   Copyright 2015 GenesisHub

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


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import com.earth2me.essentials.api.Economy;
import com.earth2me.essentials.api.UserDoesNotExistException;

import tk.genesishub.gFeatures.GenesisEconomy.MoneyManager;

public class Scored {
	MoneyManager mm = new MoneyManager();
	@SuppressWarnings("deprecation")
	public Scoreboard Initialize(Player p) throws IllegalStateException, IllegalArgumentException, UserDoesNotExistException{
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard board = manager.getNewScoreboard();
		Objective objective = board.registerNewObjective("test", "dummy");
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		objective.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "  _GenesisHub_  ");
		Score score2 = objective.getScore(ChatColor.DARK_BLUE + "Online:"); //Get a fake offline player
		score2.setScore(9);
		Score score3 = objective.getScore(ChatColor.DARK_BLUE + "" + Integer.toString(Bukkit.getServer().getOnlinePlayers().size())); //Get a fake offline player
		score3.setScore(8);
		Score score = objective.getScore(ChatColor.GREEN + "Clupic:"); //Get a fake offline player
		score.setScore(7);
		Score score5 = objective.getScore(ChatColor.GREEN + "" + Float.toString(mm.getMoney(p))); //Get a fake offline player
		score5.setScore(6);
		Score score1 = objective.getScore(ChatColor.AQUA + "Dollars:");
		score1.setScore(5);
		Score score7 = objective.getScore(ChatColor.AQUA + "" + Economy.format(Economy.getMoney(p.getName()))); //Get a fake offline player
		score7.setScore(4);
		Score score8 = objective.getScore(ChatColor.LIGHT_PURPLE + "Random Word:");
		score8.setScore(3);
		String[] str = {"Awesome!", "Epic!", "Amazing!", "Cool!", "I caz spll", "Dude!", "GenesisHub!", "Hi!", "Different!", "Oink." , "Beep!", "Welcome!", "Yo.", "LOL!", "wut", "Play!"}; 
		Score score9 = objective.getScore(ChatColor.LIGHT_PURPLE + str[(int) Math.floor(Math.random() * 16)]);
		score9.setScore(2);
		if(!(p.getName().length() >= 16)){
		Score score10 = objective.getScore(ChatColor.DARK_AQUA + p.getName().trim());
		score10.setScore(1);
		}
		return board;
	}
}
