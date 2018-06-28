package net.estinet.gFeatures.Feature.CTF;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.estinet.gFeatures.Feature.CTF.MapsSpec.*;
import org.bukkit.Bukkit;
import net.estinet.gFeatures.Configuration.Config;
import net.estinet.gFeatures.Feature.CTF.Confligs.ConfligInit;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2017 EstiNet

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

public class ConfigHub {
    private static List<CTFMap> maps = new ArrayList<>();

    static {
        maps.add(new MapOne());
        maps.add(new MapTwo());
        maps.add(new MapThree());
    }

    public static void setupConfig() {
        new Config().createDirectory("plugins/gFeatures/CTF", "[CTF] plugin directory set!");
        List<CTFMap> mapList = new ArrayList<>();

        // add maps to list

        for (CTFMap map : maps) {
            if (map.directory.isDirectory()) {
                mapList.add(map);
            }
        }
        if (mapList.isEmpty()) {
            Bukkit.getLogger().info("[CTF] No maps found!");
            Disable.onDisable();
            net.estinet.gFeatures.gFeatures.getFeature("CTF").disable();
            return;
        }

        // randomly select one

        int random = (int) Math.floor(Math.random() * mapList.size());
        Bukkit.getLogger().info("[CTF] Map " + (random+1) + " selected!");
        Basic.ctfmap = mapList.get(random);
        Basic.ctfmap.pullWorld();

        new ConfligInit().createConfigs();
    }
}
