package net.estinet.gFeatures.Feature.CTF.Confligs;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;

import org.apache.commons.io.IOUtils;

public class ConfligInit {
	public void createConfigs(){
		try {
			MakeFile("LaserRifle");
			MakeFile("DualLaserPistols");
			MakeFile("PlasmaShotgun");
			MakeFile("PlasmaSniper");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void deleteConfigs(){
		try {
			DeleteFile("LaserRifle");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void MakeFile(String filename) throws IOException{
		Reader paramReader = new InputStreamReader(getClass().getResourceAsStream("/net/estinet/gFeatures/Feature/CTF/Confligs/" + filename));
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
