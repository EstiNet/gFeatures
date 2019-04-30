package net.estinet.gFeatures.Feature.Gliders;

import net.estinet.gFeatures.ClioteSky.ClioteHook;
import net.estinet.gFeatures.ClioteSky.ClioteSky;
import net.estinet.gFeatures.Feature.CTF.Basic;
import net.estinet.gFeatures.Feature.CTF.Mode;

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

public class GetMGInfoClioteHook extends ClioteHook {

	public GetMGInfoClioteHook(String identifier, String gFeatureName) {
		this.identifier = identifier;
		this.gFeatureName = gFeatureName;
	}

	@Override
	public void run(byte[] data, String identifier) {
		try {
			if (net.estinet.gFeatures.Feature.CTF.Basic.mode.equals(Mode.WAITING)) {
				ClioteSky.getInstance().sendAsync(new byte[0], "mghello", "Bungee");
			} else {
				ClioteSky.getInstance().sendAsync(new byte[0], "mgstart", "Bungee");
			}
			ClioteSky.getInstance().sendAsync(ClioteSky.stringToBytes(Basic.mapName), "mgmap", "Bungee");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}