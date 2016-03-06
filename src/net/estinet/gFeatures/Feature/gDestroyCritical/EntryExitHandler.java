package net.estinet.gFeatures.Feature.gDestroyCritical;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.bukkit.entity.Player;
import org.w3c.dom.Document;

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

public class EntryExitHandler{
	Constants cons = new Constants();
	FileManager fm = new FileManager();
	public void onJoin(Player player){
		TeamManager as = new TeamManager();
    	as.ChooseTeams(player.getPlayer());
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
 		DocumentBuilder docBuilder;
		try {
			docBuilder = docFactory.newDocumentBuilder();
		
		Document doc = docBuilder.parse(cons.f);
		if((doc.getElementsByTagName(player.getName())).getLength() == 0){
			fm.setupPlayer(player);
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void onLeave(Player player){
	 cons.Acceptance.remove(player.getName());
   	 cons.ot.remove(player.getName());
   	 cons.bt.remove(player.getName());
   	 cons.BlockBroke.set(cons.Acceptance.indexOf(player.getName()), "0");
	}
}
