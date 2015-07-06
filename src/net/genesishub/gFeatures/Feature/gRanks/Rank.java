package net.genesishub.gFeatures.Feature.gRanks;

import java.util.ArrayList;
import java.util.List;

public class Rank {
	private String name, prefix;
	private List<String> people = new ArrayList<>();
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
	public boolean removePerson(String UUID){
		if(people.contains(UUID)){
			people.remove(UUID);
			return true;
		}
		return false;
	}
	public List<String> getPersonList(){
		return people;
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
