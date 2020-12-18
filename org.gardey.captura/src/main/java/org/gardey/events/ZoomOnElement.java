package org.gardey.events;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class ZoomOnElement extends UsabilityEvent {
	
	private int zoomAmount;
	
	private int textSize;
	
	public ZoomOnElement () {
		
	}

	public int getZoomAmount() {
		return zoomAmount;
	}

	public void setZoomAmount(int zoomAmount) {
		this.zoomAmount = zoomAmount;
	}

	public int getTextSize() {
		return textSize;
	}

	public void setTextSize(int textSize) {
		this.textSize = textSize;
	}
	
}
