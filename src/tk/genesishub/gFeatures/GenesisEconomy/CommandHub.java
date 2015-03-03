package tk.genesishub.gFeatures.GenesisEconomy;

import net.milkbowl.vault.economy.EconomyResponse;
import net.milkbowl.vault.economy.Economy;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHub {
	public void Intitiate(CommandSender sender, Command command, String commandLabel, String[] args) {
		if(!(sender instanceof Player)) {
            Bukkit.getLogger().info("Only players are supported for this GenesisEconomy as of now.");
        }

        Player player = (Player) sender;

        if(command.getLabel().equals("test-economy")) {
            // Lets give the player 1.05 currency (note that SOME economic plugins require rounding!)
            sender.sendMessage(String.format("You have %s", Econist.econ.format(Econist.econ.getBalance(player.getName()))));
            EconomyResponse r = Econist.econ.depositPlayer(player, 1.05);
            if(r.transactionSuccess()) {
                sender.sendMessage(String.format("You were given %s and now have %s", Econist.econ.format(r.amount), Econist.econ.format(r.balance)));
            } else {
                sender.sendMessage(String.format("An error occured: %s", r.errorMessage));
            }
        } 
	}
}
