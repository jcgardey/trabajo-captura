package org.gardey.events;

import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;

import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class NavigationPath extends UsabilityEvent {
	
	
	private Collection <Navigation> navigations;
	
	public NavigationPath () {
		this.navigations = new HashSet <Navigation> ();
		
	}

	public Collection<Navigation> getNavigations() {
		return navigations;
	}

	public void setNavigations(Collection<Navigation> navigations) {
		this.navigations = navigations;
	}
	
	public void addNavigation(Navigation aNavigation) {
		this.getNavigations().add(aNavigation);
	}
	
	public String toString() {
		String result = super.toString();
		return result + this.getNavigations().toString();
	}
	
	public UsabilityEvent clone() {
		NavigationPath clone = (NavigationPath) super.clone();
		clone.setNavigations(this.getNavigations());
		return clone;
	}

	public void duplicateNavigations() {
		this.getNavigations().addAll( this.getNavigations().stream().map(navigation -> navigation.clone()).collect(Collectors.toList()) );
	}
}
