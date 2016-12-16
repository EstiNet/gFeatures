package net.estinet.gFeatures.Feature.ParkourRace;

import net.estinet.gFeatures.Feature.FusionPlay.GameUtil.FusionMap;
import net.estinet.gFeatures.Feature.ParkourRace.Maps.MapOne;

import org.bukkit.Location;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MapsConfigure {
    public static List<FusionMap> init(){
        List<FusionMap> maps = new ArrayList<>();
        MapOne fm1 = new MapOne(new File("plugins/gFeatures/ParkourRace/Maps/parkour1"));
        maps.add(fm1);
        return maps;
    }
}
