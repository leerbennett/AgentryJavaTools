package com.syclo.java;

import com.syclo.java.User;


/**
 * Base class allowing step handlers to maintain access to user class in order to access session data
 */
public class StepHandler {

	protected User _user = null;
	
	public StepHandler(User user) {
		_user = user;
	}
}
