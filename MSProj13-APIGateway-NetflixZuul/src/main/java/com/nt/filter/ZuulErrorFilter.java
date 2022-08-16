package com.nt.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulErrorFilter extends ZuulFilter {
	private Logger logger=LoggerFactory.getLogger(ZuulErrorFilter.class);
	
	public ZuulErrorFilter() {
	  System.out.println("ZuulErrorFilter.ZuulErrorFilter()");
	}

	@Override
	public boolean shouldFilter() {
	
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		 //get RequestContext obj
		RequestContext  context= RequestContext.getCurrentContext();
		//get Throwable object
		Throwable throwable=context.getThrowable();
		// wirte log message about error /exception
		logger.error("exception message :"+throwable.getMessage());
		logger.error("Exception type:"+throwable);
		return null;
	}

	@Override
	public String filterType() {
		 //error filter
		return  FilterConstants.ERROR_TYPE;
	}

	@Override
	public int filterOrder() {
	
		return 0;
	}

}
