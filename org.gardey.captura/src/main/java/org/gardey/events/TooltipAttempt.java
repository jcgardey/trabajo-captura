package org.gardey.events;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class TooltipAttempt extends UsabilityEvent {
	
	private double waitingTime;
	
	public TooltipAttempt ( ) {
		
	}

	
	public double getWaitingTime() {
		return waitingTime;
	}

	public void setWaitingTime(double waitingTime) {
		this.waitingTime = waitingTime;
	}
	
	

}
