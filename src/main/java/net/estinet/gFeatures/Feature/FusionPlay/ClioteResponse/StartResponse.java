package net.estinet.gFeatures.Feature.FusionPlay.ClioteResponse;

import java.util.List;

import net.estinet.gFeatures.ClioteSky.ClioteSky;
import net.estinet.gFeatures.Feature.FusionPlay.FusionPlay;
import net.estinet.gFeatures.Feature.FusionPlay.GameUtil.FusionState;

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

public class StartResponse {
    public static void response(List<String> args, String sender) {
        if (!FusionPlay.otherup) {
            if (args.contains("new")) {
                ClioteSky.getInstance().sendAsync(ClioteSky.stringToBytes("cachealive new"), "fusionplay", "Bungee");
            } else {
                ClioteSky.getInstance().sendAsync(ClioteSky.stringToBytes("cachealive"), "fusionplay", "Bungee");
            }
        }
        FusionPlay.assigned = true;
        FusionPlay.currentGame.gameAssigned();
        FusionPlay.currentGame.setFusionState(FusionState.WAITING);
    }
}
