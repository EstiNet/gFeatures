package net.estinet.gFeatures.Feature.gHub;

import net.estinet.gFeatures.ClioteSky.ClioteSky;
import net.estinet.gFeatures.Configs;
import net.estinet.gFeatures.Command.EstiCommand;
import net.estinet.gFeatures.Feature.gHub.command.gHubCommand;
import net.estinet.gFeatures.gFeatures;

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

public class Configure {
    @Configs
    public static void onSetup() {
        gHub base = new gHub("gHub", "1.3.1");
        base.addEventListener(new EventHub());
        gFeatures.addFeature(base);

        EstiCommand test = new EstiCommand("gHub", "gHub core command.", "/gHub", "gFeatures.admin", base, new gHubCommand());
        gFeatures.addCommand(test);

        ClioteSky.addHook(new MGDoneClioteHook("mgdone", base.getName()));
        ClioteSky.addHook(new MGReturnClioteHook("mgrecieve", base.getName()));
        ClioteSky.addHook(new MGStartClioteHook("mgstart", base.getName()));
        ClioteSky.addHook(new SurvivalMenuClioteHook("survivalmenu", base.getName()));
    }
}
