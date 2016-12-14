package com.syclo.tool.stephandler;

import com.syclo.agentry.AgentryException;
import com.syclo.agentry.BusinessLogicException;
import com.syclo.java.StepHandler;
import com.syclo.java.User;
import com.syclo.tool.object.Tool;

/**
 * Performs the work of the ToolUpdate transaction.
 * In this tutorial example, we replace any tool with matching the toolNumPrev with the tool provided in our list of Tools.
 * 
 * The com.syclo.agentry.user class provides support for getting the appropriate fields from the incoming Agentry transaction.
 * In this example we use "transaction.<propertyName>" tags to reference the properties from the Agentry transaction.
 * See the Syclo Data Markup Language section of the Agentry Language Reference manual 
 * for details on tags used to reference additional information from the client. 
 */
public class ToolEditStepHandler extends StepHandler{
	public ToolEditStepHandler(User user) {
		super(user);
	}

	public void run() throws AgentryException {
		try {
			//Get new object properties from the Agentry transaction
			String toolnum = _user.getString("transaction.toolnum");
			String description = _user.getString("transaction.description");
			_user.log("calling ToolEditStepHandler::run() on toolnum:" + toolnum + " - " + description);
			int quantity = (int) _user.getDouble("transaction.toolqty");
			double cost = _user.getDouble("transaction.toolrate");
			String color = _user.getString("transaction.toolColor");
			String storeRoomId = _user.getString("transaction.storeRoom");
			int id = (int) _user.getDouble("transaction.id");

			//Store the new tool in our back end
			Tool newTool = new Tool(toolnum, cost, quantity, color, description, storeRoomId);
			com.syclo.tool.User.editTool(id, newTool);
		}
		catch(Exception e) {
			String msg = e.getMessage();
			_user.log(msg);
			throw new BusinessLogicException(msg);
		}
	}

}
