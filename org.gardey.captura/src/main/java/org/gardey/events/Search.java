package org.gardey.events;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class Search extends UsabilityEvent {
	
	private String searchQuery;
	
	private float time;
	
	private boolean foundResults;
	
	private boolean resultFollowed;
	
	public Search () {
		
	}

	public String getSearchQuery() {
		return searchQuery;
	}

	public void setSearchQuery(String searchQuery) {
		this.searchQuery = searchQuery;
	}

	public float getTime() {
		return time;
	}

	public void setTime(float time) {
		this.time = time;
	}

	public boolean isFoundResults() {
		return foundResults;
	}

	public void setFoundResults(boolean foundResults) {
		this.foundResults = foundResults;
	}

	public boolean isResultFollowed() {
		return resultFollowed;
	}

	public void setResultFollowed(boolean resultFollowed) {
		this.resultFollowed = resultFollowed;
	}
	
	

}
