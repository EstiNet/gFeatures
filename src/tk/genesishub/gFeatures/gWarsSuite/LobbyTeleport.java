package tk.genesishub.gFeatures.gWarsSuite;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class LobbyTeleport {
	Lobby lobby = new Lobby();
	public void Initalize(PlayerMoveEvent event){
		Player player = event.getPlayer();
		CommandSender sender = (CommandSender)player;
		World world = Bukkit.getServer().getWorld("gWars");
		Location loc = event.getPlayer().getLocation();
		int x = (int) loc.getX();
		int z = (int) loc.getZ();
		if(x == 134 && z == 291){
			//airfield
			lobby.Initiate(421, 5, 201, 89.998, 1.95, 575, 1, 131, 269.849, -0.3, event.getPlayer(), (CommandSender)event.getPlayer());
		}
		else if(x == 125 && z == 287){
			//underground
			lobby.Initiate(422, 2, 225, 89.545, 6.45, 569, 2, 107, 271.795, -12.45, event.getPlayer(), (CommandSender)event.getPlayer());
		}
		else if(x == 125 && z == 282){
			//mainfloor
			lobby.Initiate(433, 5, 225, 89.545, 6.45, 557, 5, 107, 271.795, -12.45, event.getPlayer(), (CommandSender)event.getPlayer());
		}
		else if(x == 125 && z == 277){
			//turrets
			lobby.Initiate(426, 15, 225, 89.545, 6.45, 555, 15, 107, 89.545, -6.45, event.getPlayer(), (CommandSender)event.getPlayer());
		}
		else if(x == 134 && z == 273){
			//town
			ItemStack chest = new ItemStack(Material.CHEST, 1);
            ItemMeta im = chest.getItemMeta();
            im.setDisplayName(ChatColor.AQUA + "Game Menu");
            chest.setItemMeta(im);
            
			if(Constants.arena.contains(player.getName())){
	    		sender.sendMessage("You are in the arena!");
	    		}
	    		else{
	    		if(Constants.ot.contains(player.getName())){
	    		Block block = world.getBlockAt(223, 3, 168);
	    		if(block.getType() == Material.GRASS){
	    		Constants.arena.add(player.getName());
	    		double x1 = 496;
	    		double y1 = 5;
	    		double z1 = 175;
	    		Location e = new Location(player.getWorld(), x1, y1, z1);
	    		player.teleport(e);
	    		player.getLocation().setYaw((float) 178.803);
	    		player.getLocation().setPitch((float) -1.8);
	    		player.getInventory().addItem(chest);
	    		}
	    		else{
	    			sender.sendMessage("Your team didn't capture the town yet!");
	    		}
	    		}
	    		else if(Constants.bt.contains(player.getName())){
	    		Block block = world.getBlockAt(223, 3, 168);
	    		if(block.getType() == Material.STONE){
	    		Constants.arena.add(player.getName());
	    		double x1 = 496;
	        	double y1 = 5;
	        	double z1 = 175;
	        	Location e = new Location(player.getWorld(), x1, y1, z1);
	        	player.teleport(e);
	        	player.getLocation().setYaw((float) 178.803);
	        	player.getLocation().setPitch((float) -1.8);
	        	player.getInventory().addItem(chest);
	    		}
	    		else{
	    		sender.sendMessage("Your team didn't capture the town yet!");
	    		}
	    		}
	    		}
		}
		else if(x ==  143 && z == 282){
			//island
			if(Constants.arena.contains(player.getName())){
	    		sender.sendMessage("You are in the arena!");
	    		}
	    		else{
	    		if(Constants.ot.contains(player.getName())){
	    		Block block = world.getBlockAt(223, 3, 169);
	    		if(block.getType() == Material.GRASS){
	    		Constants.arena.add(player.getName());
	    		double x1 = 551;
	    		double y1 = 5;
	    		double z1 = 420;
	    		Location e = new Location(player.getWorld(), x1, y1, z1);
	    		player.teleport(e);
	    		player.getLocation().setYaw((float) 179.999);
	    		player.getLocation().setPitch((float) -2.1);
	    		ItemStack chest1 = new ItemStack(Material.CHEST, 1);
	            ItemMeta im1 = chest1.getItemMeta();
	            im1.setDisplayName(Color.AQUA + "Game Menu");
	            chest1.setItemMeta(im1);
	    		player.getInventory().addItem(chest1);
	    		}
	    		else{
	    			sender.sendMessage("Your team didn't capture the island yet!");
	    		}
	    		}
	    		else if(Constants.bt.contains(player.getName())){
	    		Block block = world.getBlockAt(223, 3, 169);
	    		if(block.getType() == Material.STONE){
	    		Constants.arena.add(player.getName());
	    		double x1 = 551;
	        	double y1 = 5;
	        	double z1 = 420;
	        	Location e = new Location(player.getWorld(), x1, y1, z1);
	        	player.teleport(e);
	        	player.getLocation().setYaw((float) 179.999);
	        	player.getLocation().setPitch((float) -2.1);
	        	ItemStack chest2 = new ItemStack(Material.CHEST, 1);
	            ItemMeta im2 = chest2.getItemMeta();
	            im2.setDisplayName(ChatColor.AQUA + "Select Gun");
	            chest2.setItemMeta(im2);
	        	player.getInventory().addItem(chest2);
	    		}
	    		else{
	    		sender.sendMessage("Your team didn't capture the island yet!");
	    		}
	    		}
	    		}
		}
	}
}
