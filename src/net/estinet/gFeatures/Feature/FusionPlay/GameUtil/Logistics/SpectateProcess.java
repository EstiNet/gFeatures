package net.estinet.gFeatures.Feature.FusionPlay.GameUtil.Logistics;

import net.estinet.gFeatures.Feature.FusionPlay.FusionPlay;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

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
        FusionPlay.currentGame.removeSpectator(p);
    }
}
