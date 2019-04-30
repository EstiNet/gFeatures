package net.estinet.gFeatures.Feature.CTF.MapsSpec;

import net.estinet.gFeatures.ClioteSky.ClioteSky;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

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

public abstract class CTFMap {
    public File directory = new File("");
    File ctfWorld = new File("./CTF");
    File mgDirectory = new File("plugins/gFeatures/CTF/MinigameSpawn");
    File minigameSpawnWorld = new File("./MinigameSpawn");

    public String mapName = "Map Name";

    public void pullWorld() {
        ctfWorld.delete();
        mgDirectory.delete();
        try {
            FileUtils.copyDirectory(directory, ctfWorld);
            FileUtils.copyDirectory(mgDirectory, minigameSpawnWorld);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ClioteSky.getInstance().sendAsync(ClioteSky.stringToBytes(mapName), "mgmap", "Bungee");
        setPoints();
    }
    public abstract void setPoints();
}
