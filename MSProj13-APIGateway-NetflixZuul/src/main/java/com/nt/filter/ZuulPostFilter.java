package com.nt.filter;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulPostFilter extends ZuulFilter {
	private  Logger logger=LoggerFactory.getLogger(ZuulPostFilter.class);
	
	public ZuulPostFilter() {
	 System.out.println("ZuulPostFilter.ZuulPostFilter()");
	}

	@Override
	public boolean shouldFilter() {
			return true;
	}

	@Override
	public Object run() throws ZuulException {
		// Get RequestContext obj
		RequestContext context=RequestContext.getCurrentContext();
		// get Response object from context obj
		HttpServletResponse res=context.getResponse();
		//log response trapping info
		logger.info("======== from  ZuulPostFilter=================");
		logger.info("response content type ::"+res.getContentType());
		logger.info("response status ::"+res.getStatus());
		logger.info("response host name:"+res.getHeader("host"));
		logger.info(" response server name::"+res.getHeader("server"));
		return null;
	}

	@Override
	public String filterType() {
		 //post filter
		return FilterConstants.POST_TYPE;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

}
