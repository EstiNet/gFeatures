package net.genesishub.gFeatures.Feature.gHub;

import net.genesishub.gFeatures.Basic;
import net.genesishub.gFeatures.Command.RegisterCommand;
import net.genesishub.gFeatures.Feature.gHub.command.Spawn;
import net.genesishub.gFeatures.Feature.gHub.config.gHubConfig;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;

public class Enable {
	public void onEnable(){
		Bukkit.getLogger().info("[gHub] gHub is enabled! Hi!");
		Bukkit.getServer().setDefaultGameMode(GameMode.ADVENTURE);
		RegisterCommand rc = new RegisterCommand();
		rc.register(new Spawn(), "spawn");
		gHubConfig ghc = new gHubConfig();
		ghc.setup();
		
		Basic.addPlayerSection("Settings", "");
		Basic.addPlayerSection("Settings.showChat", "true");
		/*Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
        	public void run(){
        		PreventFall pf = new PreventFall();
        		pf.check();
        	}
        }, 40L, 40L);*/
	}
}
