package org.gardey.events;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class SelectOptionSelection extends OptionSelection {
	
	private String selectionText;
	
	public SelectOptionSelection () {
		
	}

	public String getSelectionText() {
		return selectionText;
	}

	public void setSelectionText(String selectionText) {
		this.selectionText = selectionText;
	}
	
}
