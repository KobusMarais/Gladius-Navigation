import java.io.*;
import java.net.*;
import java.util.*;
import java.lang.Object;
import java.lang.Throwable;

public class FailedValidation extends NavigationExceptions {
	public FailedValidation() {}

	public FailedValidation(String mesg) {
		super(mesg);
	}

	public FailedValidation(Throwable reason) {
		super(reason);
	}

	public FailedValidation(String mesg, Throwable reason) {
		super(mesg,reason);
	}

	protected String defaultMessage = new String("User did not enter the correct credentials or validation failed elsewhere.");
	protected Throwable defaultCause = new Throwable(defaultMessage);
}