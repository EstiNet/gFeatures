package net.estinet.gFeatures.ClioteSky.Network;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;

import net.estinet.gFeatures.API.Logger.Debug;
import net.estinet.gFeatures.ClioteSky.ClioteSky;
import net.estinet.gFeatures.ClioteSky.Network.Protocol.Output.OutputHello;

public class NetworkThread {
	public static Socket clientSocket = null;
	public static DataOutputStream outToServer = null;
	public static BufferedReader inFromServer = null;
	public static void start(boolean whee){
		try{
			String input;
			try{
			clientSocket = new Socket(ClioteSky.getAddress(), Integer.parseInt(ClioteSky.getPort()));
			outToServer = new DataOutputStream(clientSocket.getOutputStream());
			inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			}
			catch(ConnectException e){
				Debug.print("[ClioteSky] Connection unsuccessful.");
				if(whee){
					ClioteSky.printError("Unable to connect to ClioteSky at " + ClioteSky.getAddress() + ":" + ClioteSky.getPort());
				}
				ClioteSky.setServerOffline();
				clientSocket.close();
				clientSocket = null;
				return;
			}
			ClioteSky.printLine("Connected to ClioteSky at " + ClioteSky.getAddress() + ":" + ClioteSky.getPort());
			OutputHello os = new OutputHello();
			os.run(null);
			while(true){
				try{
					input = inFromServer.readLine();
					if(input == null){
						ClioteSky.printError("Couldn't establish connection with server. We'll try a bit later!");
						ClioteSky.setServerOffline();
						clientSocket.close();
						clientSocket = null;
						break;
					}
					else{
						Decosion de = new Decosion();
						de.decode(input);
					}
				}
				catch(SocketException se){
					ClioteSky.printError("Uh oh! Server went offline.");
					ClioteSky.setServerOffline();
					clientSocket.close();
					clientSocket = null;
					break;
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void sendOutput(String message){
		try {
			if(ClioteSky.isServerOnline()){
				DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
				outToServer.writeBytes(message + "\n");
				outToServer.flush();
			}
			else{
				ClioteSky.cachedQueries.add(message);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
