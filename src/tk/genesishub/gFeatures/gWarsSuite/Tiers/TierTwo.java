package tk.genesishub.gFeatures.gWarsSuite.Tiers;

import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import tk.genesishub.gFeatures.gWarsSuite.Constants;
import tk.genesishub.gFeatures.gWarsSuite.KitManagerSecondary;
import tk.genesishub.gFeatures.gWarsSuite.StatsRetrieve;

public class TierTwo {
	Constants cons = new Constants();
	StatsRetrieve sr = new StatsRetrieve();
	KitManagerSecondary kmh = new KitManagerSecondary();
	public void Initialize(CommandSender sender, String value){
		ItemStack ammo = new ItemStack(Material.MELON_SEEDS,32);
		Player player = (Player)sender;
		if((sr.getKills(player.getName()))<10){
			sender.sendMessage("You don't have enough kills! 10 kills is required for Tier 2 weapons.");
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
		kmh.gunKitsSetup(player, "SilSil69");
		kmh.gunKitsSetup(player, "Python");
	}
	public void Shotgun(CommandSender sender){
		Player player = (Player)sender;
		kmh.gunKitsSetup(player, "SPAS");
		kmh.gunKitsSetup(player, "Python");
	}
	public void Special(CommandSender sender){
		Player player = (Player)sender;
		ItemStack helm = new ItemStack(Material.CHAINMAIL_HELMET, 1);
		ItemStack legging = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
		ItemStack chest = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
		ItemStack boot = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
		Constants.gunin.add(player.getName());
		player.addPotionEffect((new PotionEffect(PotionEffectType.ABSORPTION, 100 ,	100)));
		player.getInventory().addItem(helm);
		player.getInventory().addItem(legging);
		player.getInventory().addItem(chest);
		player.getInventory().addItem(boot);
		kmh.gunKitsSetup(player, "Python");
	}
	public void AutoRifle(CommandSender sender){
		Player player = (Player)sender;
		kmh.gunKitsSetup(player, "AK47-Black Edition");
		kmh.gunKitsSetup(player, "Python");
	}
}
