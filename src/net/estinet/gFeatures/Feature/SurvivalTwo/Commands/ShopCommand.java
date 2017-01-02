package net.estinet.gFeatures.Feature.SurvivalTwo.Commands;

import org.bukkit.entity.Player;

import net.estinet.gFeatures.Command.CommandExecutable;
import net.estinet.gFeatures.Feature.SurvivalTwo.Menus.Shop;

public class ShopCommand extends CommandExecutable{
	@Override
	public void run() {
		Shop shop = new Shop();
		shop.init((Player) super.sender);
	}
	
}
