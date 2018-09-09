package net.estinet.gFeatures.Feature.SurvivalTwo;

import net.estinet.gFeatures.gFeature;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

public class SurvivalTwo extends gFeature {

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

}
