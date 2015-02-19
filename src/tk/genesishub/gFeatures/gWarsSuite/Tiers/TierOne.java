package tk.genesishub.gFeatures.gWarsSuite.Tiers;

import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import tk.genesishub.gFeatures.gWarsSuite.Constants;
import tk.genesishub.gFeatures.gWarsSuite.KitManagerSecondary;

public class TierOne {
	Constants cons = new Constants();
	tk.genesishub.gFeatures.gWarsSuite.StatsRetrieve sr = new tk.genesishub.gFeatures.gWarsSuite.StatsRetrieve();
	KitManagerSecondary kmh = new KitManagerSecondary();
	public void Initialize(CommandSender sender, String value){
		ItemStack ammo = new ItemStack(Material.MELON_SEEDS,32);
		Player player = (Player)sender;
		if((sr.getKills(player.getName()))<5){
			sender.sendMessage("You don't have enough kills! 5 kills is required for Tier 1 weapons.");
		}
		else if(Constants.gunin.contains(player.getName())){
			
		}
		else{
		player.getInventory().addItem(ammo);
		player.getInventory().remove(Material.CHEST);
		Constants.gunin.add(player.getName());
		switch(value){
		case "sniper":
			Sniper(sender);
			break;
		case "shotgun":
			Shotgun(sender);
			break;
		case "autorifle":
			AutoRifle(sender);
			break;
		case "special":
			Special(sender);
			break;
		}
		}	
	}
	public void Sniper(CommandSender sender){
		Player player = (Player)sender;
		kmh.gunKitsSetup(player, "ULR338");
		kmh.gunKitsSetup(player, "Python");
	}
	public void Shotgun(CommandSender sender){
		Player player = (Player)sender;
		kmh.gunKitsSetup(player, "Colt Model 1");
		kmh.gunKitsSetup(player, "Python");
	}
	public void Special(CommandSender sender){
		Player player = (Player)sender;
		kmh.gunKitsSetup(player, "Bazooka");
		kmh.gunKitsSetup(player, "Python");
	}
	public void AutoRifle(CommandSender sender){
		Player player = (Player)sender;
		kmh.gunKitsSetup(player, "m16");
		kmh.gunKitsSetup(player, "Python");
	}
}
