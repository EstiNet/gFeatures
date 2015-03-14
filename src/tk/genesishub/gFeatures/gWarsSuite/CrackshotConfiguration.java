package tk.genesishub.gFeatures.gWarsSuite;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;

import org.apache.commons.io.IOUtils;

public class CrackshotConfiguration {
	public void Initialize() throws IOException{
		Reader paramReader = new InputStreamReader(getClass().getResourceAsStream("/tk/genesishub/gFeatures/Commands/Config/"));
		StringWriter writer = new StringWriter();
		IOUtils.copy(paramReader, writer);
		String theString = writer.toString();
	}
}
