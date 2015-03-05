package tk.genesishub.gFeatures.GenesisEconomy;

import org.bukkit.event.player.PlayerJoinEvent;

public class Join {
	public void Initialize(PlayerJoinEvent e){
		Connection c = new Connection();
		CheckConfig cc = new CheckConfig();
		c.Connect(c.toURL(cc.getPort(), cc.getAddress(), cc.getTablename()), cc.getUsername(), cc.getPassword(), "INSERT INTO People (Name, Money)"+
				"SELECT * FROM (SELECT '" + e.getPlayer().getUniqueId().toString() + "', '0') AS tmp"+
				"WHERE NOT EXISTS ("+
						"SELECT name FROM People WHERE name = '"+ e.getPlayer().getUniqueId().toString()+"'"+
						") LIMIT 1;"
			);
	}
}
