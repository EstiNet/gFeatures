package net.estinet.gFeatures.Feature.CTF.Commands;

import net.estinet.gFeatures.Command.CommandExecutable;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class SuicideCommand extends CommandExecutable {

    @Override
    public void run() {
        if (super.sender instanceof Player) {
            ((Player)super.sender).setHealth(0);
        }
    }

}