package tk.genesishub.gFeatures.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.event.Event;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;

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

public class EffTitle extends Effect{

	  private Expression<String> plot;
	  private Expression<World> world;
	 
	  @Override
	  protected void execute(Event event){
		  Bukkit.getServer().broadcastMessage(ChatColor.GREEN + "Yes! This test worked!");

	        }
	  
	 
	  @Override
	  public String toString(Event event, boolean b){
	    return "Test worked! Party!";
	  }
	 
	  @Override
	  @SuppressWarnings("unchecked")
	  public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult){
	        world = (Expression<World>) expressions[2];
	        return true;
	  }

}
