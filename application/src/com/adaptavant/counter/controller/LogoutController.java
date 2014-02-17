package com.adaptavant.counter.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class LogoutController {
	/**
     * A logger object.
     */
    private static final Logger LOG = Logger.getLogger(LogoutController.class
            .getName());
    /**
     * Invalidate the session after clicking logout button.
     */
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpServletRequest request){
		try{
		// Get the existing session.
		HttpSession session = request.getSession(false);
		
		//invalidate the session
		if(session!=null) {
			session.invalidate();
			}
		}catch(Exception e){
			//log error message here
            LOG.log(Level.WARNING, e.toString(), e);
		}
		return "redirect:redirect.jsp";
	}

}
