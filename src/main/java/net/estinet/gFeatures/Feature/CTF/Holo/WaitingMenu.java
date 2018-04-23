package net.estinet.gFeatures.Feature.CTF.Holo;

import net.estinet.gFeatures.ClioteSky.ClioteSky;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import net.estinet.gFeatures.Feature.Shop.GUI.MainShop;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2017 EstiNet

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

public class WaitingMenu {
    public void init(Player p) {
        if (p.getInventory().getItemInMainHand().getType().equals(Material.COMPASS)) {
            ClioteSky.getInstance().sendAsync(ClioteSky.stringToBytes(p.getName() + " MinigameHub"), "redirect", "Bungee");
            p.playSound(p.getLocation(), Sound.BLOCK_PORTAL_TRAVEL, 25, 25);
        } else if (p.getInventory().getItemInMainHand().getType().equals(Material.CHEST)) {
            MainShop ms = new MainShop();
            ms.init(p);
        }
    }
}
