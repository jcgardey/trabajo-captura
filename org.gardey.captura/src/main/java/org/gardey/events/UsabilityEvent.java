package org.gardey.events;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.jdo.Query;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

import org.gardey.DomElement;
import org.gardey.User;
import org.gardey.smells.UsabilitySmell;

@PersistenceCapable
public class UsabilityEvent {
	
	@PrimaryKey
	private String oid;
	
	private Date timestamp;
	
	private String eventName;
	
	private Collection <UsabilitySmell> badsmells;
	
	private DomElement domElement;

	public UsabilityEvent () {
		this.timestamp = new Date ();
		this.eventName = this.getClass().getSimpleName();
	}
		
	
	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}
	
		
	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String name) {
		this.eventName = name;
	}

	
	public Collection<UsabilitySmell> getBadsmells() {
		return badsmells;
	}

	public void setBadsmells(Collection<UsabilitySmell> badsmells) {
		this.badsmells = badsmells;
	}

	public DomElement getDomElement() {
		return domElement;
	}

	public void setDomElement(DomElement domElement) {
		this.domElement = domElement;
	}
	
	public void addSmell(UsabilitySmell aSmell) {
		if (this.badsmells == null) {
			this.badsmells = new HashSet <UsabilitySmell> ();
		}
		this.badsmells.add(aSmell);
	}
	
	
	public String toString() {
		return this.getEventName();
	}
	
	public UsabilityEvent clone() {
		UsabilityEvent clone;
		try {
			clone = this.getClass().newInstance();
			clone.setEventName(this.eventName);
			clone.setBadsmells(this.getBadsmells());
			clone.setDomElement(this.getDomElement());
			clone.setTimestamp(this.getTimestamp());
			return clone;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
