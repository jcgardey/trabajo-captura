package org.gardey.events;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class LongRequest extends UsabilityEvent {
	
	private int time;
	private String formXPath;
	
	public LongRequest(int time, String formXPath) {
		this.time = time;
		this.formXPath = formXPath;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getFormXPath() {
		return formXPath;
	}

	public void setFormXPath(String formXPath) {
		this.formXPath = formXPath;
	}
	
}
