package net.estinet.gFeatures.Feature.gDestroyCritical;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
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

public class ArenaSetup{
	Constants cons = new Constants();
	public void Assemble() throws IOException{
		Bukkit.getServer().broadcastMessage("Choosing a random arena for the game...");
		File[] worlddata = cons.directory.listFiles();
		List<String> arrayworlddata = new ArrayList<String>();
		int counter = 0;
		for(File file: worlddata){
			String filename = file.getName();
			arrayworlddata.add(counter, filename);
			counter++;
		}
		int randomnum = (int) Math.floor(Math.random()*arrayworlddata.size());
		String filenamechosen = arrayworlddata.get(randomnum);
		Bukkit.getServer().broadcastMessage("The map chosen was " + filenamechosen + "!");
		File worldchosen = new File("plugins/gDestroy/gDestroyMaps/"+filenamechosen);
		Path currentRelativePath = Paths.get("");
		String s = currentRelativePath.toAbsolutePath().toString();
		File defaults = new File(s);
		copy(worldchosen, defaults);
	}
	  public void arenaSetup(){
	    	 Constants.arenaon = true;
	    	 try {
				Assemble();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				Bukkit.getLogger().info("UHOH");
			}
	    	 cons.sched.scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
	         	public void run(){
	            gameEnd();
	     		}
	         }, 12000L);
	    	 return;
	     }
	  @SuppressWarnings({ "deprecation", "unused" })
	public void gameEnd(){
	    	 Bukkit.getServer().broadcastMessage("The match has ended! Stats are currently being processed...");
	    	 for (Player p : Bukkit.getServer().getOnlinePlayers()) {
	     		for(Player player : Bukkit.getServer().getOnlinePlayers()) {
	     			player.teleport(cons.spectate);
	     			cons.Acceptance.remove(player.getName());
	     			player.setGameMode(GameMode.SPECTATOR);
	     			 cons.BlockBroke.set(cons.Acceptance.indexOf(player.getName()), "0");
				}
	     	}
	    	 cons.sched.scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
	          	public void run(){
	            Bukkit.getServer().broadcastMessage("The leaderboard stats are:");
	            //LEADERBOARD STUFF HERE
	            for (Player p : Bukkit.getServer().getOnlinePlayers()) {
		     		for(Player player : Bukkit.getServer().getOnlinePlayers()) {
		     			player.teleport(cons.lobby);
		     			player.setGameMode(GameMode.SURVIVAL);
		     			cons.Acceptance.remove(player.getName());
		     			 cons.BlockBroke.set(cons.Acceptance.indexOf(player.getName()), "0");
					}
		     	}
	            }
	          }, 720L);//1 minute
	    	 Constants.arenaon = false;
	    	 return;
	     }
	  public void run(){ 
			Bukkit.getServer().broadcastMessage("Doing quick scan for enough players...");
			quickCheck(cons.Acceptance.size());
		}
		 public void quickCheck(int playersready){
	    	 if(playersready>1){
	    		 Bukkit.getServer().broadcastMessage("There are enough players to start gDestroy! Setting up the map...");
	    		 arenaSetup();
	    	 }
	    	 else{
	    		 Bukkit.getServer().broadcastMessage("There are not enough players to start gDestroy! There needs to be 2 or more people who did /join! Do /join now!");
	    	 }
	     }
		 public void copy(File sourceLocation, File targetLocation) throws IOException {
			    if (sourceLocation.isDirectory()) {
			        copyDirectory(sourceLocation, targetLocation);
			    } else {
			        copyFile(sourceLocation, targetLocation);
			    }
			}

			private void copyDirectory(File source, File target) throws IOException {
			    if (!target.exists()) {
			        target.mkdir();
			    }

			    for (String f : source.list()) {
			        copy(new File(source, f), new File(target, f));
			    }
			}

			private void copyFile(File source, File target) throws IOException {        
			    try (
			            InputStream in = new FileInputStream(source);
			            OutputStream out = new FileOutputStream(target)
			    ) {
			        byte[] buf = new byte[1024];
			        int length;
			        while ((length = in.read(buf)) > 0) {
			            out.write(buf, 0, length);
			        }
			    }
			}
}