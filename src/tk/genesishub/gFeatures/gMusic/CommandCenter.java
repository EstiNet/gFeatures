package tk.genesishub.gFeatures.gMusic;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandCenter {
	@SuppressWarnings("deprecation")
	public void CommandInitiate(final CommandSender sender, Command cmd, String label, String[] args) throws Exception{
		if(!(sender instanceof Player)){
			Bukkit.getLogger().info("Players only!");
		}
		else{
			if(args.length == 0){
				sender.sendMessage(ChatColor.DARK_AQUA + "Opening music menu! :D");
				MusicMenu mm = new MusicMenu();
				mm.Initialize((Player) sender);
			}
			else if (args[0].equalsIgnoreCase("help")){
				sender.sendMessage("----Music Help----");
			}
			else if (args[0].equalsIgnoreCase("stop")){
				((Player) sender).playEffect(((Player) sender).getLocation(), Effect.RECORD_PLAY,
                        (short) 0);
                sender.sendMessage(ChatColor.RED + "Stopping any music.... (It's experimental and might not work.");
			}
			else{
				sender.sendMessage(ChatColor.AQUA + "/music");
			}
		}
	}
}
