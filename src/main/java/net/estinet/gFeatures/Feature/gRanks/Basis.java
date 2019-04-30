package net.estinet.gFeatures.Feature.gRanks;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import net.estinet.gFeatures.API.Logger.Debug;
import net.estinet.gFeatures.Configuration.Config;
import net.estinet.gFeatures.Feature.gRanks.Global.FileSync;
import net.estinet.gFeatures.Feature.gRanks.Global.GlobalInherit;
import net.estinet.gFeatures.Feature.gRanks.Global.GlobalPerm;
import net.estinet.gFeatures.Feature.gRanks.Global.InheritSync;
import net.estinet.gFeatures.Feature.gRanks.Perms.Files;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;

/*
 * gFeatures
 * https://github.com/EstiNet/gFeatures
 *
 *    Copyright 2019 EstiNet
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *
 */

public class Basis {

    private static List<Rank> ranks = new CopyOnWriteArrayList<>();

    public static List<Rank> getRanks() {
        return ranks;
    }

    public static void addRank(Rank rank) {
        ranks.add(rank);
    }

    public static void removeRank(Rank rank) {
        ranks.remove(rank);
    }

    public static Rank getRank(String rankname) {
        for (Rank r : ranks) {
            if (r.getName().equalsIgnoreCase(rankname)) {
                return r;
            }
        }
        return null;
    }

    public static boolean isRank(String rankname) {
        for (Rank r : ranks) {
            if (r.getName().equalsIgnoreCase(rankname)) {
                return true;
            }
        }
        return false;
    }

    private static void resetAll() {
        ranks = new ArrayList<>();
    }

    private static void fetchRanksSQL() {
        gRanks.loopThroughSQLQuery(Integer.parseInt(SQLConnect.ConnectReturn("SELECT COUNT(*) FROM Ranks").get(1)),
                SQLConnect.ConnectReturnRanks("SELECT * FROM Ranks;"),
                (name, prefix) -> Basis.addRank(new Rank(name, prefix)));
    }

    private static void fetchPeopleSQL() {
        gRanks.loopThroughSQLQuery(Integer.parseInt(SQLConnect.ConnectReturn("SELECT COUNT(*) FROM People").get(1)),
                SQLConnect.ConnectReturnPeople("SELECT * FROM People;"),
                (uuid, rank) -> Basis.getRank(rank).addPerson(uuid));
    }

    public static void setPlayerPerms(Player p) {
        Bukkit.getScheduler().runTaskAsynchronously(Bukkit.getPluginManager().getPlugin("gFeatures"), () -> {

            PermissionAttachment pa = p.addAttachment(Bukkit.getPluginManager().getPlugin("gFeatures"));
            Rank rank = (gRanks.getRankOfPlayer(p, true) == null) ? Basis.getRank("Default") : gRanks.getRankOfPlayer(p, true);
            for (String perm : rank.getPerms()) {
                if (perm.equals("'*'")) {
                    Bukkit.getScheduler().runTask(Bukkit.getPluginManager().getPlugin("gFeatures"), () -> p.setOp(true));
                } else {
                    Debug.print("[gRanks] Set permission " + perm + " to " + !perm.contains("-") + " for player " + p.getName());
                    Bukkit.getScheduler().runTask(Bukkit.getPluginManager().getPlugin("gFeatures"), () -> {
                        pa.setPermission(perm.replace("-", ""), !perm.contains("-"));
                    });
                }
            }

            gRanks.oplist = new ArrayList<>();
            for (OfflinePlayer op : Bukkit.getOperators()) {
                gRanks.oplist.add(op.getUniqueId());
            }
            if (!gRanks.getRankOfPlayer(p, true).getPerms().contains("'*'") && !gRanks.oplist.contains(p.getUniqueId())) {
                Bukkit.getScheduler().runTask(Bukkit.getPluginManager().getPlugin("gFeatures"), () -> p.setOp(false));
            }
            gRanks.updatePrefix(p);
        });
    }

    public static void initializeQuery(boolean fixPlayers) {
        Basis.resetAll();
        try {
            fetchRanksSQL();
        } catch (Exception e) {
            e.printStackTrace();
            Rank r = new Rank("Default", "[&aPlayer&f] ");
            gRanks.addRank(r);
        }
        fetchPeopleSQL();

        Config c = new Config();
        c.createDirectory("plugins/gFeatures/gRanks/perms", "Created Permissions folder!");
        c.createDirectory("plugins/gFeatures/gRanks/inherit", "Created Inherit folder!");
        c.createDirectory("plugins/gFeatures/gRanks/ginherit", "Created Global Inherit folder!");
        c.createDirectory("plugins/gFeatures/gRanks/gperms", "Created Global Permissions folder!");

        FileSync.start();
        InheritSync.start();
        GlobalPerm.start();
        GlobalInherit.start();
        Files.setupFiles();

        if (fixPlayers) {

            Bukkit.getScheduler().runTask(Bukkit.getPluginManager().getPlugin("gFeatures"), () -> {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    setPlayerPerms(p);
                }
            });
        }

    }

    public static boolean hasRank(Player p) {
        return gRanks.getRankOfPlayer(p, true) != null;
    }
}
