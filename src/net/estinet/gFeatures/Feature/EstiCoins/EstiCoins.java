package net.estinet.gFeatures.Feature.EstiCoins;

import net.estinet.gFeatures.Configuration.Config;
import net.estinet.gFeatures.Events;
import net.estinet.gFeatures.Retrieval;
import net.estinet.gFeatures.gFeature;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EstiCoins extends gFeature implements Events {

    //SQL Fields
    public static String sqlAddress, sqlPort, sqlTablename, sqlUsername, sqlPassword;

    public EstiCoins(String featurename, String version) {
        super(featurename, version);
    }
    @Override
    public void enable(){
        Bukkit.getLogger().info("[EstiCoins] Enabled! Yay.");
        if(ConfigManager.check()){
            String URL = Connection.toURL(sqlPort, sqlAddress, sqlTablename);
            Connection.checkOnline(URL, sqlUsername, sqlPassword);
            connect("CREATE TABLE IF NOT EXISTS Peoples(Name VARCHAR(200), Money FLOAT) ENGINE=InnoDB;");
            connect("UPDATE Peoples SET Money = Money + 1\nWHERE Name = 'InDev';");
        }

        YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(new File("plugins/gFeatures/EstiCoins/config.yml"));
        EstiCoins.sqlAddress = yamlFile.get("Config.MySQL.Address").toString();
        EstiCoins.sqlPassword = yamlFile.get("Config.MySQL.Password").toString();
        EstiCoins.sqlUsername = yamlFile.get("Config.MySQL.Username").toString();
        EstiCoins.sqlPort = yamlFile.get("Config.MySQL.Port").toString();
        EstiCoins.sqlTablename = yamlFile.get("Config.MySQL.TableName").toString();
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
            new Thread(() -> connect("INSERT INTO Peoples(Name, Money)\n"+
                    "SELECT * FROM (SELECT '" + e.getPlayer().getUniqueId() + "', '0') AS tmp\n"+
                    "WHERE NOT EXISTS (\n"+
                    "SELECT Name FROM Peoples WHERE Name = '" + e.getPlayer().getUniqueId() + "'\n"+
                    ") LIMIT 1;\n"
            )).start();
        }
    }
    @Retrieval
    public void onPlayerJoin(){}
    @Override
    public void commandTrigger(CommandSender sender, Command cmd, String label, String[] args) {
        CommandHub ch = new CommandHub();
        ch.Intitiate(sender, cmd, label, args);
    }

    private static List<String> connectReturn(String query) {
        return Connection.connectReturn(Connection.toURL(sqlPort, sqlAddress, sqlTablename), sqlUsername, sqlPassword, query);
    }
    private static void connect(String query) {
        Connection.connect(Connection.toURL(sqlPort, sqlAddress, sqlTablename), sqlUsername, sqlPassword, query);
    }

    /*
     * EstiCoins API
     */

    public static double getMoney(Player p){
        return Double.parseDouble(connectReturn("SELECT Name, Money FROM Peoples WHERE Name = '" + p.getUniqueId().toString() + "';").get(1));
    }
    public static double getMoney(OfflinePlayer p){
        return getMoney((Player) p);
    }
    public static void giveMoney(Player p, double amount) {
        connect("UPDATE Peoples SET Money = " + (amount + getMoney(p)) + "\nWHERE Name = '" + p.getUniqueId().toString() + "';");
    }
    public static void takeMoney(Player p, double amount) {
        connect("UPDATE Peoples SET Money = " + (amount - getMoney(p)) + "\nWHERE Name = '" + p.getUniqueId().toString() + "';");
    }
    public static void setMoney(Player p, double amount) {
        connect("UPDATE Peoples SET Money = " + amount + "\nWHERE Name = '" + p.getUniqueId().toString() + "';");
    }
    public static List<String> top(){
        return connectReturn("SELECT * FROM Peoples;");
    }
    public static void giveMoney(OfflinePlayer p, double amount){
        giveMoney((Player) p, amount);
    }
    public static void takeMoney(OfflinePlayer p, double amount){
        takeMoney((Player) p, amount);
    }
    public static void setMoney(OfflinePlayer p, double amount){
        setMoney((Player) p, amount);
    }
    public static boolean playerExists(OfflinePlayer p) {
        return playerExists((Player) p);
    }
    public static boolean playerExists(Player p){
        return connectReturn("SELECT Name, Money FROM Peoples WHERE Name = '" + p.getUniqueId().toString() + "';").get(1) != null;
    }
    public static boolean isOnline(String name) {
        final Boolean[] ret = {false};
        Bukkit.getOnlinePlayers().forEach(player -> {
            if(name.equals(player.getName())) ret[0] = true;
        });
        return ret[0];
    }
}
