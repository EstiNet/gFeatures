package net.estinet.gFeatures.Utility.EstiJoin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import net.estinet.gFeatures.Retrieval;
import net.estinet.gFeatures.gUtility;
import net.estinet.gFeatures.Feature.gRanks.Retrieve;

public class EstiJoin extends gUtility{
	
	public EstiJoin(String featurename, String d) {
		super(featurename, d);
	}
	@Override
	public void enable(){
		Bukkit.getLogger().info("[EstiJoin] Enabled.");
	}
	@Override
	public void disable(){
		Bukkit.getLogger().info("[EstiJoin] Disabled.");
	}
	@Override
	public void eventTrigger(Event event) {
		if(event.getEventName().equalsIgnoreCase("playerjoinevent")){
			PlayerJoinEvent e = (PlayerJoinEvent) event;
			Thread thr = new Thread(new Runnable(){
				public void run(){
				try{
				Retrieve r = new Retrieve();
				String prefixs = net.estinet.gFeatures.Feature.gRanks.Basis.getRank(r.getRank(e.getPlayer())).getPrefix();
				String prefix = prefixs.replace('&', '§');
				e.setJoinMessage(ChatColor.GOLD + "[" + ChatColor.DARK_AQUA + "Join" + ChatColor.GOLD + "]" + ChatColor.RESET + " " + prefix + "" + ChatColor.WHITE + e.getPlayer().getName());
				}
				catch(Exception es){
					e.setJoinMessage(ChatColor.GOLD + "[" + ChatColor.DARK_AQUA + "Join" + ChatColor.GOLD + "]" + ChatColor.RESET + " " + ChatColor.WHITE + e.getPlayer().getName());
				}
				}
				});
				thr.start();
		}
		else if(event.getEventName().equalsIgnoreCase("playerquitevent")){
			PlayerQuitEvent e = (PlayerQuitEvent) event;
			try{
				Retrieve r = new Retrieve();
				String prefixs = net.estinet.gFeatures.Feature.gRanks.Basis.getRank(r.getRank(e.getPlayer())).getPrefix();
				String prefix = prefixs.replace('&', '§');
				e.setQuitMessage(ChatColor.GOLD + "[" + ChatColor.DARK_AQUA + "Leave" + ChatColor.GOLD + "]" + ChatColor.RESET + " " + prefix + "" + ChatColor.WHITE + e.getPlayer().getName());
				}
				catch(Exception es){
					e.setQuitMessage(ChatColor.GOLD + "[" + ChatColor.DARK_AQUA + "Leave" + ChatColor.GOLD + "]" + ChatColor.RESET + " " + ChatColor.WHITE + e.getPlayer().getName());
				}
		}
	}
	@Override
	@Retrieval
	public void onPlayerJoin(){}
	@Override
	@Retrieval
	public void onPlayerLeave(){}
	@Override
	public void commandTrigger(CommandSender sender, Command cmd, String label, String[] args) {}
}
