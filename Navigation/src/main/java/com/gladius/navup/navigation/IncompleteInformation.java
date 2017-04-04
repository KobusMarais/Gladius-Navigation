package com.gladius.navup.navigation;
import java.io.*;
import java.net.*;
import java.util.*;
import java.lang.Object;
import java.lang.Throwable;

/**
 * Custom exception class to be raised if information received from other modules is incomplete
 * Example use case: If we request a location but only receive latitude not longitude
 * @author  Mia Gerber
 */
public class IncompleteInformation extends NavigationExceptions {
	public IncompleteInformation() {}

	/**
	* Constructor 
	* @param 	mesg	object of type String to be output as a description of exception that is raised
	*/
	public IncompleteInformation(String mesg) {
		super(mesg);
	}

	/**
	* Constructor
	* @param 	reason	object of type Throwable to be thrown if exception is raised
	*/
	public IncompleteInformation(Throwable reason) {
		super(reason);
	}

	/**
	* Constructor
	* @param	mesg	object of type String to be output as a description of exception that is raised
	* @param 	reason	object of type Throwable to be thrown if exception is raised
	*/
	public IncompleteInformation(String mesg, Throwable reason) {
		super(mesg,reason);
	}

	protected String defaultMessage = new String("User did not provide enough information to find a route.");
	protected Throwable defaultCause = new Throwable(defaultMessage);
}
