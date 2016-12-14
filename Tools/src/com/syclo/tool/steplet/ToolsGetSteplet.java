package com.syclo.tool.steplet;

import com.syclo.agentry.AgentryException;
import com.syclo.agentry.FetchSession;
import com.syclo.java.Steplet;
import com.syclo.tool.object.Tool;
import com.syclo.tool.stephandler.ToolsGetStepHandler;

/**
 * This Steplet is referenced by the Java step in the Agentry fetch definition.
 * It servers as entry point into Java, but calls its stephandler to actually get the Tool data from the back end.
 */
public class ToolsGetSteplet extends Steplet {

	public ToolsGetSteplet(FetchSession session) throws AgentryException {
		super(session);
	}

	public Tool[] _returnData = null;
	
	/* (non-Javadoc)
	 * @see com.syclo.agentry.Steplet#doSteplet()
	 */
	@Override
	public boolean doSteplet() throws AgentryException {
		ToolsGetStepHandler sh = new ToolsGetStepHandler(_user); 
		_returnData = sh.run();
		return true;
	}

}
