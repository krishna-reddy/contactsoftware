package com.adaptavant.counter.filter;

//Import required java libraries

import javax.servlet.*;


import com.adaptavant.counter.jdo.factory.PMF;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

//Implements Filter class
public class PersistenceCloseFilter implements Filter  {
	/**
	 * Thread count doesn't need locking, instead should use an AtomicInteger
	 */
	AtomicInteger counter=new AtomicInteger();

	/**
    * A logger object.
    */
   private static final Logger LOG = Logger.getLogger(PersistenceCloseFilter.class
           .getName());
    
/**
 * dofilter method for servicing the client request and response
 */
public void  doFilter(ServletRequest request, 
              ServletResponse response,
              FilterChain chain) 
              throws java.io.IOException, ServletException {

	//pre processing goes here
   // Get the IP address of client machine.   
   String ipAddress = request.getRemoteAddr();

   // Log the IP address and current timestamp.
   LOG.info("IP "+ ipAddress + ", Time "
                                    + new Date().toString());
   
   LOG.info("Threads/Request count for this app:"+counter.incrementAndGet());
   
   // Pass request back down the filter chain
   chain.doFilter(request,response);
   
   //post processing goes here
   //close the persistence manager
  PMF.close();
}

@Override
public void init(FilterConfig arg0) throws ServletException {
	// TODO Auto-generated method stub
	
}

@Override
public void destroy() {
	// TODO Auto-generated method stub
	
}
}