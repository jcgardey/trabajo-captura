package org.gardey.repositories;

import java.util.Collection;
import java.util.List;
import javax.jdo.Query;
import org.gardey.User;
import org.gardey.smells.*;

public class UsabilitySmellRepository extends AbstractRepository {


	public UsabilitySmell getUsabilitySmellByTargetHtml(String targetHtml) {
		Query aQuery = this.getPersistenceManager().newQuery(UsabilitySmell.class);
		aQuery.setFilter("this.domElement.html == targetHtml");
    	aQuery.declareParameters("String targetHtml");
    	aQuery.setParameters(targetHtml);
    	return (UsabilitySmell) aQuery.executeUnique();
	}
	
	public Collection <UsabilitySmell> getUsabilitySmellsDetectedInPage(String pageUrl, User aUser) {
    	Query aQuery = this.getPersistenceManager().newQuery(UsabilitySmell.class);
    	aQuery.setFilter("this.user == aUser && this.domElement.url == pageUrl");
    	aQuery.declareParameters("org.gardey.User aUser,String pageUrl");
    	return (List <UsabilitySmell>) aQuery.execute(aUser,pageUrl);
	}
	
	public Collection <UsabilitySmell> getUndescriptiveElementsWithHighWaitingTime() {
		Query aQuery = this.getPersistenceManager().newQuery("SELECT FROM org.gardey.smells.UsabilitySmell WHERE (SELECT avg(e.waitingTime) FROM org.gardey.events.TooltipAttempt e WHERE this.events.contains(e)) "
				+ ">  (SELECT avg(t.waitingTime) FROM org.gardey.events.TooltipAttempt t)");
		
		return (Collection <UsabilitySmell>) aQuery.execute();
		
	}
	
	public void duplicateSmellsForUser(User aUser) {
		aUser.duplicateBadsmells();
	}

	public Long getUsabilitySmellsCount() {
		Query aQuery = this.getPersistenceManager().newQuery(UsabilitySmell.class);
		aQuery.setResult("count(this)");
		return (Long) aQuery.executeResultUnique();
	}
}
