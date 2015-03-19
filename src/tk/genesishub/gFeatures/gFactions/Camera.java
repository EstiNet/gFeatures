package tk.genesishub.gFeatures.gFactions;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class Camera {
	public void Tutorial(Player p){
		World world = Bukkit.getServer().getWorld("Factions1.8.3");
		Location loc = new Location(world, -95, 71, 51);
		p.sendMessage(ChatColor.AQUA + "____" + ChatColor.GOLD + "Tutorial" + ChatColor.AQUA + "____");
		p.sendMessage(ChatColor.DARK_AQUA + "Welcome to GenesisHub " + ChatColor.RED + " Factions" + ChatColor.DARK_AQUA + "!");
		p.sendMessage(ChatColor.DARK_AQUA + "Let's get started!");
		p.sendMessage(ChatColor.DARK_AQUA + "Now, this is our spawn.");
		p.sendMessage(ChatColor.DARK_AQUA + "We'll be hovering here for a while.");
		p.sendMessage(ChatColor.AQUA + "____" + ChatColor.GOLD + "Tutorial" + ChatColor.AQUA + "____");
	}
}
