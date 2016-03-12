package com.sect.ejb.server.logger;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import org.apache.log4j.Logger;

public class ProductProcessLogger {
	@AroundInvoke
	public Object writeInfo(InvocationContext invocationContext)throws Exception{
		Logger logger = Logger.getLogger(invocationContext.getTarget().getClass());
		logger.debug(invocationContext.getTarget().getClass().getName()+"@@@@"+invocationContext.getMethod().getName());
		return invocationContext.proceed();
	}
	
}
