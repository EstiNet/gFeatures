package tk.genesishub.gFeatures.GenesisAccess;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.PluginManager;

public class Main {
	File f = new File("GenesisAccess/chat.txt");
    public void onEnable() { //What to do on server load/reload
        Bukkit.getLogger().info("GenesisAccess 1.0 is enabled. All clear for take off!");
        int num = 0;
        boolean b = false;
    	while(b == false){
        if(!f.exists()){
	         try {
	        	 Bukkit.getLogger().info("Creating a new file...");
	        	 b=true;
	        	 f.createNewFile();
	         }
	         catch(Exception e){
	        	 Bukkit.getLogger().info("File could not be created.");	 
	         }
	         }
        
    	else{
    		num += 1;
    		f=new File("GenesisAccess/chat"+num+".txt");
    	}
        }
        }
    public void onDisable() { //What to do on server unload/reload
       Bukkit.getLogger().info("GenesisAccess is disabled. Bye!");
    }
    @EventHandler
    public void PlayerChatEvent(AsyncPlayerChatEvent e){
   	 String message = e.getMessage();
   	 String playername = e.getPlayer().getName();
   	 BufferedWriter output;
		try {
			output = new BufferedWriter(new FileWriter(f, true));
			output.write(playername + ": " + message +"\n");
			output.newLine();
        output.close();
		}
		catch(Exception e1){
			Bukkit.getLogger().info("UHOH");
		}
    }
    @EventHandler
    public void PlayerCommandEvent(PlayerCommandPreprocessEvent e){
   	 String message = e.getMessage();
   	 String playername = e.getPlayer().getName();
   	 BufferedWriter output;
		try {
			output = new BufferedWriter(new FileWriter(f, true));
			output.write(playername + ": executed command " + message +"\n");
			output.newLine();
        output.close();
		}
		catch(Exception e1){
			Bukkit.getLogger().info("UHOH");
		}
    }
    @EventHandler
    public void PlayerJoinEvent(PlayerLoginEvent e){
   	 String playername = e.getPlayer().getName();
   	 BufferedWriter output;
		try {
			output = new BufferedWriter(new FileWriter(f, true));
			output.write(playername + ": joined the game");
			output.newLine();
        output.close();
		}
		catch(Exception e1){
			Bukkit.getLogger().info("UHOH");
		}
    }

    @EventHandler
    public void PlayerSlainEvent(PlayerDeathEvent e){
   	 if(e.getEntity() instanceof Player){
   	 String playername = e.getEntity().getName();
   	 BufferedWriter output;
		try {
			output = new BufferedWriter(new FileWriter(f, true));
			output.write(playername + " was slain by "+ e.getEntity().getKiller());
			output.newLine();
        output.close();
		}
		catch(Exception e1){
			Bukkit.getLogger().info("UHOH");
		}
		}
    }
    @EventHandler
    public void PlayerleaveEvent(PlayerQuitEvent e){
   	 String playername = e.getPlayer().getName();
   	 BufferedWriter output;
		try {
			output = new BufferedWriter(new FileWriter(f, true));
			output.write(playername + ": left the game");
			output.newLine();
			output.close();
		}
		catch(Exception e1){
			Bukkit.getLogger().info("UHOH");
		}
    }
}
