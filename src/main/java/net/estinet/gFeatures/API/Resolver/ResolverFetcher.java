package net.estinet.gFeatures.API.Resolver;

import net.estinet.gFeatures.ClioteSkyOld.API.CliotePing;
import net.estinet.gFeatures.Feature.ServerQuery.ServerQuery;

import java.util.Hashtable;

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

public class ResolverFetcher {

    private static Hashtable<String, String> hashtable = new Hashtable<>();

    /*
     * ClioteSkyOld and ServerQuery must be enabled to use this API!
     */

    public static void uuidFromName(String name, ResolverExecutor re) {
        if (hashtable.get(name) != null) {
            re.run(hashtable.get(name));
        } else {
            ServerQuery.requestQueue.offer(args -> {
                if(!args.get(0).equals("*")) hashtable.put(name, args.get(0));
                re.run(args.get(0));
            });
            CliotePing cp = new CliotePing();
            cp.sendMessage("info uuidlookup " + name, "Bungee");
        }
    }
}
