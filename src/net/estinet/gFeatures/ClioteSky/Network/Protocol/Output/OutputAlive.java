package net.estinet.gFeatures.ClioteSky.Network.Protocol.Output;

import java.util.List;

import org.bukkit.Bukkit;

import net.estinet.gFeatures.ClioteSky.ClioteSky;
import net.estinet.gFeatures.ClioteSky.Network.NetworkThread;
import net.estinet.gFeatures.ClioteSky.Network.Protocol.Packet;

public class OutputAlive extends Packet{
	public void run(List<String> args){
		ClioteSky.setAliveCache(true);
		NetworkThread.sendOutput("alive");
		Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
        	public void run(){
        		if(ClioteSky.isAliveCache()){
        			if(ClioteSky.isServerOnline() != false){
        				ClioteSky.setServerOnline(false);
        			}
        		}
        		else{
        			if(ClioteSky.isServerOnline() != true){
        				ClioteSky.setServerOnline(true);
        			}
        		}
        	}
        }, 100L);
        
	}
}
