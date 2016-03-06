package net.estinet.gFeatures.Feature.gRanks.Global;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import net.estinet.gFeatures.Feature.gRanks.Basis;
import net.estinet.gFeatures.Feature.gRanks.Rank;
import net.estinet.gFeatures.Feature.gRanks.Retrieve;
import net.estinet.gFeatures.Feature.gRanks.SQLConnect;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2016 EstiNet

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

public class FileSync {
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
			for(Rank rank : Basis.getRanks()){
				PrintWriter pw = new PrintWriter("plugins/gFeatures/gRanks/gperms/" + rank.getName() + ".txt");
				pw.close();
			}
			List<String> permdata = c.ConnectReturnPerm(URL, Username, Password, "SELECT * FROM Perms;");
			for(int iter = 0; iter<permdata.size(); iter++){
				try{
				String perm = permdata.get(cache);
				cache += 1;
				String rank = permdata.get(cache);
				cache += 1;
				BufferedWriter output = new BufferedWriter(new FileWriter(new File("plugins/gFeatures/gRanks/gperms/" + rank + ".txt"), true));
				output.write(perm);
				output.newLine();
				output.close();
				}
				catch(Exception e){
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		for(Rank rank : Basis.getRanks()){
			File f = new File("plugins/gFeatures/gRanks/gperms/" + rank.getName() + ".txt");
			try {
				for(String perm : getPerms(f)){
					Basis.getRank(rank.getName()).addPerm(perm);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public void push(){
		Thread thread = new Thread(new FilePush());
		thread.start();
		return;
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
