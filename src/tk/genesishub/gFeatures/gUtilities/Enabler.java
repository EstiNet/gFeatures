package tk.genesishub.gFeatures.gUtilities;

import java.io.IOException;

import org.bukkit.Bukkit;

import tk.genesishub.gFeatures.gUtilities.FeatureManager.Enable;

public class Enabler {
	public void Start(){
		FileCheck fc = new FileCheck();
		try {
			fc.CheckYML();
			Enable e = new Enable();
			e.onEnable();
		} catch (IOException e) {
			e.printStackTrace();
			Bukkit.getLogger().info("Well, there's an error. :(");
		}
	}
}
