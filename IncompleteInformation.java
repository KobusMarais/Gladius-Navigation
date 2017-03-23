package Navigation;
import java.io.*;
import java.net.*;
import java.util.*;
import java.lang.Object;
import java.lang.Throwable;

public class IncompleteInformation extends NavigationExceptions {
	public IncompleteInformation() {}

	public IncompleteInformation(String mesg) {
		super(mesg);
	}

	public IncompleteInformation(Throwable reason) {
		super(reason);
	}

	public IncompleteInformation(String mesg, Throwable reason) {
		super(mesg,reason);
	}

	protected String defaultMessage = new String("User did not provide enough information to find a route.");
	protected Throwable defaultCause = new Throwable(defaultMessage);
}