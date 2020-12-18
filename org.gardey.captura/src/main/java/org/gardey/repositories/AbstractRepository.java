package org.gardey.repositories;

import javax.jdo.PersistenceManager;

public class AbstractRepository {
	
	
	
	private PersistenceManager persistenceManager;


	public PersistenceManager getPersistenceManager() {
		return this.persistenceManager;
	}
	
	public void setPersistenceManager(PersistenceManager manager) {
		this.persistenceManager = manager;
	}

}
