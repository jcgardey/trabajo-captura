package org.gardey.utils;


import org.apache.commons.lang.time.StopWatch;
import org.apache.log4j.Logger;
import org.gardey.App;

public class Timer {
	
	private StopWatch watch;
	
	private static Timer instance;
	
	private Timer () {
		this.watch = new StopWatch();
	}
	
	public static Timer getInstance() {
		if (instance == null) {
			instance = new Timer();
		}
		return instance;
	}
	
	public void start () {
		this.watch.start();
	}
	
	public long stop() {
		this.watch.stop();
		long currentTime = this.watch.getTime();
		Logger.getLogger(System.getProperty("targetDatastore")).info("QUERY TOTAL TIME ELAPSED: " + currentTime + " ms");
		this.watch.reset();
		return currentTime;
	}
	
}
