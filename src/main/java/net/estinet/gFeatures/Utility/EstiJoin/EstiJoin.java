package net.estinet.gFeatures.Utility.EstiJoin;

import net.estinet.gFeatures.Configuration.Config;
import net.estinet.gFeatures.gUtility;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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

public class EstiJoin extends gUtility {

    public static String title = "";
    public static String subtitle = "";

    public EstiJoin(String featurename, String d) {
        super(featurename, d);
    }

    @Override
    public void enable() {
        Bukkit.getLogger().info("[EstiJoin] Enabled.");
        Config c = new Config();
        c.createDirectory("plugins/gFeatures/EstiJoin", "Created EstiJoin Directory.");
        File f = new File("plugins/gFeatures/EstiJoin/title.txt");
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                title = br.readLine();
                subtitle = br.readLine();
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void disable() {
        Bukkit.getLogger().info("[EstiJoin] Disabled.");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        try {
            if (!title.equals("")) {
                e.getPlayer().sendTitle(title.replace('&', '§'), subtitle.replace('&', '§'), 50, 40, 50);
            }
        } catch (Exception es) {
        }
        e.setJoinMessage(ChatColor.GOLD + "[" + ChatColor.DARK_AQUA + "Join" + ChatColor.GOLD + "]" + ChatColor.RESET + " " + ChatColor.WHITE + e.getPlayer().getName());
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e) {
        e.setQuitMessage(ChatColor.GOLD + "[" + ChatColor.DARK_AQUA + "Leave" + ChatColor.GOLD + "]" + ChatColor.RESET + " " + ChatColor.WHITE + e.getPlayer().getName());
    }

    @Override
    public void commandTrigger(CommandSender sender, Command cmd, String label, String[] args) {
    }
}
