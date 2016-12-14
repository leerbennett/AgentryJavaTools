package com.syclo.java;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;

import com.syclo.agentry.DataTableObject;
import com.syclo.agentry.DataTableSession;
import com.syclo.agentry.Session;
import com.syclo.agentry.AgentryException;
import com.syclo.java.User;

/**
 * This class controls access to an Agentry DataTable including checks to see if client data is up to date or not. 
 *
 * @param <DTOBJ> DataTable subclasses can specify that they contain a subclass of DataTableObject. 
 */
public class DataTable<DTOBJ extends DataTableObject> extends com.syclo.agentry.DataTable<DTOBJ> {

	protected ArrayList<DTOBJ> _objList = new ArrayList<DTOBJ>();
	protected boolean _rebuilding = true;
	protected boolean _tableCheck = true;
	protected User _user = null;     
	protected String _shortClassName = "";
	protected String _userName = null;
	protected Session _session = null;

	public DataTable (DataTableSession session, GregorianCalendar clientLastUpdate) throws Exception {
		super(session, clientLastUpdate);
		_rebuilding = true;
		_tableCheck = true;
		if (session == null) {
			throw new Exception("Exception caught in Syclo.sap.DataTable: session is null");
		}
		_session = session;
		_user = (com.syclo.tool.User) _session.getUser();
		setShortClassName();
		_user.sessionData(_session.getSessionData());
	}
	
    /**
     * write a message to the user log file
     * @param msg	the string to write to the file
     */
    public void log(String msg) {
		_user.log(msg);	
	}

	/* (non-Javadoc)
	 * @see com.syclo.agentry.DataTable#initialize()
	 */
	public void initialize() throws AgentryException
	{
		super.initialize();
		log("clientLastDataUpdateTime=" + _clientLastDataUpdateTime.getTime());

		//check to see if the table should be refreshed
		if (_clientLastDataUpdateTime.isInvalidTimeAndDate()) {
			_rebuilding=true;
		}
		log("reload=" + _rebuilding);
		_tableCheck = true; 
	}
	
	/* (non-Javadoc)
	 * @see com.syclo.agentry.DataTable#isOutOfDate()
	 */
	public boolean isOutOfDate() throws AgentryException
	{
		_rebuilding = true;
		return _rebuilding;
	}

	/**
    * determine the short class (non fully qualified) name of this class
 	 */
	public void setShortClassName() {
		_shortClassName = this.getClass().getSimpleName();
	}

	@Override
	public Iterator<DTOBJ> iterator() throws AgentryException {
		return _objList.iterator();
	}
}
	