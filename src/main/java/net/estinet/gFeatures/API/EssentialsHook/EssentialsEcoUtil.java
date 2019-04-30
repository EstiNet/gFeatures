package net.estinet.gFeatures.API.EssentialsHook;

import java.io.File;
import java.util.UUID;

import org.bukkit.configuration.file.YamlConfiguration;

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

public class EssentialsEcoUtil {
	public static double getMoney(UUID uuid){
		YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(new File("plugins/Essentials/userdata/" + uuid + ".yml"));
		String money = yamlFile.getString("money");
		double realMoney = 0;
		if(money == null){
			YamlConfiguration yamlFiles = YamlConfiguration.loadConfiguration(new File("plugins/Essentials/config.yml"));
			realMoney = Double.parseDouble(yamlFiles.getString("starting-balance"));
		}
		else{
			realMoney = Double.parseDouble(money);
		}
		return realMoney;
	}
}
