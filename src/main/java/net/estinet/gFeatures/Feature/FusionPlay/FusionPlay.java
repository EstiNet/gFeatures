package net.estinet.gFeatures.Feature.FusionPlay;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import net.estinet.gFeatures.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import net.estinet.gFeatures.Feature.FusionPlay.GameUtil.FusionGame;
import net.estinet.gFeatures.Feature.FusionPlay.GameUtil.FusionState;
import net.md_5.bungee.api.ChatColor;

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

public class FusionPlay extends gFeature {

    public static List<FusionGame> games = new ArrayList<>();
    public static FusionGame currentGame = null;
    public static boolean otherup = false;
    public static boolean assigned = false;

    public FusionPlay(String featurename, String version) {
        super(featurename, version);
    }

    @Override
    public void enable() {
        Enable.onEnable();
    }

    @Override
    public void disable() {
        Disable.onDisable();
    }

    public static void addGame(FusionGame fg) {
        games.add(fg);
    }

    public static void selectGame() {
        File f = new File("plugins/gFeatures/FusionPlay/notminigame.txt");
        String not = "";
        boolean hmm = true;
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            not = br.readLine();
            br.close();
            f.delete();
        } catch (FileNotFoundException e) {
            hmm = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (hmm) {
            Bukkit.getLogger().info("[FusionPlay] Responding to server change type request.");
            assigned = true;
            otherup = true;
        }
        int whee = 0;
        while (true) {
            if (whee == 300) {
                games.get(0).setFusionState(FusionState.WAITING);
                currentGame = games.get(0);
                break;
            }
            int random = (int) (Math.random() * (games.size()));
            if (!games.get(random).getName().equalsIgnoreCase(not)) {
                games.get(random).setFusionState(FusionState.WAITING);
                currentGame = games.get(random);
                gFeature feature = games.get(random);
                feature.setState(FeatureState.ENABLE);
                gFeatures.addFeature(games.get(random));
                games.get(random).enable();
                break;
            }
            Bukkit.getLogger().info("[FusionPlay] Ugh.");
            whee++;
        }
        for (FusionGame fg : games) {
            if (!fg.equals(currentGame)) {
                fg.setFusionState(FusionState.LIMBO);
            }
        }
    }

    public static void winners(Player p1, Player p2, Player p3) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            Bukkit.getLogger().info(ChatColor.DARK_AQUA + " (◕‿↼) Game Complete! （╯°□°）╯︵(\\ .o.)\\" + ChatColor.GOLD + "1: " + p1.getName() + " 2: " + p2.getName() + " 3: " + p3.getName());
            //aapi.sendTitle(p, 20, 50, 20, ChatColor.DARK_AQUA + " (◕‿↼) Game Complete! （╯°□°）╯︵(\\ .o.)\\");
            p.sendTitle(ChatColor.DARK_AQUA + " (◕‿↼) Game Complete! （╯°□°）╯︵(\\ .o.)\\", ChatColor.GOLD + "1: " + p1.getName() + " 2: " + p2.getName() + " 3: " + p3.getName(), 20, 50, 20);
        }
    }
}
