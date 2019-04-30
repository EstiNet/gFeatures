package net.estinet.gFeatures.Feature.EstiChat;

import java.util.List;

import net.estinet.gFeatures.ClioteSky.ClioteHook;
import net.estinet.gFeatures.ClioteSky.ClioteSky;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;

import net.estinet.gFeatures.gFeature;

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

public class ConsoleClioteHook extends ClioteHook {

    public ConsoleClioteHook(String identifier, String gFeatureName) {
        this.identifier = identifier;
        this.gFeatureName = gFeatureName;
    }

    @Override
    public void run(byte[] data, String sender) {

        List<String> args = ClioteSky.parseBytesToStringList(data);

        StringBuilder mgs = new StringBuilder();
        assert args != null;
        String server = args.get(0);
        args.remove(0);
        for (String arg : args) {
            mgs.append(arg).append(" ");
        }
        mgs = new StringBuilder(mgs.substring(0, mgs.length() - 1));
        if (!mgs.toString().equals(EstiChat.lastSent)) {
            ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
            console.sendMessage("[" + server + "] " + mgs);
        }
    }
}
