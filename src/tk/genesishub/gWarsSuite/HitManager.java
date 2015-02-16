package tk.genesishub.gWarsSuite;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import com.shampaggon.crackshot.events.WeaponDamageEntityEvent;

public class HitManager {
	File f = new File("KillsDeaths.xml");
	StatsRetrieve sr = new StatsRetrieve();
	StatsManager sm = new StatsManager();
	Constants cons = new Constants();
	public void EntityDamageByOther(EntityDamageByEntityEvent event){
		if(event.getEntity() instanceof Player && event.getDamager() instanceof Player) {
            Player damaged = (Player)event.getEntity();
            Player damager = (Player)event.getDamager();

            if(Constants.bt.contains(damaged.getName()) && Constants.bt.contains(damager.getName())) { // check if both damaged and damager are on blue team
                event.setCancelled(true); // cancel the event, so no damage will be dealt.
            }

            if(Constants.ot.contains(damaged.getName()) && Constants.ot.contains(damager.getName())) { // same for red team
                event.setCancelled(true);
            }}
	}
	public void WeaponDamage(WeaponDamageEntityEvent event){
		Bukkit.getServer().getLogger().info("Adding a kill to " + ((HumanEntity) event.getVictim()).getName() + " because of death from " + event.getPlayer().getName() + " 1");
		//event.getVictim() instanceof Player && event.getPlayer() instanceof Player
		if(true) {
            Player damaged = (Player)event.getVictim();
            Player damager = (Player)event.getPlayer();
            try{
    			Player death = (Player) event.getVictim();
    			Entity cause = event.getPlayer();
    			Bukkit.getServer().getLogger().info("Adding a kill to " + ((HumanEntity) cause).getName() + " because of death from " + ((HumanEntity) death).getName() + " 2");
    			Damageable d = (Damageable) death;
    			int health = (int) d.getHealth();
    			double damage = event.getDamage();
    			Bukkit.getServer().getLogger().info(Double.toString(health));
    			if(health - damage <= 0){
    			death.getInventory().remove(Material.CHEST);
    			death.getInventory().remove(Material.STAINED_GLASS);
    			Player death1 = (Player) event.getVictim();
    			Player cause1 = event.getPlayer();
    			Bukkit.getServer().getLogger().info("Adding a kill to " + ((HumanEntity) cause).getName()+ " because of death from " + ((HumanEntity) death).getName() + " 3");
    			gunKill(event);
    			sm.giveKills(cause1, 1);
    			sm.giveDeaths(death1, 1);
    			}
            if(Constants.bt.contains(damaged.getName()) && Constants.bt.contains(damager.getName())) { // check if both damaged and damager are on blue team
                event.setCancelled(true); // cancel the event, so no damage will be dealt.
            }
            if(Constants.ot.contains(damaged.getName()) && Constants.ot.contains(damager.getName())) { // same for red team
                event.setCancelled(true);
            }
			}catch(Exception e){
				e.printStackTrace();
			}
        }
	}
	public void gunKill(WeaponDamageEntityEvent event){
		try{
			Entity death = event.getVictim();
			Entity cause = event.getPlayer();
			if(death instanceof Player && cause instanceof Player && death.isDead()){
				Entity death1 = (Player) event.getVictim();
				Player cause1 = event.getPlayer();
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	 		DocumentBuilder docBuilder;
			
			docBuilder = docFactory.newDocumentBuilder();
	 		Document doc = docBuilder.parse(f);
	 		
	 		Node list = sr.getPlayerByUUID((Player)death1);
	 		
	 		Node notDeaths = list.getFirstChild();
	 		Node deaths = notDeaths.getNextSibling();
	 		String deaths2 = deaths.getTextContent();
	 		int foo = Integer.parseInt(deaths2);
	 		foo += 1;
	 		String backtostring = Integer.toString(foo);
	 		deaths.setTextContent(backtostring);
	 		
	 		Node list1 = sr.getPlayerByUUID(cause1);
	
	 		Node deaths111 = list1.getFirstChild();
	 		String deaths21 = deaths111.getTextContent();
	 		int foo1 = Integer.parseInt(deaths21);
	 		int deathsreal1 = foo1 + 1;
	 		String backtostring1 = Integer.toString(deathsreal1);
	 		deaths111.setTextContent(backtostring1);
	 		
	 	// write the content into xml file
	 	 		TransformerFactory transformerFactory = TransformerFactory.newInstance();
	 	 		javax.xml.transform.Transformer transformer = transformerFactory.newTransformer();
	 	 		DOMSource source = new DOMSource(doc);
	 	 		StreamResult result = new StreamResult(f);
	 	  
	 	 		// Output to console for testing
	 	 		// StreamResult result = new StreamResult(System.out);
	 	  
	 	 		transformer.transform(source, result);
			}
		}
			catch(Exception e){
				
			}
	}
}
