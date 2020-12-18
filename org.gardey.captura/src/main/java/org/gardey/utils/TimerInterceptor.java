package org.gardey.utils;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;
import org.gardey.App;

public class TimerInterceptor implements MethodInterceptor {
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Timer.getInstance().start();
		Object result = invocation.proceed();
		Timer.getInstance().stop();
		return result;
	}

}
