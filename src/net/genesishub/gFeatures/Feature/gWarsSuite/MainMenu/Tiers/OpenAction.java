package net.genesishub.gFeatures.Feature.gWarsSuite.MainMenu.Tiers;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import net.genesishub.gFeatures.API.Inventory.IAction;

public class OpenAction implements IAction
{
     private String command;
 
     public OpenAction(String command)
     {
          this.command = command;
     }
 
     @Override
     public void execute(Player player, Inventory inventory, int slot, ItemStack itemStack)
     {
          
     }
}
 