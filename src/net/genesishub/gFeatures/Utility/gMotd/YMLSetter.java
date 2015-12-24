package net.genesishub.gFeatures.Utility.gMotd;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import net.genesishub.gFeatures.Configuration.Config;

public class YMLSetter {
	public static String motd = "";
	public void enableCheck(){
		Config c = new Config();
		c.createFile("plugins/gFeatures/motd.txt", "Created MOTD file!");
		try {
			motd = readFile("plugins/gFeatures/motd.txt", Charset.defaultCharset());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String readFile(String path, Charset encoding) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}
	public static String getMotd(){
		String motds = motd.replace('&', '§');
		return motds;
	}
}
