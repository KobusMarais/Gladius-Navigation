package com.gladius.navup.navigation;
import java.io.*;
import java.net.*;
import java.util.*;
import java.lang.Object;
import java.lang.Throwable;

public class NotRegistered extends NavigationExceptions {
	public NotRegistered() {}

	public NotRegistered(String mesg) {
		super(mesg);
	}

	public NotRegistered(Throwable reason) {
		super(reason);
	}

	public NotRegistered(String mesg, Throwable reason) {
		super(mesg,reason);
	}

	protected String defaultMessage = new String("User is not registered and cannot request a route.");
	protected Throwable defaultCause = new Throwable(defaultMessage);
}