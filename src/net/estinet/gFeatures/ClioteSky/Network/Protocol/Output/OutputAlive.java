package net.estinet.gFeatures.ClioteSky.Network.Protocol.Output;

import java.io.IOException;
import java.util.List;

import org.bukkit.Bukkit;

import net.estinet.gFeatures.ClioteSky.ClioteSky;
import net.estinet.gFeatures.ClioteSky.Network.NetworkThread;
import net.estinet.gFeatures.ClioteSky.Network.Protocol.Packet;

public class OutputAlive extends Packet{
	public void run(List<String> args){
		if(NetworkThread.clientSocket == null){
			ClioteSky.setServerOnline(false);
		}
		else{
		ClioteSky.setAliveCache(true);
		NetworkThread nt = new NetworkThread();
		nt.sendOutput("alive");
		Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
        	public void run(){
        		if(ClioteSky.isAliveCache()){
        			if(ClioteSky.isServerOnline()){
        				ClioteSky.printLine("Uh oh! Server went offline.");
        				try {
							NetworkThread.clientSocket.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
        				ClioteSky.setServerOffline();
        			}
        		}
        	}
        }, 100L);
	}
	}
}
