package net.estinet.gFeatures.Feature.Spleef;

import net.estinet.gFeatures.Feature.FusionPlay.GameUtil.FusionMap;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MapsConfigure {
    public static List<FusionMap> init(){
        List<FusionMap> maps = new ArrayList<>();
        SMap fm1 = new SMap(new File("plugins/gFeatures/Spleef/SMap"));
        maps.add(fm1);
        return maps;
    }
}
