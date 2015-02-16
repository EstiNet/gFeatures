package tk.genesishub.gWarsSuite;

import java.io.File;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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
	public void clearGunin(Player player){
		if(Constants.gunin.contains(player.getName())){
			Constants.gunin.remove(player.getName());
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
			int[] i = sm.giveKills(Bukkit.getServer().getPluginManager().getPlugin("gWarsSuite").getServer().getPlayer(args[0]), Integer.parseInt(args[1]));
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
			sm.takeKills(Bukkit.getServer().getPluginManager().getPlugin("gWarsSuite").getServer().getPlayer(args[0]), Integer.parseInt(args[1]));
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
			sm.giveDeaths(Bukkit.getServer().getPluginManager().getPlugin("gWarsSuite").getServer().getPlayer(args[0]), Integer.parseInt(args[1]));
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
			sm.takeDeaths(Bukkit.getServer().getPluginManager().getPlugin("gWarsSuite").getServer().getPlayer(args[0]), Integer.parseInt(args[1]));
		}
	}

}
