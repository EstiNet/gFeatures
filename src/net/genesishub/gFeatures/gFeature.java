package net.genesishub.gFeatures;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Event;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import com.shampaggon.crackshot.events.WeaponDamageEntityEvent;

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

public class gFeature {
	private String name;
	private String version;
	private FeatureState state;
	private String commandlabel;
	
	public gFeature(String featurename, String d){
		name = featurename;
		version = d;
	}
	public void setName(String featurename){
		name = featurename;
		return;
	}
	public void setVersion(String featureversion){
		version = featureversion;
		return;
	}
	public void setState(FeatureState states){
		state = states;
		return;
	}
	public void setCommandLabel(String label){
		commandlabel = label;
		return;
	}
	public String getName(){
		return name;
	}
	public String getVersion(){
		return version;
	}
	public FeatureState getState(){
		return state;
	}
	public String getCommandLabel(){
		return commandlabel;
	}
	public void enable(){}
	public void disable(){}
	public void eventTrigger(Event event){}
	public void commandTrigger(CommandSender sender, Command cmd, String label, String[] args){}
	public void onPlayerJoin(){}
	public void onPlayerLeave(){}
    public void onPlayerMove(){}
    public void onPlayerRespawn(){}
    public void onPlayerDeath(){}
    public void onEntityDamageByEntity() {}
    public void onWeaponDamageEntity() {}
    public void onPlayerInteract(){}
    public void onPlayerBreakBlock(){}
    public void onPlayerChat(){}
    public void onPlayerCommand(){}
    public void onPlayerOpenInventory(){}
    public void onPlayerItemHeld(){}
}
