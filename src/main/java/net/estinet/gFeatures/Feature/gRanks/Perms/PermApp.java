package net.estinet.gFeatures.Feature.gRanks.Perms;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import net.estinet.gFeatures.Feature.gRanks.gRanks;
import org.apache.commons.io.IOUtils;
import net.estinet.gFeatures.Feature.gRanks.Basis;
import net.estinet.gFeatures.Feature.gRanks.Rank;

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

class PermApp {
    public static void setupPerms() {
        try {
            for (Rank r : Basis.getRanks()) {
                for (String permission : gRanks.getPermsFile(new File("plugins/gFeatures/gRanks/perms/" + r.getName() + ".txt"))) {
                    Basis.getRank(r.getName()).addPerm(permission);
                }
                for (String inherit : gRanks.getPermsFile(new File("plugins/gFeatures/gRanks/inherit/" + r.getName() + ".txt"))) {
                    try {
                        if (Basis.getRank(inherit.replace("!", "")) != null) {
                            if (!inherit.contains("!")) r.addInherit(Basis.getRank(inherit));
                            for (String perm : Basis.getRank(inherit.replace("!", "")).getPerms()) {
                                r.addPerm(perm);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            for (Rank r : Basis.getRanks()) dfs(r, r, 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void dfs(Rank original, Rank current, int layer) {
        if (layer >= 10) return;
        if (layer != 0) {
            for (String perm : current.getPerms()) {
                original.addPerm(perm);
            }
        }
        for (Rank r : current.getInheritList()) {
            dfs(original, r, layer + 1);
        }
    }
}
