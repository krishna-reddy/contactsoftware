package com.adaptavant.counter.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.adaptavant.counter.jdo.Account;
import com.adaptavant.counter.jdo.factory.PMF;
import com.adaptavant.counter.service.config.ApplicationContextProvider;
import com.adaptavant.counter.service.sharedcounter.SharedCounterService;
import com.google.appengine.api.NamespaceManager;

@Controller
public class RegLoginController {
	/**
     * A logger object.
     */
    private static final Logger LOG = Logger.getLogger(RegLoginController.class
            .getName());
	/**
	 * Register the new User Account.
	 */
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public ModelAndView registration(HttpServletRequest req,ModelAndView model){
		//get the singleton persistence manager
		PersistenceManager pm = PMF.get();
		
		// get the transaction
		Transaction tx=pm.currentTransaction();
		
		//create transient object
		Account account=new Account();
		
		//get the values from  request
		String username=req.getParameter("username");
		
		//create the session if not exist 
		HttpSession session=req.getSession();
		//set the username into session
		session.setAttribute("username", username);
		try{
		String fname=req.getParameter("firstname");
		String lname=req.getParameter("lastname");
		String email=req.getParameter("email");
		
		//set the values into object
		account.setPassword(req.getParameter("password"));
		account.setUsername(username);
		account.setEmail(email);
		account.setFname(fname);
		account.setLname(lname);
	
		//get the object by uname
		pm.getObjectById(Account.class,username);
			
		//if uname exist
		model.setViewName("RegFail");
			
			}catch (Exception e){	
				try {
				//begin the transaction
				tx.begin();
				
				//persist the object
			   pm.makePersistent(account);
			   
			   //commit the transaction
			   pm.currentTransaction().commit();
			  
			 //get the counter bean
			   ApplicationContext ctx = ApplicationContextProvider.getApplicationContext();
			   SharedCounterService app=(SharedCounterService) ctx.getBean("sharedCounterService");
					
				
				 //add user details to model
				model.setViewName("success");
				
				model.addObject("contacts_counter",app.createEntry(username+"-contacts-counter", "contacts"));
				model.addObject("company_counter",app.createEntry(username+"-company-counter", "company"));
				NamespaceManager.set(username);
					
				}catch (Exception e1) {
					LOG.log(Level.WARNING,
		                    "Error occured while persisting Account object.You may need username as a key");
		            LOG.log(Level.WARNING, e1.toString(), e1);
				}finally{
					//rollback if transaction is active
					if(tx.isActive()){
						tx.rollback();
						}
					}
			  
			}
		
		//return the model to view
		return model;
	
	}
	/**
	 *Login into the user account using username and password.
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView login(HttpServletRequest req,HttpServletResponse res,ModelAndView model){
		
		//get the singleton persistence manager
		PersistenceManager pm = PMF.get();
				
		// get the transaction
		Transaction tx=pm.currentTransaction();
				
		try{
		//begin the transaction
		tx.begin();
		
		//getting uname and password
		String uname=req.getParameter("username");
		String password=req.getParameter("password");
	
		//query the datastore by  filter with uname and password
		Query q=pm.newQuery(Account.class, "username=='"+uname+"'&& password=='"+password+"'");
		List<Account> results=(List<Account>) q.execute();
	
		if(results.size()==0){
			//send to error page
			model.setViewName("LoginError");
			
		}
		else{
		
		//create model with view success
		model.setViewName("success");
		
		//create the session if not exist
		HttpSession session=req.getSession();
		//set the username
		session.setAttribute("username", uname);
			}
		
		//commit the transaction
		tx.commit();
		}catch(Exception e){
			LOG.log(Level.WARNING,
                    "Error occured while fetching the data.");
            LOG.log(Level.WARNING, e.toString(), e);
		}finally{
			//rollback if transaction is active
			if(tx.isActive()){
				tx.rollback();
				}
			}
			
		//return the model to view
		return model;
	
	}
	

}
