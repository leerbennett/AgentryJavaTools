package com.syclo.tool.steplet;

import com.syclo.agentry.AgentryException;
import com.syclo.agentry.StepletAbortException;
import com.syclo.agentry.TransactionSession;
import com.syclo.java.Steplet;
import com.syclo.tool.stephandler.ToolDeleteStepHandler;

/**
 * This Steplet is referenced by the Agentry step definition used by ToolDelete transaction.
 * It servers as entry point into Java, but calls its stephandler to actually perform a transaction with the backend.
 */
public class ToolDeleteSteplet extends Steplet {

	public ToolDeleteSteplet(TransactionSession session)
	throws StepletAbortException, AgentryException {
		super(session);
	}

	/* (non-Javadoc)
	 * @see com.syclo.agentry.Steplet#doSteplet()
	 */
	@Override
	public boolean doSteplet() throws AgentryException {
		ToolDeleteStepHandler sh = new ToolDeleteStepHandler(_user); 
		sh.run();
		return true;
	}

}
