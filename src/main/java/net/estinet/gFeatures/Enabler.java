package net.estinet.gFeatures;

import net.estinet.gFeatures.Command.EstiCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.event.Listener;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

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

public class Enabler {
    public void onEnable() {
        for (int i = 0; i < gFeatures.getFeatures().size(); i++) {
            gFeature feature = gFeatures.getFeatures().get(i);
            if (feature.getState().equals(FeatureState.ENABLE)) {
                try {
                    for (Listener l : feature.getEventListeners()) {
                        Bukkit.getPluginManager().registerEvents(l, gFeatures.getPlugin());
                    }
                    feature.enable();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        for (int i = 0; i < gFeatures.getExtensions().size(); i++) {
            Extension extension = gFeatures.getExtensions().get(i);
            if (extension.getState().equals(FeatureState.ENABLE) && extension.getType().equals(ExtensionsType.Utility)) {
                gUtility gu = (gUtility) extension;
                for (Listener l : gu.getEventListeners()) {
                    Bukkit.getPluginManager().registerEvents(l, gFeatures.getPlugin());
                }
                gu.enable();
            }
        }

        for (EstiCommand command : gFeatures.getCommands()) {
            if (gFeatures.getFeature(command.getFeature().getName()).getState().equals(FeatureState.ENABLE)) {

                try {
                    final Field bukkitCommandMap = Bukkit.getServer().getClass().getDeclaredField("commandMap");

                    bukkitCommandMap.setAccessible(true);
                    CommandMap commandMap = (CommandMap) bukkitCommandMap.get(Bukkit.getServer());

                    commandMap.register(command.getName(), command);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
