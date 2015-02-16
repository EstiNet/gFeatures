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
	Constants cons = new Constants();
	public void Initialize(Player p){
		if(p.getItemInHand().getType() == Material.CHEST && Constants.arena.contains(p.getName())){
			InventoryAPI menu = makeInventory(p);
			menu.open(p);
		}
	}
	public InventoryAPI makeInventory(final Player p){
		try{
		InventoryAPI menu = new InventoryAPI("Game Menu", 9, new InventoryAPI.OptionClickEventHandler() {
	        @Override
	        public void onOptionClick(final InventoryAPI.OptionClickEvent event) {
	            if(event.getName().equals(ChatColor.GOLD+"Summon Airplane")){
	            	if(!(Constants.airplaneline.contains(p.getName()))){
	            	summon.Initialize(p, "airplane");
	            	BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
	            	Constants.airplaneline.add(p.getName());
	                scheduler.scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gWarsSuite"), new Runnable() {
	                	public void run(){
	                   cons.removeAirplaneline(p);
	                   }
	                }, 200L);
	            	}
	            	event.getPlayer().closeInventory();
	            }
	            else if(event.getName().equals(ChatColor.GOLD+"Summon Boat")){
		            	if(!(Constants.airplaneline.contains(p.getName()))){
		            	summon.Initialize(p, "boat");
		            	BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
		            	Constants.airplaneline.add(p.getName());
		                scheduler.scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gWarsSuite"), new Runnable() {
		                	public void run(){
		                   cons.removeAirplaneline(p);
		                   }
		                }, 200L);
		            }
		           event.getPlayer().closeInventory();
		      }
	            event.setWillClose(true);
	        }
	    }, Bukkit.getServer().getPluginManager().getPlugin("gWarsSuite"))
    .setOption(0, new ItemStack(Material.MINECART, 1), ChatColor.GOLD+"Summon Airplane", ChatColor.WHITE+"Stand close to an airfield!")
    .setOption(1, new ItemStack(Material.MINECART, 1), ChatColor.GOLD+"Summon Anti Aircraft Guns", ChatColor.WHITE+"Stand close to an Anti-Aircraft Station!")
    .setOption(2, new ItemStack(Material.BOAT, 1), ChatColor.GOLD+"Summon Boat", "Stand close to the docks!")
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
