package net.genesishub.gFeatures.Feature.gRanks.Global;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import net.genesishub.gFeatures.Feature.gRanks.Basis;
import net.genesishub.gFeatures.Feature.gRanks.Rank;
import net.genesishub.gFeatures.Feature.gRanks.Retrieve;
import net.genesishub.gFeatures.Feature.gRanks.SQLConnect;

import org.apache.commons.io.IOUtils;

public class InheritSync {
	SQLConnect c = new SQLConnect();
	Retrieve cc = new Retrieve();
	public void start(){
		String Address, Port, Tablename, Username, Password;
		Address = cc.getAddress();
		Port = cc.getPort();
		Tablename = cc.getTablename();
		Username = cc.getUsername();
		Password = cc.getPassword();
		String URL = c.toURL(Port, Address, Tablename);
		
		int cache = 0;
		try{
			int i = Integer.parseInt(c.ConnectReturn(URL, Username, Password, "SELECT COUNT(*) FROM Inherits").get(1));
			List<String> permdata = c.ConnectReturnPerm(URL, Username, Password, "SELECT * FROM Inherits;");
			for(int iter = 0; iter<i; iter++){
				String inherit = permdata.get(cache);
				cache += 1;
				String rank = permdata.get(cache);
				cache += 1;
				try{
				File f = new File("plugins/gFeatures/gRanks/ginherit/" + rank + ".txt");
				f.delete();
				f.createNewFile();
				BufferedWriter output = new BufferedWriter(new FileWriter(f, true));
				output.write(inherit + "\n");
				output.close();
				}
				catch(Exception e){
					e.printStackTrace();
					continue;
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		for(Rank rank : Basis.getRanks()){
			File f = new File("plugins/gFeatures/gRanks/ginherit/" + rank.getName() + ".txt");
			try {
				for(String inherit : getPerms(f)){
					try{
					Basis.getRank(rank.getName()).addInherit(Basis.getRank(inherit));
					}
					catch(Exception e){
						e.printStackTrace();
						continue;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public void push(){
		String Address, Port, Tablename, Username, Password;
		Address = cc.getAddress();
		Port = cc.getPort();
		Tablename = cc.getTablename();
		Username = cc.getUsername();
		Password = cc.getPassword();
		String URL = c.toURL(Port, Address, Tablename);
		c.Connect(URL, Username, Password, "TRUNCATE TABLE Inherits;");
		for(Rank rank : Basis.getRanks()){
			File f = new File("plugins/gFeatures/gRanks/ginherit/" + rank.getName() + ".txt");
			try {
				for(String inherit : getPerms(f)){
					cc.addgInherit(inherit, rank.getName());
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
