package net.estinet.gFeatures.SQL.Player;

import java.util.ArrayList;
import java.util.List;

public class EstiData {
	private static String name;
	private static List<String> fields = new ArrayList<>();
	
	public EstiData(List<String> field){
		fields = field;
	}
	public EstiData(List<String> field, String pluginname){
		fields = field;
		name = pluginname;
	}
	public String getPluginName(){
		return name;
	}
	public List<String> getFields(){
		return fields;
	}
	public void setPluginName(String pluginname){
		name = pluginname;
	}
	public void addField(String field){
		fields.add(field);
	}
	public void removeField(String field){
		fields.remove(field);
	}
	public int getFieldNum(){
		return fields.size();
	}
}
