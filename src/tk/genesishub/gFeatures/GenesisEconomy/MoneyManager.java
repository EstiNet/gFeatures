package tk.genesishub.gFeatures.GenesisEconomy;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

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
		rs = c.ConnectReturn(URL, Username, Password, "SELECT Name, Money FROM People WHERE Name = '" + p.getUniqueId().toString() + "'");
		return Float.parseFloat(rs.get(2));
	}
	public void giveMoney(Player p, float amount){
		List<String> rs = new ArrayList<>();
		rs = c.ConnectReturn(URL, Username, Password, "SELECT Name, Money FROM People WHERE Name = '" + p.getUniqueId().toString() + "'");
		float num = Float.parseFloat(rs.get(2));
		float money = num + amount;
		rs = c.ConnectReturn(URL, Username, Password, "UPDATE People SET Money WHERE Name = '"+ p.getUniqueId().toString() +"'");
	}
	public void takeMoney(Player p, double amount){
		
	}
}
