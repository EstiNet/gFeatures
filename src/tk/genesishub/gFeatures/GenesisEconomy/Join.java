package tk.genesishub.gFeatures.GenesisEconomy;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.player.PlayerJoinEvent;

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
