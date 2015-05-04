package net.genesishub.gFeatures.Feature.gWarsSuite;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/*
gFeatures
https://github.com/Seshpenguin/gFeatures

   Copyright 2015 DolphinBox

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

public class StatsRetrieve{
	Constants cons = new Constants();
	File f = new File("KillsDeaths.xml");
	@SuppressWarnings("deprecation")
	public int getKills(String playername){
		try{
    		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	 		DocumentBuilder docBuilder;
			
			docBuilder = docFactory.newDocumentBuilder();
	 		Document doc = docBuilder.parse(f);
	 		OfflinePlayer offlineplayer = Bukkit.getOfflinePlayer(playername);
	 		offlineplayer.getUniqueId().toString();
	 		Node root = getPlayerByUUID((Player)offlineplayer);
	 		Node kills = root.getFirstChild();
	 		int Killss = Integer.parseInt(kills.getTextContent());
	 		
	 	// write the content into xml file
 	 		TransformerFactory transformerFactory = TransformerFactory.newInstance();
 	 		javax.xml.transform.Transformer transformer = transformerFactory.newTransformer();
 	 		DOMSource source = new DOMSource(doc);
 	 		StreamResult result = new StreamResult(f);
 	  
 	 		// Output to console for testing
 	 		// StreamResult result = new StreamResult(System.out);
 	  
 	 		transformer.transform(source, result);
 	 		return Killss;
    		}
    		catch(Exception e){
    			e.printStackTrace();
    		}
		return 200;
	}
	@SuppressWarnings("deprecation")
	public int getDeaths(String playername){
		try{
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
 		DocumentBuilder docBuilder;
		docBuilder = docFactory.newDocumentBuilder();
 		Document doc = docBuilder.parse(f);
 		OfflinePlayer offlineplayer = Bukkit.getOfflinePlayer(playername);
 		offlineplayer.getUniqueId().toString();
 		Node root = getPlayerByUUID((Player)offlineplayer);
 		Node kills = root.getFirstChild();
 		Node deaths = kills.getNextSibling();
 		String next = deaths.getTextContent();
 		int finaldeath = Integer.parseInt(next);
 		TransformerFactory transformerFactory = TransformerFactory.newInstance();
	 		javax.xml.transform.Transformer transformer = transformerFactory.newTransformer();
	 		DOMSource source = new DOMSource(doc);
	 		StreamResult result = new StreamResult(f);
	  
	 		// Output to console for testing
	 		// StreamResult result = new StreamResult(System.out);
	  
	 		transformer.transform(source, result);
 		return finaldeath;
 	// write the content into xml file
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}
	 public boolean playerExists(String uuid) throws ParserConfigurationException, SAXException, IOException{
     	boolean b = false;
     	DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
  		DocumentBuilder docBuilder;
 			docBuilder = docFactory.newDocumentBuilder();
 		
 		Document doc = docBuilder.parse(f);
     	NodeList nodes = doc.getChildNodes();
     	Node node = nodes.item(0);
     	NodeList nodes2 = node.getChildNodes();
     	Bukkit.getServer().getLogger().info("length "  + nodes2.getLength() + " id ");
     	for(int i = 0; i<nodes2.getLength(); i++){
     		Node current = nodes2.item(i);
     		if(current.getAttributes().getNamedItem("name").getTextContent().equals(uuid)){
     			b= true;
     		}
     	}
     	return b;
     }
     public Node getPlayerByUUID(Player p) throws ParserConfigurationException, SAXException, IOException{
     	Node node = null;
     	DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
  		DocumentBuilder docBuilder;
 		docBuilder = docFactory.newDocumentBuilder();
 		String uuid = p.getUniqueId().toString();
 		Document doc = docBuilder.parse(f);
     	NodeList nodes = doc.getChildNodes();
     	Node nodee = nodes.item(0);
     	NodeList nodes2 = nodee.getChildNodes();
     	for(int i = 0; i<nodes2.getLength(); i++){
     		Node current = nodes2.item(i);
     		if(current.getAttributes().getNamedItem("name").getTextContent().equals(uuid)){
     			node = current;
     		}
     	}
     	return node;
     }
}
