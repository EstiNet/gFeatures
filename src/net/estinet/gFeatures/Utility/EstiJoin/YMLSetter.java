package net.estinet.gFeatures.Utility.gMotd;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import net.estinet.gFeatures.Configuration.Config;

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
