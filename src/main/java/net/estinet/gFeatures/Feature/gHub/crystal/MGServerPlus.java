package net.estinet.gFeatures.Feature.gHub.crystal;

/*
 * gFeatures
 * https://github.com/EstiNet/gFeatures
 *
 *    Copyright 2019 EstiNet
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *
 */

public class MGServerPlus {
	private String name;
	private String state;
	private int numOfPlayers;
	private String map;
	public MGServerPlus(String name, String state, String numOfPlayers, String map){
		this.name = name;
		this.state = state;
		this.numOfPlayers = Integer.parseInt(numOfPlayers);
		this.map = map;
	}
	public String getName(){
		return name;
	}
	public String getState(){
		return state;
	}
	public int getNumOfPlayers(){
		return numOfPlayers;
	}
	public String getMap(){
		return map;
	}
}
