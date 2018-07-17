package net.estinet.gFeatures.Feature.gRanks;

import net.estinet.gFeatures.API.Logger.Debug;
import net.estinet.gFeatures.Retrieval;
import net.estinet.gFeatures.gFeature;

import org.apache.commons.io.IOUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2018 EstiNet

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

public class gRanks extends gFeature {

    public static String address, port, tablename, username, password, url;
    public static boolean cliotesky;

    public static List<UUID> oplist = new ArrayList<>();

    public gRanks(String featurename, String d) {
        super(featurename, d);
    }

    @Override
    public void enable() {
        Enable.onEnable();
    }

    @Override
    public void disable() {
        Disable.onDisable();
    }

    @Override
    public void eventTrigger(Event event) {
        if (event.getEventName().equalsIgnoreCase("playerjoinevent")) {
            EventHub.onPlayerJoin((PlayerJoinEvent) event);
        } else if (event.getEventName().equalsIgnoreCase("asyncplayerchatevent")) {
            EventHub.onPlayerChat((AsyncPlayerChatEvent) event);
        } else if (event.getEventName().equalsIgnoreCase("PlayerQuitEvent")) {
            EventHub.onPlayerLeave((PlayerQuitEvent) event);
        }
    }

    @Override
    @Retrieval
    public void onPlayerJoin() {
    }

    @Override
    @Retrieval
    public void onPlayerChat() {
    }

    @Override
    @Retrieval
    public void onPlayerLeave() {
    }

    @Override
    public void commandTrigger(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender.hasPermission("gFeatures.admin")) {
            CommandHub.onCommand(sender, cmd, label, args);
        }
    }

    /*
     * API
     */

    public static String getRank(Player p) {
        List<String> rs = SQLConnect.ConnectReturn("SELECT UUID, Rank FROM People WHERE UUID = '" + p.getUniqueId().toString() + "';");
        return rs.get(1);
    }

    public static String getRank(String UUID) {
        List<String> rs = SQLConnect.ConnectReturn("SELECT UUID, Rank FROM People WHERE UUID = '" + UUID + "';");
        return rs.get(1);
    }

    public static void setRank(Rank rank, Player p) {
        SQLConnect.Connect("UPDATE People SET Rank = '" + rank.getName() + "' \nWHERE UUID = '" + p.getUniqueId().toString() + "';");
        Basis.getRank(rank.getName()).addPerson(p.getUniqueId().toString());
    }

    public static void setRank(Rank rank, String UUID) {
        SQLConnect.Connect("UPDATE People SET Rank = '" + rank.getName() + "' \nWHERE UUID = '" + UUID + "';");
        Basis.getRank(rank.getName()).addPerson(UUID);
    }

    public static void addRank(Rank rank) {
        SQLConnect.Connect("INSERT INTO Ranks(Name, Prefix)\n" +
                "SELECT * FROM (SELECT '" + rank.getName() + "', '" + rank.getPrefix() + "') AS tmp\n" +
                "WHERE NOT EXISTS (\n" +
                "SELECT Name FROM Ranks WHERE Name = '" + rank.getPrefix() + "'\n" +
                ") LIMIT 1;\n"
        );
        Basis.addRank(rank);
    }

    public static void addgPerm(String perm, String rankname) {
        SQLConnect.Connect("INSERT INTO Perms(Perm, Rank)\n" +
                "SELECT * FROM (SELECT '" + perm + "', '" + rankname + "') AS tmp\n" +
                "WHERE NOT EXISTS (\n" +
                "SELECT Perm FROM Perms WHERE Perm = '" + rankname + "'\n" +
                ") LIMIT 1;\n"
        );
        try {
            Debug.print(rankname + " is adding " + perm);
            Basis.getRank(rankname).addPerm(perm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addgInherit(String inherit, String rankname) {
        SQLConnect.Connect("INSERT INTO Inherits(Inherit, Rank)\n" +
                "SELECT * FROM (SELECT '" + inherit + "', '" + rankname + "') AS tmp\n" +
                "WHERE NOT EXISTS (\n" +
                "SELECT Inherit FROM Inherits WHERE Inherit = '" + rankname + "'\n" +
                ") LIMIT 1;\n"
        );
        try {
            Basis.getRank(rankname).addInherit(Basis.getRank(inherit));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteRank(Rank rank) {
        SQLConnect.Connect("DELETE FROM Ranks WHERE Name = '" + rank.getName() + "';");
        Rank people = Basis.getRank(rank.getName());
        for (String uuid : people.getPersonList()) {
            SQLConnect.Connect("UPDATE People SET Rank = 'Default' \nWHERE UUID = '" + uuid + "';");
            Basis.getRank("Default").addPerson(uuid);
        }
        Basis.removeRank(rank);
    }

    public static void deletegPerm(String perm, String rankname) {
        SQLConnect.Connect("DELETE FROM Perms WHERE Perm = '" + perm + "' AND Rank = '" + rankname + "';");
        try {
            Basis.getRank(rankname).removePerm(perm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deletegInherit(String inherit, String rankname) {
        SQLConnect.Connect("DELETE FROM Inherits WHERE Inherit = '" + inherit + "' AND Rank = '" + rankname + "';");
        try {
            Basis.getRank(rankname).removeInherit(Basis.getRank(rankname));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loopThroughSQLQuery(int length, List<String> list, TwoVal tv) {
        for (int i = 0, cache = 0; i < length; i++) {
            String arg1 = list.get(cache);
            cache++;
            String arg2 = list.get(cache);
            cache++;
            tv.run(arg1, arg2);
        }
    }

    public static List<String> getPermsFile(File f) throws IOException {
        List<String> perms = Files.readAllLines(Paths.get(f.getPath()), StandardCharsets.UTF_8);
        for (int i = 0; i < perms.size(); i++) {
            perms.set(i, perms.get(i).replace("\r", ""));
            if (perms.get(i).equals("")) {
                i--;
                perms.remove(i);
            }
        }
        return perms;
    }
}