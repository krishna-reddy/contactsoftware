package com.adaptavant.counter.controller;
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

import com.adaptavant.counter.jdo.Contacts;
import com.adaptavant.counter.jdo.factory.PMF;
import com.adaptavant.counter.service.config.ApplicationContextProvider;
import com.adaptavant.counter.service.sharedcounter.SharedCounterService;
import com.google.appengine.api.NamespaceManager;

@Controller
public class ContactDetailsController {
	/**
     * A logger object.
     */
    private static final Logger LOG = Logger.getLogger(ContactDetailsController.class
            .getName());
    /**
     * Add the new contact object into datastore. 
     */
	@RequestMapping(value="/addContact",method=RequestMethod.POST)
	public ModelAndView add(HttpServletRequest req,ModelAndView model){
		//get the singleton persistence manager
		PersistenceManager pm=PMF.get();
		
		//get the transaction
		Transaction tx=pm.currentTransaction();
		try
		{
		//declare the count
		int contactMethods=1;
		
		//get the bean object
		ApplicationContext ctx = ApplicationContextProvider.getApplicationContext();
		SharedCounterService app=(SharedCounterService) ctx.getBean("sharedCounterService");
		
		//create a transient Contact object
		Contacts contact=new Contacts();
		
		//get the detail from request
		String firstname=req.getParameter("firstname");
		String lastname=req.getParameter("lastname");
		String company=req.getParameter("company");
		String email=req.getParameter("email");
		String telephone=req.getParameter("telephone");
		String address=req.getParameter("address");
		
		//check condition for increment contact methods
		if(!address.trim().equals("")){
			contactMethods++;
		}
		
		if(telephone!=null){
			contactMethods++;
			}
		//set the details to contact object
		contact.setFirstname(firstname);
		contact.setLastname(lastname);
		contact.setEmail(email);
		contact.setCompany(company);
		contact.setTelephone(telephone);
		contact.setAddress(address);
		contact.setContactMethods(contactMethods);
	
			
			//get the existing session
			HttpSession session=req.getSession(false);
			//get the username from the session
			String uname=(String) session.getAttribute("username");
			
			//set the company into session
			session.setAttribute("company", company);
			
			//set the Name Space
			NamespaceManager.set(uname);
			
			//begin the transaction
			tx.begin();
		
			Query q=pm.newQuery("SELECT company company FROM com.adaptavant.counter.jdo.Contacts WHERE company=='"+company+"'");
			
			List<String> companies= (List<String>) q.execute();
			

			if(companies.size()==0)
			{
				
				app.createEntry(uname+"-"+company+"-counter", "companyContacts");
				
				app.updateEntry(uname+"-"+company+"-counter", "companyContacts");
				
				app.updateEntry(uname+"-company-counter", "company");
		
			}else{
				app.updateEntry(uname+"-"+company+"-counter", "companyContacts");
			}
			
			//update the counter values
			app.updateEntry(uname+"-contacts-counter", "contacts");
			
			//persist the object
			pm.makePersistent(contact);
		
			model.setViewName("CUDContactSuccess");
			model.addObject("message","Contact Added Successfully");

			//commit the transaction
			tx.commit();
			}catch(Exception e){
				//log error message here
				LOG.log(Level.WARNING,
	                    "Error occured while querying the Contacts object ");
	            LOG.log(Level.WARNING, e.toString(), e);
	            try{
	            	model.setViewName("CUDContactFail");
	            	model.addObject("message","Contact Added Failed");
	            }catch(Exception ex){
	            	//log error message here
		            LOG.log(Level.WARNING, ex.toString(), ex);
	            }
			}
			finally{
			if(tx.isActive()){
				tx.rollback();
			}
			}
		
			//return the model to view
			return model;
	}
	/**
	 * Update the contact into the datastore
	 */
	@RequestMapping(value="/updateContact",method=RequestMethod.POST)
	public ModelAndView update(HttpServletRequest req,ModelAndView model){
		
		//get the singleton persistence manager
		PersistenceManager pm=PMF.get();
				
		//get the transaction
		Transaction tx=pm.currentTransaction();
		
		//declare the int count contact methods
		int contactMethods=1;
		
		try
		{	
		//get the value from the request
		String firstname=req.getParameter("firstname");
		String lastname=req.getParameter("lastname");
		String company=req.getParameter("company");
		String email=req.getParameter("email");
		String telephone=req.getParameter("telephone");
		String address=req.getParameter("address");
		
		//check condition for increment contact methods
		if(!address.trim().equals("")){
			contactMethods++;
			}
		
		if(!telephone.trim().equals("")){
			contactMethods++;
			}
		
		//get the counter bean
		ApplicationContext ctx = ApplicationContextProvider.getApplicationContext();
		SharedCounterService app=(SharedCounterService) ctx.getBean("sharedCounterService");
		
		
		//get the existing session
		HttpSession session=req.getSession(false);
		//get the username from session
		String uname=(String) session.getAttribute("username");
	
		//set the namespace
		NamespaceManager.set(uname);
		
		//begin the transaction
		tx.begin();
		
		//get the previous company
		Contacts contact=pm.getObjectById(Contacts.class,email);
		String prevCompany=contact.getCompany();
		
		//To get the company
		Query q=pm.newQuery("SELECT  company FROM com.adaptavant.counter.jdo.Contacts WHERE company=='"+company+"'");
		
		List<String>companies=(List<String>) q.execute();
		
	
		if(companies.size()==0)
		{
			
			app.createEntry(uname+"-"+company+"-counter", "companyContacts");
			
			app.updateEntry(uname+"-"+company+"-counter", "companyContacts");
			
			
	
		}else if(company!=prevCompany){
			app.updateEntry(uname+"-"+company+"-counter", "companyContacts");
			int count=app.deleteEntry(uname+"-"+prevCompany+"-counter", "companyContacts");
			//check the count of contacts in the prev company
			if(count==0){
			//delete company entry
			app.deleteEntry(uname+"-company-counter", "contacts");
				}
			}	
			//set the updated data
			contact.setFirstname(firstname);
			contact.setLastname(lastname);
			contact.setCompany(company);
			contact.setTelephone(telephone);
			contact.setAddress(address);
			contact.setContactMethods(contactMethods);

			//commit the transaction
			tx.commit();
		
		//create the model 
		model.setViewName("CUDContactSuccess");
		model.addObject("message","Contact Updated Successfully");
		}catch(Exception e){

			//log error message here
			LOG.log(Level.WARNING,
                    "Error occured while querying the Contacts object ");
            LOG.log(Level.WARNING, e.toString(), e);
            try{
			model.setViewName("CUDContactFail");
			model.addObject("message","Contact Failed to Update");
            }catch(Exception ex){
            	LOG.log(Level.WARNING, ex.toString(), ex);
            }
		
		}finally{
			//rollback if transaction is active
			if(tx.isActive()){
				tx.rollback();
			}
		}
		//return model to view
		return model;
	}
	/**
	 * Delete the Contact from the datastore
	 */
	@RequestMapping(value="/deleteContact",method=RequestMethod.GET)
	public ModelAndView delete(HttpServletRequest req,HttpServletResponse res,ModelAndView model){
		
		//get the singleton persistence manager
		PersistenceManager pm=PMF.get();
		
		//get the transaction
		Transaction tx=pm.currentTransaction();
		
		try{
			
		//get the values from the request
		String pemail=req.getParameter("email");
		
		//get the counter bean object
		ApplicationContext ctx = ApplicationContextProvider.getApplicationContext();
		SharedCounterService app=(SharedCounterService) ctx.getBean("sharedCounterService");
		
		//get  the existing  session
		HttpSession session=req.getSession(false);
		//get the username from the session
		String uname=(String) session.getAttribute("username");
		
			//begin the transaction
			tx.begin();
			
			//set the name space
			NamespaceManager.set(uname);
			
			
			Contacts contact=pm.getObjectById(Contacts.class,pemail);
			String company=contact.getCompany();
				
			Query query1=pm.newQuery(Contacts.class);
			query1.setFilter("company==:companyParam");
			List<Contacts> result=(List<Contacts>) query1.execute(company);
			
			if(result.size()==1)
			{
			//decrement the company counter
			app.deleteEntry(uname+"-company-counter", "companys");
			}	
			
			//delete object
			pm.deletePersistent(contact);
		
			
			//commit the transaction
			tx.commit();

		
			//delete the contact counter value
			app.deleteEntry(uname+"-contacts-counter", "contacts");
			
			app.deleteEntry(uname+"-"+company+"-counter", "companyContacts");
			
			
			model.setViewName("CUDContactSuccess");
			model.addObject("message","Contact Deleted Successfully");
			
			
			}catch(Exception e){
				//log error message here
				LOG.log(Level.WARNING,
	                    "Error occured while querying the Contacts object ");
	            LOG.log(Level.WARNING, e.toString(), e);
	            try{
	            	model.setViewName("CUDContactFail");
	            	model.addObject("message","Contact Failed to Delete");
	            }catch(Exception ex){
	            	LOG.log(Level.WARNING, ex.toString(), ex);
	            }
			}
			finally{
			//rollback if transaction is active
			if(tx.isActive()){
				tx.rollback();
			}
		
			}
			//return the model to view
			return model;
	}
	/**
	 * Display the all contacts available for this account.
	 */
	@RequestMapping(value="/displayContacts")
	public ModelAndView show(HttpServletRequest req,ModelAndView model){
			//get the singleton persistence manager
			PersistenceManager pm=PMF.get();
			
			 // We want our object to be detached 
		    pm.setDetachAllOnCommit(true);	
		
			//get the transaction
			Transaction tx=pm.currentTransaction();
			try
			{
			//begin the transaction
			tx.begin();
			
			//get the existing session 
			HttpSession session=req.getSession(false);
			//get the username from the session
			String uname=(String) session.getAttribute("username");
		
			//set the Name Space
			NamespaceManager.set(uname);
			
			//get the contacts
			Query query=pm.newQuery("select from com.adaptavant.counter.jdo.Contacts");
			
			//set the range
			query.setRange(0,100);
			
			//execute the query
			List<Contacts>results=(List<Contacts>) query.execute();
			
			
			//set the viewName and add model object
			model.setViewName("displayContacts");
			model.addObject("contacts",results);
			
			//commit the transaction
			tx.commit();
				
			}catch(Exception e){
				//log error message here
				LOG.log(Level.WARNING,
	                    "Error occured while querying the Contacts object ");
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
	/**
	 * Get the contact object from the datastore using email as a key.
	 */
	 @RequestMapping(value="/getContact",method = RequestMethod.GET)
	public ModelAndView display(HttpServletRequest req,ModelAndView model){
		 	//get the singleton persistence manager
			PersistenceManager pm=PMF.get();
			
			 // We want our object to be detached 
		    pm.setDetachAllOnCommit(true);	
			
		  
			//get the transaction
			Transaction tx=pm.currentTransaction();
			try
			{
			//begin the transaction
			tx.begin();
			
			//get the values from request
			String email=req.getParameter("email");
	
			//get  the existing session 
			HttpSession session=req.getSession(false);
			//get the username from the session
			String uname=(String) session.getAttribute("username");
		
			//set the Name Space
			NamespaceManager.set(uname);
			
			//get the contacts
			Contacts contact=pm.getObjectById(Contacts.class,email);
			
			//create the model
			model.setViewName("updateContactForm");
			
			model.addObject("contact",contact);
			
			//commit the transaction
			tx.commit();
			
			}catch(Exception e){
				//log error message here
				LOG.log(Level.WARNING,
	                    "Error occured while querying the Contacts object ");
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
