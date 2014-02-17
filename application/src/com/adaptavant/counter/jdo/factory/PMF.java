package com.adaptavant.counter.jdo.factory;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;

/**
 * The persistence manager helper class responsible for maintaining and 
 * providing access to a Singleton instance of the PersistenceManager.
 */
public class PMF {

  /**
   *  the singleton instance 
   *  
   */
  private static PersistenceManager instance = null;

  /**
   * Hide the constructor.
   */
  private PMF() {
  }

  /**
   * Gets the singleton instance of the PersistenceManager
   * 
   * @return the singleton instance of the PersistenceManager
   */
  public static PersistenceManager get() {
    if (instance == null) {
      instance =
          JDOHelper.getPersistenceManagerFactory("transactions-optional")
              .getPersistenceManager();
    }
    return instance;
  }
  /**
   * Close the persistence manager and make null.
   */
  public static void  close(){
	  if(instance!=null){
		  instance.close();
		  instance=null;
	  }
  }
}

