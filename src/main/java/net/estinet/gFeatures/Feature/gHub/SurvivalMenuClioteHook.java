package net.estinet.gFeatures.Feature.gHub;

import net.estinet.gFeatures.API.Logger.Debug;
import net.estinet.gFeatures.ClioteSky.ClioteHook;
import net.estinet.gFeatures.ClioteSky.ClioteSky;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.util.List;

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

public class SurvivalMenuClioteHook extends ClioteHook {

    public SurvivalMenuClioteHook(String identifier, String gFeatureName) {
        this.identifier = identifier;
        this.gFeatureName = gFeatureName;
    }

    public int i = 0, taskID;

    @Override
    public void run(byte[] data, String sender) {
        List<String> args = ClioteSky.parseBytesToStringList(data);
        Runnable run = () -> {
            if (i >= 20) {
                Bukkit.getScheduler().cancelTask(taskID);
            }
            if (Bukkit.getPlayer(args.get(0)) != null) {
                Bukkit.getPlayer(args.get(0)).teleport(new Location(Bukkit.getPlayer(args.get(0)).getWorld(), -158.5, 105.5, 485.5));
                Bukkit.getScheduler().cancelTask(taskID);
            } else {
                i++;
            }
        };
        this.taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getPluginManager().getPlugin("gFeatures"), run, 20, 30);
    }
}
