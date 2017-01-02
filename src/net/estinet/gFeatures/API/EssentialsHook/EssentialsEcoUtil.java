package net.estinet.gFeatures.API.EssentialsHook;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.configuration.file.YamlConfiguration;

import net.estinet.gFeatures.Extension;
import net.estinet.gFeatures.gFeature;

public class EssentialsEcoUtil {
	public static double getMoney(UUID uuid){
		YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(new File("plugins/Essentials/userdata/" + uuid));
		List<gFeature> featur = new ArrayList<>();
		List<Extension> extension = new ArrayList<>();
		String money = yamlFile.getString("money");
		double realMoney = 0;
		if(money == null){
			YamlConfiguration yamlFiles = YamlConfiguration.loadConfiguration(new File("plugins/Essentials/config.yml"));
			realMoney = yamlFiles.getDouble("starting-balance");
		}
		else{
			realMoney = yamlFile.getDouble("money");
		}
		return realMoney;
	}
}
