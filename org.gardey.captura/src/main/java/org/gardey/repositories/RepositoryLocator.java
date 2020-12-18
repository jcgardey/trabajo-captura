package org.gardey.repositories;


public class RepositoryLocator {
	
	
	
	private static RepositoryLocator defaultRepositoryLocator;
	
	private ApplicationManagerRepository applicationManagerRepository;
	
	private UserRepository userRepository;
	
	private UsabilitySmellRepository usabilitySmellRepository;
	
	private UsabilityEventRepository usabilityEventRepository;
	
	
	public RepositoryLocator () {

	}
	
	public static RepositoryLocator getInstance() {
		return defaultRepositoryLocator;
	}
	
	
	public static void setDefaultRepositoryLocator(RepositoryLocator aRepositoryLocator) {
		defaultRepositoryLocator = aRepositoryLocator;
	}
	
	
	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public UsabilitySmellRepository getUsabilitySmellRepository() {
		return usabilitySmellRepository;
	}

	public void setUsabilitySmellRepository(UsabilitySmellRepository usabilitySmellRepository) {
		this.usabilitySmellRepository = usabilitySmellRepository;
	}

	public UsabilityEventRepository getUsabilityEventRepository() {
		return usabilityEventRepository;
	}

	public void setUsabilityEventRepository(UsabilityEventRepository usabilityEventRepository) {
		this.usabilityEventRepository = usabilityEventRepository;
	}

	public ApplicationManagerRepository getApplicationManagerRepository() {
		return applicationManagerRepository;
	}

	public void setApplicationManagerRepository(ApplicationManagerRepository applicationManagerRepository) {
		this.applicationManagerRepository = applicationManagerRepository;
	}
	
}
