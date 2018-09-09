package net.estinet.gFeatures;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Event;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

public abstract class gFeature implements Listener {
    private String name;
    private String version;
    private FeatureState state;
    private ArrayList<Listener> eventListeners = new ArrayList<>(Arrays.asList(this)); // Default event listener is the current class

    public gFeature(String featurename, String d) {
        name = featurename;
        version = d;
    }

    public void setName(String featurename) {
        name = featurename;
    }

    public void setVersion(String featureversion) {
        version = featureversion;
    }

    public void setState(FeatureState states) {
        state = states;
    }

    public void addEventListener(Listener eventListener) {
        this.eventListeners.add(eventListener);
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public FeatureState getState() {
        return state;
    }

    public List<Listener> getEventListeners() {return eventListeners;}

    public abstract void enable();

    public abstract void disable();

    public void commandTrigger(CommandSender sender, Command cmd, String label, String[] args){}
}
