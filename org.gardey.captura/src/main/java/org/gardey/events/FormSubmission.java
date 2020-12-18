package org.gardey.events;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class FormSubmission extends UsabilityEvent {
	
	private boolean failed;
	private boolean isSearchForm;
	
	private float time;

	public boolean isFailed() {
		return failed;
	}

	public void setFailed(boolean failed) {
		this.failed = failed;
	}

	public boolean isSearchForm() {
		return isSearchForm;
	}

	public void setSearchForm(boolean isSearchForm) {
		this.isSearchForm = isSearchForm;
	}

	public float getTime() {
		return time;
	}

	public void setTime(float time) {
		this.time = time;
	}
	
}
