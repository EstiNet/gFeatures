package net.estinet.gFeatures.Feature.gDestroyCritical;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

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

public class TeamManager {
	Constants cons = new Constants();
	public void ChooseTeams(Player p){
		java.util.List<String> ot = cons.ot;
		java.util.List<String> bt = cons.bt;
		 if(ot.size() > bt.size()){
    		 bt.add(p.getName());
    		 Bukkit.getServer().broadcastMessage("Player " + p.getName() + " has joined the blue team!");
    		 p.teleport(cons.lobby);
    		 p.setGameMode(GameMode.SURVIVAL);
    		 p.sendMessage("To join the game, do the command /join!");
    	 }
    	 else{
    		 ot.add(p.getName());
    		 Bukkit.getServer().broadcastMessage("Player " + p.getName() + " has joined the orange team!");
    		 p.teleport(cons.lobby);
    		 p.setGameMode(GameMode.SURVIVAL);
    		 p.sendMessage("To join the game, do the command /join!");
    	 }
	}
	public String getTeam(Player p){
		if(cons.ot.contains(p.getName())){
			return "orange";
		}
		else{
			return "blue";
		}
	}
}
