package gladios.navigation;
import java.io.*;
import java.net.*;
import java.util.*;
import java.lang.Object;
import java.lang.Throwable;

/**
 * Custom exception class for general exceptions relating to navigation
 * Example use case: Route that is sent contains less than two waypoints
 * @author  Mia Gerber
 */

public class
NavigationExceptions extends Exception {
	public NavigationExceptions() {}

	/**
	* Constructor 
	* @param 	mesg	object of type String to be output as a description of exception that is raised
*	*/
	public NavigationExceptions(String mesg) {
		super(mesg);
	}

	/**
	* Constructor
	* @param 	reason	object of type Throwable to be thrown if exception is raised
	*/
	public NavigationExceptions(Throwable reason) {
		
		super(reason);
	}

	/**
	* Constructor
	* @param	mesg	object of type String to be output as a description of exception that is raised
	* @param 	reason	object of type Throwable to be thrown if exception is raised
	*/
	public NavigationExceptions(String mesg, Throwable reason) {
		super(mesg,reason);
	}

}
