package com.syclo.tool.table;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import com.syclo.agentry.AgentryException;
import com.syclo.agentry.DataTableObject;
import com.syclo.agentry.DataTableSession;

/**
 * This class is referenced by the Agentry definition of the Color DataTable
 * Returns a fixed list as a simple example.
 */
public class DTColor extends com.syclo.java.DataTable<DataTableObject>
{
	public DTColor(DataTableSession session, GregorianCalendar clientLastUpdate) throws Exception
	{
		super(session, clientLastUpdate);
	}

	public void initialize() throws AgentryException {
		super.initialize();
		_objList = build();		
	}

	public boolean isOutOfDate() throws AgentryException
	{
		return true;
	}
	
	protected ArrayList<DataTableObject> build() {
		// Create a new DataTable	
		ArrayList<DataTableObject> _dtObjList = new ArrayList<DataTableObject>();	
		
		// Add some objects to _dtObjList
		_dtObjList.add(new DataTableObject("Red", "Red"));
		_dtObjList.add(new DataTableObject("Green", "Green"));
		_dtObjList.add(new DataTableObject("Blue", "Blue"));
		
		return _dtObjList;
	}
	
}

