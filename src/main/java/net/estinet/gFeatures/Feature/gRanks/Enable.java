package net.estinet.gFeatures.Feature.gRanks;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import net.estinet.gFeatures.API.MojangAPI.UUIDFetcher;
import net.estinet.gFeatures.Feature.gRanks.Global.FileSync;
import net.estinet.gFeatures.Feature.gRanks.Global.GlobalInherit;
import net.estinet.gFeatures.Feature.gRanks.Global.GlobalPerm;
import net.estinet.gFeatures.Feature.gRanks.Perms.Files;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;

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

public class Enable {

    public static void onEnable() {
        Bukkit.getLogger().info("[gRanks] Plugin enabled!");
        ConfigHub.setupConfig();
        SQLConnect.checkOnline(gRanks.url, gRanks.username, gRanks.password);
        SQLConnect.Connect("CREATE TABLE IF NOT EXISTS People(id MEDIUMINT NOT NULL AUTO_INCREMENT, UUID VARCHAR(200), Rank VARCHAR(200), PRIMARY KEY (id))  ENGINE=InnoDB;");
        SQLConnect.Connect("CREATE TABLE IF NOT EXISTS Ranks(id MEDIUMINT NOT NULL AUTO_INCREMENT, Name VARCHAR(200), Prefix VARCHAR(200), PRIMARY KEY (id))  ENGINE=InnoDB;");
        SQLConnect.Connect("CREATE TABLE IF NOT EXISTS Perms(id MEDIUMINT NOT NULL AUTO_INCREMENT, Perm VARCHAR(200), Rank VARCHAR(200), PRIMARY KEY (id))  ENGINE=InnoDB;");
        SQLConnect.Connect("CREATE TABLE IF NOT EXISTS Inherits(id MEDIUMINT NOT NULL AUTO_INCREMENT, Inherit VARCHAR(200), Rank VARCHAR(200), PRIMARY KEY (id))  ENGINE=InnoDB;");

        Basis.initializeQuery(false);
        for (Rank rank : Basis.getRanks()) Bukkit.getLogger().info("[gRanks] Adding rank " + rank.getName() + " with prefix of " + rank.getPrefix());
        if (!gRanks.cliotesky) LoopCheck.start();

    }
}
