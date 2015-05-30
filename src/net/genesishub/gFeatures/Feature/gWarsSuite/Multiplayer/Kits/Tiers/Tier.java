package net.genesishub.gFeatures.Feature.gWarsSuite.Multiplayer.Kits.Tiers;

import org.bukkit.entity.Player;

import net.genesishub.gFeatures.Feature.gWarsSuite.Multiplayer.Kits.*;

public class Tier <T>{
	TierZero tz = new TierZero();
	TierOne to = new TierOne();
	TierTwo tt = new TierTwo();
	TierThree tth = new TierThree();
	TierFour tf = new TierFour();
	public Tier(T tier, Player p){
		if(tier.getClass().getName().equalsIgnoreCase("ZeroTier")){
			ZeroTier zt = (ZeroTier) tier;
			tz.initialize(zt.toString(), p);
		}
		else if(tier.getClass().getName().equalsIgnoreCase("OneTier")){
			
		}
	}
}
