package org.gardey.events;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class BulkAction extends UsabilityEvent {
	
	private int numberOfItems;
	
	public BulkAction () {
		
	}

	public int getNumberOfItems() {
		return numberOfItems;
	}

	public void setNumberOfItems(int numberOfItems) {
		this.numberOfItems = numberOfItems;
	}
	
}
