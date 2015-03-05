package tk.genesishub.gFeatures.GenesisEconomy;

import org.bukkit.event.player.PlayerJoinEvent;

public class Join {
	public void Initialize(PlayerJoinEvent e){
		Connection c = new Connection();
		CheckConfig cc = new CheckConfig();
		c.Connect(c.toURL(cc.getPort(), cc.getAddress(), cc.getTablename()), cc.getUsername(), cc.getPassword(), "IF NOT EXISTS ("+
		"SELECT * FROM information_schema.COLUMNS"+
		"WHERE column_name=fieldName"+
		"and table_name=tableName"+
		"and table_schema=dbName"+
		")"+
	"THEN"+
		"set @ddl=CONCAT('ALTER TABLE ',dbName,'.',tableName,"+
			"' ADD COLUMN ',fieldName,' ',fieldDef);"+
		"prepare stmt from @ddl;"+
		"execute stmt;"
	+"END IF");
	}
}
