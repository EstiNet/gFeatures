package net.estinet.gFeatures;

import org.bukkit.Bukkit;

import net.estinet.gFeatures.API.Logger.Debug;

/*
 * gFeatures
 * https://github.com/EstiNet/gFeatures
 *
 *    Copyright 2019 EstiNet
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *
 */

public class gLoop {
	public void start(){
		/*
		 * Initialize gFeatures Core loops here.
		 * 
		 */
		if(gFeatures.getSQLState()){
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
        	public void run(){
        		Thread th = new Thread(new Runnable(){
        			public void run(){
        				try{
        					gFeatures.recieveSQLPlayers();
        				}
        				catch(Exception e){
        					Debug.print(e.getMessage());
        				}
        			}
        		});
        		th.start();
        	}
        }, 2000L, 2000L);
		}
	}
}
