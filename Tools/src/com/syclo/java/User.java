package com.syclo.java;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.GregorianCalendar;

import com.syclo.agentry.AgentryException;
import com.syclo.agentry.Session;
import com.syclo.agentry.SessionData;

/** 
 * This class is responsible for managing the connection/disconnection to the BackEnd server, 
 * and processing the Agentry session variables for fetches, pushes and transaction.
 * This class is active during transmit from a client device.
 * In the case of this tutorial, we are not connecting to another back end system so the login method are empty.
 * In a real world application these methods would implement a secure login to a back end  system. 
 */

public class User extends com.syclo.agentry.User
{	
	private static final long serialVersionUID = 1144059115430163225L;
	protected String	_password = null;
	protected String	_userID = null;
	protected String	_host = null;
	protected String	_appName = null;

	/**
	* pointer to the ToolServer object that instantiated this class
	*/
	protected Server _server = null;

	/**
	* caches the Agentry transaction, push or fetch session data passed from the Agentry server
	*/
	protected SessionData _sessionData = null;
	
	/**
	* constructor that can be used for standalone testing. does not require a nativeUser parameter
	*/
	public User(String host1, String name, String pw, Server server) throws IOException
	{
		super(name);
		_host = host1;
		_password = pw;
		_appName = server.appName();
		_server = server;
		setHost();
	}

	/**
	* constructor that is used by the Agentry server.
	*/
	public User(String name, Server server) 
	{
		super(name);
		_server = server;
		_appName = server.appName();
		setHost();
	}

	public void setHost() 
	{
		String methodName = "ToolUser::setHost()";
		log(methodName);
		String host = null;//_properties.server();
		if (host == null) {
			host = "localhost";
			//String errorString;
//			log(getProperty("java.text.noServerSet", methodName));
		}

		_host = host;
	}

	
	/**
	* sets the _password property
	*/
	public void setPassword(String pw) 
	{
		_password = pw;
	}

	/**
	* gets the _userID property
	*/
	public String userID() 
	{
		return _userID;
	}
	
	/**
	* caches the Agentry transaction, push or fetch session data passed from the Agentry server
	*
	* @throws MXException	if any calls to the MAXIMO API fail
	* @throws RemoteException	if any generic remote connectivity exception occurs
	*/
	public void setAgentrySessionData(Session agentrySession)
	{
			_sessionData = agentrySession.getSessionData();
	};
		
	/**
	* terminates the user's connection to the MAXIMO server
	*
	* @throws MXException	if any calls to the MAXIMO API fail
	* @throws RemoteException	if any generic remote connectivity exception occurs
	*/
	public void disconnect()
	{
		String methodName = "ToolUser::disconnect()";
		log(methodName);
		
	}

	/**
	* getter method for the protected _host data member
	*/
	public String host() 
	{
		return _host;
	}

	/**
	* prints to screen and captures to a file the supplied message parameter
	*/
	public void log(String msg) // throws MXException, RemoteException
	{
		if (msg == null) {
			return;
		}
		debug(msg);
		System.out.println(msg);				
	}

	/**
	* calls the disconnect method of this class and logs off of the Agentry server as well.
	*/
	public void loggedOut()
	{
		//String methodName = "ToolUser::loggedOut()";
//		log(getProperty("java.text.forUser", methodName, _name));
//		_ToolServer.removeUser(_name);
		super.loggedOut();
		disconnect();
	}

	public void beginChangePassword()
	{
		//String methodName = "ToolUser::beginChangePassword";
		//log(getProperty("java.text.forUser", methodName, _name));
	}

	public void endChangePassword()
	{
		//String methodName = "ToolUser::endChangePassword";
		//log(getProperty("java.text.forUser", methodName, _name));
	}

	public void changePasswordSessionAborted()
	{
		//String methodName = "ToolUser::changePasswordSessionAborted";
		//log(getProperty("java.text.forUser", methodName, _name));
	}

	/**
	* wrapper for the _sessionData's getString method. returns an empty string if _sessionData getString evals to null
	*/
	public String getString(String property)
	{
		String ret = _sessionData.getString(property);
		if (ret == null) {
			ret = "";
		}
		if (ret.startsWith("Cannot find flunky")) {
			ret = "";
		}
		return ret;
	}

	/**
	* wrapper for the _sessionData's eval method. returns an empty string if _sessionData evals to null
	*/
	public String eval(String str)
	{
		//log("calling ToolUser::eval for " + str);
		String ret = _sessionData.eval(str);
		if (ret == null) {
			ret = "";
		}	
		return ret;
	}

	/**
	* wrapper to set a local flunky in the backend's spindoc. The isLiteral parameter determines
	* whether the value string itself needs to be evaluated
	*/
	public void setLocalFlunky(String flunkyName, String flunkyVal, boolean isLiteral)
	{
		log("calling User::setLocalFlunky for " + flunkyName);
		String evalFlunky = "";
		if (isLiteral) {
			evalFlunky = "<<local " + flunkyName + "=<< \"" + flunkyVal + "\" >>";
		} else {	
			evalFlunky = "<<local " + flunkyName + "=\"" + flunkyVal + "\" >>";
		}
		if (_sessionData != null) {
			_sessionData.eval(evalFlunky);
		}
	}

	/**
	* wrapper for the _sessionData's getDouble method. 
	*/
	public double getDouble(String property)
	{
		return _sessionData.getDouble(property);
	}


	/**
	* wrapper for the _sessionData's getTimeAndDate(property) method. 
	*/
	public Date getTimeAndDate(String property) throws AgentryException
	{
		GregorianCalendar cal = _sessionData.getTimeAndDate(property);
		return cal.getTime();
	}

	/**
	* setter for the _sessionData protected member
	*/
	public void sessionData(SessionData sd)
	{
		_sessionData=sd;
	}
	
}
	
