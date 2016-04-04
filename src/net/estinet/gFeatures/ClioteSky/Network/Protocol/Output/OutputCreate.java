package net.estinet.gFeatures.ClioteSky.Network.Protocol.Output;

import java.util.List;

import net.estinet.gFeatures.ClioteSky.ClioteSky;
import net.estinet.gFeatures.ClioteSky.Network.NetworkThread;
import net.estinet.gFeatures.ClioteSky.Network.Protocol.Packet;

public class OutputCreate extends Packet{
	public void run(List<String> args){
		NetworkThread nt = new NetworkThread();
		nt.sendOutput("create " + ClioteSky.getName() + " " + ClioteSky.getCategory() + " " + ClioteSky.getPassword());
		OutputHello oh = new OutputHello();
		oh.run(null);
	}
}
