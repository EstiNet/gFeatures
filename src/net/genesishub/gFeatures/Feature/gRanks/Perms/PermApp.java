package net.genesishub.gFeatures.Feature.gRanks.Perms;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;

import net.genesishub.gFeatures.Feature.gRanks.Basis;
import net.genesishub.gFeatures.Feature.gRanks.Rank;

public class PermApp {
	public void setupPerms(){
		for(Rank r : Basis.getRanks()){
			File f = new File("plugins/gFeatures/gRanks/perms/" + r.getName() + ".txt");
			try {
				for(String permission : getPerms(f)){
					Basis.getRank(r.getName()).addPerm(permission);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public List<String> getPerms(File f) throws IOException{
		List<String> permissions = new ArrayList<>();
		FileInputStream is = new FileInputStream(f);
		Reader paramReader = new InputStreamReader(is);
		StringWriter writer = new StringWriter();
		IOUtils.copy(paramReader, writer);
		String theString = writer.toString();
		String[] lines = theString.split("\n");
		for(int i = 0; i < lines.length; i++){
			String perm = lines[i].replace("\r", "");
			permissions.add(perm);
		}
		return permissions;
	}
}
