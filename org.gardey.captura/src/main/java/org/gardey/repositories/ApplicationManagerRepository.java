package org.gardey.repositories;
import java.util.Collection;
import java.util.HashSet;

import javax.jdo.FetchPlan;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.gardey.ApplicationManager;
import org.gardey.User;
import org.gardey.events.UsabilityEvent;
import org.gardey.smells.UsabilitySmell;

public class ApplicationManagerRepository extends AbstractRepository {
	
	
	public ApplicationManager getApplicationManager() {
		PersistenceManager pm = this.getPersistenceManager();
	    Query aQuery = pm.newQuery("SELECT FROM org.gardey.ApplicationManager"); 
	    return (ApplicationManager) aQuery.executeUnique();	
	}
	
	public ApplicationManager getApplicationManagerDetachedCopy() {
		this.getPersistenceManager().getFetchPlan().setGroups(new String[] {FetchPlan.DEFAULT, FetchPlan.ALL});
	    this.getPersistenceManager().getFetchPlan().setMaxFetchDepth(-1);
	    return this.getPersistenceManager().detachCopy(this.getApplicationManager());
	}
	
	public void duplicateUsers(int timesRepeat) {
		//this.getPersistenceManager().getFetchPlan().setGroup(FetchPlan.ALL);
		//this.getPersistenceManager().getFetchPlan().setMaxFetchDepth(-1);
		ApplicationManager appManager = this.getApplicationManager();
		for (int i = 0; i < timesRepeat; i++) {
			Collection <User> newUsers = new HashSet <User>();
			for (User user : appManager.getUsers()) {
				User detachedUser = this.getPersistenceManager().detachCopy(user);
				detachedUser.setUsername(user.getUsername() + " " + System.currentTimeMillis());
				newUsers.add(detachedUser);
			}
			appManager.getUsers().addAll(newUsers);
		}
		this.getPersistenceManager().makePersistent(appManager);
	}
	
	public void save(ApplicationManager aManager) {
		this.getPersistenceManager().makePersistent(aManager);	
	}

}
