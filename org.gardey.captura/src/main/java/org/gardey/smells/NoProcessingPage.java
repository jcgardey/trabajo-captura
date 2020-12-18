package org.gardey.smells;

import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class NoProcessingPage extends UsabilitySmell {
	
	private double timeAverage;
	
	private int eventsCount;
	
	public NoProcessingPage() {
		
	}

	public double getTimeAverage() {
		return timeAverage;
	}

	public void setTimeAverage(double timeAverage) {
		this.timeAverage = timeAverage;
	}

	public int getEventsCount() {
		return eventsCount;
	}

	public void setEventsCount(int eventsCount) {
		this.eventsCount = eventsCount;
	}
	
}
