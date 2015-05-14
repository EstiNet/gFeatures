package net.genesishub.gFeatures.Feature.gWarsSuiteOld;

import java.io.File;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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

//Admin Controls and Debugging

public class Administration {
	File f = new File("KillsDeaths.xml");
	StatsManager sm = new StatsManager();
	StatsRetrieve sr = new StatsRetrieve();
	public void listArena(Player p){
		for(int i = 0; i<Constants.arena.size(); i++){
			String msg = Constants.arena.get(i);
			p.sendMessage(msg);
			p.sendMessage("Length " + Integer.toString(Constants.arena.size()));
		}
	}
	public void listGunin(Player p){
		for(int i = 0; i<Constants.gunin.size(); i++){
			String msg = Constants.gunin.get(i);
			p.sendMessage(msg);
			p.sendMessage("Length " + Integer.toString(Constants.gunin.size()));
		}
	}
	public void listAirplaneline(Player p){
		for(int i = 0; i<Constants.airplaneline.size(); i++){
			String msg = Constants.airplaneline.get(i);
			p.sendMessage(msg);
			p.sendMessage("Length " + Integer.toString(Constants.airplaneline.size()));
		}
	}
	public void listBT(Player p){
		for(int i = 0; i<Constants.bt.size(); i++){
			String msg = Constants.bt.get(i);
			p.sendMessage(msg);
			p.sendMessage("Length " + Integer.toString(Constants.bt.size()));
		}
	}
	public void listOT(Player p){
		for(int i = 0; i<Constants.ot.size(); i++){
			String msg = Constants.ot.get(i);
			p.sendMessage(msg);
			p.sendMessage("Length " + Integer.toString(Constants.ot.size()));
		}
	}
	public void clearArena(Player player){
		if(Constants.arena.contains(player.getName())){
			Constants.arena.remove(player.getName());
		}
		else{
			player.sendMessage("Couldn't remove you.");
		}
	}
	public void clearAirplaneline(Player player){
		if(Constants.airplaneline.contains(player.getName())){
			Constants.airplaneline.remove(player.getName());
		}
		else{
			player.sendMessage("Couldn't remove you.");
		}
	}
	public void clearGunin(Player player){
		if(Constants.gunin.contains(player.getName())){
			Constants.gunin.remove(player.getName());
		}
		else{
			player.sendMessage("Couldn't remove you.");
		}
	}
	public void commandGiveKills(final CommandSender sender, Command cmd, String label, String[] args) throws NumberFormatException, Exception{
		if(args.length == 0){
			sender.sendMessage("/admin-givekills player amount");
		}
		else if(args.length == 1){
			sender.sendMessage("/admin-givekills player amount");
		}
		else if(args.length == 2){
			int[] i = sm.giveKills(Bukkit.getServer().getPluginManager().getPlugin("gFeatures").getServer().getPlayer(args[0]), Integer.parseInt(args[1]));
			sender.sendMessage("Gave " + args[1] + " kills to " + args[0] + " who originally had " + i[0] + " kills and now has " + i[1] + " kills. Node value = ");
		}
	}
	public void commandTakeKills(final CommandSender sender, Command cmd, String label, String[] args) throws NumberFormatException, Exception{
		if(args.length == 0){
			sender.sendMessage("/admin-takekills player amount");
		}
		else if(args.length == 1){
			sender.sendMessage("/admin-takekills player amount");
		}
		else if(args.length == 2){
			sender.sendMessage("Took " + args[1] + " kills from " + args[0]);
			sm.takeKills(Bukkit.getServer().getPluginManager().getPlugin("gFeatures").getServer().getPlayer(args[0]), Integer.parseInt(args[1]));
		}
	}

	public void commandGiveDeaths(final CommandSender sender, Command cmd, String label, String[] args) throws NumberFormatException, Exception{
		if(args.length == 0){
			sender.sendMessage("/admin-givedeaths player amount");
		}
		else if(args.length == 1){
			sender.sendMessage("/admin-givedeaths player amount");
		}
		else if(args.length == 2){
			sender.sendMessage("Gave " + args[1] + " deaths to " + args[0]);
			sm.giveDeaths(Bukkit.getServer().getPluginManager().getPlugin("gFeatures").getServer().getPlayer(args[0]), Integer.parseInt(args[1]));
		}
	}

	public void commandTakeDeaths(final CommandSender sender, Command cmd, String label, String[] args) throws NumberFormatException, Exception{
		if(args.length == 0){
			sender.sendMessage("/admin-takedeaths player amount");
		}
		else if(args.length == 1){
			sender.sendMessage("/admin-takedeaths player amount");
		}
		else if(args.length == 2){
			sender.sendMessage("Took " + args[1] + " deaths from " + args[0]);
			sm.takeDeaths(Bukkit.getServer().getPluginManager().getPlugin("gFeatures").getServer().getPlayer(args[0]), Integer.parseInt(args[1]));
		}
	}

}
