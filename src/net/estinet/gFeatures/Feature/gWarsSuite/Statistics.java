package net.estinet.gFeatures.Feature.gWarsSuite;

import java.util.ArrayList;
import java.util.List;

import net.estinet.gFeatures.Feature.gWarsSuite.Connection.CheckConfig;
import net.estinet.gFeatures.Feature.gWarsSuite.Connection.Connection;
import net.estinet.gFeatures.Feature.gWarsSuite.Multiplayer.BlueTeam;
import net.estinet.gFeatures.Feature.gWarsSuite.Multiplayer.OrangeTeam;
import net.estinet.gFeatures.Feature.gWarsSuite.Multiplayer.Team;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

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

public class Statistics {
	Connection c = new Connection();
	CheckConfig cc = new CheckConfig();
	String Address = cc.getAddress();
	String Port = cc.getPort();
	String Tablename = cc.getTablename();
	String Username = cc.getUsername();
	String Password = cc.getPassword();
	String URL = c.toURL(Port, Address, Tablename);
	public int getKills(Player p){
		List<String> rs = new ArrayList<>();
		rs = c.ConnectReturn(URL, Username, Password, "SELECT Name, Kills FROM Kills WHERE Name = '" + p.getUniqueId().toString() + "';");
		return Integer.parseInt(rs.get(1));
	}
	public int getDeaths(Player p){
		List<String> rs = new ArrayList<>();
		rs = c.ConnectReturn(URL, Username, Password, "SELECT Name, Deaths FROM Deaths WHERE Name = '" + p.getUniqueId().toString() + "';");
		return Integer.parseInt(rs.get(1));
	}
	public gWarsMode getMode(Entity entity){
		return Constants.mode.get(entity);
	}
	public gWarsMode getMode(String playername){
		for(Entity entity: Constants.mode.keySet()){
			if(entity.getName().equals(playername)){
				return Constants.mode.get(entity);
			}
		}
		return null;
	}
	public void addKill(Player p, int num){
		List<String> rs = new ArrayList<>();
		rs = c.ConnectReturn(URL, Username, Password, "SELECT Name, Kills FROM Kills WHERE Name = '" + p.getUniqueId().toString() + "';");
		float nums = Float.parseFloat(rs.get(1));
		float money = nums + num;
		c.Connect(URL, Username, Password, "UPDATE Kills SET Kills = " + money + "\nWHERE Name = '" + p.getUniqueId().toString() + "';");
	}
	public void addDeaths(Player p, int num){
		List<String> rs = new ArrayList<>();
		rs = c.ConnectReturn(URL, Username, Password, "SELECT Name, Deaths FROM Deaths WHERE Name = '" + p.getUniqueId().toString() + "';");
		float nums = Float.parseFloat(rs.get(1));
		float money = nums + num;
		c.Connect(URL, Username, Password, "UPDATE Deaths SET Deaths = " + money + "\nWHERE Name = '" + p.getUniqueId().toString() + "';");
	}
	public void minusKill(Player p, int num){
		List<String> rs = new ArrayList<>();
		rs = c.ConnectReturn(URL, Username, Password, "SELECT Name, Kills FROM Kills WHERE Name = '" + p.getUniqueId().toString() + "';");
		float nums = Float.parseFloat(rs.get(1));
		float money = nums - num;
		c.Connect(URL, Username, Password, "UPDATE Kills SET Kills = " + money + "\nWHERE Name = '" + p.getUniqueId().toString() + "';");
	}
	public void minusDeaths(Player p, int num){
		List<String> rs = new ArrayList<>();
		rs = c.ConnectReturn(URL, Username, Password, "SELECT Name, Deaths FROM Deaths WHERE Name = '" + p.getUniqueId().toString() + "';");
		float nums = Float.parseFloat(rs.get(1));
		float money = nums - num;
		c.Connect(URL, Username, Password, "UPDATE Deaths SET Deaths = " + money + "\nWHERE Name = '" + p.getUniqueId().toString() + "';");
	}
	public void setKills(Player p, int value){
		c.Connect(URL, Username, Password, "UPDATE Kills SET Kills = " + value + "\nWHERE Name = '" + p.getUniqueId().toString() + "';");
	}
	public void setDeaths(Player p, int value){
		c.Connect(URL, Username, Password, "UPDATE Deaths SET Deaths = " + value + "\nWHERE Name = '" + p.getUniqueId().toString() + "';");
	}
	public void setMode(Player p, gWarsMode mode){
		for(gWarsMode m : gWarsMode.values()){
			if(m.equals(mode)){
				Constants.mode.remove(p);
				Constants.mode.put(p, mode);
			}
		}
	}
	public Team getTeam(Player p){
		if(OrangeTeam.hasPlayer(p)){
			return Team.ORANGE;
		}
		else if(BlueTeam.hasPlayer(p)){
			return Team.BLUE;
		}
		else{
			return Team.NEUTRAL;
		}
	}
	public String getStringTeam(Player p){
		if(OrangeTeam.hasPlayer(p)){
			return ChatColor.GOLD + "Kloyne";
		}
		else if(BlueTeam.hasPlayer(p)){
			return ChatColor.DARK_AQUA + "Innisfil";
		}
		return ChatColor.WHITE + "Not in game.";
	}
}
