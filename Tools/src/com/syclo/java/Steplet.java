package com.syclo.java;

import com.syclo.agentry.AgentryException;
import com.syclo.agentry.FetchSession;
import com.syclo.agentry.PushSession;
import com.syclo.agentry.ServiceEventSession;
import com.syclo.agentry.StepletAbortException;
import com.syclo.agentry.TransactionSession;

// Tool Classes


/**
 * This class extends com.syclo.agentry.Steplet. It is a container class for all common methods that 
 * steplets will need to perform. The primary method of interest is the 
 * initMXSession(Session session) method which saves a reference to the Agentry session data (that
 * contains all the transaction/fetch/push data values) as well as calling the ToolUser's initMxSession()
 * method that insures the Java connection to a back end server is valid.
 */

public abstract class Steplet extends com.syclo.agentry.Steplet {

	/**
	 * pointer to the ToolUser
	 */
	protected User _user = null;


	/**
	 * constructor for transaction steplets
	 */
	public Steplet(TransactionSession session) throws StepletAbortException, AgentryException {
		super(session);
		_user = (User) _session.getUser();
		_user.log("ToolSteplet(TransactionSession session)");
		_user.setAgentrySessionData(session);
	
	}

	/**
	 * constructor for fetch steplets
	 */
	public Steplet(FetchSession session) throws StepletAbortException, AgentryException {
		super(session);
		_user = (User) _session.getUser();
		_user.log("ToolSteplet(FetchSession session)");
		_user.setAgentrySessionData(session);
	
	}

	/**
	 * constructor for push steplets
	 */
	public Steplet(PushSession session) throws StepletAbortException, AgentryException {
		super(session);
		_user = (User) _session.getUser();
		_user.log("ToolSteplet(PushSession session)");
		
	}
	
	public Steplet(ServiceEventSession session) throws Exception {
		super(session);
		_user = (User) _session.getUser();
		_user.log("ToolSteplet(ServiceEventSession session)");
	}

	/**
	 * All subclasses need to implement the following method that does the Steplet's work.
	 * Typically this will simply be creating and running a StepHandler to perform the real Java work.
	 */
	abstract public boolean doSteplet() throws StepletAbortException, AgentryException;
	
}	
