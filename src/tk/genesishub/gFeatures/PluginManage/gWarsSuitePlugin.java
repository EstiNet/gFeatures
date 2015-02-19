package tk.genesishub.gFeatures.PluginManage;

public class gWarsSuitePlugin {
	public static PluginState state;
	public gWarsSuitePlugin(PluginState state1){
			gWarsSuitePlugin.state = state1;
	}
	public static PluginState getState(){
		return gWarsSuitePlugin.state;
	}
}
