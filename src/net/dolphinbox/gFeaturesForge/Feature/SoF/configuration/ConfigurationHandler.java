package net.dolphinbox.gFeaturesForge.Feature.SoF.configuration;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ConfigurationHandler {
	public static void init(File configFile){
		Configuration configuration = new Configuration(configFile);
		
		boolean configValue =  false;
		try{
			//Load the config file
			configuration.load();
			
			//Read value from the config file
			configValue = configuration.get("SoF", "configValue", true, "This is a test value.").getBoolean(true);
		}catch (Exception e){
			//Catch any errors in reading/loading the config
		}finally{
			//Save the config file
			configuration.save();
		}
		
		System.out.println("[Debug] Value of configValue:" + configValue);
	}
}
