package net.estinet.gFeatures.Feature.gRanks;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import net.estinet.gFeatures.API.Logger.Debug;
import net.estinet.gFeatures.Feature.gRanks.Global.FileSync;
import net.estinet.gFeatures.Feature.gRanks.Global.GlobalPerm;
import net.estinet.gFeatures.Feature.gRanks.Global.InheritSync;
import net.estinet.gFeatures.Feature.gRanks.Perms.Files;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;

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

public class Basis {
    public static volatile ConcurrentHashMap<UUID, PermissionAttachment> permissions = new ConcurrentHashMap<>();
    private static List<Rank> ranks = new ArrayList<>();

    public static List<Rank> getRanks() {
        return ranks;
    }

    public static void addRank(Rank rank) {
        ranks.add(rank);
    }

    public static void addPermissionAttach(UUID uuid, PermissionAttachment pa) {
        permissions.put(uuid, pa);
    }

    public static void removeRank(Rank rank) {
        ranks.remove(rank);
    }

    public static void removePermissionsAttach(UUID uuid) {
        try {
            permissions.remove(uuid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Rank getRank(String rankname) {
        for (Rank r : ranks) {
            if (r.getName().equalsIgnoreCase(rankname)) {
                return r;
            }
        }
        return null;
    }

    public static PermissionAttachment getPermissionsAttach(UUID uuid) {
        return permissions.get(uuid);
    }

    public static boolean isRank(String rankname) {
        for (Rank r : ranks) {
            if (r.getName().equalsIgnoreCase(rankname)) {
                return true;
            }
        }
        return false;
    }

    public static void resetAll() {
        ranks = new ArrayList<>();
    }

    public void resetDisplayName(Player p) {
        p.setDisplayName(Basis.getRank(gRanks.getRank(p)).getPrefix() + p.getName());
    }

    public void initializeQuery() {
        Basis.resetAll();
        int i = Integer.parseInt(SQLConnect.ConnectReturn("SELECT COUNT(*) FROM Ranks").get(1));
        int cache = 0;
        List<String> ranksdata = SQLConnect.ConnectReturnRanks("SELECT * FROM Ranks;");
        for (int iter = 0; iter < i; iter++) {
            String name = ranksdata.get(cache);
            cache += 1;
            String prefix = ranksdata.get(cache);
            cache += 1;
            Rank newrank = new Rank(name, prefix);
            Basis.addRank(newrank);
        }
        cache = 0;
        try {
            int is = Integer.parseInt(SQLConnect.ConnectReturn("SELECT COUNT(*) FROM People").get(1));
            List<String> peopledata = SQLConnect.ConnectReturnPeople("SELECT * FROM People;");
            for (int iter = 0; iter < is; iter++) {
                String UUID = peopledata.get(cache);
                cache += 1;
                String rank = peopledata.get(cache);
                cache += 1;
                Basis.getRank(rank).addPerson(UUID);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        GlobalPerm gp = new GlobalPerm();
        gp.start();
        Files f = new Files();
        f.setupFiles();
        FileSync fs = new FileSync();
        fs.start();
        InheritSync is = new InheritSync();
        is.start();
        for (Player p : Bukkit.getOnlinePlayers()) {
            Basis.removePermissionsAttach(p.getUniqueId());
            PermissionAttachment pa = p.addAttachment(Bukkit.getPluginManager().getPlugin("gFeatures"));
            for (String perm : Basis.getRank(gRanks.getRank(p)).getPerms()) {
                if (perm.equals("'*'")) {
                    p.setOp(true);
                } else {
                    boolean isittrue;
                    if (perm.contains("-")) {
                        isittrue = false;
                        perm = perm.replace("-", "");
                    } else {
                        isittrue = true;
                    }
                    Debug.print("[gRanks] Set permission " + perm + " to " + isittrue + " for player " + p.getName());
                    pa.setPermission(perm, isittrue);
                }
            }
            gRanks.oplist = new ArrayList<>();
            for (OfflinePlayer op : Bukkit.getOperators()) {
                gRanks.oplist.add(op.getUniqueId());
            }
            if (!Basis.getRank(gRanks.getRank(p)).getPerms().contains("'*'") && !gRanks.oplist.contains(p.getUniqueId())) {
                p.setOp(false);
            }
            Basis.addPermissionAttach(p.getUniqueId(), pa);
        }
    }

    public static boolean hasRank(Player p) {
        try {
            gRanks.getRank(p);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}