package net.estinet.gFeatures.Feature.ParkourRace;

import net.estinet.gFeatures.Feature.FusionPlay.GameUtil.FusionMap;
import org.bukkit.Location;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Devin on 12/14/2016.
 */
public class MapsConfigure {
    public static List<FusionMap> init(){
        List<FusionMap> maps = new ArrayList<>();
        List<Location> locations1 = new ArrayList<>();
        FusionMap fm1 = new FusionMap(new File("plugins/gFeatures/ParkourRace/Maps/parkour1"), locations1);
        maps.add(fm1);
        return maps;
    }
}
