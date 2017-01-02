package net.estinet.gFeatures.API.EssentialsHook;

import java.io.File;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

public class EssentialsEcoUtil {
	public static double getMoney(UUID uuid){
		YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(new File("plugins/Essentials/userdata/" + uuid + ".yml"));
		String money = yamlFile.getString("money");
		double realMoney = 0;
		if(money == null){
			YamlConfiguration yamlFiles = YamlConfiguration.loadConfiguration(new File("plugins/Essentials/config.yml"));
			realMoney = Double.parseDouble(yamlFiles.getString("starting-balance"));
		}
		else{
			realMoney = Double.parseDouble(money);
		}
		Bukkit.getLogger().info(realMoney + " " + money + " " + uuid);
		return realMoney;
	}
}
