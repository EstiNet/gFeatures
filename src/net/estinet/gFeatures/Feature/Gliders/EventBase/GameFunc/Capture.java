package net.estinet.gFeatures.Feature.CTF.EventBase.GameFunc;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;

import net.estinet.gFeatures.Feature.CTF.Basic;

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

public class Capture {
	public void loop(){
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
        	public void run(){
        		try{
        			if(Basic.blueflagger instanceof Player){
        				Firework fw = (Firework) Bukkit.getServer().getWorld("CTF").spawnEntity(Basic.blueflagger.getLocation(), EntityType.FIREWORK);
        				FireworkMeta fwm = fw.getFireworkMeta();
        				FireworkEffect effect = FireworkEffect.builder().withColor(Color.AQUA).with(Type.BALL).build();

        				fwm.addEffect(effect);
        				fwm.setPower(2);

        				fw.setFireworkMeta(fwm);
        			}
        			if(Basic.orangeflagger instanceof Player){
        				Firework fw = (Firework) Bukkit.getServer().getWorld("CTF").spawnEntity(Basic.orangeflagger.getLocation(), EntityType.FIREWORK);
        				FireworkMeta fwm = fw.getFireworkMeta();
        				FireworkEffect effect = FireworkEffect.builder().withColor(Color.ORANGE).with(Type.BALL).build();

        				fwm.addEffect(effect);
        				fwm.setPower(2);

        				fw.setFireworkMeta(fwm);
        			}
        		}
        		catch(Exception e){
        			
        		}
        	}
        }, 80L, 80L);
	}
}
