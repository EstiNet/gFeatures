package net.genesishub.gFeatures.Feature.gWarsSuite;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;

import org.apache.commons.io.IOUtils;

public class Configuration {
	public Configuration(boolean state){
		try{
		if(state == true){
			MakeFile("ak47silver");
			MakeFile("autorifle");
			MakeFile("bazooka");
			MakeFile("coltmodel1");
			MakeFile("flamethrower");
			MakeFile("m16");
			MakeFile("Python");
			MakeFile("shotgun");
			MakeFile("silsil69");
			MakeFile("sniper");
			MakeFile("spas");
			MakeFile("ulr338");
		}
		else{
			DeleteFile("ak47blackedition");
			DeleteFile("autorifle");
			DeleteFile("bazooka");
			DeleteFile("coltmodel1");
			DeleteFile("flamethrower");
			DeleteFile("m16");
			DeleteFile("Python");
			DeleteFile("shotgun");
			DeleteFile("silsil69");
			DeleteFile("sniper");
			DeleteFile("spas");
			DeleteFile("ulr338");
		}
		}
		catch(Exception e){}
	}
	public void MakeFile(String filename) throws IOException{
		Reader paramReader = new InputStreamReader(getClass().getResourceAsStream("/net/genesishub/gFeatures/Feature/gWarsSuite/" + filename));
		StringWriter writer = new StringWriter();
		IOUtils.copy(paramReader, writer);
		String theString = writer.toString();
		File f = new File("plugins/CrackShot/weapons/" + filename + ".yml");
		f.createNewFile();
		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		bw.write(theString);
		bw.close();
	}
	public void DeleteFile(String filename) throws IOException{
		File f = new File("plugins/CrackShot/weapons/" + filename + ".yml");
		f.delete();
	}
}
