package net.estinet.gFeatures.Feature.ParkourRace;

import java.util.concurrent.TimeUnit;

import net.estinet.gFeatures.Basic;
import net.estinet.gFeatures.Configs;
import net.estinet.gFeatures.Feature.FusionPlay.FusionPlay;
import net.estinet.gFeatures.Feature.FusionPlay.GameUtil.FusionSettings;
import net.estinet.gFeatures.Feature.FusionPlay.GameUtil.TimeManager;
public class Configure{
	@Configs
	public static void onSetup(){
		ParkourRace fg = new ParkourRace("ParkourRace", "1.0.0");
		FusionSettings fs = new FusionSettings();
		fs.setAutoLoadMap(true);
		fs.setDefaultMapName("world");
		fs.setUsesSpawns(true);
		fs.setTimeManager(new TimeManager(3, TimeUnit.MINUTES));
		fg.setSettings(fs);
		fg.setMaps(MapsConfigure.init());
		FusionPlay.addGame(fg);
		Basic.addFeature(fg);
	}
}
