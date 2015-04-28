package tk.genesishub.gFeatures.gUtilities;

import java.io.File;
import java.io.IOException;

public class FileCheck {
	File f = new File("plugins/gFeatures/gUtilities/Config.yml");
	public void CheckYML() throws IOException{
		if(f.exists()){
			CheckValues();
			return;
		}
		else{
			YML yml = new YML();
			yml.create();
		}
	}
	public void CheckValues(){
		
	}
}
