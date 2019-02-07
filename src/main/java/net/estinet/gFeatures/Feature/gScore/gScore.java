package net.estinet.gFeatures.Feature.gScore;

import net.estinet.gFeatures.ClioteSky.ClioteSky;
import net.estinet.gFeatures.gFeature;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import java.util.ArrayList;
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

public class gScore extends gFeature {

    public static List<UUID> people = new ArrayList<>();
    public static boolean currentlyUpdating = false;

    public gScore(String featurename, String d) {
        super(featurename, d);
    }

    @Override
    public void enable() {
        Bukkit.getLogger().info("[gScore] Enabled.");
    }

    @Override
    public void disable() {
        Bukkit.getLogger().info("[gScore] Disabled! :(");
    }

    public static void updateScores() {
        if (!currentlyUpdating) {
            currentlyUpdating = true;
            try {
                for (Player ps : Bukkit.getServer().getOnlinePlayers()) {
                    if (gScore.people.contains(ps.getUniqueId())) {
                        ScoreboardManager manager = Bukkit.getScoreboardManager();
                        Scoreboard score = manager.getNewScoreboard();
                        Bukkit.getScheduler().runTaskAsynchronously(Bukkit.getPluginManager().getPlugin("gFeatures"), () -> ps.setScoreboard(Scored.getScore(ps, score)));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            Bukkit.getScheduler().runTaskLater(Bukkit.getPluginManager().getPlugin("gFeatures"), () -> currentlyUpdating = false, 40);
        } else {
            Bukkit.getScheduler().runTaskLater(Bukkit.getPluginManager().getPlugin("gFeatures"), gScore::updateScores, 40);
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (!gScore.people.contains(event.getPlayer().getUniqueId())) gScore.people.add(event.getPlayer().getUniqueId());
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), () -> {
            gScore.updateScores();
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), () -> ClioteSky.getInstance().sendAsync(ClioteSky.stringToBytes("online"), "info", "Bungee"), 40L);
        }, 40L);
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        updateScores();
    }
}
