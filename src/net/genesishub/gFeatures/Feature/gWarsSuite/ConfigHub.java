package net.genesishub.gFeatures.Feature.gWarsSuite;

import net.genesishub.gFeatures.Configuration.Config;

/*
gFeatures
https://github.com/GenesisHub/gFeatures

   Copyright 2015 GenesisHub

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

public class ConfigHub {
	Config config = new Config();
	public void setupConfig(){
		config.createDirectory("plugins/gFeatures/gWarsSuite", "gWarsSuite plugin directory set!");
		config.createFile("plugins/gFeatures/gWarsSuite/Config.yml", "gWarsSuite plugin config set!");
	}
}
