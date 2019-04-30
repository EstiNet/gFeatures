package net.estinet.gFeatures.Feature.FusionPlay;

import java.util.List;

import net.estinet.gFeatures.ClioteSky.ClioteHook;
import net.estinet.gFeatures.ClioteSky.ClioteSky;
import org.bukkit.Bukkit;

import net.estinet.gFeatures.Feature.FusionPlay.ClioteResponse.OtherResponse;
import net.estinet.gFeatures.Feature.FusionPlay.ClioteResponse.StartResponse;

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

public class FusionPlayClioteHook extends ClioteHook {

    public FusionPlayClioteHook(String identifier, String gFeatureName) {
        this.identifier = identifier;
        this.gFeatureName = gFeatureName;
    }

    @Override
    public void run(byte[] data, String sender) {

        List<String> args = ClioteSky.parseBytesToStringList(data);

        try {
            switch (args.get(0)) {
                case "start":
                    StartResponse.response(args, sender);
                    break;
                case "other":
                    OtherResponse.response(args, sender);
                    break;
                case "obtain":
                    Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "stop");
                    break;
                case "alive":
                    ClioteSky.getInstance().sendAsync(ClioteSky.stringToBytes("alive"), "fusionplay", "Bungee");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
