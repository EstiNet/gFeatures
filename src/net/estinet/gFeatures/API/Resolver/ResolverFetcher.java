package net.estinet.gFeatures.API.Resolver;

import net.estinet.gFeatures.ClioteSky.API.CliotePing;
import net.estinet.gFeatures.Feature.ServerQuery.ServerQuery;

import java.util.Hashtable;
import java.util.UUID;

public class ResolverFetcher {

    public static Hashtable<String, String> hashtable = new Hashtable<>();

    /*
     * ClioteSky and ServerQuery must be enabled to use this API!
     */

    public static void uuidFromName(String name, ResolverExecutor re) {
        if (hashtable.get(name) != null) {
            re.run(hashtable.get(name));
        } else {
            CliotePing cp = new CliotePing();
            cp.sendMessage("info uuidlookup " + name, "Bungee");
            ServerQuery.requestQueue.offer(args -> {
                if(!args.get(0).equals("*")) hashtable.put(name, args.get(0));
                re.run(args.get(0));
            });
        }
    }
}
