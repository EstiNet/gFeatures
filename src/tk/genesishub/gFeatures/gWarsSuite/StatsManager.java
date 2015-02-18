package tk.genesishub.gFeatures.gWarsSuite;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class StatsManager {
	File f = new File("KillsDeaths.xml");
	String backtostring;
	StatsRetrieve sr = new StatsRetrieve();
	@SuppressWarnings("deprecation")
	public int[] giveKills(Player player, int kills) throws Exception{
		try{
 	 	DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
 		DocumentBuilder docBuilder;
		docBuilder = docFactory.newDocumentBuilder();
 		final Document doc = docBuilder.parse(f);
 		OfflinePlayer offlineplayer = Bukkit.getOfflinePlayer(player.getName());
 		offlineplayer.getUniqueId().toString();
 		Node root = sr.getPlayerByUUID((Player)offlineplayer);
 		Node killsnode = root.getFirstChild();
 		int kills2 = Integer.parseInt(killsnode.getTextContent());
 		int killsadded = kills2 + kills;
 		backtostring = Integer.toString(killsadded);
 		killsnode.setTextContent(backtostring);
 		killsnode.setNodeValue(backtostring);
 		String nodename = root.getNodeName();
 		NodeList node = doc.getElementsByTagName(nodename);
 		Node node2 = node.item(0);
 		node2.getFirstChild().setTextContent(backtostring);
 	    TransformerFactory transformerFactory = TransformerFactory.newInstance();
 	    Transformer transformer;		
 	    transformer = transformerFactory.newTransformer();
 	    DOMSource source = new DOMSource(doc);
 	    StreamResult result = new StreamResult(f);
 	    transformer.transform(source, result);
 	   	Bukkit.getLogger().info("Done.");
		int[] array = {kills2, killsadded};
	 	return array;
	 	}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	public void takeKills(Player player, int kills) throws Exception{
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
 		DocumentBuilder docBuilder;
		docBuilder = docFactory.newDocumentBuilder();
 		Document doc = docBuilder.parse(f);
 		Node list = sr.getPlayerByUUID(player);
 		Node notDeaths = list.getFirstChild();
 		String deaths2 = notDeaths.getTextContent();
 		int foo = Integer.parseInt(deaths2);
 		foo -= kills;
 		String backtostring = Integer.toString(foo);
 		notDeaths.setTextContent(backtostring);
 		String nodename = list.getNodeName();
 		NodeList node = doc.getElementsByTagName(nodename);
 		Node node2 = node.item(0);
 		node2.getFirstChild().setTextContent(backtostring);
 	 	TransformerFactory transformerFactory = TransformerFactory.newInstance();
 	 	Transformer transformer = transformerFactory.newTransformer();
 	 	DOMSource source = new DOMSource(doc);
 	 	StreamResult result = new StreamResult(f);
 	 	transformer.transform(source, result);
	}
	public void giveDeaths(Player player, int Deaths) throws Exception{
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
 		DocumentBuilder docBuilder;
		docBuilder = docFactory.newDocumentBuilder();
 		Document doc = docBuilder.parse(f);
 		Node list = sr.getPlayerByUUID(player);
 		Node notDeaths = list.getFirstChild();
 		Node deaths = notDeaths.getNextSibling();
 		String deaths2 = deaths.getTextContent();
 		int foo = Integer.parseInt(deaths2);
 		foo += Deaths;
 		String backtostring = Integer.toString(foo);
 		deaths.setTextContent(backtostring);
 		String nodename = list.getNodeName();
 		NodeList node = doc.getElementsByTagName(nodename);
 		Node node2 = node.item(0);
 		node2.getFirstChild().getNextSibling().setTextContent(backtostring);
 	 	TransformerFactory transformerFactory = TransformerFactory.newInstance();
 	 	javax.xml.transform.Transformer transformer = transformerFactory.newTransformer();
 	 	DOMSource source = new DOMSource(doc);
 	 	StreamResult result = new StreamResult(f);
 	 	transformer.transform(source, result);
	}
	public void takeDeaths(Player player, int Deaths) throws Exception{
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
 		DocumentBuilder docBuilder;
		docBuilder = docFactory.newDocumentBuilder();
 		Document doc = docBuilder.parse(f);
 		Node list = sr.getPlayerByUUID(player);
 		Node notDeaths = list.getFirstChild();
 		Node deaths = notDeaths.getNextSibling();
 		String deaths2 = deaths.getTextContent();
 		int foo = Integer.parseInt(deaths2);
 		foo -= Deaths;
 		String backtostring = Integer.toString(foo);
 		deaths.setTextContent(backtostring);
 		String nodename = list.getNodeName();
 		NodeList node = doc.getElementsByTagName(nodename);
 		Node node2 = node.item(0);
 		node2.getFirstChild().getNextSibling().setTextContent(backtostring);
 	 	TransformerFactory transformerFactory = TransformerFactory.newInstance();
 	 	javax.xml.transform.Transformer transformer = transformerFactory.newTransformer();
 	 	DOMSource source = new DOMSource(doc);
 	 	StreamResult result = new StreamResult(f);
 	 	transformer.transform(source, result);
	}
}
