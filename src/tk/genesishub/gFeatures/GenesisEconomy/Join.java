package tk.genesishub.gFeatures.GenesisEconomy;

import org.bukkit.event.player.PlayerJoinEvent;

public class Join {
	public void Initialize(PlayerJoinEvent e){
		Connection c = new Connection();
		CheckConfig cc = new CheckConfig();
		c.Connect(c.toURL(cc.getPort(), cc.getAddress(), cc.getTablename()), cc.getUsername(), cc.getPassword(), "INSERT INTO People (Name, Money)\n"+
				"SELECT * FROM (SELECT 'dunce', '0') AS tmp\n"+
				"WHERE NOT EXISTS (\n"+
				"SELECT Name FROM People WHERE Name = 'dunce'\n"+
				") LIMIT 1;\n"
			);
	}
}
