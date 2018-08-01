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

    public static int i = 0, taskID;

    @Override
    public void run(byte[] data, String sender) {
        List<String> args = ClioteSky.parseBytesToStringList(data);
        Runnable run = () -> {
            if (i >= 20) {
                Bukkit.getScheduler().cancelTask(taskID);
            }
            if (Bukkit.getPlayer(args.get(0)) != null) {
                Bukkit.getPlayer(args.get(0)).teleport(new Location(Bukkit.getPlayer(args.get(0)).getWorld(), -158.5, 105.5, 485.5));
                Bukkit.getScheduler().cancelTask(taskID);
            } else {
                i++;
            }
        };
        SurvivalMenuClioteHook.taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getPluginManager().getPlugin("gFeatures"), run, 20, 20);
    }
}
