package net.estinet.gFeatures.ClioteSky;

import net.estinet.gFeatures.ClioteSky.Network.Protocol.Input.InputAlive;
import net.estinet.gFeatures.ClioteSky.Network.Protocol.Input.InputError;
import net.estinet.gFeatures.ClioteSky.Network.Protocol.Input.InputMessage;

public class ClioteInit {
	public void enable(){
		ClioteConfigUtil ccu = new ClioteConfigUtil();
		ccu.load();
		if(ClioteSky.isEnable()){
			ClioteSky.printLine("Connecting to ClioteSky...");
			ClioteSky.inputPackets.add(new InputAlive());
			ClioteSky.inputPackets.add(new InputError());
			ClioteSky.inputPackets.add(new InputMessage());
			ccu.fillCacheFromFile();
			ClioteSky.setServerOnline(true);
		}
	}
}
