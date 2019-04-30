package net.estinet.gFeatures.Feature.Statistics;

import net.estinet.gFeatures.gFeature;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

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

public class Statistics extends gFeature{
	
	Enable enable = new Enable();
	Disable disable = new Disable();
	
	public Statistics(String featurename, String d) {
		super(featurename, d);
	}
	@Override
	public void enable(){
		enable.onEnable();
	}
	@Override
	public void disable(){
		disable.onDisable();
	}
	@Override
	public void commandTrigger(CommandSender sender, Command cmd, String label, String[] args) { 
			//TODO Meh...
	}
}
