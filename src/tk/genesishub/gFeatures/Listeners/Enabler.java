package tk.genesishub.gFeatures.Listeners;

import java.io.FileNotFoundException;

import com.esotericsoftware.yamlbeans.YamlException;

import tk.genesishub.gFeatures.Listeners.YAML.YAMLInitialize;

public class Enabler {
	public void Enable() throws FileNotFoundException, YamlException{
		YAMLInitialize ymli = new YAMLInitialize();
		ymli.Enabler();
	}
}
