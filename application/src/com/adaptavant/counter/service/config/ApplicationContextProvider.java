package com.adaptavant.counter.service.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextProvider implements ApplicationContextAware{
	/**
	 * Initialize the Application context.
	 */
 private static ApplicationContext ctx = null;
 
 /**
  * 
  * get the applicationContext object.
  */
 public static ApplicationContext getApplicationContext() {
return ctx;
 }
 /**
  * set the application context by spring.
  */
 public void setApplicationContext(ApplicationContext ctx) throws BeansException {
this.ctx = ctx;
 }
 
}