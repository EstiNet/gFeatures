package net.estinet.gFeatures.SQL.Update;

import net.estinet.gFeatures.gFeatures;
import org.bukkit.entity.Player;

import net.estinet.gFeatures.SQL.Player.EstiPlayer;

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

public class Entrly {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void join(Player p){
		if(gFeatures.getSQLState()){
		for(int i = 0; i < gFeatures.getEstiPlayers().size(); i++){
			EstiPlayer player = gFeatures.getEstiPlayers().get(i);
			if(player.getUUID().equals(p.getUniqueId().toString())){
				player.setName(player.getName());
				gFeatures.getEstiPlayers().set(i, player);
				return;
			}
		}
		
		EstiPlayer player = new EstiPlayer(p, gFeatures.getHashFromEstiSet(gFeatures.getSQLFields()));
		gFeatures.addEstiPlayer(player);
		Thread thr = new Thread(new Runnable(){
			public void run(){
				gFeatures.syncSQLPlayers();
			}
		});
		thr.start();
		}
	}
}
