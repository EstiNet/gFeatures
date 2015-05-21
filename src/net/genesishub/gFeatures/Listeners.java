package net.genesishub.gFeatures;

import net.genesishub.gFeatures.API.PlayerStats.ConfigHub;
import net.genesishub.gFeatures.Configuration.LoadConfig;
import net.genesishub.gFeatures.Configuration.SetupConfig;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.shampaggon.crackshot.events.WeaponDamageEntityEvent;

public class Listeners extends JavaPlugin implements Listener{
	public static final String version = "2.2.2";
	
	PluginManager pm = getServer().getPluginManager();
	Enabler enable = new Enabler();
	Disabler disable = new Disabler();
	Library library = new Library();
	CommandLibrary commands = new CommandLibrary();
	Setup setup = new Setup();
	ConfigHub ch = new ConfigHub();
	
	@Override
	public void onEnable(){
	    pm.registerEvents(this, this);
		getLogger().info("_________________________________________________________________________");
		getLogger().info("[gFeatures] gFeatures enabled!");
		getLogger().info("[gFeatures] This gFeatures installation is running core: " + version);
		getLogger().info("[gFeatures] Turning on Features...");
		setup.onSetup();
		SetupConfig.setup();
		LoadConfig.load();
		enable.onEnable();
		ch.setupConfig();
		ch.loadConfig();
		getLogger().info("[gFeatures] Complete!");
		getLogger().info("_________________________________________________________________________");
	}
	@Override
	public void onDisable(){
		getLogger().info("_________________________________________________________________________");
		getLogger().info("[gFeatures] gFeatures disabled!");
		getLogger().info("[gFeatures] This gFeatures installation is running core: " + version);
		getLogger().info("[gFeatures] Turning off Features...");
		disable.onDisable();
		getLogger().info("[gFeatures] Complete!");
		getLogger().info("_________________________________________________________________________");
	}
	@EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
    	library.onPlayerJoin(event);
    	ch.addPlayerSection(event.getPlayer());
    	Basic.getgPlayer(event.getPlayer().getName()).setPlayer(event.getPlayer());
    }
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event){
    	library.onPlayerLeave(event);
    }
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event){
    	library.onPlayerMove(event);
    }
    @EventHandler(priority=EventPriority.HIGHEST)
    public void onPlayerRespawn(PlayerRespawnEvent event){
    	library.onPlayerRespawn(event);
    }
    @EventHandler
    public void onDeath(PlayerDeathEvent event){
    	library.onPlayerDeath(event);
    }
    @EventHandler
    public void onHit(EntityDamageByEntityEvent event) {
    	library.onEntityDamageByEntity(event);
    }
    @EventHandler
    public void onHit1(WeaponDamageEntityEvent event) {
        library.onWeaponDamageEntity(event);
    }
    @EventHandler
    public void PlayerInteract(PlayerInteractEvent event){
        library.onPlayerInteract(event);
    }
    @EventHandler
    public void PlayerBreakBlock(BlockBreakEvent event){
    	library.onPlayerBreakBlock(event);
    }
    @EventHandler
    public void PlayerChatEvent(AsyncPlayerChatEvent event){
    	library.onPlayerChat(event);
    }
    @EventHandler
    public void PlayerCommandEvent(PlayerCommandPreprocessEvent event){
    	library.onPlayerCommand(event);
    }
    @Override
    public boolean onCommand(final CommandSender sender, Command cmd, String label, String[] args) {
    	commands.Commands(sender, cmd, label, args);
        return true;
    }
}
