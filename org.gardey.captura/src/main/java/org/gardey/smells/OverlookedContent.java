package org.gardey.smells;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class OverlookedContent extends UsabilitySmell {
	
	private boolean downwards;
	
	private String url;
	
	private int addedTop;
	
	public OverlookedContent () {
		
	}

	public boolean isDownwards() {
		return downwards;
	}

	public void setDownwards(boolean downwards) {
		this.downwards = downwards;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getAddedTop() {
		return addedTop;
	}

	public void setAddedTop(int addedTop) {
		this.addedTop = addedTop;
	}

}
