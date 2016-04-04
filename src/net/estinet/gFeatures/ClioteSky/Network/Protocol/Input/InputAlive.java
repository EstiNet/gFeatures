package net.estinet.gFeatures.ClioteSky.Network.Protocol.Input;

import java.util.List;

import net.estinet.gFeatures.API.Logger.Debug;
import net.estinet.gFeatures.ClioteSky.ClioteSky;
import net.estinet.gFeatures.ClioteSky.Network.Protocol.Packet;

public class InputAlive extends Packet{
	public InputAlive(){
		super.name = "Alive";
	}
	public void run(List<String> args){
		ClioteSky.setAliveCache(false);
		Debug.print("[ClioteSky] Ping successful.");
	}
}
