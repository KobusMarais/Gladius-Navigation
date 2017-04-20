package gladios.navigation;
import java.io.*;
import java.net.*;
import java.util.*;
import java.lang.Object;
import java.lang.Throwable;

/**
 * Custom exception class for exception that will be raised if a route for given constraints cannot be found
 * Example use case: Requesting a path for wheelchair access that has none
 * @author  Mia Gerber
 */
public class RouteNotFound extends NavigationExceptions {
	public RouteNotFound() {}

	/**
	* Constructor 
	* @param 	mesg	object of type String to be output as a description of exception that is raised
	*/
	public RouteNotFound(String mesg) {
		super(mesg);
	}

	/**
	* Constructor
	* @param 	reason	object of type Throwable to be thrown if exception is raised
	*/
	public RouteNotFound(Throwable reason) {
		super(reason);
	}

	/**
	* Constructor
	* @param	mesg	object of type String to be output as a description of exception that is raised
	* @param 	reason	object of type Throwable to be thrown if exception is raised
	*/
	public RouteNotFound(String mesg, Throwable reason) {
		super(mesg,reason);
	}

	protected String defaultMessage = new String("A route could not be found for the given inputs.");
	protected Throwable defaultCause = new Throwable(defaultMessage);
}
