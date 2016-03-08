package net.estinet.gFeatures;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import net.estinet.gFeatures.API.PlayerStats.Setup;
import net.estinet.gFeatures.API.PlayerStats.gPlayer;
import net.estinet.gFeatures.Command.EstiCommand;
import net.estinet.gFeatures.SQL.Player.EstiPlayer;
import net.estinet.gFeatures.SQL.Player.EstiSet;
import net.estinet.gFeatures.SQL.Update.Read;
import net.estinet.gFeatures.SQL.Update.Write;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2016 EstiNet

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

public class Basic<T,V> {
	public static File f = new File("plugins/gFeatures/Config.yml");
	public static YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(f);
	
	static Setup setup = new Setup();
	static Write write = new Write();
	static Read read = new Read();
	
	public static List<gFeature> features = new ArrayList<>();
	private static List<Extension> extensions = new ArrayList<>();
	private static List<EstiCommand> commands = new ArrayList<>();
	private static HashMap<String, String> playersections = new HashMap<>();
	private static List<gPlayer> playerstats = new ArrayList<>();
	@SuppressWarnings("rawtypes")
	private static List<EstiSet> sqlplayerfields = new ArrayList<>();
	@SuppressWarnings("rawtypes")
	private static List<EstiPlayer> sqlplayers = new ArrayList<>();
	
	public static void addFeature(gFeature feature){
		features.add(feature);
	}
	public static void addExtension(Extension extend){
		extensions.add(extend);
	}
	public static void addCommand(EstiCommand command){
		commands.add(command);
	}
	public static void addPlayerSection(String sectionname, String defaultvalue){
		playersections.put(sectionname, defaultvalue);
	}
	public static void addgPlayer(gPlayer player){
		playerstats.add(player);
	}
	@SuppressWarnings("rawtypes")
	public static void addSQLFields(EstiSet field){
		sqlplayerfields.add(field);
	}
	@SuppressWarnings("rawtypes")
	public static void addEstiPlayer(EstiPlayer estiplayer){
		sqlplayers.add(estiplayer);
	}
	public static void removeFeature(gFeature feature){
		features.remove(feature);
	}
	public static void removeExtension(Extension extend){
		extensions.remove(extend);
	}
	public static void removeCommand(EstiCommand command){
		commands.remove(command);
	}
	public static void removePlayerSection(String sectionname, String defaultvalue){
		playersections.remove(sectionname);
	}
	public static void removegPlayer(gPlayer player){
		playerstats.remove(player);
	}
	@SuppressWarnings("rawtypes")
	public static void removeSQLFields(EstiSet field){
		sqlplayerfields.remove(field);
	}
	@SuppressWarnings("rawtypes")
	public static void removeEstiPlayer(EstiPlayer estiplayer){
		sqlplayers.remove(estiplayer);
	}
	public static gFeature getFeature(String name){
		for(gFeature feature : features){
			if(feature.getName().equalsIgnoreCase(name)){
				return feature;
			}
		}
		return null;
	}
	public static Extension getExtension(String name){
		for(Extension extend : extensions){
			if(extend.getName().equalsIgnoreCase(name)){
				return extend;
			}
		}
		return null;
	}
	public static EstiCommand getCommand(String name){
		for(EstiCommand command : commands){
			if(command.getName().equalsIgnoreCase(name)){
				return command;
			}
		}
		return null;
	}
	public static gPlayer getgPlayer(String uuid){
		for(gPlayer player : playerstats){
			if(player.getUUID().equalsIgnoreCase(uuid)){
				return player;
			}
		}
		return null;
	}
	public static EstiPlayer getEstiPlayer(String uuid){
		for(EstiPlayer player : sqlplayers){
			if(player.getUUID().equalsIgnoreCase(uuid)){
				return player;
			}
		}
		return null;
	}
	public static List<gFeature> getFeatures(){
		return features;
	}
	public static List<Extension> getExtensions(){
		return extensions;
	}
	public static List<EstiCommand> getCommands(){
		return commands;
	}
	public static HashMap<String, String> getPlayerSections(){
		return playersections;
	}
	public static List<gPlayer> getgPlayers(){
		return playerstats;
	}
	@SuppressWarnings("rawtypes")
	public static List<EstiSet> getSQLFields(){
		return sqlplayerfields;
	}
	@SuppressWarnings("rawtypes")
	public static List<EstiPlayer> getEstiPlayers(){
		return sqlplayers;
	}
	public static void setgPlayers(List<gPlayer> pl){
		playerstats = pl;
	}
	public static void setFeatures(List<gFeature> pl){
		features = pl;
	}
	public static void setExtensions(List<Extension> pl){
		extensions = pl;
	}
	public static void setCommands(List<EstiCommand> ec){
		commands = ec;
	}
	@SuppressWarnings("rawtypes")
	public static void setSQLFields(List<EstiSet> set){
		sqlplayerfields = set;
	}
	@SuppressWarnings("rawtypes")
	public static void setEstiPlayers(List<EstiPlayer> set){
		sqlplayers = set;
	}
	public static void setgPlayer(gPlayer originalplayer, gPlayer newplayer){
		playerstats.set(playerstats.indexOf(originalplayer), newplayer);
		setup.flushPlayer(newplayer);
	}
	public static void setEstiPlayer(EstiPlayer original, EstiPlayer newplayer){
		sqlplayers.set(sqlplayers.indexOf(original), newplayer);
		syncSQLPlayers();
	}
	public static void resetFeatures(){
		List<gFeature> feature = new ArrayList<>();
		features = feature;
	}
	public static void resetExtensions(){
		List<Extension> extend = new ArrayList<>();
		extensions = extend;
	}
	public static void syncSQLPlayers(){
		write.writeToSQL();
	}
	public static void recieveSQLPlayers(){
		read.read();
	}
	@SuppressWarnings("rawtypes")
	public static HashMap<String, EstiSet> getHashFromEstiSet(List<EstiSet> sets){
		HashMap<String, EstiSet> hash = new HashMap<>();
		for(EstiSet set : sets){
			Bukkit.getLogger().info(set.getTag() + " " + set.getKeySet().toArray()[0] + " " + set.getValueSet().toArray()[0]);
			hash.put(set.getTag(), set);
		}
		return hash;
	}
	
	/*
	 * MySQL Integration
	 */
	
	public static String getPort(){
		if(yamlFile.get("Config.MySQL.Port") == null){
			return "";
		}
		return yamlFile.get("Config.MySQL.Port").toString();
	}
	public static String getAddress(){
		if(yamlFile.get("Config.MySQL.Address") == null){
			return "";
		}
		return yamlFile.get("Config.MySQL.Address").toString();
	}
	public static String getTablename(){
		if(yamlFile.get("Config.MySQL.TableName") == null){
			return "";
		}
		return yamlFile.get("Config.MySQL.TableName").toString();
	}
	public static String getUsername(){
		if(yamlFile.get("Config.MySQL.Username") == null){
			return "";
		}
		return yamlFile.get("Config.MySQL.Username").toString();
	}
	public static String getPassword(){
		if(yamlFile.get("Config.MySQL.Password") == null){
			return "";
		}
		return yamlFile.get("Config.MySQL.Password").toString();
	}
	public static boolean getSQLState(){
		if(yamlFile.get("Config.MySQL.State") == null){
			return false;
		}
		else if(yamlFile.get("Config.MySQL.State").equals("true")){
			return true;
		}
		else{
			return false;
		}
	}
}
