package net.estinet.gFeatures.Feature.SurvivalTwo.Commands;

import org.bukkit.entity.Player;

import net.estinet.gFeatures.Command.CommandExecutable;
import net.estinet.gFeatures.Feature.SurvivalTwo.Menus.MainMenu;

public class MenuCommand extends CommandExecutable{
	@Override
	public void run() {
		MainMenu menu = new MainMenu();
		menu.init((Player) super.sender);
	}
}
