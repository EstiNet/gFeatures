package tk.genesishub.gWarsSuite;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHub {
	Spectate spectate = new Spectate();
	ListTeams lt = new ListTeams();
	Capture capture = new Capture();
	Nuking nuke = new Nuking();
	Lobby lobby = new Lobby();
	Administration admin = new Administration();
	TeamManager tm = new TeamManager();
	KitManagerHub kmh = new KitManagerHub();
	StatsRetrieve sr = new StatsRetrieve();
	public void CommandInitiate(final CommandSender sender, Command cmd, String label, String[] args) throws NumberFormatException, Exception{
		Bukkit.getServer().getWorld("gWars");
		Player s = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("spectate")){
			spectate.SpectateInitiate(sender, cmd, label, args, s);
		}
		if (cmd.getName().equalsIgnoreCase("nuke")){
			nuke.NukeInitiate(sender, cmd, label, args, s);
		}
		if (cmd.getName().equalsIgnoreCase("done")){
			nuke.AntiNukeInitiate(sender, cmd, label, args, s);
		}
		if (cmd.getName().equalsIgnoreCase("listteams")){
			lt.TeamListInitiate(sender, cmd, label, args);
		}
    	if (cmd.getName().equalsIgnoreCase("capture") || cmd.getName().equalsIgnoreCase("c")) {
    		capture.CaptureCommandInitiate(sender, cmd, label, args);
    	}
    	if(cmd.getName().equalsIgnoreCase("airfield")){
    		lobby.LobbyInitiate(sender, cmd, label, args, "airfield");
    	}
    	if(cmd.getName().equalsIgnoreCase("underground")){
    		lobby.LobbyInitiate(sender, cmd, label, args, "underground");
    	}
    	if(cmd.getName().equalsIgnoreCase("mainfloor")){
    		lobby.LobbyInitiate(sender, cmd, label, args, "mainfloor");
    	}
    	if(cmd.getName().equalsIgnoreCase("turrets")){
    		lobby.LobbyInitiate(sender, cmd, label, args, "turrets");
    	}
    	if(cmd.getName().equalsIgnoreCase("tutorial")){
    			sender.sendMessage("Quick Tutorial (Note: this is temporary until we get a proper tutorial area):");
    			sender.sendMessage("How to use a gun:");
    			sender.sendMessage("Right Click to shoot.");
    			sender.sendMessage("On some guns, left click to activate scope.");
    			sender.sendMessage("Interact with the signs:");
    			sender.sendMessage("Right click the holograms or right click the signs.");
    			sender.sendMessage("How to capture a point:");
    			sender.sendMessage("Make sure you are on a capture point.");
    			sender.sendMessage("Then do the command /c");
    			sender.sendMessage("Check your stats: /stats");
    			sender.sendMessage("How to use an airplane:");
    			sender.sendMessage("Look where you want to go.");
    			sender.sendMessage("Do not collide with blocks!");
    			sender.sendMessage("We will be making a proper tutorial later! Check back soon!");
    			sender.sendMessage("We have a youtube tutorial!");
    			sender.sendMessage("https://www.youtube.com/watch?v=OPu2IOPBVEI");
    	}
    	if(cmd.getName().equalsIgnoreCase("spawn")){
    		lobby.LobbyInitiate(sender, cmd, label, args, "spawn");
    	}
    	if(cmd.getName().equalsIgnoreCase("town")){
    		lobby.LobbyInitiate(sender, cmd, label, args, "town");
    	}
    	if(cmd.getName().equalsIgnoreCase("island")){
    		lobby.LobbyInitiate(sender, cmd, label, args, "island");
    	}
    	if (cmd.getName().equalsIgnoreCase("kit-tier0-sniper")) { 
    		if(Constants.arena.contains(sender.getName())){
    			sender.sendMessage("You are in the arena!!!!!!!!!");
    		}
    		else{
    		kmh.Organize(sender, cmd, label, args, "tier0-sniper");
    		}
    	}
    	if (cmd.getName().equalsIgnoreCase("kit-tier0-shotgun")) { 
    		if(Constants.arena.contains(sender.getName())){
    			sender.sendMessage("You are in the arena!!!!!!!!!");
    		}
    		else{
    		kmh.Organize(sender, cmd, label, args, "tier0-shotgun");
    		}
    	}
    	if (cmd.getName().equalsIgnoreCase("kit-tier0-auto-rifle")) { 
    		if(Constants.arena.contains(sender.getName())){
    			sender.sendMessage("You are in the arena!!!!!!!!!");
    		}
    		else{
    		kmh.Organize(sender, cmd, label, args, "tier0-auto-rifle");
    		}
    	}
    	if (cmd.getName().equalsIgnoreCase("kit-tier0-special")) { 
    		if(Constants.arena.contains(sender.getName())){
    			sender.sendMessage("You are in the arena!!!!!!!!!");
    		}
    		else{
    		kmh.Organize(sender, cmd, label, args, "tier0-special");
    		}
    	}
    	if (cmd.getName().equalsIgnoreCase("kit-tier1-sniper")) { 
    		if(Constants.arena.contains(sender.getName())){
    			sender.sendMessage("You are in the arena!!!!!!!!!");
    		}
    		else{
    		kmh.Organize(sender, cmd, label, args, "tier1-sniper");
    		}
    	}
    	if (cmd.getName().equalsIgnoreCase("kit-tier1-auto-rifle")) { 
    		if(Constants.arena.contains(sender.getName())){
    			sender.sendMessage("You are in the arena!!!!!!!!!");
    		}
    		else{
    		kmh.Organize(sender, cmd, label, args, "tier1-auto-rifle");
    		}
    	}
    	if (cmd.getName().equalsIgnoreCase("kit-tier1-shotgun")) { 
    		if(Constants.arena.contains(sender.getName())){
    			sender.sendMessage("You are in the arena!!!!!!!!!");
    		}
    		else{
    		kmh.Organize(sender, cmd, label, args, "tier1-shotgun");
    		}
    	}
    	if (cmd.getName().equalsIgnoreCase("kit-tier1-special")) { 
    		if(Constants.arena.contains(sender.getName())){
    			sender.sendMessage("You are in the arena!!!!!!!!!");
    		}
    		else{
    		kmh.Organize(sender, cmd, label, args, "tier1-special");
    		}
    	}
    	if (cmd.getName().equalsIgnoreCase("kit-tier2-sniper")) { 
    		if(Constants.arena.contains(sender.getName())){
    			sender.sendMessage("You are in the arena!!!!!!!!!");
    		}
    		else{
    		kmh.Organize(sender, cmd, label, args, "tier2-sniper");
    		}
    	}
    	if (cmd.getName().equalsIgnoreCase("kit-tier2-shotgun")) { 
    		if(Constants.arena.contains(sender.getName())){
    			sender.sendMessage("You are in the arena!!!!!!!!!");
    		}
    		else{
    		kmh.Organize(sender, cmd, label, args, "tier2-shotgun");
    		}
    	}
    	if (cmd.getName().equalsIgnoreCase("kit-tier2-auto-rifle")) { 
    		if(Constants.arena.contains(sender.getName())){
    			sender.sendMessage("You are in the arena!!!!!!!!!");
    		}
    		else{
    		kmh.Organize(sender, cmd, label, args, "tier2-auto-rifle");
    		}
    	}
    	if (cmd.getName().equalsIgnoreCase("kit-tier2-special")) { 
    		if(Constants.arena.contains(sender.getName())){
    			sender.sendMessage("You are in the arena!!!!!!!!!");
    		}
    		else{
    		kmh.Organize(sender, cmd, label, args, "tier2-special");
    		}
    	}
    	if (cmd.getName().equalsIgnoreCase("kit-tier3-sniper")) { 
    		if(Constants.arena.contains(sender.getName())){
    			sender.sendMessage("You are in the arena!!!!!!!!!");
    		}
    		else{
    		kmh.Organize(sender, cmd, label, args, "tier3-sniper");
    		}
    	}
    	if (cmd.getName().equalsIgnoreCase("kit-tier3-auto-rifle")) { 
    		if(Constants.arena.contains(sender.getName())){
    			sender.sendMessage("You are in the arena!!!!!!!!!");
    		}
    		else{
    		kmh.Organize(sender, cmd, label, args, "tier3-auto-rifle");
    		}
    	}
    	if (cmd.getName().equalsIgnoreCase("kit-tier3-shotgun")) { 
    		if(Constants.arena.contains(sender.getName())){
    			sender.sendMessage("You are in the arena!!!!!!!!!");
    		}
    		else{
    		kmh.Organize(sender, cmd, label, args, "tier3-shotgun");
    		}
    	}
    	if (cmd.getName().equalsIgnoreCase("kit-tier3-special")) { 
    		if(Constants.arena.contains(sender.getName())){
    			sender.sendMessage("You are in the arena!!!!!!!!!");
    		}
    		else{
    		kmh.Organize(sender, cmd, label, args, "tier3-special");
    		}
    	}
    	if (cmd.getName().equalsIgnoreCase("kit-tier4-special")) { 
    		if(Constants.arena.contains(sender.getName())){
    			sender.sendMessage("You are in the arena!!!!!!!!!");
    		}
    		else{
    		kmh.Organize(sender, cmd, label, args, "tier4-special");
    		}
    	}
    	if (cmd.getName().equalsIgnoreCase("kit-tier4-shotgun")) { 
    		if(Constants.arena.contains(sender.getName())){
    			sender.sendMessage("You are in the arena!!!!!!!!!");
    		}
    		else{
    		kmh.Organize(sender, cmd, label, args, "tier4-shotgun");
    		}
    	}
    	if (cmd.getName().equalsIgnoreCase("kit-tier4-sniper")) { 
    		if(Constants.arena.contains(sender.getName())){
    			sender.sendMessage("You are in the arena!!!!!!!!!");
    		}
    		else{
    		kmh.Organize(sender, cmd, label, args, "tier4-sniper");
    		}
    	}
    	if (cmd.getName().equalsIgnoreCase("kit-tier4-auto-rifle")) { 
    		if(Constants.arena.contains(sender.getName())){
    			sender.sendMessage("You are in the arena!!!!!!!!!");
    		}
    		else{
    		kmh.Organize(sender, cmd, label, args, "tier4-auto-rifle");
    		}
    	}
    	if (cmd.getName().equalsIgnoreCase("admin-arena")){
    		admin.listArena(s);
    	}
    	if (cmd.getName().equalsIgnoreCase("admin-gunin")){
    		admin.listGunin(s);
    	}
    	if(cmd.getName().equalsIgnoreCase("admin-clear-arena")){
    		admin.clearArena(s);
    	}
    	if (cmd.getName().equalsIgnoreCase("admin-bt")){
    		admin.listBT(s);
    	}
    	if (cmd.getName().equalsIgnoreCase("admin-ot")){
    		admin.listOT(s);
    	}
    	if (cmd.getName().equalsIgnoreCase("switchteam") || cmd.getName().equalsIgnoreCase("st")) { 
    		tm.TeamSwitchInitiate(sender, cmd, label, args);
    	}
    	if(cmd.getName().equalsIgnoreCase("admin-givekills")){
    		admin.commandGiveKills(sender, cmd, label, args);
    	}
    	if(cmd.getName().equalsIgnoreCase("admin-takekills")){
    		admin.commandTakeKills(sender, cmd, label, args);
    	}
    	if(cmd.getName().equalsIgnoreCase("admin-givedeaths")){
    		admin.commandGiveDeaths(sender, cmd, label, args);
    	}
    	if(cmd.getName().equalsIgnoreCase("admin-takedeaths")){
    		admin.commandTakeDeaths(sender, cmd, label, args);
    	}
    	if (cmd.getName().equalsIgnoreCase("stats")) { // If the player typed /basic then do the following...
    		try{
    			sender.sendMessage("Kills = "+sr.getKills(s.getName()) + "  Deaths = "+sr.getDeaths(s.getName()));
    		}
    		catch(Exception e){
    			e.printStackTrace();
    		}
    	}
	}
}
