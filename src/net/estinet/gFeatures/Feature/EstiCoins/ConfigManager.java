package net.estinet.gFeatures.Feature.EstiCoins;

import net.estinet.gFeatures.Configuration.Config;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

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

public class ConfigManager {
    private static File f = new File("plugins/gFeatures/EstiCoins/config.yml");

    public static boolean check() {
        try {
            Config c = new Config();
            c.createDirectory("plugins/gFeatures/EstiCoins", "EstiCoins files created!");
            boolean b = false;
            if (!f.exists()) {
                Bukkit.getLogger().info("[EstiCoins] Setting up configs....");
                f.createNewFile();
                YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(f);
                yamlFile.createSection("Config");
                yamlFile.createSection("Config.MySQL");
                yamlFile.createSection("Config.MySQL.Address");
                yamlFile.createSection("Config.MySQL.Port");
                yamlFile.createSection("Config.MySQL.TableName");
                yamlFile.createSection("Config.MySQL.Username");
                yamlFile.createSection("Config.MySQL.Password");
                yamlFile.set("Config.MySQL.Port", "3306");
                yamlFile.set("Config.MySQL.Address", "localhost");
                yamlFile.set("Config.MySQL.TableName", "geconomy");
                yamlFile.set("Config.MySQL.Username", "root");
                yamlFile.set("Config.MySQL.Password", "pass123");
                yamlFile.save(f);
                Bukkit.getLogger().info("[EstiCoins] Successfully added config!");
                b = true;
            }

            YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(new File("plugins/gFeatures/EstiCoins/config.yml"));
            EstiCoins.sqlAddress = yamlFile.getString("Config.MySQL.Address");
            EstiCoins.sqlPassword = yamlFile.getString("Config.MySQL.Password");
            EstiCoins.sqlUsername = yamlFile.getString("Config.MySQL.Username");
            EstiCoins.sqlPort = yamlFile.getString("Config.MySQL.Port");
            EstiCoins.sqlTablename = yamlFile.getString("Config.MySQL.TableName");

            if(b) return false;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
