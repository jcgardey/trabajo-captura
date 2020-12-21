package org.gardey;


import javax.jdo.PersistenceManagerFactory;
import org.apache.log4j.Logger;
import org.gardey.repositories.*;
import org.gardey.smells.UsabilitySmell;
import org.gardey.utils.DatastoreName;
import org.gardey.utils.Datastores;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App
{
	private ApplicationContext context;
	
	public App() {
		this.context = new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");
	}
	
    public static void main( String[] args ) throws Exception {
    	App app = new App ();
    	if (System.getProperty("exec.args") == null) {
    		throw new Exception("Invalid arguments");
    	}
    	if (System.getProperty("exec.args").equals("migrate")) {
    		System.out.println("migrating to mysql...");
			app.migrate(DatastoreName.MONGODB, DatastoreName.MySQL);
			app.replicateData(DatastoreName.MySQL);
    		System.out.println("migrating to cassandra...");
			app.migrate(DatastoreName.MONGODB, DatastoreName.CASSANDRA);
			app.replicateData(DatastoreName.CASSANDRA);
    		System.out.println("migrating to neo4j...");
			app.migrate(DatastoreName.MONGODB, DatastoreName.NEO4J);
			app.replicateData(DatastoreName.NEO4J);
			app.replicateData(DatastoreName.MONGODB);
		}
		String targetDatastore = System.getProperty("targetDatastore");
    	if (System.getProperty("exec.args").equals("run-queries")) {
    		app.runQueriesInDatastore(DatastoreName.valueOf(targetDatastore));	
		}
		if (System.getProperty("exec.args").equals("replicate-data")) {
			app.replicateData(DatastoreName.valueOf(targetDatastore));
		}
		//cierre de conexion de cassandra para que no quede abierta
    	app.closeRepository("cassandra");
    }

    public void runQueriesInDatastore (DatastoreName targetDastore) {
    	Logger.getLogger(targetDastore.toString()).info("");	
    	Logger.getLogger(targetDastore.toString()).info("");	
    	Logger.getLogger(targetDastore.toString()).info("Runing queries in " + targetDastore.toString());
    	
    	RepositoryLocator.setDefaultRepositoryLocator(Datastores.getInstance().getRepositoryLocatorForDatastore(targetDastore));
    	
    	ApplicationManager applicationManager = RepositoryLocator.getInstance().getApplicationManagerRepository().getApplicationManager();
    	
    	Logger.getLogger(targetDastore.toString()).info("Database stats");
    	Logger.getLogger(targetDastore.toString()).info("Users: " + applicationManager.getUsersCount());
    	Logger.getLogger(targetDastore.toString()).info("Usability Smells: " + applicationManager.getUsabilitySmellsCount());
    	Logger.getLogger(targetDastore.toString()).info("Usability Events: " + applicationManager.getUsabilityEventsCount());
    		
    	Logger.getLogger(targetDastore.toString()).info("");	
    	Logger.getLogger(targetDastore.toString()).info("<-- Buscar usuario a partir de su username -->");
    	User aUser = applicationManager.findUserByUsername("test");
    	
    	Logger.getLogger(targetDastore.toString()).info("");
    	Logger.getLogger(targetDastore.toString()).info("<-- Recuperar un smell a partir de la url y el xpath su objeto DOM involucrado  -->");
		UsabilitySmell aSmell = applicationManager.getUsabilitySmellByTargetHtml("<a href=\"/agency_sales/108517\"> <span class=\"label label-primary label-pnr\">UYSUKS</span></a>");
		
    	Logger.getLogger(targetDastore.toString()).info("");
    	Logger.getLogger(targetDastore.toString()).info("<-- Usability Events asociados a un usability smell ordenados por fecha de ocurrencia de manera descendente  -->");
		Logger.getLogger(targetDastore.toString()).info("Result Size: " + aSmell.getUsabilityEventsOrderedByTimestamp().size());
    	
     	Logger.getLogger(targetDastore.toString()).info("");
    	Logger.getLogger(targetDastore.toString()).info("<-- Usability Smells de un usuario detectados en una URL específica -->");
    	Logger.getLogger(targetDastore.toString()).info("Result Size: " + aUser.getUsabilitySmellsDetectedInPage("http://clientes.belugas.com.ar/testsite/register.php").size());
    	
    	Logger.getLogger(targetDastore.toString()).info("");
    	Logger.getLogger(targetDastore.toString()).info("<-- Usability Events detectados en un fragmento de código HTML -->");
		Logger.getLogger(targetDastore.toString()).info("Result Size: " + applicationManager.getUsabilityEventsInHtml("<input type=\"text\" class=\"form-control input-sm\" id=\"pnr_code\" name=\"pnr_code\" />").size());

    	
    	Logger.getLogger(targetDastore.toString()).info("");
    	Logger.getLogger(targetDastore.toString()).info("<-- Navegaciones de los usuarios cuyo path pasa por una URL específica -->");
    	Logger.getLogger(targetDastore.toString()).info("Result Size: " + applicationManager.getNavigationPathsIncludingUrl("https://laplataviaja.com/paquetes.php").size());
    	
    	Logger.getLogger(targetDastore.toString()).info("");
    	Logger.getLogger(targetDastore.toString()).info("<-- Cantidad de Usability Event de cada tipo -->");
    	applicationManager.getEventsQtyByType();	
    	
    	Logger.getLogger(targetDastore.toString()).info("");
    	Logger.getLogger(targetDastore.toString()).info("<-- Usability Smells UndescriptiveElement cuyo tiempo de espera promedio es superior al promedio general -->");
		Logger.getLogger(targetDastore.toString()).info("Result Size: " + applicationManager.getUndescriptiveElementsWithHighWaitingTime().size());	
    }

    public void migrate (DatastoreName source, DatastoreName destination) {
    	Datastores.getInstance().getRepositoryLocatorForDatastore(destination).getApplicationManagerRepository().save(Datastores.getInstance().getRepositoryLocatorForDatastore(source).getApplicationManagerRepository().getApplicationManagerDetachedCopy());
    }

    public void replicateData(DatastoreName database) {
		RepositoryLocator.setDefaultRepositoryLocator(Datastores.getInstance().getRepositoryLocatorForDatastore(database));
    	ApplicationManager applicationManager = RepositoryLocator.getInstance().getApplicationManagerRepository().getApplicationManager();   
    	
    	for (int i = 0; i < 9; i++) {
    		RepositoryLocator.getInstance().getUserRepository().duplicateUsers(applicationManager);
		}
		User aUser = applicationManager.findUserByUsername("jcgardey");
		User anotherUser = applicationManager.findUserByUsername("carlosazzamiess");
		User testUser = applicationManager.findUserByUsername("test");
		
		for (int i = 0; i < 7; i++) {
			RepositoryLocator.getInstance().getUsabilityEventRepository().duplicateNavigations(aUser);
			RepositoryLocator.getInstance().getUsabilityEventRepository().duplicateNavigations(anotherUser);
			RepositoryLocator.getInstance().getUsabilityEventRepository().duplicateNavigations(testUser);
		}
		
		for (int i = 0; i < 5; i++) {
			RepositoryLocator.getInstance().getUsabilitySmellRepository().duplicateSmellsForUser(aUser);
			RepositoryLocator.getInstance().getUsabilitySmellRepository().duplicateSmellsForUser(anotherUser);		
			RepositoryLocator.getInstance().getUsabilitySmellRepository().duplicateSmellsForUser(aUser);
			
		}
		
		for (int i = 0; i < 4; i++) {
			RepositoryLocator.getInstance().getUsabilityEventRepository().duplicateUsabilityEvents(anotherUser);
			RepositoryLocator.getInstance().getUsabilityEventRepository().duplicateUsabilityEvents(testUser);
			RepositoryLocator.getInstance().getUsabilityEventRepository().duplicateUsabilityEvents(aUser); 
			
		}
    }
    

    public void closeRepository(String database) {
    	PersistenceManagerFactory pmf = (PersistenceManagerFactory) this.getContext().getBean(database);
    	pmf.close();
    }

    public ApplicationContext getContext () {
    	return this.context;
    }
 }
