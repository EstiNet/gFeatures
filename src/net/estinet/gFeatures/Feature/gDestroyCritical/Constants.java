package net.estinet.gFeatures.Feature.gDestroyCritical;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

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

public class Constants {
	File f = new File("gDestroyStorage");
	File main = new File("plugins/gDestroy");
	File directory = new File("plugins/gDestroy/gDestroyMaps");
	public static boolean arenaon = false;
	List<String> Acceptance = new ArrayList<>();
	List<String> ot = new ArrayList<>();
	List<String> bt = new ArrayList<>();
	List<String> BlockBroke = new ArrayList<>();
	JavaPlugin plugin;
    Server server;
    BukkitScheduler sched;
    Location orangespawn;
    Location bluespawn;
    Location spectate;
    Location lobby;
    public int getPointData(int BlockId){
    	switch(BlockId){
    	case 1: 
    		return 1;
    	case 2:
    		return 1;
    	case 3:
    		return 1;
    	case 4:
    		return 1;
    	case 5:
    		return 3;
    	case 6:
    		return 3;
    	case 7:
    		return 9000;
    	case 12:
    		return 1;
    	case 13:
    		return 1;
    	case 14:
    		return 30;
    	case 15:
    		return 20;
    	case 16:
    		return 10;
    	case 17:
    		return 3;
    	case 18:
    		return 1;
    	case 19:
    		return 100;
    	case 20:
    		return 1;
    	case 21:
    		return 20;
    	case 22:
    		return 60;
    	case 23:
    		return 1;
    	case 24:
    		return 4;
    	case 25:
    		return 1;
    	case 26:
    		return 1;
    	case 27:
    		return 1;
    	case 28:
    		return 1;
    	case 29:
    		return 5;
    	case 30:
    		return 3;
    	case 31:
    		return 1;
    	case 32:
    		return 1;
    	case 33:
    		return 3;
    	case 35:
    		return 3;
    	case 37:
    		return 1;
    	case 38:
    		return 1;
    	
    	}
    	return 1;
    }
    
}
