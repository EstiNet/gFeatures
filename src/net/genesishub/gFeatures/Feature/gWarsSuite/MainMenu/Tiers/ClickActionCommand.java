package net.genesishub.gFeatures.Feature.gWarsSuite.MainMenu.Tiers;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import net.genesishub.gFeatures.API.Inventory.IAction;


public class ClickActionCommand implements IAction
{
    private String command;

    public ClickActionCommand(String command)
    {
         this.command = command;
    }

    @Override
    public void execute(Player player, Inventory inventory, int slot, ItemStack itemStack)
    {
         Bukkit.dispatchCommand(player, command);
         player.closeInventory();
    }
}