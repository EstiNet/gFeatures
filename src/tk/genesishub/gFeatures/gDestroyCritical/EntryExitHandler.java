package tk.genesishub.gFeatures.gDestroyCritical;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.w3c.dom.Document;

public class EntryExitHandler extends JavaPlugin{
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
