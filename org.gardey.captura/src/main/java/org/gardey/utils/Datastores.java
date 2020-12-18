package org.gardey.utils;

import java.util.Map;

import org.gardey.repositories.RepositoryLocator;

public class Datastores {
	
	private static Datastores instance;
	
	private Map<DatastoreName, RepositoryLocator> repositoryLocators;
	
	private Datastores() {
		
	}
	
	public static Datastores getInstance() {
		if (instance == null) {
			instance = new Datastores();
		}
		return instance;
	}
		
	public RepositoryLocator getRepositoryLocatorForDatastore(DatastoreName aDatastoreName) {
		return this.repositoryLocators.get(aDatastoreName);
	}

	public Map<DatastoreName, RepositoryLocator> getRepositoryLocators() {
		return repositoryLocators;
	}

	public void setRepositoryLocators(Map<DatastoreName, RepositoryLocator> repositoryLocators) {
		this.repositoryLocators = repositoryLocators;
	}
	

}
