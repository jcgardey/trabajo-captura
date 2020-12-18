package org.gardey.events;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class UnfilledForm extends UsabilityEvent {
	
	private double time;
	
	public UnfilledForm () {
		
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}
	

}
