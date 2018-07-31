package net.estinet.gFeatures.Feature.gHub;

import net.estinet.gFeatures.ClioteSky.ClioteHook;
import net.estinet.gFeatures.ClioteSky.ClioteSky;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.util.List;

public class SurvivalMenuClioteHook extends ClioteHook {

    public SurvivalMenuClioteHook(String identifier, String gFeatureName) {
        this.identifier = identifier;
        this.gFeatureName = gFeatureName;
    }

    @Override
    public void run(byte[] data, String sender) {
        List<String> args = ClioteSky.parseBytesToStringList(data);
        Bukkit.getScheduler().runTaskLater(Bukkit.getPluginManager().getPlugin("gFeatures"), () -> {
            Bukkit.getPlayer(args.get(0)).teleport(new Location(Bukkit.getPlayer(args.get(0)).getWorld(), -158.5, 105.5, 485.5));
        }, 30);
    }
} 