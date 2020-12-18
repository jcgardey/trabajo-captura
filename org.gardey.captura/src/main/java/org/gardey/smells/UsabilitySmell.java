package org.gardey.smells;


import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;

import javax.jdo.annotations.*;

import org.gardey.DomElement;
import org.gardey.User;
import org.gardey.events.UsabilityEvent;
import org.gardey.events.NavigationPath;
import org.gardey.repositories.RepositoryLocator;
import org.gardey.repositories.UsabilityEventRepository;

@PersistenceCapable
public class UsabilitySmell {
	
	@PrimaryKey
	private String oid;
	
	private Collection <UsabilityEvent> events;
	
	private boolean ignored;
	
	private String smellName;
	
	private User user;
	
	private DomElement domElement;
	
	public UsabilitySmell () {
		this.events = new HashSet <UsabilityEvent> ();
		this.smellName = this.getClass().getSimpleName();
	}
		
	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public Collection<UsabilityEvent> getEvents() {
		return events;
	}

	public void setEvents(Collection<UsabilityEvent> events) {
		this.events = events;
	}

	public boolean isIgnored() {
		return ignored;
	}

	public void setIgnored(boolean ignored) {
		this.ignored = ignored;
	}

	public String getSmellName() {
		return smellName;
	}

	public void setSmellName(String name) {
		this.smellName = name;
	}
	
	public void addEvent(UsabilityEvent anEvent) {
		this.getEvents().add(anEvent);
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public DomElement getDomElement() {
		return domElement;
	}

	public void setDomElement(DomElement domElement) {
		this.domElement = domElement;
	}
	
	public Collection<UsabilityEvent> getUsabilityEventsOrderedByTimestamp() {
		return this.getUsabilityEventRepository().getUsabilityEventsOrderedByTimestamp(this);
	}
	
	private UsabilityEventRepository getUsabilityEventRepository() {
		return RepositoryLocator.getInstance().getUsabilityEventRepository();
	}
	
	public UsabilitySmell clone() {
		try {
			UsabilitySmell clone = this.getClass().newInstance();
			//clone.setEvents(this.getEvents());
			//clone.getEvents().forEach(event -> event.addSmell(clone));
			clone.setUser(this.getUser());
			clone.setDomElement(this.getDomElement());
			clone.setIgnored(this.isIgnored());
			return clone;
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
		
	}

	public String toString() {
		String text = this.smellName;
		if (this.getDomElement() != null) {
			text += " on " + this.getDomElement().getUrl() + " - " + this.getDomElement().getXpath();
		}
		return text;
	}

	public void duplicateEvents() {
		this.getEvents().addAll( this.getEvents().stream().map(event -> event.clone()).collect(Collectors.toList()) );
	}
	
	public void duplicateNavigations() {
		if (this.smellName.equals("DistantContent")) {
			this.getEvents().stream().forEach(event -> ((NavigationPath) event).duplicateNavigations());
		}
	}
	
}
