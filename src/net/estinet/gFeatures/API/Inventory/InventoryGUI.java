package net.estinet.gFeatures.API.Inventory;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2016 EstiNet

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

/**
 * Copyright (c) 2015 nverdier
 * <p/>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is furnished to
 * do so, subject to the following conditions:
 * <p/>
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of
 * the Software.
 * <p/>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO
 * THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF
 * OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
public class InventoryGUI implements Listener
{
    private Inventory             inventory;
    private Map<Integer, IAction> actions;

    /**
     * Creates an InventoryGUI with a title and certain amount of rows.
     *
     * @param plugin Instance of the class extending JavaPlugin.
     * @param title  The title of the GUI. Color codes supported
     * @param rows   The number of rows to be in the inventory.
     */
    public InventoryGUI(Plugin plugin, String title, int rows)
    {
        this.inventory = Bukkit.createInventory(null, rows * 9, ChatColor.translateAlternateColorCodes('&', title));
        this.actions = new HashMap<>();

        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    /**
     * Puts an ItemStack in a certain slot, and adds an IAction to it.
     *
     * @param slot        The slot you want to put the ItemStack in.
     * @param itemStack   The ItemStack you are adding.
     * @param clickAction The IAction that runs when the ItemStack is clicked.
     * @return this (for method chaining)
     */
    public InventoryGUI setItem(int slot, ItemStack itemStack, IAction clickAction)
    {
        slot = slot > inventory.getSize() ? slot % inventory.getSize() : slot;
        inventory.setItem(slot, itemStack);
        actions.put(slot, clickAction);
        return this;
    }

    /**
     * @param slot   The slot to set the IAction in.
     * @param action The IAction that runs when the specified slot is clicked.
     * @return this (for method chaining)
     */
    public InventoryGUI setAction(int slot, IAction action)
    {
        if (action != null)
        {
            actions.put(slot, action);
        }
        else
        {
            actions.remove(slot);
        }
        return this;
    }

    /**
     * Sets the action that will happen when the Inventory is opened.
     *
     * @param action The IAction that runs when the Inventory is opened.
     * @return this (for method chaining)
     */
    public InventoryGUI setOpenAction(IAction action)
    {
        if (action != null)
        {
            actions.put(-1, action);
        }
        else
        {
            actions.remove(-1);
        }
        return this;
    }

    /**
     * Sets the action that will happen the the Inventory is closed.
     *
     * @param action The IAction that runs when the Inventory is closed.
     * @return this (for method chaining)
     */
    public InventoryGUI setCloseAction(IAction action)
    {
        if (action != null)
        {
            actions.put(-2, action);
        }
        else
        {
            actions.remove(-2);
        }
        return this;
    }

    /**
     * Opens the inventory for a Player.
     *
     * @param player The player to open the inventory for.
     * @return this (for method chaining)
     */
    public InventoryGUI openInventory(Player player)
    {
        player.openInventory(inventory);
        return this;
    }

    /**
     * Opens the inventory for each Player in a Player[].
     *
     * @param players The Players to open the inventory for.
     * @return this (for method chaining)
     */
    public InventoryGUI openInventory(Player[] players)
    {
        for (Player player : players)
        {
            openInventory(player);
        }
        return this;
    }

    /**
     * Opens the inventory for each Player in a Collection<? extends Player>.
     *
     * @param players The Players to open the inventory for.
     * @return this (for method chaining)
     */
    public InventoryGUI openInventory(Collection<? extends Player> players)
    {
        for (Player player : players)
        {
            openInventory(player);
        }
        return this;
    }

    /**
     * Returns the created inventory.
     *
     * @return The final Inventory.
     */
    public Inventory get()
    {
        return this.inventory;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e)
    {
        if (e.getInventory().equals(inventory) && e.getRawSlot() < inventory.getSize())
        {
            e.setCancelled(true);
            IAction action = actions.get(e.getRawSlot());
            if (action != null)
            {
                action.execute((Player) e.getWhoClicked(),
                               e.getInventory(),
                               e.getRawSlot(),
                               e.getInventory().getItem(e.getRawSlot()));
            }
        }
    }

    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent e)
    {
        if (e.getInventory().equals(inventory))
        {
            IAction action = actions.get(-1);
            if (action != null)
            {
                action.execute((Player) e.getPlayer(), e.getInventory(), -1, null);
            }
        }
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent e)
    {
        if (e.getInventory().equals(inventory))
        {
            IAction action = actions.get(-2);
            if (action != null)
            {
                action.execute((Player) e.getPlayer(), e.getInventory(), -1, null);
            }
        }
    }
}