package com.gladius.navup.navigation;
import java.io.*;
import java.net.*;
import java.util.*;
import java.lang.Object;
import java.lang.Throwable;

/**
 * Custom exception class for exception that will be raised if general route creation fails
 * Example use case: Cannot connect to database to retrieve user preferences
 * @author  Mia Gerber
 */
public class FailedValidation extends NavigationExceptions {
	public FailedValidation() {}

	/**
	* Constructor 
	* @param 	mesg	object of type String to be output as a description of exception that is raised
	*/
	public FailedValidation(String mesg) {
		super(mesg);
	}

	/**
	* Constructor
	* @param 	reason	object of type Throwable to be thrown if exception is raised
	*/
	public FailedValidation(Throwable reason) {
		super(reason);
	}

	/**
	* Constructor
	* @param	mesg	object of type String to be output as a description of exception that is raised
	* @param 	reason	object of type Throwable to be thrown if exception is raised
	*/
	public FailedValidation(String mesg, Throwable reason) {
		super(mesg,reason);
	}

	protected String defaultMessage = new String("User did not enter the correct credentials or validation failed elsewhere.");
	protected Throwable defaultCause = new Throwable(defaultMessage);
}
