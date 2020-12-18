package org.gardey;

import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

import org.gardey.events.NavigationPath;
import org.gardey.events.UsabilityEvent;
import org.gardey.repositories.RepositoryLocator;
import org.gardey.repositories.UsabilityEventRepository;
import org.gardey.repositories.UsabilitySmellRepository;
import org.gardey.repositories.UserRepository;
import org.gardey.smells.UsabilitySmell;

@PersistenceCapable
public class ApplicationManager {

	@PrimaryKey
	private String oid;

	private Collection <User> users;

	public ApplicationManager () {
		this.users = new HashSet <User> ();
	}

	public void setUsers(Collection <User> users) {
		this.users = users;
	}

	public Collection<User> getUsers() {
		return this.users;
	}

	public void addUser(User anUser) {
		this.getUsers().add(anUser);
	}
	
	
	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}
	
	public void duplicateUsers() {
		this.getUsers().addAll( this.getUsers().stream().map(user -> user.clone()).collect(Collectors.toList()) );
	}
	
	public User findUserByUsername(String username) {
		return this.getUserRepository().findUserByUsername(username);
	}
	
	public UsabilitySmell getUsabilitySmellByTargetHtml(String targetHtml) {
		return this.getUsabilitySmellRepository().getUsabilitySmellByTargetHtml(targetHtml);
	}
	
	public Collection<UsabilityEvent> getUsabilityEventsInHtml(String htmlCode) {
		return this.getUsabilityEventRepository().getUsabilityEventsInHtml(htmlCode);
	}
	
	public Collection <NavigationPath> getNavigationPathsIncludingUrl(String url) {
		return this.getUsabilityEventRepository().getNavigationPathsIncludingUrl(url);
	}
	
	public Collection <UsabilitySmell> getUndescriptiveElementsWithHighWaitingTime() {
		return RepositoryLocator.getInstance().getUsabilitySmellRepository().getUndescriptiveElementsWithHighWaitingTime();
	}
	
	public Collection <Object[]> getEventsQtyByType() {
		return RepositoryLocator.getInstance().getUsabilityEventRepository().getEventsQtyByType();
	}
	
	public UserRepository getUserRepository() {
		return RepositoryLocator.getInstance().getUserRepository();
	}
	
	public UsabilitySmellRepository getUsabilitySmellRepository() {
		return RepositoryLocator.getInstance().getUsabilitySmellRepository();
	}
	
	public UsabilityEventRepository getUsabilityEventRepository() {
		return RepositoryLocator.getInstance().getUsabilityEventRepository();
	}
	
	public Integer getUsersCount() {
		return this.getUsers().size();
	}
	
	public Long getUsabilitySmellsCount() {
		return this.getUsabilitySmellRepository().getUsabilitySmellsCount();
	}
	
	public Long getUsabilityEventsCount() {
		return this.getUsabilityEventRepository().getUsabilityEventsCount();
	}

}
