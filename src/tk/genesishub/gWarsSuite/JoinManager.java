package tk.genesishub.gWarsSuite;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class JoinManager{
	Constants cons = new Constants();
	StatsRetrieve sr = new StatsRetrieve();
	FileManager fm = new FileManager();
	File f = new File("KillsDeaths.xml");
	TierSelectionMenu tsm = new TierSelectionMenu();
	public void JoinManage(PlayerJoinEvent event) throws ParserConfigurationException, TransformerException, SAXException, IOException{
		Player player = event.getPlayer();
    		Player p = event.getPlayer();
            boolean b = sr.playerExists(p.getUniqueId().toString());
    		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
     		DocumentBuilder docBuilder;
    			docBuilder = docFactory.newDocumentBuilder();
    		Document doc = docBuilder.parse(f);
    		if(!(b)){
    			fm.createaNode(p);
    		}
    		int hello = doc.getElementsByTagName(p.getName()).getLength();
    		String hello1 ="";
    		hello1=Integer.toString(hello);
    		Bukkit.getServer().getLogger().info(hello1);
    	player.setGameMode(GameMode.SURVIVAL);
    	Bukkit.getServer().broadcastMessage(player.getName()+" has joined gWars!");
    	if(Constants.ot.size() > Constants.bt.size()){
    		Constants.bt.add(player.getName());
    		Bukkit.getServer().broadcastMessage(player.getName()+" has joined the Blue Team!");
    		double x = Double.parseDouble("134");//insert x
            double y = Double.parseDouble("53");//insert y
            double z = Double.parseDouble("282");//insert z
            Location e = new Location(player.getWorld(), x, y, z);
            ItemStack wool = new ItemStack(Material.STAINED_GLASS, 1, (byte)3);
            ItemStack chest = new ItemStack(Material.CHEST, 1);
            ItemMeta im = chest.getItemMeta();
            im.setDisplayName(ChatColor.AQUA + "Select Gun");
            chest.setItemMeta(im);
            player.getInventory().setHelmet(wool);
            player.getInventory().setHeldItemSlot(0);
            player.getInventory().setItemInHand(chest);
            player.teleport(e);//tp's to blue spawn
            player.getLocation().getWorld().setSpawnLocation((int)player.getLocation().getX(), (int)player.getLocation().getY(), (int)player.getLocation().getZ());
    	}
    	else{
    		Constants.ot.add(player.getName());
    		Bukkit.getServer().broadcastMessage(player.getName()+ " has joined the Orange Team!");
    		 double x1 = Double.parseDouble("134");//insert x
            double y1 = Double.parseDouble("11");//insert y
            double z1 = Double.parseDouble("282");//insert z
            Location e1 = new Location(player.getWorld(), x1, y1, z1);
            ItemStack wool = new ItemStack(Material.STAINED_GLASS, 1, (byte)1);
            ItemStack chest = new ItemStack(Material.CHEST, 1);
            ItemMeta im = chest.getItemMeta();
            im.setDisplayName(ChatColor.AQUA + "Select Gun");
            chest.setItemMeta(im);
            player.getInventory().setHelmet(wool);
            player.getInventory().setHeldItemSlot(0);
            player.getInventory().setItemInHand(chest);
            player.teleport(e1);//tp's to orange spawn
            player.getLocation().getWorld().setSpawnLocation((int)player.getLocation().getX(), (int)player.getLocation().getY(), (int)player.getLocation().getZ());
            }
    	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "clear "+ player.getName());
         ItemStack chest = new ItemStack(Material.CHEST, 1);
         ItemMeta im = chest.getItemMeta();
         im.setDisplayName(ChatColor.AQUA + "Select Gun");
         chest.setItemMeta(im);
         player.getInventory().setItemInHand(chest);
	}
}
