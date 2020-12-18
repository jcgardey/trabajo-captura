package org.gardey.events;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class FlashNavigation extends UsabilityEvent {
	
	private float timeBrowsing;
	private String url;
	
	public float getTimeBrowsing() {
		return timeBrowsing;
	}
	public void setTimeBrowsing(float timeBrowsing) {
		this.timeBrowsing = timeBrowsing;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
