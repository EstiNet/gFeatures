package net.estinet.gFeatures.Feature.gRanks.Global;

import java.util.List;

import net.estinet.gFeatures.Feature.gRanks.Basis;
import net.estinet.gFeatures.Feature.gRanks.SQLConnect;

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

public class GlobalPerm {
    public void start() {
        int cache = 0;
        try {
            int i = Integer.parseInt(SQLConnect.ConnectReturn("SELECT COUNT(*) FROM Perms").get(1));
            List<String> permdata = SQLConnect.ConnectReturnPerm("SELECT * FROM Perms;");
            for (int iter = 0; iter < i; iter++) {
                String perm = permdata.get(cache);
                cache++;
                String rank = permdata.get(cache);
                cache++;
                Basis.getRank(rank).addPerm(perm);
            }
        } catch (Exception e) {
        }
    }
}
