package org.gardey.events;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Discriminator;
import javax.jdo.annotations.DiscriminatorStrategy; 
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;

@PersistenceCapable
public class FlashScrolling extends UsabilityEvent {
	
	private int initialTop;
	private int finalTop;
	private int time;
	
	public FlashScrolling(int initialTop, int finalTop, int time) {
		this.initialTop = initialTop;
		this.finalTop = finalTop;
		this.time = time;
	}

	public int getInitialTop() {
		return initialTop;
	}

	public void setInitialTop(int initialTop) {
		this.initialTop = initialTop;
	}

	public int getFinalTop() {
		return finalTop;
	}

	public void setFinalTop(int finalTop) {
		this.finalTop = finalTop;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
	
	

}
