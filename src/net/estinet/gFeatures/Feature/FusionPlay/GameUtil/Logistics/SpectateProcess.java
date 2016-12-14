package net.estinet.gFeatures.Feature.FusionPlay.GameUtil.Logistics;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import java.util.List;

public class SpectateProcess {
    public static List<Player> spectators = new java.util.ArrayList<>();

    public static void addSpectator(Player p){
        p.setGameMode(GameMode.ADVENTURE);
        for(Player pp : Bukkit.getOnlinePlayers()){
            if(!spectator)
            pp.hidePlayer(p);
        }
    }
}
