package com.syclo.tool.steplet;

import com.syclo.agentry.AgentryException;
import com.syclo.agentry.StepletAbortException;
import com.syclo.agentry.TransactionSession;
import com.syclo.java.Steplet;
import com.syclo.tool.stephandler.ToolAddStepHandler;

/**
 * This Steplet is referenced by the Agentry step definition used by the ToolAdd transaction.
 * It servers as entry point into Java, but calls its stephandler to actually perform a transaction with the backend.
 */
public class ToolAddSteplet extends Steplet {

	public ToolAddSteplet(TransactionSession session)
	throws StepletAbortException, AgentryException {
		super(session);
	}

	/* (non-Javadoc)
	 * @see com.syclo.agentry.Steplet#doSteplet()
	 */
	@Override
	public boolean doSteplet() throws AgentryException {
		ToolAddStepHandler sh = new ToolAddStepHandler(_user); 
		sh.run();
		return true;
	}

}
