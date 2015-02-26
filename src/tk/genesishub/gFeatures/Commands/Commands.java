package tk.genesishub.gFeatures.Commands;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import org.apache.commons.io.IOUtils;

public class Commands {
	public boolean Check(String check, String command) throws IOException{
		Reader paramReader = new InputStreamReader(getClass().getResourceAsStream("/tk/genesishub/gFeatures/Commands/Config/" + check));
		StringWriter writer = new StringWriter();
		IOUtils.copy(paramReader, writer);
		String theString = writer.toString();
		String[] lines = theString.split("\n");
		for(int i = 0; i < lines.length; i++){
			if(lines[i].equals(command)){
				return true;
			}
		}
		return false;
	}
}
