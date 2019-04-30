package net.estinet.gFeatures.Feature.gRanks.Commands;

import java.util.Collections;
import java.util.Map;
import java.util.UUID;

import net.estinet.gFeatures.API.Logger.Debug;
import net.estinet.gFeatures.API.MojangAPI.UUIDFetcher;
import net.estinet.gFeatures.ClioteSky.ClioteSky;
import net.estinet.gFeatures.Feature.gRanks.Basis;
import net.estinet.gFeatures.Feature.gRanks.Rank;

import net.estinet.gFeatures.Feature.gRanks.gRanks;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

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

public class TwoArg {
    public static void onCommand(final CommandSender sender, Command cmd, String label, String[] args) {
        if (args[0].equalsIgnoreCase("get")) {
            UUIDFetcher uuid = new UUIDFetcher(Collections.singletonList(args[1]));
            Map<String, UUID> response;
            try {
                response = uuid.call();
            } catch (Exception e) {
                sender.sendMessage(ChatColor.RED + "[gRanks] Error with your input. Please try again!");
                return;
            }
            String rs;
            try {
                rs = rs = gRanks.getRankOfPlayer(response.get(args[1]).toString(), true).getName();
            } catch (Exception e) {
                sender.sendMessage(ChatColor.RED + "[gRanks] Error with your input. Please try again!");
                return;
            }
            sender.sendMessage(ChatColor.GRAY + "[gRanks] Player " + args[1] + " is " + rs);
        } else if (args[0].equalsIgnoreCase("delete")) {
            Rank newrank = new Rank(args[1], "");
            gRanks.deleteRank(newrank);
            sender.sendMessage(ChatColor.GRAY + "[gRanks] Deleted rank " + args[1] + ".");
            if (gRanks.cliotesky) {
                ClioteSky.getInstance().sendAsync(ClioteSky.stringToBytes("sync"), "granks", "all");
            }
        } else if (args[0].equalsIgnoreCase("perms")) {
            try {
                Rank rank = Basis.getRank(args[1]);
                sender.sendMessage(ChatColor.GRAY + "Permissions for " + args[1]);
                Debug.print("Permissions for " + args[1]);
                for (String perm : rank.getPerms()) {
                    sender.sendMessage(ChatColor.GRAY + "- " + perm);
                    Debug.print("- " + perm);
                }
            } catch (Exception e) {
                sender.sendMessage(ChatColor.RED + "[gRanks] Error with your input. Please try again!");
            }

        } else if (args[0].equalsIgnoreCase("inherits")) {
            try {
                Rank ra = Basis.getRank(args[1]);
                sender.sendMessage(ChatColor.GRAY + "Inherited Ranks:");
                for (Rank inherit : ra.getInheritList()) {
                    sender.sendMessage(ChatColor.GRAY + "- " + inherit.getName());
                }
            } catch (Exception e) {
                sender.sendMessage(ChatColor.RED + "[gRanks] Error with your input. Please try again!");
            }
        } else {
            sender.sendMessage(ChatColor.GRAY + "[gRanks] Please do /gRanks help.");
        }
    }
}
