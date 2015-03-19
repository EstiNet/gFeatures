package tk.genesishub.gFeatures.gFactions;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.mewin.WGRegionEvents.events.RegionEnterEvent;
import com.mewin.WGRegionEvents.events.RegionLeaveEvent;

public class PreventAutoClaim {
	public void Initialize(RegionEnterEvent event){
		Player p = event.getPlayer();
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add -factions.*");
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add factions.create");
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add factions.demote*");
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add factions.description*");
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add factions.disband");
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add factions.faction");
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add factions.home");
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add factions.invite");
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add factions.join");
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add factions.leader");
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add factions.money");
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add factions.list");
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add factions.leave");
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add factions.open");
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add factions.player");
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add factions.motd");
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add factions.promote");
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add factions.relation");
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add factions.name");
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add -factions.*");
	}
	public void Initialize(RegionLeaveEvent event){
		Player p = event.getPlayer();
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " remove -factions.*");
	}
}
