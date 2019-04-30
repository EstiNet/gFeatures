package net.estinet.gFeatures.Feature.gRanks.Global;

import net.estinet.gFeatures.Feature.gRanks.Basis;
import net.estinet.gFeatures.Feature.gRanks.Rank;
import net.estinet.gFeatures.Feature.gRanks.SQLConnect;
import net.estinet.gFeatures.Feature.gRanks.gRanks;

import java.io.File;
import java.io.IOException;

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

public class InheritPush implements Runnable {

    @Override
    public void run() {
        SQLConnect.Connect("TRUNCATE TABLE Inherits;");
        for (Rank rank : Basis.getRanks()) {
            File f = new File("plugins/gFeatures/gRanks/ginherit/" + rank.getName() + ".txt");
            try {
                for (String inherit : gRanks.getPermsFile(f)) {
                    gRanks.addgInherit(inherit, rank.getName());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
