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

    String address, port, tablename, username, password;

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
                String URL = c.toURL(port, address, tablename);
                c.checkOnline(URL, Username, Password);
                c.Connect(URL, Username, Password, "CREATE TABLE IF NOT EXISTS Peoples(Name VARCHAR(200), Money FLOAT) ENGINE=InnoDB;");
                c.Connect(URL, Username, Password, "UPDATE Peoples SET Money = Money + 1\nWHERE Name = 'InDev';");
            }
            Config con = new Config();
            con.createDirectory("plugins/gFeatures/EstiCoins", "Created EstiCoins directory!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void disable(){
        Disable.onDisable();
    }
    @Override
    public void eventTrigger(Event event) {
        if(event.getEventName().equalsIgnoreCase("playerjoinevent")){
            eh.onPlayerJoin((PlayerJoinEvent)event);
        }
    }
    @Retrieval
    public void onPlayerJoin(){}
}
