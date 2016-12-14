/*
 * $Filename: C:\Local QVCS\AgentryProjects\CommonSql\java\ToolServer.java $
 *
 * Copyright 1997-2004 Syclo LLC, All Rights Reserved.
 * $Author: mjzervas $
 *
 *	
 */ 

package com.syclo.tool;

import com.syclo.agentry.User;

/**
 * This class will be the initial entry point into our Java back end.
 * Agentry.ini's Java-[n].serverClass needs to reference the full name of this class com.syclo.tool.Server. 
 * This class will be created when the Agentry Server starts up.
 * It is used to create a user session each time a client transmits.
 * Notice how we override createUser to create our application's own User class, which must be a subclass of com.syclo.User 
 */

public class Server extends com.syclo.java.Server
{
	public Server() throws InstantiationException
	{	
		super();
	}

	@Override
	public User createUser(String name) 
	{
		String methodLabel = "Server::createUser " + name;
		log(methodLabel);
		User u = new com.syclo.tool.User(name, this);
		return u;		
	}

	/** getter for the _appName member */
	@Override
	public String appName()
	{
		return "Java Demo";
	}

}
