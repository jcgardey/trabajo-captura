package org.gardey.smells;

import java.util.Collection;
import java.util.HashSet;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

import org.gardey.events.UsabilityEvent;

@PersistenceCapable
public class Expression {
	
	@PrimaryKey
	private String oid;
	
	private String name;
	
	private String regex;
	
	private Collection <UsabilityEvent> threats;
	
	public Expression() {
		this.threats = new HashSet <UsabilityEvent> ();
	}
	
	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegex() {
		return regex;
	}

	public void setRegex(String regex) {
		this.regex = regex;
	}

	public Collection<UsabilityEvent> getThreats() {
		return threats;
	}

	public void setThreats(Collection<UsabilityEvent> threats) {
		this.threats = threats;
	}

}
