package tk.genesishub.gFeatures.Skript.Java;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import tk.genesishub.gFeatures.Skript.Skripts;

/*
gFeatures
https://github.com/Seshpenguin/gFeatures

   Copyright 2015 DolphinBox

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
	public List<String> getList(){
		List<String> list = new ArrayList<>();
		List<Skripts> list2 = Skripts.getList();
		for(Skripts s : list2){
			list.add(s.toString());
		}
		return list;
	}
	public void Enable(Skripts s) throws IOException{
		Reader paramReader = new InputStreamReader(getClass().getResourceAsStream("/tk/genesishub/gFeatures/Skript/" + s.toString()));
		StringWriter writer = new StringWriter();
		IOUtils.copy(paramReader, writer);
		String theString = writer.toString();
		File f = new File("plugins/Skript/scripts/" + s.toString() + "/");
		f.createNewFile();
		BufferedWriter bw = new BufferedWriter(new FileWriter(f, true));
		bw.write(theString);
		bw.close();
	}
	public void Disable(Skripts s){
		File f = new File("plugins/Skript/scripts/" + s.toString() + "/");
		f.delete();
	}
}
