package org.gardey.utils;


import javax.jdo.Transaction;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;
import org.gardey.App;
import org.gardey.repositories.AbstractRepository;


public class TransactionInterceptor implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		AbstractRepository targetRepository = (AbstractRepository) invocation.getThis();
		Transaction currentTransaction = targetRepository.getPersistenceManager().currentTransaction();
		currentTransaction.begin();
		Object result = invocation.proceed();
		// simula el acceso a los datos
		if (result != null) {
			result.toString();
		}
		currentTransaction.commit();
		return result;
	}
}
