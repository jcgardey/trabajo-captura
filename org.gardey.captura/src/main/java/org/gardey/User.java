package org.gardey;
import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import org.gardey.events.NavigationPath;
import org.gardey.repositories.RepositoryLocator;
import org.gardey.repositories.UsabilitySmellRepository;
import org.gardey.smells.UsabilitySmell;

@PersistenceCapable
public class User {
	
	@PrimaryKey
	private String oid;
	
	private String username;
	
	private String email;
		
	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	private Collection <UsabilitySmell> badsmells;
	
	public User () {
		this.badsmells = new HashSet <UsabilitySmell> ();
	}
	
	public User (String username, String email) {
		this.username = username;
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Collection<UsabilitySmell> getBadsmells() {
		return badsmells;
	}

	public void setBadsmells(Collection<UsabilitySmell> badsmells) {
		this.badsmells = badsmells;
	}
	
	public String toString() {
		return this.getUsername() + " " + this.getEmail(); 
	}

	public User clone() {
		return new User(this.getUsername() + System.currentTimeMillis(), this.getEmail());
	}
	
	public void duplicateBadsmells() {
		this.getBadsmells().addAll( this.getBadsmells().stream().map(smell -> smell.clone()).collect(Collectors.toList()) );
	}
	
	
	public void duplicateUsabilityEvents() {
		this.getBadsmells().forEach(smell -> smell.duplicateEvents());
	}
	
	public UsabilitySmellRepository getUsabilitySmellRepository() {
		return RepositoryLocator.getInstance().getUsabilitySmellRepository();
	}
	
	public Collection <UsabilitySmell> getUsabilitySmellsDetectedInPage(String url) {
		return this.getUsabilitySmellRepository().getUsabilitySmellsDetectedInPage(url, this);
	}
	
	public void duplicateNavigations() {	
		this.getBadsmells().forEach(smell -> smell.duplicateNavigations());
	}

}
