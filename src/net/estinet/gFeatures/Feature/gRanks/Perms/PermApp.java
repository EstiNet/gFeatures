package net.estinet.gFeatures.Feature.gRanks.Perms;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import net.estinet.gFeatures.Feature.gRanks.Basis;
import net.estinet.gFeatures.Feature.gRanks.Rank;

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
		for(Rank r : Basis.getRanks()){
			try {
				for(String inherit : getPerms(new File("plugins/gFeatures/gRanks/inherit/" + r.getName() + ".txt"))){
					try{
						for(String perm : Basis.getRank(inherit).getPerms()){
							r.addInherit(Basis.getRank(inherit));
							r.addPerm(perm);
						}
					}
					catch(Exception e){}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		for(Rank r : Basis.getRanks()){
			try {
				for(String inherit : getPerms(new File("plugins/gFeatures/gRanks/inherit/" + r.getName() + ".txt"))){
					try{
						for(String perm : Basis.getRank(inherit).getPerms()){
							r.addInherit(Basis.getRank(inherit));
							r.addPerm(perm);
						}
					}
					catch(Exception e){}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		for(Rank r : Basis.getRanks()){
			try {
				for(String inherit : getPerms(new File("plugins/gFeatures/gRanks/inherit/" + r.getName() + ".txt"))){
					try{
						for(String perm : Basis.getRank(inherit).getPerms()){
							r.addInherit(Basis.getRank(inherit));
							r.addPerm(perm);
						}
					}
					catch(Exception e){}
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
