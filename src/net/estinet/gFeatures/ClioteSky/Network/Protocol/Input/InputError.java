package net.estinet.gFeatures.ClioteSky.Network.Protocol.Input;

import java.util.List;

import net.estinet.gFeatures.API.Logger.Debug;
import net.estinet.gFeatures.ClioteSky.ClioteSky;
import net.estinet.gFeatures.ClioteSky.Network.Protocol.Packet;
import net.estinet.gFeatures.ClioteSky.Network.Protocol.Output.OutputAlive;
import net.estinet.gFeatures.ClioteSky.Network.Protocol.Output.OutputCreate;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2018 EstiNet

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
			ClioteSky.setServerOnlineBoolean();
			ClioteSky.printError("Cliote already logged in! Are you sure there isn't already another instance of this server?");
            //add if statement if server is already logged in don't try again
			OutputAlive oa = new OutputAlive();
			oa.run(args);
			break;
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
