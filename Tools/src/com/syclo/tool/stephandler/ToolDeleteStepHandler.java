package com.syclo.tool.stephandler;

import com.syclo.agentry.AgentryException;
import com.syclo.agentry.BusinessLogicException;
import com.syclo.java.StepHandler;
import com.syclo.java.User;

/**
 * Performs the work of the ToolDelete transaction.
 * In this tutorial example, we remove the tool with the matching ID.
 * 
 * The com.syclo.agentry.user class provides support for getting the appropriate fields from the incoming Agentry transaction.
 * In this example we use "transaction.<propertyName>" tags to reference the properties from the Agentry transaction.
 * See the Syclo Data Markup Language section of the Agentry Language Reference manual 
 * for details on tags used to reference additional information from the client. 
 */
public class ToolDeleteStepHandler extends StepHandler {

	public ToolDeleteStepHandler(User user) {
		super(user);
	}
	
	public void run() throws AgentryException{
		try {
			int id = (int) _user.getDouble("transaction.id");
			_user.log("calling ToolDeleteStepHandler::run() on tool id:" + id);			
			com.syclo.tool.User.deleteTool(id);
		}
		catch(Exception e) {
			String msg = e.getMessage();
			_user.log(msg);
			throw new BusinessLogicException(msg);
		}
	}

}
