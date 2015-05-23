package net.genesishub.gFeaturesSponge.API.PlayerStats;

import java.util.HashMap;

import org.bukkit.entity.Player;

/*
gFeatures
https://github.com/GenesisHub/gFeatures

   Copyright 2015 GenesisHub

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

public class gPlayer {
	private Player player;
	private String uuid;
	private String name;
	private HashMap<String, String> values = new HashMap<>();
	public gPlayer(Player players){
		player = players;
		uuid = players.getUniqueId().toString();
		name = player.getName();
	}
	public gPlayer(String UUID, String names){
		uuid = UUID;
		name = names;
	}
	public Player getPlayer(){
		return player;
	}
	public String getUUID(){
		return uuid;
	}
	public String getName(){
		return name;
	}
	public HashMap<String, String> getValues(){
		return values;
	}
	public void setPlayer(Player p){
		player = p;
	}
	@Deprecated
	public void setUUID(String uuids){
		uuid = uuids;
	}
	@Deprecated
	public void setName(String names){
		name = names;
	}
	public void setValue(String valuename, String value){
		values.remove(valuename);
		values.put(valuename, value);
	}
	public void addValue(String valuename, String value){
		values.put(valuename, value);
	}
	public void removeValue(String valuename, String value){
		values.remove(valuename, value);
	}
	public void removeValue(String valuename){
		values.remove(valuename);
	}
	public String getValue(String valuename){
		return values.get(valuename);
	}
}
