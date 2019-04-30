package net.estinet.gFeatures.Feature.CTF.EventBase.GameFunc;

import com.destroystokyo.paper.Title;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;


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

public class Action {
    public static void sendAll(String message) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.sendActionBar(message);
        }
    }

    public static void sendAllTitle(String title, String subtitle, int fadeIn, int stay, int fadeOut) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.sendTitle(new Title(title, subtitle, fadeIn, stay, fadeOut));
        }
    }
}
