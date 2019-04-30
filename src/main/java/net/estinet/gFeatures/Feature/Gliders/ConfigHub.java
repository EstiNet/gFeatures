package net.estinet.gFeatures.Feature.Gliders;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.estinet.gFeatures.ClioteSky.ClioteSky;
import net.estinet.gFeatures.gFeatures;
import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;

import net.estinet.gFeatures.Configuration.Config;
import net.estinet.gFeatures.Feature.Gliders.Confligs.ConfligInit;

/*
 * gFeatures
 * https://github.com/EstiNet/gFeatures
 *
 *    Copyright 2019 EstiNet
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *
 */

public class ConfigHub {
    Config config = new Config();
    ConfligInit ci = new ConfligInit();
    File f = new File("plugins/gFeatures/Gliders/Config.yml");
    File ctf1 = new File("plugins/gFeatures/Gliders/Gliders1"); // Big world
    File ctf2 = new File("plugins/gFeatures/Gliders/Gliders2"); // Small World

    public void setupConfig() {
        List<Maps> maps = new ArrayList<>();
        config.createDirectory("plugins/gFeatures/Gliders", "[Gliders] plugin directory set!");
        File fl = new File("plugins/gFeatures/Gliders/MinigameSpawn");
        File flz = new File("./MinigameSpawn");

        flz.delete();

        try {
            FileUtils.copyDirectory(fl, flz);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (ctf1.isDirectory()) {
            maps.add(Maps.One);
        }
        if (ctf2.isDirectory()) {
            maps.add(Maps.Two);
        }
        if (maps.isEmpty()) {
            Bukkit.getLogger().info("[Gliders] No maps found!");
            Disable.onDisable();
            gFeatures.getFeature("Gliders").disable();
            return;
        }

        ClioteSky.getInstance().sendAsync(ClioteSky.stringToBytes("Island"), "mgmap", "Bungee");

        ci.createConfigs();
    }
}
