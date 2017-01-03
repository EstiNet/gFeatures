package net.estinet.gFeatures.Feature.SurvivalTwo.Menus;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import net.estinet.gFeatures.API.Inventory.AnvilGUI;

public class TpaMenu{
	public void init(Player p){
		AnvilGUI gui = new AnvilGUI(p, new AnvilGUI.AnvilClickEventHandler(){
			@Override
			public void onAnvilClick(AnvilGUI.AnvilClickEvent event){
				if(event.getSlot() == AnvilGUI.AnvilSlot.OUTPUT){
					event.setWillClose(true);
					event.setWillDestroy(true);

					p.performCommand("tpa " + event.getName());
				} else {
					event.setWillClose(false);
					event.setWillDestroy(false);
				}
			}
		});

		gui.setSlot(AnvilGUI.AnvilSlot.INPUT_LEFT, new ItemStack(Material.NAME_TAG));

		gui.open();
	}
}
