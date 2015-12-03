package net.estinet.gFeatures.Feature.gWarsSuite.Configs;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;

import org.apache.commons.io.IOUtils;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2015 EstiNet

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

public class CrackshotConfiguration {
	public void Initialize(boolean state) throws IOException{
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
			MakeFile("beretta-arx100");
			MakeFile("fn-tps");
			MakeFile("sr-25");
			MakeFile("crossbow");
		}
		else{
			DeleteFile("ak47silver");
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
			DeleteFile("beretta-arx100");
			DeleteFile("fn-tps");
			DeleteFile("sr-25");
			DeleteFile("crossbow");
		}
	}
	public void MakeFile(String filename) throws IOException{
		Reader paramReader = new InputStreamReader(getClass().getResourceAsStream("/net/estinet/gFeatures/Feature/gWarsSuite/Configs/" + filename));
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
