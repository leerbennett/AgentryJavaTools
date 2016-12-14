package com.syclo.java;

import com.syclo.agentry.SessionData;
import com.syclo.agentry.User;

/**
 * This is the base class for a Java Back end.
 * A sub class of Server will be the initial entry point into the back end Java.
 * Agentry.ini's Java-[n].serverClass controls the class that the Agentry server will start for the Java Back End. 
 * Server is responsible for actually handling the logic 
 * for authentication responses and user management. The class writes out logging information 
 * to the Agentry server's server.log file
 */

public class Server extends com.syclo.agentry.Server
{
	protected static Server _server;

	/**
	 *Constructor that instantiates a server 
	 */
	public Server() throws InstantiationException
	{	
		_server = this;
	}

	public void login(User u, String password, SessionData sessionDaata) {
		// in the real world some validation would go here.
		// you'd get the userid from the user object and use the password to validate against something
		// and then throw the appropriate Exception if the validation failed
	}
	
	public void loginPreviousUser(User u, String password, SessionData sessionData) 
	{
		String methodLabel = "Server::loginPreviousUser";
		log(methodLabel);
		login(u, password, sessionData);
	}

	public void loginBlocked(User u, StringBuffer error)
	{
		String logString = "Server::loginBlocked - " + error;
		log(logString);
	}
	
	public void loginFailed(User u, StringBuffer error)
	{
		String logString = "Server::loginFailed - " + error;
		log(logString);
	}
	
	/** write to the log file */
	public void log(String debugString)
	{
		if (debugString == null) {
			return;
		}
		debug(debugString);
	}

	public String appName()
	{
		return "Agentry Application";
	}

}
