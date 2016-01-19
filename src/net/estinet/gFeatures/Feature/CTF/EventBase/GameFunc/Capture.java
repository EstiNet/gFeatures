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
        				fwm.setPower(20);

        				fw.setFireworkMeta(fwm);
        			}
        			if(Basic.orangeflagger instanceof Player){
        				Firework fw = (Firework) Bukkit.getServer().getWorld("CTF").spawnEntity(Basic.orangeflagger.getLocation(), EntityType.FIREWORK);
        				FireworkMeta fwm = fw.getFireworkMeta();
        				FireworkEffect effect = FireworkEffect.builder().withColor(Color.ORANGE).with(Type.BALL).build();

        				fwm.addEffect(effect);
        				fwm.setPower(20);

        				fw.setFireworkMeta(fwm);
        			}
        		}
        		catch(Exception e){
        			
        		}
        	}
        }, 200L, 200L);
	}
}
