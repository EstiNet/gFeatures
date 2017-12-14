package net.estinet.gFeatures.Feature.EstiCoins;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2017 EstiNet

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

public class CommandHub {
    public void init(CommandSender sender, Command command, String commandLabel, String[] args) throws IllegalArgumentException, IllegalStateException {
        if (args.length == 0) {
            coins(sender);
        } else {
            switch (args[0]) {
                case "help":
                    help(sender);
                    break;
                case "pay":
                    pay(sender, args);
                    break;
                case "set":
                    set(sender, args);
                    break;
                case "top":
                    top(sender);
                    break;
                case "get":
                    get(sender, args);
                    break;
                default:
                    help(sender);
                    break;
            }
        }
    }

    public static void coins(CommandSender sender) {
        if (sender instanceof Player) {
            double m = EstiCoins.getMoney((Player) sender);
            if (m % 0.1 == 0) {
                sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "You have " + ChatColor.AQUA + "" + m + "0" + ChatColor.GOLD + "" + ChatColor.BOLD + " coins.");
            } else {
                sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "You have " + ChatColor.AQUA + m + ChatColor.GOLD + "" + ChatColor.BOLD + " coins.");
            }
        } else {
            Bukkit.getLogger().info("Do /coins help for more information!");
        }
    }

    public static void help(CommandSender sender) {
        sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "–––––––Help––––––");
        sender.sendMessage(ChatColor.AQUA + "/coins                      | Shows how much coins you have.");
        sender.sendMessage(ChatColor.AQUA + "/coins get <player>         | Views how much coins the player has.");
        sender.sendMessage(ChatColor.AQUA + "/coins pay <player> <amount>| Pays a player.");
        sender.sendMessage(ChatColor.AQUA + "/coins set <player> <amount>| Admin command.");
        sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "–––––––Help–––––––");
    }

    public static void pay(CommandSender sender, String[] args) {
        if (args.length != 3) {
            sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Usage: /coins pay <player> <amount>");
        } else {
            try {
                if (Double.parseDouble(args[2]) < 0) {
                    sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "No negative integers!");
                    return;
                }
                if (sender instanceof Player) {
                    double m = Double.parseDouble(args[2]);
                    double pMoney = EstiCoins.getMoney((Player) sender);
                    if (m > pMoney) {
                        sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "You don't have enough coins!");
                    } else {
                        if (EstiCoins.isOnline(args[1])) {
                            Player pl = Bukkit.getPlayer(args[1]);
                            EstiCoins.giveMoney(pl, m);
                            EstiCoins.takeMoney((Player) sender, m);
                            sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Sent " + m + " coins to " + pl.getName());
                            pl.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "You recieved " + m + " coins from " + sender.getName());
                        } else {
                            OfflinePlayer op = Bukkit.getOfflinePlayer(args[1]);
                            EstiCoins.giveMoney(op, m);
                            EstiCoins.takeMoney((Player) sender, m);
                            sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Sent " + m + " coins to " + op.getName());
                        }
                    }
                } else {
                    Player pl = Bukkit.getPlayer(args[1]);
                    EstiCoins.giveMoney(pl, Double.parseDouble(args[2]));
                    sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Gave " + args[2] + " coins to player " + pl.getName());
                    pl.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Recieved " + args[2] + " coins.");
                }
            } catch (NumberFormatException nef) {
                sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Incorrect input. Check again.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void set(CommandSender sender, String[] args) {
        if (!sender.hasPermission("gFeatures.admin")) {
            sender.sendMessage(Bukkit.spigot().getConfig().getString("messages.unknown-command"));
            return;
        }
        if (args.length != 3) {
            sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Usage: /coins set <player> <amount>");
        } else {
            try {
                EstiCoins.setMoney(Bukkit.getServer().getOfflinePlayer(args[1]), Double.parseDouble(args[2]));
                sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Set player " + Bukkit.getServer().getOfflinePlayer(args[1]).getName() + "'s balance to " + args[2]);
            } catch (NumberFormatException e) {
                sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Problem with your input! Check what you entered.");
            }
        }

    }

    public static void top(CommandSender sender) {
        sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "This feature is not available yet.");
    }

    public static void get(CommandSender sender, String[] args) {
        if (args.length != 2) {
            sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "/coins get <player>");
            return;
        }
        OfflinePlayer op = Bukkit.getOfflinePlayer(args[1]);
        try {
            if (EstiCoins.playerExists(op)) {
                double m = EstiCoins.getMoney((Player) sender);
                if (m % 0.1 == 0) {
                    sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Player " + op.getName() + " has " + ChatColor.AQUA + "" + m + "0" + ChatColor.GOLD + "" + ChatColor.BOLD + " coins.");
                } else {
                    sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Player " + op.getName() + " has " + ChatColor.AQUA + m + ChatColor.GOLD + "" + ChatColor.BOLD + " coins.");
                }
            } else {
                sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Player not found. :(");
            }
        } catch (Exception e) {
            sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Error in your input. Try again!");
            e.printStackTrace();
        }
    }
}
