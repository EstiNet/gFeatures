package net.estinet.gFeatures.ClioteSky.Network.Protocol.Input;

import java.util.List;

import net.estinet.gFeatures.API.Logger.Debug;
import net.estinet.gFeatures.ClioteSky.ClioteSky;
import net.estinet.gFeatures.ClioteSky.Network.Protocol.Packet;
import net.estinet.gFeatures.ClioteSky.Network.Protocol.Output.OutputCreate;

public class InputError extends Packet{
	public InputError(){
		super.name = "Error";
	}
	public void run(List<String> args){
		Debug.print("[ClioteSky] Recieved error " + args.get(0) + " from server.");
		switch(args.get(0)){
		case "201":
			ClioteSky.printError("Name not known when logging in! Are you sure you configured the config correctly?");
			break;
		case "300":
			ClioteSky.printError("Category not known when creating Cliote! Are you sure you created the category on the server yet?");
			break;
		case "301":
			ClioteSky.printError("Cliote name already taken! Select another one!");
			break;
		case "400":
			ClioteSky.printError("Cliote already logged in! Are you sure there isn't already another instance of this server?");
		case "900":
			ClioteSky.printError("Password incorrect when logging in! Are you sure you configured the config correctly?");
			break;
		case "901":
			OutputCreate oc = new OutputCreate();
			oc.run(null);
			break;
		default:
			break;
		}
	}
}
