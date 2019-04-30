package net.estinet.gFeatures.Feature.gRanks.Perms;

import java.util.HashMap;
import java.util.List;

import net.estinet.gFeatures.API.Logger.Debug;
import net.estinet.gFeatures.Feature.gRanks.SQLConnect;
import net.estinet.gFeatures.Feature.gRanks.gRanks;

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

public class Cleanup implements Runnable {
    @Override
    public void run() {
        HashMap<String, String> perms = new HashMap<>();
        SQLConnect.Connect("SET @count = 0;");
        // Maybe later? c.Connect(URL, Username, Password, "UPDATE `perms` SET `perms`.`id` = @count:= @count + 1;");
        SQLConnect.Connect("ALTER TABLE `perms` AUTO_INCREMENT = 1;");

        gRanks.loopThroughSQLQuery(Integer.parseInt(SQLConnect.ConnectReturn("SELECT COUNT(*) FROM Perms").get(1)),
                SQLConnect.ConnectReturnPerm("SELECT * FROM Perms;"),
                perms::put);

        for (String perm : perms.keySet()) {
            gRanks.deletegPerm(perm, perms.get(perm));
            gRanks.addgPerm(perm, perms.get(perm));
        }

        HashMap<String, String> inherits = new HashMap<>();

        gRanks.loopThroughSQLQuery(Integer.parseInt(SQLConnect.ConnectReturn("SELECT COUNT(*) FROM Inherits").get(1)),
                SQLConnect.ConnectReturnInherit("SELECT * FROM Inherits;"),
                inherits::put);

        for (String inherit : inherits.keySet()) {
            gRanks.deletegInherit(inherit, inherits.get(inherit));
            gRanks.addgInherit(inherit, inherits.get(inherit));
        }
    }
}
