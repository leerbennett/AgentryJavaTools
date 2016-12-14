package com.syclo.tool.stephandler;

import com.syclo.java.StepHandler;
import com.syclo.java.User;
import com.syclo.tool.object.Tool;

/**
 * Does the work of getting the list of Tools from the back end.
 * Our tutorial uses a simple in memory repository class.
 * In a real world application this step handler would be responsible for 
 * getting all of the Tool data relevant to the user transmitting.
 */
public class ToolsGetStepHandler extends StepHandler{

	public ToolsGetStepHandler(User user) {
		super(user);
	}
	
	public Tool[] run() {
		try {
			_user.log("calling ToolsGetStepHandler::run()...");			
			return com.syclo.tool.User.getTools();
		}
		catch(Exception e) {
			_user.log(e.getMessage());
			return null;
		}
	}

}
