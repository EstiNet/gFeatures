package net.estinet.gFeatures.Feature.gRanks.Events;

import net.estinet.gFeatures.Feature.gRanks.gRanks;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.permissions.PermissionAttachment;

import net.estinet.gFeatures.API.Logger.Debug;
import net.estinet.gFeatures.Feature.gRanks.Basis;
import net.estinet.gFeatures.Feature.gRanks.SQLConnect;

import java.util.ArrayList;

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

public class StartupTask {
    public void init(PlayerJoinEvent event, int times) {
        if (times > 25) return;
        Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), () -> {
            Player p = event.getPlayer();
            SQLConnect.Connect("INSERT INTO People(UUID, Rank)\n" +
                    "SELECT * FROM (SELECT '" + event.getPlayer().getUniqueId().toString() + "', 'Default') AS tmp\n" +
                    "WHERE NOT EXISTS (\n" +
                    "SELECT UUID FROM People WHERE UUID = '" + event.getPlayer().getUniqueId().toString() + "'\n" +
                    ") LIMIT 1;\n"
            );
            if (!Basis.hasRank(p)) {
                gRanks.setRank(Basis.getRank("Default"), p);
            }
        }, 40L);
        try {
            PermissionAttachment pa = event.getPlayer().addAttachment(Bukkit.getPluginManager().getPlugin("gFeatures"));
            for (String perm : Basis.getRank(gRanks.getRank(event.getPlayer())).getPerms()) {
                if (perm.equals("'*'")) {
                    event.getPlayer().setOp(true);
                } else {
                    boolean isittrue;
                    if (perm.contains("-")) {
                        isittrue = false;
                        perm = perm.replace("-", "");
                    } else {
                        isittrue = true;
                    }
                    Debug.print("[gRanks] Set permission " + perm + " to " + isittrue + " for player " + event.getPlayer().getName());
                    pa.setPermission(perm, isittrue);
                }
            }
            gRanks.oplist = new ArrayList<>();
            for (OfflinePlayer op : Bukkit.getOperators()) {
                gRanks.oplist.add(op.getUniqueId());
            }
            if (!Basis.getRank(gRanks.getRank(event.getPlayer())).getPerms().contains("'*'") && !gRanks.oplist.contains(event.getPlayer().getUniqueId())) {
                event.getPlayer().setOp(false);
            }
            Basis.addPermissionAttach(event.getPlayer().getUniqueId(), pa);

            gRanks.updatePrefix(event.getPlayer());
        } catch (NullPointerException e) {
            Bukkit.getScheduler().runTaskAsynchronously(Bukkit.getPluginManager().getPlugin("gFeatures"), () -> {
                StartupTask st = new StartupTask();
                st.init(event, times + 1);
            });
        }
    }
}
