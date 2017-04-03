package com.gladius.navup.navigation;
import java.io.*;
import java.net.*;
import java.util.*;
import java.lang.Object;
import java.lang.Throwable;

public class
NavigationExceptions extends Exception {
	public NavigationExceptions() {}

	public NavigationExceptions(String mesg) {
		super(mesg);
	}

	public NavigationExceptions(Throwable reason) {
		super(reason);
	}

	public NavigationExceptions(String mesg, Throwable reason) {
		super(mesg,reason);
	}

}