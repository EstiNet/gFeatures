package net.genesishub.gFeatures.Feature.gRanks;

import java.util.ArrayList;
import java.util.List;

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
		perms.add(perm);
	}
	public void addInherit(Rank inherit){
		inherits.add(inherit);
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
