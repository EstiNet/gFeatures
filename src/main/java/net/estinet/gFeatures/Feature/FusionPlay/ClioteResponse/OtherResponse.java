package net.estinet.gFeatures.Feature.FusionPlay.ClioteResponse;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import net.estinet.gFeatures.ClioteSky.ClioteSky;
import org.bukkit.Bukkit;

import net.estinet.gFeatures.Feature.FusionPlay.FusionPlay;

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

public class OtherResponse {
    public static void response(List<String> args, String sender) {
        ClioteSky.getInstance().sendAsync(ClioteSky.stringToBytes("otheralive " + args.get(1)), "fusionplay", "Bungee");
        File f = new File("plugins/gFeatures/FusionPlay/notminigame.txt");
        try {
            f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter output;
        try {
            output = new BufferedWriter(new FileWriter(f, true));
            output.write(FusionPlay.currentGame.getName());
            output.newLine();
            output.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "stop");
    }
}
