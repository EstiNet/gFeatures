package net.estinet.gFeatures.ClioteSky;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;

public class ClioteConfigUtil {
	public void load(){
		File f = new File("plugins/gFeatures/Config.yml");
		YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(f);
		ClioteSky.setName(yamlFile.get("Config.ClioteSky.Name").toString());
		ClioteSky.setCategory(yamlFile.get("Config.ClioteSky.Category").toString());
		ClioteSky.setAddress(yamlFile.get("Config.ClioteSky.Address").toString());
		ClioteSky.setEnable(Boolean.parseBoolean(yamlFile.get("Config.ClioteSky.Enable").toString()));
		ClioteSky.setPassword(yamlFile.get("Config.ClioteSky.Password").toString());
		ClioteSky.setPort(yamlFile.get("Config.ClioteSky.Port").toString());
		File file = new File("plugins/gFeatures/cliotecache.txt");
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public void resetCache(){
		File file = new File("plugins/gFeatures/cliotecache.txt");
		file.delete();
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void addCacheEntry(String message){
		File file = new File("plugins/gFeatures/cliotecache.txt");
		ClioteSky.cachedQueries.add(message);
		BufferedWriter output;
		try {
			output = new BufferedWriter(new FileWriter(file, true));
			output.write(message + "\n");
			output.newLine();
			output.close();
		}
		catch(Exception e){}
	}
	public void fillCacheFromFile(){
		try (BufferedReader br = new BufferedReader(new FileReader("plugins/gFeatures/cliotecache.txt"))){
			String CurrentLine;
			while ((CurrentLine = br.readLine()) != null) {
				ClioteSky.cachedQueries.add(CurrentLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
