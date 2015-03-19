package tk.genesishub.gFeatures.gFactions;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class Camera {
	public void Tutorial(final Player p){
		p.hidePlayer(p);
		for(World world : Bukkit.getServer().getWorlds()){
			Bukkit.getLogger().info(world.getName());
		}
		World world = Bukkit.getServer().getWorld("Factions1.8.3");
		Location loc = new Location(world, 44.3, 206, -167);
		loc.setPitch(-317.2F);
		loc.setYaw(10.8F);
		final Location loc1 = new Location(world,36.6,223.2,-129.5);
		loc.setPitch(-297.3F);
		loc.setYaw(32.0F);
		final Location loc2 = new Location(world,44,230.3,-110.8);
		loc.setPitch(-252.1F);
		loc.setYaw(33.8F);
		final Location loc3 = new Location(world,-1.8,230.3,-89.7);
		loc.setPitch(-85.8F);
		loc.setYaw(30.2F);
		final Location loc4 = new Location(world,8.4,230.3,-71.5);
		loc.setPitch(-19F);
		loc.setYaw(39.2F);
		final Location loc5 = new Location(world,-2.3,225,-60.3);
		loc.setPitch(-304.2F);
		loc.setYaw(61.8F);
		final Location loc6 = new Location(world,-37.4,216,-36.6);
		loc.setPitch(-304.2F);
		loc.setYaw(61.8F);
		final Location loc7 = new Location(world,-62.8,201.0,-19.7);
		loc.setPitch(-304.0F);
		loc.setYaw(79.3F);
		final Location loc8 = new Location(world,-83.3,174.1,-4.1);
		loc.setPitch(-299.5F);
		loc.setYaw(56.9F);
		final Location loc9 = new Location(world,-102,131,10.7);
		loc.setPitch(-300.7F);
		loc.setYaw(60.6F);
		final Location loc10 = new Location(world,-108.5,104,14.5);
		loc.setPitch(-301.6F);
		loc.setYaw(41.7F);
		final Location loc11 = new Location(world,-121.3,73.6,21.3);
		loc.setPitch(-291.1F);
		loc.setYaw(12.3F);
		final Location loc12 = new Location(world,-121.4,73.6,21.4);
		loc.setPitch(-22.3F);
		loc.setYaw(9.6F);
		final Location loc13 = new Location(world,-116.3,73.6,31.9);
		loc.setPitch(-64.5F);
		loc.setYaw(32.7F);
		final Location loc14 = new Location(world,-100.1,66.1,39.7);
		loc.setPitch(-190.2F);
		loc.setYaw(15.6F);
		final Location loc15 = new Location(world,-101.2,66,37.9);
		loc.setPitch(-239.8F);
		loc.setYaw(-12.1F);
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add camerastudio");
		p.sendMessage(ChatColor.AQUA + "____" + ChatColor.GOLD + "Tutorial" + ChatColor.AQUA + "____");
		p.sendMessage(ChatColor.DARK_AQUA + "Welcome to GenesisHub " + ChatColor.RED + " Factions" + ChatColor.DARK_AQUA + "!");
		p.sendMessage(ChatColor.DARK_AQUA + "Before we begin, we are going to setup the tutorial. This may take up to 20 seconds.!");
		p.sendMessage(ChatColor.DARK_AQUA + "During this time you will be teleported and you will be executing some commands!");
		//SETUP
		p.teleport(loc);
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "sudo " + p.getName() + " cam p");
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
        	public void run(){
		p.teleport(loc1);
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "sudo " + p.getName() + " cam p");
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
        	public void run(){
		p.teleport(loc2);
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "sudo " + p.getName() + " cam p");
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
        	public void run(){
		p.teleport(loc3);
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "sudo " + p.getName() + " cam p");
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
        	public void run(){
		p.teleport(loc4);
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "sudo " + p.getName() + " cam p");
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
        	public void run(){
		p.teleport(loc5);
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "sudo " + p.getName() + " cam p");
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
        	public void run(){
		p.teleport(loc6);
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "sudo " + p.getName() + " cam p");
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
        	public void run(){
		p.teleport(loc7);
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "sudo " + p.getName() + " cam p");
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
        	public void run(){
		p.teleport(loc8);
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "sudo " + p.getName() + " cam p");
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
        	public void run(){
		p.teleport(loc9);
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "sudo " + p.getName() + " cam p");
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
        	public void run(){
		p.teleport(loc10);
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "sudo " + p.getName() + " cam p");
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
        	public void run(){
		p.teleport(loc11);
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "sudo " + p.getName() + " cam p");
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
        	public void run(){
		p.teleport(loc12);
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "sudo " + p.getName() + " cam p");
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
        	public void run(){
        		p.teleport(loc13);
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "sudo " + p.getName() + " cam p");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
	        	public void run(){
			p.teleport(loc14);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
	        	public void run(){
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "sudo " + p.getName() + " cam p");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
	        	public void run(){
			p.teleport(loc15);
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "sudo " + p.getName() + " cam p");
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "sudo " + p.getName() + " cam start 2m");
	        	}
			}, 100L);
	        	}
			}, 100L);
	        	}
			}, 100L);
	        	}
			}, 100L);
	        	}
			}, 100L);
	        	}
			}, 100L);
	        	}
			}, 60L);
	        	}
			}, 60L);
	        	}
			}, 60L);
	        	}
			}, 60L);
	        	}
			}, 60L);
	        	}
			}, 60L);
	        	}
			}, 60L);
	        	}
			}, 60L);
	        	}
			}, 60L);
	        	}
			}, 60L);
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
        	public void run(){
		p.sendMessage(ChatColor.AQUA + "____" + ChatColor.GOLD + "Tutorial" + ChatColor.AQUA + "____");
		p.sendMessage(ChatColor.DARK_AQUA + "Done! Let's get started!");
		p.sendMessage(ChatColor.DARK_AQUA + "Now, this is our spawn.");
		p.sendMessage(ChatColor.DARK_AQUA + "We'll be hovering here for a while.");
		p.sendMessage(ChatColor.DARK_AQUA + "Sit back and enjoy the ride!");
		p.sendMessage(ChatColor.AQUA + "____" + ChatColor.GOLD + "Tutorial" + ChatColor.AQUA + "____");
		p.showPlayer(p);
        	}
		}, 60L * 16);
	}
}
