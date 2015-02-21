package tk.genesishub.gFeatures.PluginManage;

public class GenesisAccessPlugin {
	static PluginState state;
	static double version;
	public GenesisAccessPlugin(){}
	public GenesisAccessPlugin(PluginState state1){
			state = state1;
	}
	public GenesisAccessPlugin(double version1){
		version = version1;
	}
	static public void setPluginState(PluginState pluginstate){
		state = pluginstate;
	}
	static public void setVersion(double pluginversion){
		version = pluginversion;
	}
	static public double getVersion(){
		return version;
	}
	static public PluginState getState(){
		return state;
	}
}
