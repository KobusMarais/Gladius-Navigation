package com.gladius.navup.navigation;
import java.io.*;
import java.net.*;
import java.util.*;
import java.lang.Object;
import java.lang.Throwable;

/**
 * Custom exception class for exception that will be raised if the user requesting a route is not registered
 * Example use case: Requesting "frequent routes" for a user that is not in the database
 * @author  Mia Gerber
 */
public class NotRegistered extends NavigationExceptions {
	public NotRegistered() {}
	
	/**
	* Constructor 
	* @param 	mesg	object of type String to be output as a description of exception that is raised
	*/
	public NotRegistered(String mesg) {
		super(mesg);
	}

	/**
	* Constructor
	* @param 	reason	object of type Throwable to be thrown if exception is raised
	*/
	public NotRegistered(Throwable reason) {
		super(reason);
	}

	/**
	* Constructor
	* @param	mesg	object of type String to be output as a description of exception that is raised
	* @param 	reason	object of type Throwable to be thrown if exception is raised
	*/
	public NotRegistered(String mesg, Throwable reason) {
		super(mesg,reason);
	}

	protected String defaultMessage = new String("User is not registered and cannot request a route.");
	protected Throwable defaultCause = new Throwable(defaultMessage);
}
