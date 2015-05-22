package net.genesishub.gFeatures.Feature.GenesisEconomy;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.player.PlayerJoinEvent;

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

public class Join {
	public void Initialize(PlayerJoinEvent e){
		Connection c = new Connection();
		CheckConfig cc = new CheckConfig();
		Bukkit.getLogger().info(ChatColor.AQUA + "Player " + e.getPlayer().getName() + " has joined.");
		Bukkit.getLogger().info("Adding " + e.getPlayer().getUniqueId());
		c.Connect(c.toURL(cc.getPort(), cc.getAddress(), cc.getTablename()), cc.getUsername(), cc.getPassword(), "INSERT INTO Peoples(Name, Money)\n"+
				"SELECT * FROM (SELECT '" + e.getPlayer().getUniqueId() + "', '0') AS tmp\n"+
				"WHERE NOT EXISTS (\n"+
				"SELECT Name FROM Peoples WHERE Name = '" + e.getPlayer().getUniqueId() + "'\n"+
				") LIMIT 1;\n"
			);
		Bukkit.getLogger().info("QUERY COMPLETED>");
	}
}
