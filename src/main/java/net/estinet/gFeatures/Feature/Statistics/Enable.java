package net.estinet.gFeatures.Feature.Statistics;

import net.estinet.gFeatures.gFeatures;
import org.bukkit.Bukkit;

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

public class Enable {
	public void onEnable(){
		Bukkit.getLogger().info("Statistics enabled! What's up?");
		gFeatures.addPlayerSection("Statistics", "");
		gFeatures.addPlayerSection("Statistics.LoginCount", "0");
		gFeatures.addPlayerSection("Statistics.LogoutCount", "0");
		gFeatures.addPlayerSection("Statistics.Deaths", "0");
		gFeatures.addPlayerSection("Statistics.Kills", "0");
	}
}
