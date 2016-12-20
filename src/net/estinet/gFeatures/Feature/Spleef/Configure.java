package net.estinet.gFeatures.Feature.Spleef;

import java.util.concurrent.TimeUnit;

import net.estinet.gFeatures.Configs;
import net.estinet.gFeatures.Feature.FusionPlay.FusionPlay;
import net.estinet.gFeatures.Feature.FusionPlay.GameUtil.FusionSettings;
import net.estinet.gFeatures.Feature.FusionPlay.GameUtil.TimeManager;
import net.estinet.gFeatures.Feature.ParkourRace.ParkourRace;
import net.md_5.bungee.api.ChatColor;

public class Configure{
	public static Spleef fg;
	@Configs
	public static void onSetup(){
		fg = new Spleef("Spleef", "1.0.0");
		FusionSettings fs = new FusionSettings();
		fs.setAutoLoadMap(true);
		fs.setDefaultMapName("world");
		fs.setUsesSpawns(true);
		fs.setTimeManager(new TimeManager(6, TimeUnit.MINUTES));
		fs.setDefaultWaitingSecLeft(10);
		fs.setCoolGameName(ChatColor.BOLD + "(づ￣ ³￣)づ" + ChatColor.AQUA + " Spleef");
		fg.setSettings(fs);
		fg.setMaps(MapsConfigure.init());
		FusionPlay.addGame(fg);
	}
}
