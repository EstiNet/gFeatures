package net.estinet.gFeatures.Feature.gRanks;

import net.estinet.gFeatures.gFeatures;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2018 EstiNet

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless requirevoidd by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

public class EventHub implements Listener {

    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        try {
            if (!Basis.hasRank(p)) {
                gRanks.setRank(Basis.getRank("Default"), p);
            }
            Bukkit.getLogger().info(gRanks.getRankOfPlayer(p, true).getName());
            Basis.setPlayerPerms(event.getPlayer());
            Bukkit.getScheduler().runTaskAsynchronously(gFeatures.getPlugin(), () -> {
                try {
                    SQLConnect.Connect("INSERT INTO People(UUID, Rank)\n" +
                            "SELECT * FROM (SELECT '" + event.getPlayer().getUniqueId().toString() + "', 'Default') AS tmp\n" +
                            "WHERE NOT EXISTS (\n" +
                            "SELECT UUID FROM People WHERE UUID = '" + event.getPlayer().getUniqueId().toString() + "'\n" +
                            ") LIMIT 1;\n"
                    );
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @EventHandler
    public static void onPlayerChat(AsyncPlayerChatEvent event) {
        String prefix = gRanks.prefixes.getOrDefault(event.getPlayer().getUniqueId(), "");
        if (!prefix.equals("")) {
            event.getPlayer().setDisplayName(prefix);
        }
    }
}
