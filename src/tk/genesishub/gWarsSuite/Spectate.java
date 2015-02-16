package tk.genesishub.gWarsSuite;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Spectate {
	Constants cons = new Constants();
	public void SpectateInitiate(final CommandSender sender, Command cmd, String label, String[] args, Player s){
		if(!(Constants.arena.contains(((Player)sender).getName())) && !(Constants.spectate.contains(sender.getName()))){
		       Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp "+ sender.getName() + " 487 36 178");
		       sender.sendMessage("You are now spectating. Do /spectate again to get back in the game.");
		       s.setGameMode(GameMode.SPECTATOR);
		       Constants.spectate.add(s.getName());
		       }
		else if(s.getGameMode().equals(GameMode.SPECTATOR)){
			Bukkit.dispatchCommand(sender, "spawn");
		       sender.sendMessage("Teleporting you back to the game...");
		       s.setGameMode(GameMode.SURVIVAL);
		       Constants.spectate.remove(s.getName());
		}
			else{
				sender.sendMessage("You are in the arena!");
			}
	}
		
}
