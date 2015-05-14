package net.genesishub.gFeatures.Plus.Skript;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import net.genesishub.gFeatures.Extension;

import org.apache.commons.io.IOUtils;

public class SkriptManager {
	public void Enable(Extension s, String packages) throws IOException{
		try{
		Reader paramReader = new InputStreamReader(getClass().getResourceAsStream("/net/genesishub/gFeatures/Plus/Skript/" + packages + "/"+ s.getName() + ".sk"));
		StringWriter writer = new StringWriter();
		IOUtils.copy(paramReader, writer);
		String theString = writer.toString();
		File f = new File("plugins/Skript/scripts/" + s.toString() + ".sk");
		f.createNewFile();
		BufferedWriter bw = new BufferedWriter(new FileWriter(f, true));
		bw.write(theString);
		bw.close();
		}catch(Exception E){}
	}
	public void Disable(Extension s){
		File f = new File("plugins/Skript/scripts/" + s.toString() + ".sk");
		if(f.exists()){
		f.delete();
		}
	}
}
