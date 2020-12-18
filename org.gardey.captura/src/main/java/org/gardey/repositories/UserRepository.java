package org.gardey.repositories;

import java.util.Collection;
import javax.jdo.Query;
import org.gardey.ApplicationManager;
import org.gardey.User;
import org.gardey.smells.UsabilitySmell;

public class UserRepository extends AbstractRepository {
	
	
	public User findUserByUsername(String username) {
		Query aQuery = this.getPersistenceManager().newQuery(User.class);
		aQuery.setFilter("this.username == aName");
		aQuery.declareParameters("String aName");
		aQuery.setParameters(username);
		User aUser = (User) aQuery.executeUnique();
		return aUser;
	
	}
	
	public Collection <UsabilitySmell> getAllUsabilitySmells(User aUser) {
		return aUser.getBadsmells();
	}
	
	/**
	 * Este metodo existe para hacer la operacion dentro de una transaccion JDO, sino en Neo4J falla.
	 * @param appManager
	 */
	public void duplicateUsers(ApplicationManager appManager) {
		appManager.duplicateUsers();
	}

}
