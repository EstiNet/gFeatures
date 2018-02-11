package net.estinet.gFeatures.Feature.ServerQuery;

import net.estinet.gFeatures.ClioteSky.API.ClioteHook;
import net.estinet.gFeatures.Feature.gScore.Scored;
import net.estinet.gFeatures.FeatureState;
import net.estinet.gFeatures.gFeature;
import net.estinet.gFeatures.gFeatures;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

public class ServerQueryClioteHook extends ClioteHook {

    public ServerQueryClioteHook(gFeature feature) {
        super(feature, "info");
    }

    @Override
    public void run(List<String> args, String categoryName, String clioteName) {
        if (args.get(0).equals("online")) {
            ServerQuery.setPlayerCount(Integer.parseInt(args.get(1)));
            if (gFeatures.getFeature("gScore").getState().equals(FeatureState.ENABLE)) {
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), () -> {
                    try {
                        for (Player p : Bukkit.getOnlinePlayers()) {
                            p.setScoreboard(Scored.getScore(p));
                        }
                    } catch (IllegalArgumentException | IllegalStateException e) {
                        e.printStackTrace();
                    }
                }, 40L);
            }
        } else if (args.get(0).equals("playerget")) {
            ServerQuery.requestQueue.poll().run(Collections.singletonList(args.get(2)));
        } else if(args.get(0).equals("uuidlookup")) {
            ServerQuery.requestQueue.poll().run(Collections.singletonList(args.get(1)));
        }
    }
}
