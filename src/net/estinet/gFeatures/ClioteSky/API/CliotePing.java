package net.estinet.gFeatures.ClioteSky.API;

import net.estinet.gFeatures.ClioteSky.Network.NetworkThread;

public class CliotePing {
	public void sendMessage(String message, String categoryOrCliote){
		NetworkThread nt = new NetworkThread();
		nt.sendOutput("send " + categoryOrCliote + " " + message);
	}
}
