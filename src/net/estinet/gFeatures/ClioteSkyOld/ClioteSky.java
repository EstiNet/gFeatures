package net.estinet.gFeatures.ClioteSkyOld;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;

import net.estinet.gFeatures.API.Logger.Debug;
import net.estinet.gFeatures.ClioteSkyOld.API.ClioteHook;
import net.estinet.gFeatures.ClioteSkyOld.Network.NetworkThread;
import net.estinet.gFeatures.ClioteSkyOld.Network.Protocol.Packet;

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

public class ClioteSky {
	private static String address = "";
	private static String port = "";
	private static String category = "";
	private static String name = "";
	private static String password = "";
	private static boolean enable = false;
	private static boolean serverOnline = false;
	private static boolean aliveCache = true;
	private static boolean syncedOutput = false;
	public static List<Packet> inputPackets = new ArrayList<>();
	public static List<ClioteHook> hooks = new ArrayList<>();
	public static List<String> cachedQueries = new ArrayList<>();
	public static List<String> secondCachedQueries = new ArrayList<>();
	public static boolean isSyncedOutput() {
		return syncedOutput;
	}
	public static void setSyncedOutput(boolean syncedOutput) {
		ClioteSky.syncedOutput = syncedOutput;
		if(!syncedOutput){
			try{
				NetworkThread nt = new NetworkThread();
				nt.sendOutput(secondCachedQueries.get(0));
				secondCachedQueries.remove(0);
			}
			catch(Exception e){
				Debug.print("[ClioteSkyOld] Reached end of cache line.");
			}
		}
	}
	public static String getCategory() {
		return category;
	}
	public static void setCategory(String category) {
		ClioteSky.category = category;
	}
	public static String getName() {
		return name;
	}
	public static void setName(String name) {
		ClioteSky.name = name;
	}
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		ClioteSky.password = password;
	}
	public static boolean isEnable() {
		return enable;
	}
	public static void setEnable(boolean enable) {
		ClioteSky.enable = enable;
	}
	public static void setAddress(String address) {
		ClioteSky.address = address;
	}
	public static void setPort(String port) {
		ClioteSky.port = port;
	}
	public static String getAddress(){
		return address;
	}
	public static String getPort(){
		return port;
	}
	public static void printError(String errorCode){
		Bukkit.getLogger().info("[ClioteSkyOld Error] " + errorCode);
	}
	public static void printLine(String line){
		Bukkit.getLogger().info("[ClioteSkyOld] " + line);
	}
	public static boolean isAliveCache() {
		return aliveCache;
	}
	public static void setAliveCache(boolean aliveCache) {
		ClioteSky.aliveCache = aliveCache;
	}
	public static boolean isServerOnline() {
		return serverOnline;
	}
	public static void setServerOnlineBoolean(){
		ClioteSky.serverOnline = true;
	}
	public static void setServerOffline(){
		ClioteSky.serverOnline = false;
		NetworkThread.clientSocket = null;
	}
	public static void setServerOnline(boolean startup) {
		ClioteSky.serverOnline = true;
		NetworkThread.start(startup);
	}
	public static void addClioteHook(ClioteHook ch){
		hooks.add(ch);
	}
}
