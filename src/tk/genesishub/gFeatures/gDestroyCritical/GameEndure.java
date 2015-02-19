package tk.genesishub.gFeatures.gDestroyCritical;

import org.bukkit.entity.Player;

public class GameEndure {
	Constants cons = new Constants();
	FileManager fm = new FileManager();
	public void onBlockBreak(Player p){
		 if(Constants.arenaon == true && cons.Acceptance.contains(p.getName())){
    		 int index = cons.Acceptance.indexOf(p.getName());
    		String blocknum = cons.BlockBroke.get(index);
    		int blocknum1 = Integer.parseInt(blocknum);
    		blocknum1++;
    		fm.BreakBlockSave(p);
    		String backtogether = Integer.toString(blocknum1);
    		cons.BlockBroke.set(index, backtogether);
    	 }
	}
	public int getBlockBroken(String playername){
		try{
			int index = cons.Acceptance.indexOf(playername);
    		String blocks = cons.BlockBroke.get(index);
    		int block = Integer.parseInt(blocks);
 	 		return block;
    		}
    		catch(Exception e){
    			
    		}
		return 200;
	}
}
