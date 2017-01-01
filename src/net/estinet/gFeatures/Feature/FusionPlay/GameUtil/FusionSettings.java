package net.estinet.gFeatures.Feature.FusionPlay.GameUtil;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2017 EstiNet

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

public class FusionSettings {

	/*
	 * FusionSettings Holder Variables
	 */

	public int secLeft = 0;
	public int waitingSecLeft = 0;
	protected int defaultWaitingSecLeft = 0;

	/*
	 * FusionGame provided settings.
	 */

	protected boolean usesSpawns = true; //Whether or not to use the built-in spawn mechanics.
	protected boolean antiDeath = true; //Prevents death screen if enabled.
	protected boolean autoLoadMap = true; //Whether or not to use built in map-loader (loads before server is fully setup)
	protected boolean dependsOnTimer = true; //Whether or not the game depends on the timer, or winning circumstance.
	protected boolean allToSpectator = true; //Whether or not to set all players to Spectator after the game ends.
	protected boolean alwaysSetTime = true; //Whether or not to always keep the current time.
	protected boolean usesPlayerCollision = true; //Whether or not to have player collision.
	protected boolean allowPlayerTakeDamage = false; //Whether or not to allow players take damage.
	protected boolean allowPlayerLoseHunger = false; //Whether or not to add hunger.
	protected boolean allowOtherMobs = false; //Whether or not to allow other mobs to exist. This will automatically turn off allowMobSpawn.
	protected boolean allowMobSpawn = false; //Whether or not to allow mobs to spawn.
	protected int startTimeOfDay = 6000; //Starting time of the game (day, night). Default is noon.
	protected String defaultMapName = "world";
	protected String coolGameName = "[CoolGame]";
	protected TimeManager timeManager = null;

	/*
	 * FusionGame Settings
	 */

	public boolean usesSpawns(){
		return usesSpawns;
	}
	public void setUsesSpawns(boolean usesSpawns){
		this.usesSpawns = usesSpawns;
	}
	public boolean usesAntiDeathScr(){
		return antiDeath;
	}
	public void setUsesAntiDeathScr(boolean antiDeath){
		this.antiDeath = antiDeath;
	}
	public boolean usesAutoLoadMap(){
		return autoLoadMap;
	}
	public void setAutoLoadMap(boolean autoLoadMap){
		this.autoLoadMap = autoLoadMap;
	}
	public String getDefaultMapName(){
		return defaultMapName;
	}
	public void setDefaultMapName(String defaultMapName){
		this.defaultMapName = defaultMapName;
	}
	public String getCoolGameName(){
		return coolGameName;
	}
	public void setCoolGameName(String alias){
		this.coolGameName = alias;
	}
	public int getWaitingSecLeft(){
		return waitingSecLeft;
	}
	public void setWaitingSecLeft(int sec){
		this.waitingSecLeft = sec;
	}
	public TimeManager getTimeManager(){
		return timeManager;
	}
	public void setTimeManager(TimeManager timeManager){
		this.timeManager = timeManager;
	}
	public boolean usesDependsOnTimer(){
		return dependsOnTimer;
	}
	public void setDependsOnTimer(boolean value){
		dependsOnTimer = value;
	}
	public boolean getAllToSpectator() {
		return allToSpectator; 
	}
	public void setAllToSpectator(boolean value){
		allToSpectator = value; 
	}
	public void setDefaultWaitingSecLeft(int defaultWaitingSec){
		this.defaultWaitingSecLeft = defaultWaitingSec;
	}
	public int getDefaultWaitingSecLeft(){
		return defaultWaitingSecLeft;
	}
	public void setStartTimeOfDay(int startTime){
		startTimeOfDay = startTime;
	}
	public int getStartTimeOfDay(){
		return startTimeOfDay;
	}
	public void setAlwaysSetTime(boolean alwaysSetTime){
		this.alwaysSetTime = alwaysSetTime;
	}
	public boolean usesAlwaysSetTime(){
		return alwaysSetTime;
	}
	public void setPlayerCollision(boolean usesPlayerCollision){
		this.usesPlayerCollision = usesPlayerCollision;
	}
	public boolean usesPlayerCollision(){
		return usesPlayerCollision;
	}
	public void setPlayerTakeDamage(boolean allowPlayerTakeDamage){
		this.allowPlayerTakeDamage = allowPlayerTakeDamage;
	}
	public boolean allowPlayerTakeDamage(){
		return allowPlayerTakeDamage;
	}
	public void setPlayerLoseHunger(boolean allowPlayerLoseHunger){
		this.allowPlayerLoseHunger = allowPlayerLoseHunger;
	}
	public boolean allowPlayerLoseHunger(){
		return allowPlayerLoseHunger;
	}
	public void setAllowOtherMobs(boolean allowOtherMobs){
		this.allowOtherMobs = allowOtherMobs;
	}
	public boolean allowOtherMobs(){
		return allowOtherMobs;
	}
	public void setAllowMobSpawn(boolean allowMobSpawn){
		this.allowMobSpawn = allowMobSpawn;
	}
	public boolean allowMobSpawn(){
		return allowMobSpawn;
	}
}
