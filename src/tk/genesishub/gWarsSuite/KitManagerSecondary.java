package tk.genesishub.gWarsSuite;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import com.shampaggon.crackshot.CSUtility;

public class KitManagerSecondary {
	Constants cons = new Constants();
	public void gunKitsSetup(Player player, String gunName){
    	if(Constants.bt.contains(player.getName())){
    		 double x1 = Double.parseDouble("134");//insert x
               double y1 = Double.parseDouble("61");//insert y
               double z1 = Double.parseDouble("283");//insert z
               Location e1 = new Location(player.getWorld(), x1, y1, z1);
               player.teleport(e1);//tp's to orangetp
    	}
    	else if(Constants.ot.contains(player.getName())){
    		 double x1 = Double.parseDouble("134");//insert x
               double y1 = Double.parseDouble("19");//insert y
               double z1 = Double.parseDouble("283");//insert z
               Location e1 = new Location(player.getWorld(), x1, y1, z1);
               player.teleport(e1);//tp's to bluetp
    	}
    	
    	CSUtility cs = new CSUtility();
    	cs.giveWeapon(player, gunName, 1);
    }
}
