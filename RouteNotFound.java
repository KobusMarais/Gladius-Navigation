import java.io.*;
import java.net.*;
import java.util.*;
import java.lang.Object;
import java.lang.Throwable;

public class RouteNotFound extends NavigationExceptions {
	public RouteNotFound() {}

	public RouteNotFound(String mesg) {
		super(mesg);
	}

	public RouteNotFound(Throwable reason) {
		super(reason);
	}

	public RouteNotFound(String mesg, Throwable reason) {
		super(mesg,reason);
	}

	protected String defaultMessage = new String("A route could not be found for the given inputs.");
	protected Throwable defaultCause = new Throwable(defaultMessage);
}