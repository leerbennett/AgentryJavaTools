package com.syclo.tool;

import java.io.IOException;

import com.syclo.java.Server;
import com.syclo.tool.object.Tool;

/** 
 * This class is responsible for managing the connection/disconnection to the BackEnd server, 
 * and processing the Agentry session variables for fetches, pushes and transaction.
 * This class is active during transmit from a client device. 
 * For this tutorial application we store a static copy of ourTools as a simulated back end.
 */

public class User extends com.syclo.java.User
{	
	private static final long serialVersionUID = -143582337427583658L;
	static protected ToolRepository ourTools;

	/**
	* constructor that can be used for standalone testing. does not require a nativeUser parameter
	*/
	public User(String host1, String name, String pw, Server server) throws IOException
	{
		super(host1, name, pw, server);
	}

	/**
	* constructor that is used by the Agentry server.
	*/
	public User(String name, Server server) 
	{
		super(name, server);
	}

	protected static ToolRepository getToolRepository() {
		//lazy initialization
		if (ourTools == null) {
			try {
				ourTools = new ToolRepository();
				ourTools.initialize();
			} catch (InstantiationException e) {
				e.printStackTrace();
			}
		}
		return ourTools;
	}

	/**
	 * @return All data in our tools list, used by Agentry Fetch
	 */
	public static Tool[] getTools() {
		return getToolRepository().getArray();
	}

	/**
	 * Remove tool with matching Id
	 * @param id Id of item to be deleted.
	 * @return True if item with this id is found for deletion.
	 */
	public static boolean deleteTool(int id) {
		return getToolRepository().delete(id);
	}

	/**
	 * Add tool provided to repository tool collection
	 * @param t Tool to be added
	 */
	public static void addTool(Tool t) {
		getToolRepository().add(t);
	}

	/**
	 * Replace tool matching id to tool provided
	 * @param id Id of item to be updated.
	 * @param t
	 */
	public static void editTool(int id, Tool t) {
		getToolRepository().edit(id, t);		
	}

}
	
