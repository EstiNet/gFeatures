package net.estinet.gFeatures.Feature.gScore;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
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

public class ActionAPI {
	 public static boolean works = true;
	  public static String nmsver;
	  
	  public static void sendActionBar(Player player, String message)
	  {
	    try
	    {
	      Class<?> c1 = Class.forName("org.bukkit.craftbukkit." + nmsver + ".entity.CraftPlayer");
	      Object p = c1.cast(player);
	      Object ppoc = null;
	      Class<?> c4 = Class.forName("net.minecraft.server." + nmsver + ".PacketPlayOutChat");
	      Class<?> c5 = Class.forName("net.minecraft.server." + nmsver + ".Packet");
	      if ((nmsver.equalsIgnoreCase("v1_8_R1")) || (!nmsver.startsWith("v1_8_")))
	      {
	        Class<?> c2 = Class.forName("net.minecraft.server." + nmsver + ".ChatSerializer");
	        Class<?> c3 = Class.forName("net.minecraft.server." + nmsver + ".IChatBaseComponent");
	        Method m3 = c2.getDeclaredMethod("a", new Class[] { String.class });
	        Object cbc = c3.cast(m3.invoke(c2, new Object[] { "{\"text\": \"" + message + "\"}" }));
	        ppoc = c4.getConstructor(new Class[] { c3, Byte.TYPE }).newInstance(new Object[] { cbc, Byte.valueOf((byte) 2) });
	      }
	      else
	      {
	        Class<?> c2 = Class.forName("net.minecraft.server." + nmsver + ".ChatComponentText");
	        Class<?> c3 = Class.forName("net.minecraft.server." + nmsver + ".IChatBaseComponent");
	        Object o = c2.getConstructor(new Class[] { String.class }).newInstance(new Object[] { message });
	        ppoc = c4.getConstructor(new Class[] { c3, Byte.TYPE }).newInstance(new Object[] { o, Byte.valueOf((byte) 2) });
	      }
	      Method m1 = c1.getDeclaredMethod("getHandle", new Class[0]);
	      Object h = m1.invoke(p, new Object[0]);
	      Field f1 = h.getClass().getDeclaredField("playerConnection");
	      Object pc = f1.get(h);
	      Method m5 = pc.getClass().getDeclaredMethod("sendPacket", new Class[] { c5 });
	      m5.invoke(pc, new Object[] { ppoc });
	    }
	    catch (Exception ex)
	    {
	      ex.printStackTrace();
	      works = false;
	    }
	  }
}
