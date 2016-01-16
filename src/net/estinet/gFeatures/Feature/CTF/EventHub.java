package net.estinet.gFeatures.Feature.CTF;

import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import net.estinet.gFeatures.Feature.CTF.EventBase.Join;
import net.estinet.gFeatures.Feature.CTF.EventBase.Leave;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2015 EstiNet

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

public class EventHub{
	Join join = new Join();
	Leave leave = new Leave();
	public void onPlayerJoin(PlayerJoinEvent event){
		join.init(event);
	}
	public void onPlayerLeave(PlayerQuitEvent event){
		leave.init(event);
	}
}
