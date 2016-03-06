package net.estinet.gFeatures.Feature.GenesisEconomy;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
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

public class MoneyManager {
	Connection c = new Connection();
	CheckConfig cc = new CheckConfig();
	String Address = cc.getAddress();
	String Port = cc.getPort();
	String Tablename = cc.getTablename();
	String Username = cc.getUsername();
	String Password = cc.getPassword();
	String URL = c.toURL(Port, Address, Tablename);
	public float getMoney(Player p){
		List<String> rs = new ArrayList<>();
		rs = c.ConnectReturn(URL, Username, Password, "SELECT Name, Money FROM Peoples WHERE Name = '" + p.getUniqueId().toString() + "';");
		return Float.parseFloat(rs.get(1));
	}
	public float getMoney(OfflinePlayer p){
		List<String> rs = new ArrayList<>();
		rs = c.ConnectReturn(URL, Username, Password, "SELECT Name, Money FROM Peoples WHERE Name = '" + p.getUniqueId().toString() + "';");
		return Float.parseFloat(rs.get(1));
	}
	public void giveMoney(Player p, float amount) throws Exception{
		List<String> rs = new ArrayList<>();
		rs = c.ConnectReturn(URL, Username, Password, "SELECT Name, Money FROM Peoples WHERE Name = '" + p.getUniqueId().toString() + "';");
		float num = Float.parseFloat(rs.get(1));
		float money = num + amount;
		c.Connect(URL, Username, Password, "UPDATE Peoples SET Money = " + money + "\nWHERE Name = '" + p.getUniqueId().toString() + "';");
	}
	public void takeMoney(Player p, float amount) throws Exception{
		List<String> rs = new ArrayList<>();
		rs = c.ConnectReturn(URL, Username, Password, "SELECT Name, Money FROM Peoples WHERE Name = '" + p.getUniqueId().toString() + "';");
		float num = Float.parseFloat(rs.get(1));
		float money = num - amount;
		c.Connect(URL, Username, Password, "UPDATE Peoples SET Money = " + money + "\nWHERE Name = '" + p.getUniqueId().toString() + "';");
	}
	public void setMoney(Player p, float amount) throws Exception{
		c.Connect(URL, Username, Password, "UPDATE Peoples SET Money = " + amount + "\nWHERE Name = '" + p.getUniqueId().toString() + "';");
	}
	public List<String> clupicTop(){
		List<String> rs = new ArrayList<>();
		rs = c.ConnectReturn(URL, Username, Password, "select * from Peoples;");
		return rs;
	}
	public void giveMoney(OfflinePlayer p, float amount){
		List<String> rs = new ArrayList<>();
		rs = c.ConnectReturn(URL, Username, Password, "SELECT Name, Money FROM Peoples WHERE Name = '" + p.getUniqueId().toString() + "';");
		float num = Float.parseFloat(rs.get(1));
		float money = num + amount;
		c.Connect(URL, Username, Password, "UPDATE Peoples SET Money = " + money + "\nWHERE Name = '" + p.getUniqueId().toString() + "';");
	}
	public void takeMoney(OfflinePlayer p, float amount){
		List<String> rs = new ArrayList<>();
		rs = c.ConnectReturn(URL, Username, Password, "SELECT Name, Money FROM Peoples WHERE Name = '" + p.getUniqueId().toString() + "';");
		float num = Float.parseFloat(rs.get(1));
		float money = num - amount;
		c.Connect(URL, Username, Password, "UPDATE Peoples SET Money = " + money + "\nWHERE Name = '" + p.getUniqueId().toString() + "';");
	}
	public void setMoney(OfflinePlayer p, float amount){
		c.Connect(URL, Username, Password, "UPDATE Peoples SET Money = " + amount + "\nWHERE Name = '" + p.getUniqueId().toString() + "';");
	}
	public boolean playerExists(OfflinePlayer p){
		List<String> rs = new ArrayList<>();
		rs = c.ConnectReturn(URL, Username, Password, "SELECT Name, Money FROM Peoples WHERE Name = '" + p.getUniqueId().toString() + "';");
		if(rs.get(1).equals(null)){
			return false;
		}
		else{
			return true;
		}
		}
		public boolean playerExists(Player p){
			List<String> rs = new ArrayList<>();
			rs = c.ConnectReturn(URL, Username, Password, "SELECT Name, Money FROM Peoples WHERE Name = '" + p.getUniqueId().toString() + "';");
			if(rs.get(1).equals(null)){
				return false;
			}
			else{
				return true;
			}
	}
	@SuppressWarnings("deprecation")
	public boolean playerOnline(String name){
		for(Player p : Bukkit.getOnlinePlayers()){
			if(p.getName().equals(name)){
				return true;
			}
		}
		return false;
	}
}
