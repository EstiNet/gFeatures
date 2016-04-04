package net.estinet.gFeatures.ClioteSky.Network;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;

import net.estinet.gFeatures.ClioteSky.ClioteSky;
import net.estinet.gFeatures.ClioteSky.Network.Protocol.Output.OutputHello;

public class NetworkThread {
	public static Socket clientSocket = null;
	public static DataOutputStream outToServer = null;
	public static BufferedReader inFromServer = null;
	public static void start(){
		try{
			String input;
			clientSocket = new Socket(ClioteSky.getAddress(), Integer.parseInt(ClioteSky.getPort()));
			outToServer = new DataOutputStream(clientSocket.getOutputStream());
			inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			ClioteSky.printLine("Connected to ClioteSky at " + ClioteSky.getAddress() + ":" + ClioteSky.getPort());
			OutputHello os = new OutputHello();
			os.run(null);
			while(true){
				try{
					input = inFromServer.readLine();
					if(input == null){
						ClioteSky.printError("Couldn't establish connection with server. We'll try a bit later!");
						ClioteSky.setServerOffline();
						break;
					}
					else{
						Decosion de = new Decosion();
						de.decode(input);
					}
				}
				catch(SocketException se){
					se.printStackTrace();
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
			DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
			outToServer.writeBytes(message + "\n");
			outToServer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
