package tk.genesishub.gFeatures.PluginManage;

public class HideAndSeekPlugin {
	public static PluginState state;
	static double version;
	public HideAndSeekPlugin(){}
	public HideAndSeekPlugin(PluginState state1){
			HideAndSeekPlugin.state = state1;
	}
	public HideAndSeekPlugin(double version1){
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
		return HideAndSeekPlugin.state;
	}
}
