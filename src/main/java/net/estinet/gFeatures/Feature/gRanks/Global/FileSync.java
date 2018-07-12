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

public class FileSync {
    public void start() {
        int cache = 0;
        try {
            for (Rank rank : Basis.getRanks()) {
                PrintWriter pw = new PrintWriter("plugins/gFeatures/gRanks/gperms/" + rank.getName() + ".txt");
                pw.close();
            }
            List<String> permdata = SQLConnect.ConnectReturnPerm("SELECT * FROM Perms;");
            for (int iter = 0; iter < permdata.size(); iter++) {
                try {
                    String perm = permdata.get(cache);
                    cache += 1;
                    String rank = permdata.get(cache);
                    cache += 1;
                    BufferedWriter output = new BufferedWriter(new FileWriter(new File("plugins/gFeatures/gRanks/gperms/" + rank + ".txt"), true));
                    output.write(perm);
                    output.newLine();
                    output.close();
                } catch (Exception e) {
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Rank rank : Basis.getRanks()) {
            File f = new File("plugins/gFeatures/gRanks/gperms/" + rank.getName() + ".txt");
            try {
                for (String perm : gRanks.getPermsFile(f)) {
                    Basis.getRank(rank.getName()).addPerm(perm);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void push() {
        Thread thread = new Thread(new FilePush());
        thread.start();
    }
}	
