package net.estinet.gFeatures.Feature.EstiCoins;

import net.estinet.gFeatures.Configuration.Config;
import net.estinet.gFeatures.Events;
import net.estinet.gFeatures.Retrieval;
import net.estinet.gFeatures.gFeature;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.IOException;

public class EstiCoins extends gFeature implements Events {

    //SQL Fields
    public static String sqlAddress, sqlPort, sqlTablename, sqlUsername, sqlPassword;

    public EstiCoins(String featurename, String version) {
        super(featurename, version);
    }
    @Override
    public void enable(){
        ConfigManager cm = new ConfigManager();
        try {
            Bukkit.getLogger().info("[EstiCoins] Enabled! Yay.");
            if(cm.check()){
                Connection c = new Connection();
                String URL = c.toURL(sqlPort, sqlAddress, sqlTablename);
                c.checkOnline(URL, sqlUsername, sqlPassword);
                c.Connect(URL, sqlUsername, sqlPassword, "CREATE TABLE IF NOT EXISTS Peoples(Name VARCHAR(200), Money FLOAT) ENGINE=InnoDB;");
                c.Connect(URL, sqlUsername, sqlPassword, "UPDATE Peoples SET Money = Money + 1\nWHERE Name = 'InDev';");
            }
            Config con = new Config();
            con.createDirectory("plugins/gFeatures/EstiCoins", "Created EstiCoins directory!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void disable(){
        Bukkit.getLogger().info("[EstiCoins] Disabled. Good bye!");
    }
    @Override
    public void eventTrigger(Event event) {
        if(event.getEventName().equalsIgnoreCase("playerjoinevent")){
            Connection c = new Connection();
            PlayerJoinEvent e = (PlayerJoinEvent) event;
            new Thread(() -> c.Connect(c.toURL(sqlPort, sqlAddress, sqlTablename), sqlUsername, sqlPassword, "INSERT INTO Peoples(Name, Money)\n"+
                    "SELECT * FROM (SELECT '" + e.getPlayer().getUniqueId() + "', '0') AS tmp\n"+
                    "WHERE NOT EXISTS (\n"+
                    "SELECT Name FROM Peoples WHERE Name = '" + e.getPlayer().getUniqueId() + "'\n"+
                    ") LIMIT 1;\n"
            )).start();
        }
    }
    @Retrieval
    public void onPlayerJoin(){}
}
