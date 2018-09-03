package net.estinet.gFeatures.Feature.gRanks;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import net.estinet.gFeatures.Configuration.Config;

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

public class ConfigHub {

    private static HashMap<String, String> configFields = new HashMap<>();

    static {
        configFields.put("Config", "");
        configFields.put("Config.Cached", "true");
        configFields.put("Config.MySQL", "");
        configFields.put("Config.MySQL.Port", "3306");
        configFields.put("Config.MySQL.Address", "localhost");
        configFields.put("Config.MySQL.TableName", "granks");
        configFields.put("Config.MySQL.Username", "root");
        configFields.put("Config.MySQL.Password", "pass123");
        configFields.put("Config.ClioteSky", "");
        configFields.put("Config.ClioteSky.Enable", "true");
    }

    public static void setupConfig() {
        File f = new File("plugins/gFeatures/gRanks/config.yml");
        Config c = new Config();
        c.createDirectory("plugins/gFeatures/gRanks", "gRanks files created!");
        if (!f.exists()) {
            Bukkit.getLogger().info("[gRanks] Setting up configs....");
            try {
                f.createNewFile();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(f);

        for (String key : configFields.keySet()) {
            if (!yamlFile.contains(key)) {
                yamlFile.createSection(key);
                if (!configFields.get(key).equals("")) {
                    yamlFile.set(key, configFields.get(key));
                }
            }
        }

        try {
            yamlFile.save(f);
            Bukkit.getLogger().info("[gRanks] Successfully added config!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        gRanks.address = yamlFile.getString("Config.MySQL.Address");
        gRanks.password = yamlFile.getString("Config.MySQL.Password");
        gRanks.tablename = yamlFile.getString("Config.MySQL.TableName");
        gRanks.port = yamlFile.getString("Config.MySQL.Port");
        gRanks.username = yamlFile.getString("Config.MySQL.Username");
        gRanks.cliotesky = yamlFile.getBoolean("Config.ClioteSky.Enable");
        gRanks.url = "jdbc:mysql://" + gRanks.address + ":" + gRanks.port + "/" + gRanks.tablename + "?autoReconnect=true&useSSL=false";

        Bukkit.getLogger().info("[gRanks] ClioteSky Support: " + gRanks.cliotesky);
    }
}
