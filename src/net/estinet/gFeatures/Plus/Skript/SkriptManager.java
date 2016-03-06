package net.estinet.gFeatures.Plus.Skript;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import net.estinet.gFeatures.Extension;

import org.apache.commons.io.IOUtils;

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

public class SkriptManager {
	public void Enable(Extension s, String packages) throws IOException{
		try{
		Reader paramReader = new InputStreamReader(getClass().getResourceAsStream("/net/estinet/gFeatures/Plus/Skript/" + packages + "/"+ s.getName() + ".sk"));
		StringWriter writer = new StringWriter();
		IOUtils.copy(paramReader, writer);
		String theString = writer.toString();
		File f = new File("plugins/Skript/scripts/" + s.getName() + ".sk");
		f.createNewFile();
		BufferedWriter bw = new BufferedWriter(new FileWriter(f, true));
		bw.write(theString);
		bw.close();
		}catch(Exception E){}
	}
	public void Disable(Extension s){
		File f = new File("plugins/Skript/scripts/" + s.getName() + ".sk");
		if(f.exists()){
		f.delete();
		}
	}
}
