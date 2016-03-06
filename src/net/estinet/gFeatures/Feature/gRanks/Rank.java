package net.estinet.gFeatures.Feature.gRanks;

import java.util.ArrayList;
import java.util.List;

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

public class Rank {
	private String name, prefix;
	private List<String> people = new ArrayList<>();
	private List<String> perms = new ArrayList<>();
	private List<Rank> inherits = new ArrayList<>();
	public Rank(String names, String prefixx){
		name = names;
		prefix = prefixx;
	}
	public String getName(){
		return name;
	}
	public String getPrefix(){
		return prefix;
	}
	public void addPerson(String UUID){
		people.add(UUID);
	}
	public void addPerm(String perm){
		if(perm.equals("")){}
		else if(perms.contains(perm)){}
		else{
		perms.add(perm);
		}
	}
	public void addInherit(Rank inherit){
		try{
		if(inherit.equals("")){}
		else if(inherits.contains(inherit)){}
		else{
		inherits.add(inherit);
		}
		}
		catch(Exception e){}
	}
	public boolean removePerson(String UUID){
		if(people.contains(UUID)){
			people.remove(UUID);
			return true;
		}
		return false;
	}
	public boolean removePerm(String perm){
		if(perms.contains(perm)){
			perms.remove(perm);
			return true;
		}
		return false;
	}
	public void removeInherit(Rank inherit){
		for(int iter = 0; iter < inherits.size(); iter++){
			if(inherits.get(iter).getName().equals(inherit.getName())){
				inherits.remove(iter);
			}
		}
	}
	public boolean isPerm(String perm){
		if(perms.contains(perm)){
			return true;
		}
		return false;
	}
	public List<String> getPerms(){
		return perms;
	}
	public List<String> getPersonList(){
		return people;
	}
	public List<Rank> getInheritList(){
		return inherits;
	}
	public void setName(String newname){
		name = newname;
	}
	public void setPrefix(String newprefix){
		prefix = newprefix;
	}
	public void setPersonList(List<String> newlist){
		people = newlist;
	}
}
