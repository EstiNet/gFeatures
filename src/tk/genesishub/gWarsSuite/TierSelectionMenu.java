package tk.genesishub.gWarsSuite;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitScheduler;

public class TierSelectionMenu {
	public void Initialize(PlayerInteractEvent event){
		if(!(Constants.gunin.contains(event.getPlayer().getName())) && event.getPlayer().getItemInHand().getType() == Material.CHEST){
			InventoryAPI menu = makeInventory(event.getPlayer());
			menu.open(event.getPlayer());
		}
	}
	public InventoryAPI test(Player p){
		StatsRetrieve sr = new StatsRetrieve();
		InventoryAPI menu = new InventoryAPI("My Fancy Menu", 9, new InventoryAPI.OptionClickEventHandler() {
            @Override
            public void onOptionClick(InventoryAPI.OptionClickEvent event) {
                event.getPlayer().sendMessage("You have chosen " + event.getName());
                event.setWillClose(true);
            }
        }, Bukkit.getServer().getPluginManager().getPlugin("gWarsSuite"))
		.setOption(1, new ItemStack(Material.IRON_BLOCK, 1), ChatColor.AQUA + "Tier 0", ChatColor.GOLD+"Weapons here cost 0 kills.")
	    .setOption(2, new ItemStack(Material.GOLD_BLOCK, 1), ChatColor.AQUA+"Tier 1", ChatColor.GOLD+"Weapons here cost 5 kills.")
	    .setOption(3, new ItemStack(Material.LAPIS_BLOCK, 1), ChatColor.AQUA+"Tier 2", ChatColor.GOLD+"Weapons here cost 10 kills.")
	    .setOption(4, new ItemStack(Material.DIAMOND_BLOCK, 1), "Tier 3", ChatColor.GOLD+"Weapons here cost 25 kills.")
	    .setOption(5, new ItemStack(Material.EMERALD_BLOCK, 1), "Tier 4", ChatColor.GOLD+"Weapons here cost 50 kills.")
		.setOption(8, new ItemStack(Material.EMERALD, 1), ChatColor.GREEN+"You have " + Integer.toString(sr.getKills(p.getName())) + " kills.");
		return menu;
	}
	public InventoryAPI makeInventory(final Player p){
		try{
		StatsRetrieve sr = new StatsRetrieve();
		final BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
		InventoryAPI menu = new InventoryAPI("Select Tier", 9, new InventoryAPI.OptionClickEventHandler() {
	        @Override
	        public void onOptionClick(final InventoryAPI.OptionClickEvent event) {
	            if(event.getName().equals(ChatColor.AQUA+"Tier 0")){
	            	final InventoryAPI menus = TierZeroInventory(p);
	            	event.getPlayer().closeInventory();
	                scheduler.scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gWarsSuite"), new Runnable() {
	                	public void run(){
	                		menus.open(event.getPlayer());
	                   }
	                }, 9L);
	            }
	            else if(event.getName().equals(ChatColor.AQUA+"Tier 1")){
	            	final InventoryAPI menu1 = TierOneInventory();
	            	event.getPlayer().closeInventory();
	                scheduler.scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gWarsSuite"), new Runnable() {
	                	public void run(){
	                		menu1.open(event.getPlayer());
	                   }
	                }, 9L);
	            }
	            else if(event.getName().equals(ChatColor.AQUA+"Tier 2")){
	            	final InventoryAPI menu2 = TierTwoInventory();
	            	event.getPlayer().closeInventory();
	            	scheduler.scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gWarsSuite"), new Runnable() {
	                	public void run(){
	                		menu2.open(event.getPlayer());
	                   }
	                }, 9L);
	            }
	            	else if(event.getName().equals(ChatColor.AQUA+"Tier 3")){
	            	final InventoryAPI menu3 = TierThreeInventory();
	            	event.getPlayer().closeInventory();
	            	scheduler.scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gWarsSuite"), new Runnable() {
	                	public void run(){
	                		menu3.open(event.getPlayer());
	                   }
	                }, 9L);
	        	}
	            	else if(event.getName().equals(ChatColor.AQUA+"Tier 4")){
	            	final InventoryAPI menu4 = TierFourInventory();
	            	event.getPlayer().closeInventory();
	            	scheduler.scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gWarsSuite"), new Runnable() {
	                	public void run(){
	                		menu4.open(event.getPlayer());
	                   }
	                }, 9L);
	            	}
	            event.setWillClose(true);
	        }
	    }, Bukkit.getServer().getPluginManager().getPlugin("gWarsSuite"))
    .setOption(0, new ItemStack(Material.IRON_BLOCK, 1), ChatColor.AQUA+"Tier 0", ChatColor.GOLD+"Weapons here cost 0 kills.")
    .setOption(1, new ItemStack(Material.GOLD_BLOCK, 1), ChatColor.AQUA+"Tier 1", ChatColor.GOLD+"Weapons here cost 5 kills.")
    .setOption(2, new ItemStack(Material.LAPIS_BLOCK, 1), ChatColor.AQUA+"Tier 2", ChatColor.GOLD+"Weapons here cost 10 kills.")
    .setOption(3, new ItemStack(Material.DIAMOND_BLOCK, 1), ChatColor.AQUA+"Tier 3", ChatColor.GOLD+"Weapons here cost 25 kills.")
    .setOption(4, new ItemStack(Material.EMERALD_BLOCK, 1), ChatColor.AQUA+"Tier 4", ChatColor.GOLD+"Weapons here cost 50 kills.")
	.setOption(8, new ItemStack(Material.EMERALD, 1), ChatColor.GREEN+"You have " + sr.getKills(p.getName()) + " kills.");
	return menu;
	}catch(Exception e){
		e.printStackTrace();
	}
		return null;
    }
	public InventoryAPI TierZeroInventory(Player p){
		final TierZero tz = new TierZero();
		InventoryAPI menu = new InventoryAPI("Select Type", 9, new InventoryAPI.OptionClickEventHandler() {
	        @Override
	        public void onOptionClick(InventoryAPI.OptionClickEvent event) {
	        	String chosen = event.getName();
	        	switch(chosen){
	        	case "Sniper":
	        		tz.Initialize((CommandSender)event.getPlayer(), "sniper");
	        		break;
	        	case "Auto Rifle":
	        		tz.Initialize((CommandSender)event.getPlayer(), "autorifle");
	        		break;
	        	case "Shotgun":
	        		tz.Initialize((CommandSender)event.getPlayer(), "shotgun");
	        		break;
	        	case "Special":
	        		tz.Initialize((CommandSender)event.getPlayer(), "special");
	        		break;
	        	}
	            event.setWillClose(true);
	        }
	    }, Bukkit.getServer().getPluginManager().getPlugin("gWarsSuite"))
    .setOption(1, new ItemStack(Material.WOOD_PICKAXE, 1), ChatColor.DARK_AQUA+"Sniper", ChatColor.WHITE+"Classic Sniper.")
    .setOption(2, new ItemStack(Material.WOOD_AXE, 1), ChatColor.DARK_AQUA+"Auto Rifle", ChatColor.WHITE+"Classic Auto Rifle.")
    .setOption(3, new ItemStack(Material.WOOD_SPADE, 1), ChatColor.DARK_AQUA+"Shotgun", ChatColor.WHITE+"Classic Shotgun.")
	.setOption(4, new ItemStack(Material.WOOD_SWORD, 1), ChatColor.DARK_AQUA+"Special", ChatColor.WHITE+"More health, less damage.");
	return menu;
	}
	public InventoryAPI TierOneInventory(){
		final TierOne to = new TierOne();
		InventoryAPI menu = new InventoryAPI("Select Type", 9, new InventoryAPI.OptionClickEventHandler() {
	        @Override
	        public void onOptionClick(InventoryAPI.OptionClickEvent event) {
	        	String chosen = event.getName();
	        	switch(chosen){
	        	case "Sniper":
	        		to.Initialize((CommandSender)event.getPlayer(), "sniper");
	        		break;
	        	case "Auto Rifle":
	        		to.Initialize((CommandSender)event.getPlayer(), "autorifle");
	        		break;
	        	case "Shotgun":
	        		to.Initialize((CommandSender)event.getPlayer(), "shotgun");
	        		break;
	        	case "Special":
	        		to.Initialize((CommandSender)event.getPlayer(), "special");
	        		break;
	        	}
	            event.setWillClose(true);
	        }
	    }, Bukkit.getServer().getPluginManager().getPlugin("gWarsSuite"))
    .setOption(1, new ItemStack(Material.WOOD_PICKAXE, 1), ChatColor.DARK_AQUA+"Sniper", ChatColor.WHITE+"ULR338")
    .setOption(2, new ItemStack(Material.WOOD_AXE, 1), ChatColor.DARK_AQUA+"Auto Rifle", ChatColor.WHITE+"m16")
    .setOption(3, new ItemStack(Material.WOOD_SPADE, 1), ChatColor.DARK_AQUA+"Shotgun", ChatColor.WHITE+"Colt Model 1")
	.setOption(4, new ItemStack(Material.WOOD_SWORD, 1), ChatColor.DARK_AQUA+"Special", ChatColor.WHITE+"Bazooka");
	return menu;
	}
	public InventoryAPI TierTwoInventory(){
		final TierTwo tz = new TierTwo();
		InventoryAPI menu = new InventoryAPI("Select Type", 9, new InventoryAPI.OptionClickEventHandler() {
	        @Override
	        public void onOptionClick(InventoryAPI.OptionClickEvent event) {
	        	String chosen = event.getName();
	        	switch(chosen){
	        	case "Sniper":
	        		tz.Initialize((CommandSender)event.getPlayer(), "sniper");
	        		break;
	        	case "Auto Rifle":
	        		tz.Initialize((CommandSender)event.getPlayer(), "autorifle");
	        		break;
	        	case "Shotgun":
	        		tz.Initialize((CommandSender)event.getPlayer(), "shotgun");
	        		break;
	        	case "Special":
	        		tz.Initialize((CommandSender)event.getPlayer(), "special");
	        		break;
	        	}
	            event.setWillClose(true);
	        }
	    }, Bukkit.getServer().getPluginManager().getPlugin("gWarsSuite"))
    .setOption(1, new ItemStack(Material.WOOD_PICKAXE, 1), ChatColor.DARK_AQUA+"Sniper", ChatColor.WHITE+"SilSil69")
    .setOption(2, new ItemStack(Material.WOOD_AXE, 1), ChatColor.DARK_AQUA+"Auto Rifle", ChatColor.WHITE+"AK47-Black Edition")
    .setOption(3, new ItemStack(Material.WOOD_SPADE, 1), ChatColor.DARK_AQUA+"Shotgun", ChatColor.WHITE+"SPAS")
	.setOption(4, new ItemStack(Material.WOOD_SWORD, 1), ChatColor.DARK_AQUA+"Special", ChatColor.WHITE+"Flamethrower");
	return menu;
	}
	public InventoryAPI TierThreeInventory(){
		final TierThree tz = new TierThree();
		InventoryAPI menu = new InventoryAPI("Select Type", 9, new InventoryAPI.OptionClickEventHandler() {
	        @Override
	        public void onOptionClick(InventoryAPI.OptionClickEvent event) {
	        	String chosen = event.getName();
	        	switch(chosen){
	        	case "Sniper":
	        		tz.Initialize((CommandSender)event.getPlayer(), "sniper");
	        		break;
	        	case "Auto Rifle":
	        		tz.Initialize((CommandSender)event.getPlayer(), "autorifle");
	        		break;
	        	case "Shotgun":
	        		tz.Initialize((CommandSender)event.getPlayer(), "shotgun");
	        		break;
	        	case "Special":
	        		tz.Initialize((CommandSender)event.getPlayer(), "special");
	        		break;
	        	}
	            event.setWillClose(true);
	        }
	    }, Bukkit.getServer().getPluginManager().getPlugin("gWarsSuite"))
    .setOption(1, new ItemStack(Material.WOOD_PICKAXE, 1), ChatColor.DARK_AQUA+"Sniper", ChatColor.WHITE+"Classic Sniper.")
    .setOption(2, new ItemStack(Material.WOOD_AXE, 1), ChatColor.DARK_AQUA+"Auto Rifle", ChatColor.WHITE+"Classic Auto Rifle.")
    .setOption(3, new ItemStack(Material.WOOD_SPADE, 1), ChatColor.DARK_AQUA+"Shotgun", ChatColor.WHITE+"Classic Shotgun.")
	.setOption(4, new ItemStack(Material.WOOD_SWORD, 1), ChatColor.DARK_AQUA+"Special", ChatColor.WHITE+"More health, less damage.");
	return menu;
	}
	public InventoryAPI TierFourInventory(){
		final TierFour tz = new TierFour();
		InventoryAPI menu = new InventoryAPI("Select Type", 9, new InventoryAPI.OptionClickEventHandler() {
	        @Override
	        public void onOptionClick(InventoryAPI.OptionClickEvent event) {
	        	String chosen = event.getName();
	        	switch(chosen){
	        	case "Sniper":
	        		tz.Initialize((CommandSender)event.getPlayer(), "sniper");
	        		break;
	        	case "Auto Rifle":
	        		tz.Initialize((CommandSender)event.getPlayer(), "autorifle");
	        		break;
	        	case "Shotgun":
	        		tz.Initialize((CommandSender)event.getPlayer(), "shotgun");
	        		break;
	        	case "Special":
	        		tz.Initialize((CommandSender)event.getPlayer(), "special");
	        		break;
	        	}
	            event.setWillClose(true);
	        }
	    }, Bukkit.getServer().getPluginManager().getPlugin("gWarsSuite"))
    .setOption(1, new ItemStack(Material.WOOD_PICKAXE, 1), ChatColor.DARK_AQUA+"Sniper", ChatColor.WHITE+"Classic Sniper.")
    .setOption(2, new ItemStack(Material.WOOD_AXE, 1), ChatColor.DARK_AQUA+"Auto Rifle", ChatColor.WHITE+"Classic Auto Rifle.")
    .setOption(3, new ItemStack(Material.WOOD_SPADE, 1), ChatColor.DARK_AQUA+"Shotgun", ChatColor.WHITE+"Classic Shotgun.")
	.setOption(4, new ItemStack(Material.WOOD_SWORD, 1), ChatColor.DARK_AQUA+"Special", ChatColor.WHITE+"More health, less damage.");
	return menu;
	}
}
