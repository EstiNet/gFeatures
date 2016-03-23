package net.estinet.gFeatures.ClioteSky.Network;

import java.util.ArrayList;
import java.util.List;

import net.estinet.gFeatures.ClioteSky.ClioteSky;
import net.estinet.gFeatures.ClioteSky.Network.Protocol.Packet;

public class Decosion {
	public void decode(String message){
		String[] args = message.split("\\s+");
		for(Packet packet : ClioteSky.inputPackets){
			if(args[0].equalsIgnoreCase(packet.name)){
				List<String> newArgs = new ArrayList<>();
				for(int i = 1; i<args.length; i++){
					newArgs.add(args[i]);
				}
				packet.run(newArgs);
			}
		}
	}
}
