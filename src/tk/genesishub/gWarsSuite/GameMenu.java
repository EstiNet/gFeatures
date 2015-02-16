package tk.genesishub.gWarsSuite;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitScheduler;

public class GameMenu {
	Summon summon = new Summon();
	TeamManager tm = new TeamManager();
	public void Initialize(Player p){
		if(p.getItemInHand().getType() == Material.CHEST && Constants.arena.contains(p.getName())){
			InventoryAPI menu = makeInventory(p);
			menu.open(p);
		}
	}
	public InventoryAPI makeInventory(final Player p){
		try{
		InventoryAPI menu = new InventoryAPI("Select Tier", 9, new InventoryAPI.OptionClickEventHandler() {
	        @Override
	        public void onOptionClick(final InventoryAPI.OptionClickEvent event) {
	            if(event.getName().equals(ChatColor.GOLD+"Summon Airplane")){
	            	if(!(Constants.airplaneline.contains(p.getName()))){
	            	summon.Initialize(p, "Airplane");
	            	BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
	            	Constants.airplaneline.add(p.getName());
	                scheduler.scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gWarsSuite"), new Runnable() {
	                	public void run(){
	                   Constants.airplaneline.remove(p.getName());
	                   }
	                }, 600L);
	            	}
	            	else{
	            		event.getPlayer().sendMessage(ChatColor.BOLD+"You cannot summon airplanes within 30 seconds of each other!");
	            	}
	            	event.getPlayer().closeInventory();
	            }
	            event.setWillClose(true);
	        }
	    }, Bukkit.getServer().getPluginManager().getPlugin("gWarsSuite"))
    .setOption(0, new ItemStack(Material.MINECART, 1), ChatColor.GOLD+"Summon Airplane", ChatColor.WHITE+"Stand close to an airfield!")
    .setOption(1, new ItemStack(Material.GOLD_BLOCK, 1), "Tier 1", "Weapons here cost 5 kills.")
    .setOption(2, new ItemStack(Material.LAPIS_BLOCK, 1), "Tier 2", "Weapons here cost 10 kills.")
    .setOption(3, new ItemStack(Material.DIAMOND_BLOCK, 1), "Tier 3", "Weapons here cost 25 kills.")
    .setOption(4, new ItemStack(Material.EMERALD_BLOCK, 1), "Tier 4", "Weapons here cost 50 kills.")
	.setOption(8, new ItemStack(Material.EMERALD, 1), ChatColor.GRAY+"The nearest player to you is " + getNearest(p, 10000.000).getName() + " from the " + tm.getTeam(p.getName()) + " team!");
	return menu;
	}catch(Exception e){
		e.printStackTrace();
	}
		return null;
    }
	public Player getNearest(Player p, Double range) {
        double distance = Double.POSITIVE_INFINITY; // To make sure the first
                                                    // player checked is closest
        Player target = p;
        for (Entity e : p.getNearbyEntities(range, range, range)) {
            if (!(e instanceof Player))
                continue;
            double distanceto = p.getLocation().distance(e.getLocation());
            if (distanceto > distance)
                continue;
            distance = distanceto;
            target = (Player) e;
        }
        return target;
    }
}
