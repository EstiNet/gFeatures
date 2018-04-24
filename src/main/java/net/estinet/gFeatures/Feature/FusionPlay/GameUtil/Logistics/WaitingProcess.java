package net.estinet.gFeatures.Feature.FusionPlay.GameUtil.Logistics;

import java.util.concurrent.TimeUnit;

import net.estinet.gFeatures.ClioteSky.ClioteSky;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;

import net.estinet.gFeatures.Feature.FusionPlay.FusionPlay;
import net.estinet.gFeatures.Feature.FusionPlay.GameUtil.FusionState;
import net.estinet.gFeatures.Feature.FusionPlay.GameUtil.TimeManager;
import net.md_5.bungee.api.ChatColor;

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

public class WaitingProcess {
    private static int counter = 0;

    public static void playerJoin(PlayerJoinEvent event) {
        FusionPlay.currentGame.enoughPlayers();
        CounterProcess.waitInit();
    }

    public static void counterComplete() {
        ClioteSky.getInstance().sendAsync(ClioteSky.stringToBytes("started"), "fusionplay", "Bungee");
        FusionPlay.currentGame.setFusionState(FusionState.STARTED);
        FusionPlay.currentGame.waitTimerComplete();
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.sendActionBar(ChatColor.AQUA + "(╯°□°）╯︵ ┻━┻");
            p.sendTitle(FusionPlay.currentGame.getSettings().getCoolGameName(), ChatColor.BOLD + "(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧ Game Start! (⌐■_■)", 30, 60, 30);
        }
        TimeManager tm = FusionPlay.currentGame.getSettings().getTimeManager();
        int sec = (int) tm.getLength();
        if (tm.getTimeUnit().equals(TimeUnit.MINUTES)) {
            sec *= 60;
        }
        FusionPlay.currentGame.getSettings().secLeft = sec;
        CounterProcess.ingameInit();
    }

    public static void joinOnWait(Player p) {
        p.teleport(FusionPlay.currentGame.getFusionMap().getSpawns().get(counter));
        if (counter == FusionPlay.currentGame.getFusionMap().getSpawns().size() - 2) {
            counter = 0;
        } else {
            counter++;
        }
    }
}
