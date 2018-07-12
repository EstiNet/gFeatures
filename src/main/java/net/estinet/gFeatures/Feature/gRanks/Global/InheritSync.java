package net.estinet.gFeatures.Feature.gRanks.Global;

import net.estinet.gFeatures.Feature.gRanks.Basis;
import net.estinet.gFeatures.Feature.gRanks.Rank;
import net.estinet.gFeatures.Feature.gRanks.SQLConnect;
import net.estinet.gFeatures.Feature.gRanks.gRanks;

import java.io.*;
import java.util.List;

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

public class InheritSync {
    SQLConnect c = new SQLConnect();

    public void start() {

        int cache = 0;
        try {
            int i = Integer.parseInt(SQLConnect.ConnectReturn("SELECT COUNT(*) FROM Inherits").get(1));
            List<String> permdata = SQLConnect.ConnectReturnInherit("SELECT * FROM Inherits;");
            for (Rank rank : Basis.getRanks()) {
                PrintWriter pw = new PrintWriter("plugins/gFeatures/gRanks/ginherit/" + rank.getName() + ".txt");
                pw.close();
            }
            for (int iter = 0; iter < i; iter++) {
                String inherit = permdata.get(cache);
                cache += 1;
                String rank = permdata.get(cache);
                cache += 1;
                try {
                    BufferedWriter output = new BufferedWriter(new FileWriter(new File("plugins/gFeatures/gRanks/ginherit/" + rank + ".txt"), true));
                    output.write(inherit);
                    output.newLine();
                    output.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    continue;
                }
            }
        } catch (Exception e) {
        }
        for (Rank rank : Basis.getRanks()) {
            File f = new File("plugins/gFeatures/gRanks/ginherit/" + rank.getName() + ".txt");
            try {
                for (String inherit : gRanks.getPermsFile(f)) {
                    try {
                        Basis.getRank(rank.getName()).addInherit(Basis.getRank(inherit));
                    } catch (Exception e) {
                        e.printStackTrace();
                        continue;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void push() {
        Thread thread = new Thread(new InheritPush());
        thread.start();
    }
}
