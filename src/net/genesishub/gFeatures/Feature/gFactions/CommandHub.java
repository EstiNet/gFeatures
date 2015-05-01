package tk.genesishub.gFeatures.gFactions;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHub {
	Camera c = new Camera();
	public void CommandSwitch(final CommandSender sender, Command cmd, String label, String[] args) throws NumberFormatException, Exception{
		if(cmd.getName().equalsIgnoreCase("tutorial")){
			sender.sendMessage("Starting tutorial...");
			c.Tutorial((Player)sender);
		}
	}
}
