package com.nt.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;


@Component
public class ZuulRouteFilter extends ZuulFilter {
	private Logger logger=LoggerFactory.getLogger(ZuulRouteFilter.class);
	
	public ZuulRouteFilter() {
	  System.out.println("ZuulRouteFilter.ZuulRouteFilter()");
	}

	@Override
	public boolean shouldFilter() {
	
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		// get RequestContext obj
		RequestContext context=RequestContext.getCurrentContext();
		//write log message about the routing
		logger.info("========from ZuulRouteFilter=========");
	  logger.info("Routing   host info ::"+context.getRouteHost());
		return null;
	}

	@Override
	public String filterType() {
		    //route filter
			return FilterConstants.ROUTE_TYPE;
	}

	@Override
	public int filterOrder() {
				return 0;
	}

}
