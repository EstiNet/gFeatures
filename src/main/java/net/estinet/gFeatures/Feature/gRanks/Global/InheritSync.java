package net.estinet.gFeatures.Feature.gRanks.Global;

import net.estinet.gFeatures.Feature.gRanks.Basis;
import net.estinet.gFeatures.Feature.gRanks.Rank;
import net.estinet.gFeatures.Feature.gRanks.SQLConnect;
import net.estinet.gFeatures.Feature.gRanks.gRanks;
import org.bukkit.Bukkit;

import java.io.*;
import java.util.List;

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

public class InheritSync {
    public static void start() {

        for (Rank rank : Basis.getRanks()) {
            PrintWriter pw = null;
            try {
                pw = new PrintWriter("plugins/gFeatures/gRanks/ginherit/" + rank.getName() + ".txt");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            pw.close();
        }

        gRanks.loopThroughSQLQuery(Integer.parseInt(SQLConnect.ConnectReturn("SELECT COUNT(*) FROM Inherits").get(1)),
                SQLConnect.ConnectReturnInherit("SELECT * FROM Inherits;"),
                (inherit, rank) -> {
                    try {
                        BufferedWriter output = new BufferedWriter(new FileWriter(new File("plugins/gFeatures/gRanks/ginherit/" + rank + ".txt"), true));
                        output.write(inherit);
                        output.newLine();
                        output.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

        for (Rank rank : Basis.getRanks()) {
            File f = new File("plugins/gFeatures/gRanks/ginherit/" + rank.getName() + ".txt");
            try {
                for (String inherit : gRanks.getPermsFile(f)) {
                    Basis.getRank(rank.getName()).addInherit(Basis.getRank(inherit));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void push() {
        Bukkit.getScheduler().runTaskAsynchronously(Bukkit.getPluginManager().getPlugin("gFeatures"), new InheritPush());
    }
}
