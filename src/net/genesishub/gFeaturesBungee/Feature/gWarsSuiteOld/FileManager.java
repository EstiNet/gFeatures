package net.genesishub.gFeatures.Feature.gWarsSuiteOld;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/*
gFeatures
https://github.com/GenesisHub/gFeatures

   Copyright 2015 GenesisHub

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

public class FileManager{
	File f = new File("KillsDeaths.xml");
	Constants cons = new Constants();
	public void createaNode(Player p) throws ParserConfigurationException, TransformerException, SAXException, IOException{
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
 		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
 		Document doc = docBuilder.parse(f);
 		Node list = doc.getFirstChild();
 		Element element = doc.createElement(p.getName());
 		list.appendChild(element);
 		Attr attribute = doc.createAttribute("name");
 		attribute.setValue(p.getUniqueId().toString());
 		element.setAttributeNode(attribute);
 		Element Kills = doc.createElement("Kills");
 		element.appendChild(Kills);
 		Kills.appendChild(doc.createTextNode("0"));
 		Element Deaths = doc.createElement("Deaths");
 		element.appendChild(Deaths);
 		Deaths.appendChild(doc.createTextNode("0"));
 		TransformerFactory transformerFactory = TransformerFactory.newInstance();
 		javax.xml.transform.Transformer transformer = transformerFactory.newTransformer();
 		DOMSource source = new DOMSource(doc);
 		StreamResult result = new StreamResult(f);
 		Bukkit.getServer().getLogger().info("Player Saved!");
 		transformer.transform(source, result);
	}
	public void EnablerCheck(){
		 if(!f.exists()){
	         try {
	        	 Bukkit.getServer().getLogger().info("Creating a new file...");
	     		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	     		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	     		Document doc = docBuilder.newDocument();
	     		Element rootElement = doc.createElement("Players");
	     		doc.appendChild(rootElement);
	     		Element Player = doc.createElement("Player");
	     		rootElement.appendChild(Player);
	     		Attr attribute = doc.createAttribute("name");
	     		
	     		Player.setAttributeNode(attribute);
	     		
	     		Element Kills = doc.createElement("Kills");
	     		Player.appendChild(Kills);
	     		
	     		Element Deaths = doc.createElement("Deaths");
	     		Player.appendChild(Deaths);
	     		TransformerFactory transformerFactory = TransformerFactory.newInstance();
	     		javax.xml.transform.Transformer transformer = transformerFactory.newTransformer();
	     		DOMSource source = new DOMSource(doc);
	     		StreamResult result = new StreamResult(f);
	     		transformer.transform(source, result);
	      
	     		Bukkit.getServer().getLogger().info("File saved!");
	      
	     	  } catch (ParserConfigurationException pce) {
	     		pce.printStackTrace();
	     	  } catch (TransformerException tfe) {
	     		tfe.printStackTrace();
	     	  }
		 }
	}
	
}
