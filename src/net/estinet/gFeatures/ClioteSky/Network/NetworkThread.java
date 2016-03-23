package net.estinet.gFeatures.ClioteSky.Network;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import net.estinet.gFeatures.ClioteSky.ClioteSky;

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
			while(true){
				try{
				input = inFromServer.readLine();
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
	public static void sendOutput(String message){
		try {
			outToServer.writeBytes(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
