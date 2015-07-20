package net.genesishub.gFeatures.Utility.gMotd;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerJoinEvent;

import net.genesishub.gFeatures.Retrieval;
import net.genesishub.gFeatures.gUtility;

public class gMotd extends gUtility{
	
	public gMotd(String featurename, String d) {
		super(featurename, d);
	}
	@Override
	public void enable(){
		YMLSetter ymls = new YMLSetter();
		ymls.enableCheck();
		Bukkit.getLogger().info("[gMotd] Enabled.");
	}
	@Override
	public void disable(){
		Bukkit.getLogger().info("[gMotd] Disabled.");
	}
	@Override
	public void eventTrigger(Event event) {
		if(event.getEventName().equalsIgnoreCase("playerjoinevent")){
			PlayerJoinEvent events = (PlayerJoinEvent) event;
			events.getPlayer().sendMessage(YMLSetter.getMotd());
		}
	}
	@Retrieval
	public void onPlayerJoin(){}
	@Override
	public void commandTrigger(CommandSender sender, Command cmd, String label, String[] args) {}
}
