package net.genesishub.gFeatures.Feature.gHub;

import net.genesishub.gFeatures.Command.RegisterCommand;
import net.genesishub.gFeatures.Command.gCommand;
import net.genesishub.gFeatures.Feature.gHub.command.Spawn;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.CommandExecutor;

public class Enable {
	public void onEnable(){
		Bukkit.getLogger().info("[gHub] gHub is enabled! Hi!");
		Bukkit.getServer().setDefaultGameMode(GameMode.ADVENTURE);
		RegisterCommand rc = new RegisterCommand();
		rc.register(new Spawn(), "spawn");
	}
}
