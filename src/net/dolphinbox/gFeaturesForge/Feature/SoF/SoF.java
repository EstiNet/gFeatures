package net.dolphinbox.gFeaturesForge.Feature.SoF;

import net.dolphinbox.gFeaturesForge.Feature.SoF.configuration.ConfigurationHandler;
import net.dolphinbox.gFeaturesForge.Feature.SoF.proxy.IProxy;
import net.dolphinbox.gFeaturesForge.Feature.SoF.reference.Reference;
import net.dolphinbox.gFeaturesForge.Feature.SoF.utility.LogHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
/*

Forge Mod for Project Codename:SoF

gFeatures
https://github.com/GenesisHub/gFeatures

   Copyright 2015 GenesisHub & DolphinBox

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
@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class SoF {
	
	@Instance(Reference.MOD_ID)
	public static SoF Instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.CLIENT_PROXY_CLASS)
	public static IProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		LogHelper.info("Starting Project Codename:SoF with gFeatures...");
		LogHelper.info("Begining Pre Initialization stage...");
		LogHelper.info("Loading Config file...");
		ConfigurationHandler.init(event.getSuggestedConfigurationFile());
		LogHelper.info("Config File Loaded!");
		LogHelper.info("Finished Pre Initialization stage.");
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		LogHelper.info("Starting Initalization stage...");
		LogHelper.info("Finished Initalization stage!");
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		LogHelper.info("Starting Post Initialization stage...");
		LogHelper.info("SoF Version: " + Reference.VERSION);
		LogHelper.info("gFeatures Version: " + net.genesishub.gFeatures.Listeners.version);
		LogHelper.info("Finished Post Initialization stage!");
	}
}
