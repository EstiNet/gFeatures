package net.estinet.gFeatures.Feature.FusionPlay.GameUtil.Logistics;

import net.estinet.gFeatures.Feature.FusionPlay.FusionPlay;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

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

public class SpectateProcess {
    public static List<UUID> spectators = new java.util.ArrayList<>();

    public static void addSpectator(Player p){
        p.setGameMode(GameMode.ADVENTURE);
        for(Player pp : Bukkit.getOnlinePlayers()){
            if(!spectators.contains(pp.getUniqueId())){
                pp.hidePlayer(p);
            }
        }
        spectators.add(p.getUniqueId());
        p.setAllowFlight(true);
        FusionPlay.currentGame.setSpectator(p);
    }
    public static void removeSpectator(Player p){
        p.setGameMode(FusionPlay.currentGame.defaultGameMode);
        for(Player pp : Bukkit.getOnlinePlayers()){
            pp.showPlayer(p);
        }
        spectators.remove(p.getUniqueId());
        p.setAllowFlight(false);
        p.setFlying(true);
        FusionPlay.currentGame.removeSpectator(p);
    }
}
