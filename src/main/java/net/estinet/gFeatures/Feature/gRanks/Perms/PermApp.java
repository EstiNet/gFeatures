package net.estinet.gFeatures.Feature.gRanks.Perms;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
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
                            if (!inherit.contains("!")) {
                                r.addInherit(Basis.getRank(inherit));
                                Basis.getRank(inherit).addInherited(r);
                            } else {
                                for (String perm : Basis.getRank(inherit.replace("!", "")).getPerms()) {
                                    r.addPerm(perm);
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            List<Rank> bottomNodes = new ArrayList<>();
            for (Rank r : Basis.getRanks()) {
                if (r.getInherited().size() == 0) bottomNodes.add(r);
            }
            for (Rank r : bottomNodes) dfs(r, 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String> dfs(Rank current, int layer) {
        if (layer >= 20) return Arrays.asList("permission loop detected");
        if (current.getInheritList().size() == 0) {
            return current.getPerms();
        } else {
            List<String> perms = new ArrayList<>();
            for (Rank r : current.getInheritList()) {
                perms.addAll(dfs(r, layer + 1));
            }
            for (String perm : perms) {
                if (!current.getPerms().contains(perm)) {
                    current.addPerm(perm);
                }
            }
            return perms;
        }
    }
}
