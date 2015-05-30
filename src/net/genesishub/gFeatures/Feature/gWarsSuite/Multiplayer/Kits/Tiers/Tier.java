package net.genesishub.gFeatures.Feature.gWarsSuite.Multiplayer.Kits.Tiers;

import net.genesishub.gFeatures.Feature.gWarsSuite.Multiplayer.Kits.TierZero;

public class Tier <T>{
	TierZero tz = new TierZero();
	public Tier(T tier){
		if(tier.getClass().getName().equalsIgnoreCase("ZeroTier")){
			ZeroTier zt = (ZeroTier) tier;
			if(zt.equals(ZeroTier.AUTORIFLE)){
				
			}
			else if(zt.equals(ZeroTier.SHOTGUN)){
				
			}
			else if(zt.equals(ZeroTier.SNIPER)){
				
			}
			else if(zt.equals(ZeroTier.SPECIAL)){
				
			}
		}
		else if(tier.getClass().getName().equalsIgnoreCase("OneTier")){
			
		}
	}
}
