//ZuulPreFilter.java
package com.nt.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulPreFilter extends ZuulFilter {
	private Logger logger=LoggerFactory.getLogger(ZuulPreFilter.class);
	
	public ZuulPreFilter() {
	 System.out.println("ZuulPreFilter.ZuulPreFilter()");
	}

	@Override
	public boolean shouldFilter() {
		  //enables the filter
			return true;
	}

	@Override
	public Object run() throws ZuulException {
		 // get Current request context 
		RequestContext context=RequestContext.getCurrentContext();
		//get request object from context obj
		HttpServletRequest req=context.getRequest();
		// log  request trapping info
		logger.info("===== from ZuulPreFilter======");
		logger.info(" reuqest uri::"+req.getRequestURI());
		logger.info(" request path::"+req.getServletPath());
		logger.info("request method::"+req.getMethod());
		logger.info(" request data content type::"+req.getContentType());
		return null;
	}

	@Override
	public String filterType() {
		//make the filter as pre type zuul filter
		return FilterConstants.PRE_TYPE;
	}

	@Override
	public int filterOrder() {
		   // high priority filter
			return 0;
	}

}
