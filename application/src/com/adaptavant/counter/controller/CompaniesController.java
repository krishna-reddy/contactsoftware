package com.adaptavant.counter.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.adaptavant.counter.jdo.Contacts;
import com.adaptavant.counter.jdo.factory.PMF;
import com.adaptavant.counter.service.config.ApplicationContextProvider;
import com.adaptavant.counter.service.sharedcounter.SharedCounterService;
import com.google.appengine.api.NamespaceManager;

@Controller
public class CompaniesController {
	/**
     * A logger object.
     */
    private static final Logger LOG = Logger.getLogger(CompaniesController.class
            .getName());
	/**
	 * display the list of companies available in the account. 
	 */
	@RequestMapping(value="/displayCompanies",method=RequestMethod.GET)
	public ModelAndView displayCompanies(HttpServletRequest req,ModelAndView model){
		//get the singleton persistence manager
		PersistenceManager pm=PMF.get();
		try{
			//declare int count
			int count=0;
			
			//get the counter bean object
			ApplicationContext ctx = ApplicationContextProvider.getApplicationContext();
			SharedCounterService app=(SharedCounterService) ctx.getBean("sharedCounterService");
			
			//begin the tranaction
			pm.currentTransaction().begin();
			
			//create the session and set attribute
			HttpSession session=req.getSession(false);
			String uname=(String) session.getAttribute("username");
			
		
			//set the Name Space
			NamespaceManager.set(uname);
			
			//query the comapies
			Query query=pm.newQuery("select company from com.adaptavant.counter.jdo.Contacts");
			query.setRange(0, 100);
			
			//execute the query
			List<String>results=(List<String>) query.execute();
			
			//create a map for holding company contacts
			Map<String,Integer>companyCount=new HashMap<String,Integer>();
			
			for(String company:results){
				count=app.getCount(uname+"-"+company+"-counter");
				companyCount.put(company, count);
			}
			
			//commit the transaction
			pm.currentTransaction().commit();
			
			//initialize the model
			model.setViewName("displayCompanies");
			
			//add company results to model for rendoring
			model.addObject("companyCount",companyCount);
			
		}catch(Exception e){
			//log error message here
			LOG.log(Level.WARNING,
                    "Error occured while querying the Contacts object ");
            LOG.log(Level.WARNING, e.toString(), e);
			}
		finally{
			//rollback the transaction
			if(pm.currentTransaction().isActive()){
				pm.currentTransaction().rollback();
			}
		}
		//return the model to the view displayCompanies.jsp
		return model;
		
	}
	
	@RequestMapping(value="/showUsers",method=RequestMethod.GET)
	public ModelAndView showUsers(HttpServletRequest req,ModelAndView model){
			//get the singleton persistence manager
			PersistenceManager pm=PMF.get();
			
			 // We want our object to be detached 
		    pm.setDetachAllOnCommit(true);				
			try{
			//get the request values
			String company=req.getParameter("company");
			
			//begin the tranaction
			pm.currentTransaction().begin();
			
			//create the session and set attribute
			HttpSession session=req.getSession(false);
			String uname=(String) session.getAttribute("username");
			
		
			//set the Name Space
			NamespaceManager.set(uname);
			
			
			//query the datastore by company
			Query q=pm.newQuery("SELECT  FROM com.adaptavant.counter.jdo.Contacts WHERE company=='"+company+"'");
			q.setRange(0,1000);
			
			//execute the query
			List<Contacts>results=(List<Contacts>) q.execute();
			
			//commit the transaction
			pm.currentTransaction().commit();
			
			//add results to model
			model.addObject("users",results);
			model.setViewName("showUsers");
			
			
		}catch(Exception e){
			//log the error message
			LOG.log(Level.WARNING, e.toString(), e);
		}finally{
			//roll back the transaction
			if(pm.currentTransaction().isActive()){
				pm.currentTransaction().rollback();
			}
		}
		return model;
	
	}

}
