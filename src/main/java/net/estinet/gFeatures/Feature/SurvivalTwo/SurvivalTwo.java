package net.estinet.gFeatures.Feature.SurvivalTwo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.event.Event;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import net.estinet.gFeatures.Events;
import net.estinet.gFeatures.Retrieval;
import net.estinet.gFeatures.gFeature;
import org.bukkit.event.player.PlayerRespawnEvent;

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

public class SurvivalTwo extends gFeature implements Events {

    EventHub eh = new EventHub();

    public static List<UUID> playerPlace = new ArrayList<>();

    public SurvivalTwo(String featurename, String version) {
        super(featurename, version);
    }

    @Override
    public void enable() {
        Enable.onEnable();
    }

    @Override
    public void disable() {
        Disable.onDisable();
    }

    @Override
    public void eventTrigger(Event event) {
        if (event.getEventName().equalsIgnoreCase("playerinteractevent")) {
            eh.onPlayerInteract((PlayerInteractEvent) event);
        } else if (event.getEventName().equalsIgnoreCase("playerjoinevent")) {
            eh.onPlayerJoin((PlayerJoinEvent) event);
        } else if (event.getEventName().equalsIgnoreCase("playerrespawnevent")) {
            eh.onPlayerRespawn((PlayerRespawnEvent) event);
        }  else if (event.getEventName().equalsIgnoreCase("creaturespawnevent")) {
            eh.onCreatureSpawn((CreatureSpawnEvent) event);
        }
    }

    @Retrieval
    @Override
    public void onPlayerJoin() {
    }

    @Retrieval
    @Override
    public void onPlayerInteract() {
    }

    @Retrieval
    @Override
    public void onPlayerRespawn() {
    }

    @Retrieval
    @Override
    public void onCreatureSpawn() {}

}
