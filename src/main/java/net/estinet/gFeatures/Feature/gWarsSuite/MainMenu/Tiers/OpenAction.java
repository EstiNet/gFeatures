package net.estinet.gFeatures.Feature.gWarsSuite.MainMenu.Tiers;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import net.estinet.gFeatures.API.Inventory.IAction;

/*
 * gFeatures
 * https://github.com/EstiNet/gFeatures
 *
 *    Copyright 2019 EstiNet
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *
 */

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
 