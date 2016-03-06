package net.estinet.gFeatures.API.Messaging;

import java.lang.reflect.Field;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_9_R1.IChatBaseComponent;
import net.minecraft.server.v1_9_R1.PacketPlayOutChat;
import net.minecraft.server.v1_9_R1.PacketPlayOutPlayerListHeaderFooter;
import net.minecraft.server.v1_9_R1.PacketPlayOutTitle;
import net.minecraft.server.v1_9_R1.PlayerConnection;

import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_9_R1.entity.CraftPlayer;

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

/**
 * Copyright (c) 2015 nverdier
 * <p/>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to
 * do so, subject to the following conditions:
 * <p/>
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 * <p/>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF
 * OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
public class ActionAPI
{
    /**
     * Sends a title to a Player.
     *
     * @param p       The Player to send the title to.
     * @param fadeIn  The time it takes for the title to fade in.
     * @param stay    The time that the title stays.
     * @param fadeOut The time it takes for the title to fade out.
     * @param title   The String of the title. Color codes supported.
     */
    public void sendTitle(Player p, int fadeIn, int stay, int fadeOut, String title)
    {
        sendAll(p, fadeIn, stay, fadeOut, title, null, null, null, null);
    }

    /**
     * Sends a subtitle to a Player.
     *
     * @param p        The Player to send the title to.
     * @param fadeIn   The time it takes for the title to fade in.
     * @param stay     The time that the title stays.
     * @param fadeOut  The time it takes for the title to fade out.
     * @param subtitle The String of the subtitle. Color codes supported.
     */
    public void sendSubtitle(Player p, int fadeIn, int stay, int fadeOut, String subtitle)
    {
        sendAll(p, fadeIn, stay, fadeOut, null, subtitle, null, null, null);
    }

    /**
     * Sends a title and subtitle to a Player.
     *
     * @param p        The Player to send the titles to.
     * @param fadeIn   The time it takes for the title to fade in.
     * @param stay     The time that the title stays.
     * @param fadeOut  The time it takes for the title to fade out.
     * @param title    The String of the title. Color codes supported.
     * @param subtitle The String of the subtitle. Color codes supported.
     */
    public void sendTitles(Player p, int fadeIn, int stay, int fadeOut, String title, String subtitle)
    {
        sendAll(p, fadeIn, stay, fadeOut, title, subtitle, null, null, null);
    }

    /**
     * Sends an action bar message to a Player.
     *
     * @param p    The Player to send the actionbar to.
     * @param text The String of the message. Color codes supported.
     */
    public void sendActionbar(Player p, String text)
    {
        sendAll(p, 0, 0, 0, null, null, text, null, null);
    }

    /**
     * Sends the tablist header and footer to a Player.
     *
     * @param p      The Player to send the tablist header/footer to.
     * @param header The text in the header. Color codes supported.
     * @param footer The text in the footer. Color codes supported.
     */
    public void sendTablist(Player p, String header, String footer)
    {
        sendAll(p, 0, 0, 0, null, null, null, header, footer);
    }

    /**
     * @param p          The Player to send the "stuff" to.
     * @param fadeIn     The time it takes for the title to fade in.
     * @param stay       The time that the title stays.
     * @param fadeOut    The time it takes for the title to fade out.
     * @param title      The String of the title. Color codes supported.
     * @param subtitle   The String of the subtitle. Color codes supported.x
     * @param actionText The String of the message. Color codes supported.
     * @param header     The text in the header. Color codes supported.
     * @param footer     The text in the footer. Color codes supported.
     */
    public void sendAll(Player p, int fadeIn, int stay, int fadeOut, String title, String subtitle, String actionText, String header, String footer)
    {
        PlayerConnection playerConnection = ((CraftPlayer) p).getHandle().playerConnection;

        if (title != null && subtitle != null)
        {
            PacketPlayOutTitle packetPlayOutTimes = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TIMES, null, fadeIn, stay, fadeOut);
            playerConnection.sendPacket(packetPlayOutTimes);
        }

        if (title != null)
        {
            net.minecraft.server.v1_9_R1.IChatBaseComponent titleComponent = IChatBaseComponent.ChatSerializer.a("{\"text\":\"" + ChatColor.translateAlternateColorCodes('&', title) + "\"}");
            PacketPlayOutTitle titlePacket = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, titleComponent);
            playerConnection.sendPacket(titlePacket);
        }

        if (subtitle != null)
        {
            IChatBaseComponent subtitleComponent = IChatBaseComponent.ChatSerializer.a("{\"text\":\"" + ChatColor.translateAlternateColorCodes('&', subtitle) + "\"}");
            PacketPlayOutTitle subtitlePacket = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, subtitleComponent);
            playerConnection.sendPacket(subtitlePacket);
        }

        if (actionText != null)
        {
            IChatBaseComponent actionComponent = IChatBaseComponent.ChatSerializer.a("{\"text\":\"" + ChatColor.translateAlternateColorCodes('&', actionText) + "\"}");
            PacketPlayOutChat actionPacket = new PacketPlayOutChat(actionComponent, (byte) 2);
            playerConnection.sendPacket(actionPacket);
        }

        if (header != null || footer != null)
        {
            header = header == null ? "" : ChatColor.translateAlternateColorCodes('&', header);
            footer = footer == null ? "" : ChatColor.translateAlternateColorCodes('&', footer);

            IChatBaseComponent headerComponent = IChatBaseComponent.ChatSerializer.a("{\"text\":\"" + header + "\"}");
            IChatBaseComponent footerComponent = IChatBaseComponent.ChatSerializer.a("{\"text\":\"" + footer + "\"}");

            PacketPlayOutPlayerListHeaderFooter packetTablist = new PacketPlayOutPlayerListHeaderFooter(headerComponent);
            try
            {
                Field field = packetTablist.getClass().getDeclaredField("b");
                field.setAccessible(true);
                field.set(packetTablist, footerComponent);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            playerConnection.sendPacket(packetTablist);
        }
    }
}