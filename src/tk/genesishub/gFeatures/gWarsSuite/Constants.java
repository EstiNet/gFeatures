package tk.genesishub.gFeatures.gWarsSuite;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.w3c.dom.Document;

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

public class Constants {
    public static List<String> bt = new ArrayList<>();
    public static List<String> ot = new ArrayList<>();
    public static List<String> arena = new ArrayList<>();
    public static List<String> gunin = new ArrayList<>();
    public static List<String> spectate = new ArrayList<>();
    public static List<String> airplaneline = new ArrayList<>();
    static String hi;
	static boolean boot, boots = true;
	static String playernukename;
	static Document doc;
	public void removeArena(Player p){
		try{
		int index = arena.indexOf(p.getName());
		arena.remove(index);
		}
		catch(Exception e){
			Bukkit.getServer().getLogger().info("This is a GenesisHub Error.");
			e.printStackTrace();
		}
	}
	public void removeGunin(Player p){
		try{
		int index = gunin.indexOf(p.getName());
		gunin.remove(index);
		}
		catch(Exception e){
			Bukkit.getServer().getLogger().info("This is a GenesisHub Error.");
			e.printStackTrace();
		}
	}
	public void removeAirplaneline(Player p){
		try{
			int index = airplaneline.indexOf(p.getName());
			airplaneline.remove(index);
			}
			catch(Exception e){
				Bukkit.getServer().getLogger().info("This is a GenesisHub Error.");
				e.printStackTrace();
			}
	}
}
