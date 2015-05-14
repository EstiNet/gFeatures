package net.genesishub.gFeatures;

import java.io.IOException;
import java.util.List;

import net.genesishub.gFeatures.Plus.Skript.SkriptManager;

public class Enabler {
	public void onEnable(){
		List<gFeature> features = Basic.getFeatures();
		List<Extension> extensions = Basic.getExtensions();
		for(gFeature feature : features){
			if(feature.getState().equals(FeatureState.ENABLE)){
			feature.enable();
			}
		}
		for(Extension extension : extensions){
			if(extension.getState().equals(FeatureState.ENABLE) && extension.getType().equals(ExtensionsType.Skript)){
				SkriptManager sm = new SkriptManager();
				try {
					sm.Enable(extension, extension.getName());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
