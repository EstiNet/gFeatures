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
