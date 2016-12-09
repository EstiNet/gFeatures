package net.estinet.gFeatures.Feature.FusionPlay.GameUtil;

import java.util.concurrent.TimeUnit;

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
