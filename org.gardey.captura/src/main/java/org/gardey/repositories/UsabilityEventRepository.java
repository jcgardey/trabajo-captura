package org.gardey.repositories;

import java.util.Collection;
import java.util.List;
import javax.jdo.Query;
import javax.jdo.Extent;
import org.gardey.User;
import org.gardey.events.Navigation;
import org.gardey.events.NavigationPath;
import org.gardey.events.UsabilityEvent;
import org.gardey.smells.UsabilitySmell;

public class UsabilityEventRepository extends AbstractRepository {
	
	
	public Collection <UsabilityEvent> getUsabilityEventsOrderedByTimestamp(UsabilitySmell smell) {
		Query aQuery = this.getPersistenceManager().newQuery(UsabilityEvent.class);
		aQuery.setFilter("this.badsmells.contains(aSmell)");
		aQuery.setOrdering("this.timestamp desc");
		aQuery.declareParameters("org.gardey.smells.UsabilitySmell aSmell");
		List <UsabilityEvent> events = (List <UsabilityEvent>) aQuery.execute(smell); 
		return events;
	}
	
	public Collection <UsabilityEvent> getUsabilityEventsInHtml (String htmlFragment) {
		Query aQuery = this.getPersistenceManager().newQuery(UsabilityEvent.class);
		aQuery.setFilter("this.domElement.html.matches(htmlFragment)");
		aQuery.declareParameters("String htmlFragment");
		List <UsabilityEvent> events = (List <UsabilityEvent>) aQuery.execute(htmlFragment); 
		return events;
	}
	
	public Collection <NavigationPath> getNavigationPathsIncludingUrl(String url) {
		Query aQuery = this.getPersistenceManager().newQuery(NavigationPath.class);
		aQuery.setFilter("this.navigations.contains(nav) && nav.url.startsWith(aUrl)");
		aQuery.declareVariables(Navigation.class.getName() + " nav");
		aQuery.declareParameters("String aUrl");
		return (List <NavigationPath>) aQuery.execute(url);
	}
	
	public void getNavigationPaths() {
		Extent <NavigationPath> navs = this.getPersistenceManager().getExtent(NavigationPath.class);
		for (NavigationPath navigationPath : navs) {
			System.out.println(navigationPath.toString());
		}
	}
	
	public Collection <Object[]> getEventsQtyByType() {
    	Query aQuery = this.getPersistenceManager().newQuery(UsabilityEvent.class);
    	aQuery.setResult("this.eventName, count(this.eventName)");
    	aQuery.groupBy("this.eventName");
    	return (List <Object[]>) aQuery.execute();
	}
	
	public void duplicateNavigations(User aUser) {
		aUser.duplicateNavigations();
	}
	
	public void duplicateUsabilityEvents(User aUser) {
		aUser.duplicateUsabilityEvents();
	}
	
	public Long getUsabilityEventsCount() {
		Query aQuery = this.getPersistenceManager().newQuery(UsabilityEvent.class);
		aQuery.setResult("count(this)");
		return (Long) aQuery.executeResultUnique();
	}
	

}
