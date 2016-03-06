package net.estinet.gFeatures.Feature.gDestroyCritical;

import org.bukkit.entity.Player;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2016 EstiNet

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
