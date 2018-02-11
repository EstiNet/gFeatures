package net.estinet.gFeatures.ClioteSky.API;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2018 EstiNet

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

import java.util.List;

import net.estinet.gFeatures.gFeature;

public class ClioteHook{
	private gFeature gf;
	private String argument;
	public ClioteHook(gFeature feature, String coreArgument){
		gf = feature;
		argument = coreArgument;
	}
	public gFeature getgFeature(){
		return gf;
	}
	public String getCoreArgument(){
		return argument;
	}
	public void setgFeature(gFeature gf){
		this.gf = gf;
	}
	public void setCoreArgument(String coreArg){
		argument = coreArg;
	}
	//Must override
	public void run(List<String> args, String categoryName, String clioteName){}
}
