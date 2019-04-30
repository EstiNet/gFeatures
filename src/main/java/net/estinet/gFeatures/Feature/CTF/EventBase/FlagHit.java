package net.estinet.gFeatures.Feature.CTF.EventBase;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import net.estinet.gFeatures.Feature.CTF.Basic;
import net.estinet.gFeatures.Feature.CTF.Team;
import net.estinet.gFeatures.Feature.CTF.EventBase.GameFunc.Action;
import net.estinet.gFeatures.Feature.CTF.Holo.CTFScore;

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

public class FlagHit {

    public static void processEvent(Location loc, Player p) {

        if (loc.getBlockX() == Basic.blueflag.getBlockX() && loc.getBlockY() == Basic.blueflag.getBlockY() && loc.getBlockZ() == Basic.blueflag.getBlockZ()) {
            if (Basic.isInOrange(p)) {
                if (Basic.blueflagger == null) {

                    Action.sendAllTitle(ChatColor.GOLD + p.getName() + " has taken the blue flag!", ChatColor.BOLD + "Fireworks will trace " + p.getName() + "!", 20, 40, 20);
                    p.sendActionBar(ChatColor.AQUA + "Get back to your base and punch the ender crystal to capture the flag!");
                    Basic.blueflagger = p;
                    // captured the blue flag
                } else if (!Basic.blueflagger.getUniqueId().equals(p.getUniqueId())) {
                    p.sendTitle("The flag has already been taken.", "", 10, 20, 10);
                }
            } else if (Basic.isInBlue(p) && Basic.orangeflagger.getUniqueId().equals(p.getUniqueId())) {

                Action.sendAllTitle(ChatColor.DARK_AQUA + p.getName() + " has captured the orange flag!", "", 20, 40, 20);
                Basic.orangeflagger = null;
                Basic.blueflags++;
                Basic.flagcaptures.remove(p.getUniqueId());
                Basic.flagcaptures.put(p.getUniqueId(), Basic.flagcaptures.get(p.getUniqueId()));
                // fully Captured the orange flag
            }
        } else if (loc.getBlockX() == Basic.orangeflag.getBlockX() && loc.getBlockY() == Basic.orangeflag.getBlockY() && loc.getBlockZ() == Basic.orangeflag.getBlockZ()) {
            if (Basic.isInBlue(p)) {
                if (Basic.orangeflagger == null) {

                    Action.sendAllTitle(ChatColor.DARK_AQUA + p.getName() + " has taken the orange flag!", ChatColor.BOLD + "Fireworks will trace " + p.getName() + "!", 20, 40, 20);
                    p.sendActionBar(ChatColor.AQUA + "Get back to your base and punch the ender crystal to capture the flag!");
                    Basic.orangeflagger = p;
                    // captured the orange flag
                } else if (!Basic.orangeflagger.getUniqueId().equals(p.getUniqueId())) {
                    p.sendTitle("The flag has already been taken.", "", 10, 20, 10);
                }
            } else if (Basic.isInOrange(p) && Basic.blueflagger.getUniqueId().equals(p.getUniqueId())) {

                Action.sendAllTitle(ChatColor.GOLD + p.getName() + " has captured the blue flag!", "", 20, 40, 20);
                Basic.blueflagger = null;
                Basic.orangeflags++;
                Basic.flagcaptures.remove(p.getUniqueId());
                Basic.flagcaptures.put(p.getUniqueId(), Basic.flagcaptures.get(p.getUniqueId()));
                // fully Captured the blue flag
            }
        }
    }
}
