package net.estinet.gFeatures.Feature.gRanks.Perms;

import net.estinet.gFeatures.Configuration.Config;
import net.estinet.gFeatures.Feature.gRanks.Basis;
import net.estinet.gFeatures.Feature.gRanks.Rank;

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

public class Files {
	public static void setupFiles(){
		Config c = new Config();
		for(Rank r : Basis.getRanks()){
			c.createFile("plugins/gFeatures/gRanks/perms/" + r.getName() + ".txt", "Created permissions file for " + r.getName() + "!");
			c.createFile("plugins/gFeatures/gRanks/gperms/" + r.getName() + ".txt", "Created global permissions file for " + r.getName() + "!");
			c.createFile("plugins/gFeatures/gRanks/inherit/" + r.getName() + ".txt", "Created inheritance file for " + r.getName() + "!");
			c.createFile("plugins/gFeatures/gRanks/ginherit/" + r.getName() + ".txt", "Created global inheritance file for " + r.getName() + "!");
		}
		PermApp.setupPerms();
	}
}