package net.estinet.gFeatures.Feature.FusionPlay.GameUtil;

import java.util.concurrent.TimeUnit;

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

public class TimeManager {
	private double length = 1;
	private TimeUnit timeunit = TimeUnit.MINUTES;
	public TimeManager(double length, TimeUnit timeunit){
		this.length = length;
		this.timeunit = timeunit;
	}
	public double getLength(){
		return length;
	}
	public TimeUnit getTimeUnit(){
		return timeunit;
	}
	public void setLength(double length){
		this.length = length;
	}
	public void setTimeUnit(TimeUnit timeunit){
		this.timeunit = timeunit;
	}
}
