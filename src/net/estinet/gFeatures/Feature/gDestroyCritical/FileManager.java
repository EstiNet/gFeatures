package net.estinet.gFeatures.Feature.gDestroyCritical;

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
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

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

public class FileManager{
	Constants cons = new Constants();
	public void AssembleFile(File f){
        try {
       	    Bukkit.getLogger().info("Creating a new file...");
    		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
    		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
     
    		// root elements
    		Document doc = docBuilder.newDocument();
    		Element rootElement = doc.createElement("Players");
    		doc.appendChild(rootElement);
    		
    		// staff elements
    		Element Player = doc.createElement("Player");
    		rootElement.appendChild(Player);
    		
    		Attr attribute = doc.createAttribute("name");
    		
    		Player.setAttributeNode(attribute);
    		
    		Element BlocksBroken = doc.createElement("BlocksBroken");
    		Player.appendChild(BlocksBroken);
    		
    		Element Points = doc.createElement("Points");
    		Player.appendChild(Points);
    	
    		// write the content into xml file
    		TransformerFactory transformerFactory = TransformerFactory.newInstance();
    		javax.xml.transform.Transformer transformer = transformerFactory.newTransformer();
    		DOMSource source = new DOMSource(doc);
    		StreamResult result = new StreamResult(f);
     
    		// Output to console for testing
    		// StreamResult result = new StreamResult(System.out);
     
    		transformer.transform(source, result);
     
    		Bukkit.getLogger().info("File saved!");
     
    	  } catch (ParserConfigurationException pce) {
    		pce.printStackTrace();
    	  } catch (TransformerException tfe) {
    		tfe.printStackTrace();
    	  }
	}
	public void BreakBlockSave(Player p){
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
 		DocumentBuilder docBuilder;
		
		try {
			docBuilder = docFactory.newDocumentBuilder();
		
 		Document doc = docBuilder.parse(cons.f);
 		
 		NodeList listbad = doc.getElementsByTagName(p.getName());
 		Node list = listbad.item(0);
 		
 		Node notDeaths = list.getFirstChild();
 		Node deaths = notDeaths.getNextSibling();
 		String deaths2 = deaths.getTextContent();
 		int foo = Integer.parseInt(deaths2);
 		foo += 1;
 		String backtostring = Integer.toString(foo);
 		deaths.setTextContent(backtostring);
 		
 	// write the content into xml file
 	 		TransformerFactory transformerFactory = TransformerFactory.newInstance();
 	 		javax.xml.transform.Transformer transformer = transformerFactory.newTransformer();
 	 		DOMSource source = new DOMSource(doc);
 	 		StreamResult result = new StreamResult(cons.f);
 	  
 	 		// Output to console for testing
 	 		// StreamResult result = new StreamResult(System.out);
 	  
 	 		transformer.transform(source, result);
 	 		}
 	 		catch(Exception e){
 	 			Bukkit.getLogger().info("UHOH");
 	 		}
	}
	public void Savepoints(Player p, int num){
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
 		DocumentBuilder docBuilder;
		
		try {
			docBuilder = docFactory.newDocumentBuilder();
		
 		Document doc = docBuilder.parse(cons.f);
 		
 		NodeList listbad = doc.getElementsByTagName(p.getName());
 		Node list = listbad.item(0);
 		
 		Node notDeaths = list.getFirstChild();
 		Node deaths = notDeaths.getNextSibling();
 		String deaths2 = deaths.getTextContent();
 		int foo = Integer.parseInt(deaths2);
 		foo += num;
 		String backtostring = Integer.toString(foo);
 		deaths.setTextContent(backtostring);
 		
 	// write the content into xml file
 	 		TransformerFactory transformerFactory = TransformerFactory.newInstance();
 	 		javax.xml.transform.Transformer transformer = transformerFactory.newTransformer();
 	 		DOMSource source = new DOMSource(doc);
 	 		StreamResult result = new StreamResult(cons.f);
 	  
 	 		// Output to console for testing
 	 		// StreamResult result = new StreamResult(System.out);
 	  
 	 		transformer.transform(source, result);
 	 		}
 	 		catch(Exception e){
 	 			Bukkit.getLogger().info("UHOH");
 	 		}
	}
	public void setupPlayer(Player p) throws ParserConfigurationException, TransformerException, SAXException, IOException{
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
 		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
 		Document doc = docBuilder.parse(cons.f);
 		
 		Node list = doc.getFirstChild();
 		Element element = doc.createElement(p.getName());
 		list.appendChild(element);
 		
 		
 		Attr attribute = doc.createAttribute("name");
 		attribute.setValue(p.getName());
 		element.setAttributeNode(attribute);
 		
 		
 		Element Kills = doc.createElement("BlocksBroken");
 		element.appendChild(Kills);
 		Kills.appendChild(doc.createTextNode("0"));
 		     		
 		Element Deaths = doc.createElement("Points");
 		element.appendChild(Deaths);
 		Deaths.appendChild(doc.createTextNode("0"));
 	
 		// write the content into xml file
 		TransformerFactory transformerFactory = TransformerFactory.newInstance();
 		javax.xml.transform.Transformer transformer = transformerFactory.newTransformer();
 		DOMSource source = new DOMSource(doc);
 		StreamResult result = new StreamResult(cons.f);
  
 		// Output to console for testing
 		// StreamResult result = new StreamResult(System.out);
  
 		transformer.transform(source, result);
  
 		Bukkit.getLogger().info("Player saved!");
 	
	}
	public void checkDirectories(){
		if(!(cons.main.isDirectory())){
			cons.main.mkdir();
			Bukkit.getLogger().info("Seems like it's the first time you ran gDestroy...");
			Bukkit.getLogger().info("Successfully added plugin data folders!");
		}
		if(!(cons.directory.isDirectory())){
			cons.directory.mkdir();
			Bukkit.getLogger().info("Successfully added plugin data folders!");
		}
		Bukkit.getLogger().info("Plugin data check completed.");
	}
}
