package net.dolphinbox.gFeaturesForge.Feature.SoF.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.dolphinbox.gFeaturesForge.Feature.SoF.item.ItemQuestTracker;
import net.dolphinbox.gFeaturesForge.Feature.SoF.item.ItemSoF;

public class ModItems {
	public static final ItemSoF QuestTracker = new ItemQuestTracker();
	
	public static void init(){
		//GameRegistry.registerItem(QuestTracker, "QuestTracker");
	}
}
