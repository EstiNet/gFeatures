package net.estinet.gFeatures.Feature.FusionPlay.GameUtil.Logistics;

import net.estinet.gFeatures.Feature.FusionPlay.FusionPlay;
import net.estinet.gFeatures.Feature.FusionPlay.GameUtil.TimeManager;

public class CounterProcess {
	public static void waitInit(){
		Thread thr = new Thread(new Runnable(){
			public void run(){
				if(FusionPlay.currentGame.getSettings().getWaitingSecLeft() <= 0){
					WaitingProcess.counterComplete();
				}
				else{
					FusionPlay.currentGame.getSettings().setWaitingSecLeft(FusionPlay.currentGame.getSettings().getWaitingSecLeft()-1);
					run();
				}
			}
		});
		thr.start();
	}
	public static void ingameInit(TimeManager tm){
		
	}
}
