package tk.genesishub.gFeatures.Commands;


import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;

public class CommandRegister extends BukkitCommand{
	static Thread t;
    public CommandRegister(String name, String description, String usageMessage, String permission, Runnable runs) {
        super(name);
        this.description = description;
        this.usageMessage = usageMessage;
        this.setPermission(permission);
        this.setAliases(new ArrayList<String>());
        t = new Thread(runs);
    }

    @SuppressWarnings("deprecation")
    @Override
	public boolean execute(CommandSender sender, String alias, String[] args) {
    	t.start();
        if (!sender.hasPermission(this.getPermission())) {
            sender.sendMessage(ChatColor.RED + "You don't have permission.");
            return true;
        }
       
        if (args.length != 1) {
            return true;
        }
       
        OfflinePlayer p = Bukkit.getOfflinePlayer(args[0]);
        if (p.isOnline()) {
            sender.sendMessage(ChatColor.GRAY + args[0] + " is " + ChatColor.GREEN + "online");
            return true;
        } else {
            sender.sendMessage(ChatColor.GRAY + args[0] + " is " + ChatColor.RED + "offline");
            return true;
        }
    }

}