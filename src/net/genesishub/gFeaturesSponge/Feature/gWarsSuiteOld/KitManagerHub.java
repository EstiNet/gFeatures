package net.genesishub.gFeatures.Feature.gWarsSuiteOld;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import tk.genesishub.gFeatures.gWarsSuite.Tiers.TierFour;
import tk.genesishub.gFeatures.gWarsSuite.Tiers.TierOne;
import tk.genesishub.gFeatures.gWarsSuite.Tiers.TierThree;
import tk.genesishub.gFeatures.gWarsSuite.Tiers.TierTwo;
import tk.genesishub.gFeatures.gWarsSuite.Tiers.TierZero;

/*
gFeatures
https://github.com/Seshpenguin/gFeatures

   Copyright 2015 DolphinBox

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

public class KitManagerHub {
	TierZero tz = new TierZero();
	TierOne to = new TierOne();
	TierTwo tt = new TierTwo();
	TierThree tth = new TierThree();
	TierFour tf = new TierFour();
	Constants cons = new Constants();
	public void Organize(final CommandSender sender, Command cmd, String label, String[] args, String value){
		switch(value){
		case "tier0-sniper":
			tz.Initialize(sender, "sniper");
			break;
		case "tier0-shotgun":
			tz.Initialize(sender, "shotgun");
			break;
		case "tier0-auto-rifle":
			tz.Initialize(sender, "autorifle");
			break;
		case "tier0-special":
			tz.Initialize(sender, "special");
			break;
		case "tier1-sniper":
			to.Initialize(sender, "sniper");
			break;
		case "tier1-shotgun":
			to.Initialize(sender, "shotgun");
			break;
		case "tier1-auto-rifle":
			to.Initialize(sender, "autorifle");
			break;
		case "tier1-special":
			to.Initialize(sender, "special");
			break;
		case "tier2-sniper":
			tt.Initialize(sender, "sniper");
			break;
		case "tier2-shotgun":
			tt.Initialize(sender, "shotgun");
			break;
		case "tier2-auto-rifle":
			tt.Initialize(sender, "autorifle");
			break;
		case "tier2-special":
			tt.Initialize(sender, "special");
			break;
		case "tier3-sniper":
			tth.Initialize(sender, "sniper");
			break;
		case "tier3-shotgun":
			tth.Initialize(sender, "shotgun");
			break;
		case "tier3-auto-rifle":
			tth.Initialize(sender, "autorifle");
			break;
		case "tier3-special":
			tth.Initialize(sender, "special");
			break;
		case "tier4-sniper":
			tf.Initialize(sender, "sniper");
			break;
		case "tier4-shotgun":
			tf.Initialize(sender, "shotgun");
			break;
		case "tier4-auto-rifle":
			tf.Initialize(sender, "autorifle");
			break;
		case "tier4-special":
			tf.Initialize(sender, "special");
			break;
		}
	}
}