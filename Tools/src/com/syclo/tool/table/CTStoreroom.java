package com.syclo.tool.table;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;

import com.syclo.agentry.ComplexTableSession;
import com.syclo.agentry.AgentryException;
import com.syclo.java.ComplexTableObject;
import com.syclo.tool.stephandler.CTStoreroomStepHandler;

/**
 * This class is referenced by the Agentry definition of the Storeroom ComplexTable
 * It uses the CTStoreroomStepHandler to populate data that needs to be returned to the client.
 */
public class CTStoreroom extends com.syclo.agentry.ComplexTable<ComplexTableObject> {

    protected ArrayList<ComplexTableObject> _ctObjList = new ArrayList<ComplexTableObject>();
    protected ArrayList<ComplexTableObject> _ctObjListDel = new ArrayList<ComplexTableObject>();
    protected CTStoreroomStepHandler _stepHandler = null;
    
    public CTStoreroom(ComplexTableSession session, GregorianCalendar clientLastUpdate) throws Exception
	{
		super(session, clientLastUpdate);
		_stepHandler = new CTStoreroomStepHandler();
	}

	public void build() throws AgentryException
	{
		setNewDataUpdateTime(new GregorianCalendar());
	}

	public boolean willRebuildTable() throws AgentryException
	{
		// override this if you want custom reload logic for this table
		return true;
	}

    /* (non-Javadoc)
     * @see com.syclo.agentry.ComplexTable#dataIterator()
     */
    public Iterator<ComplexTableObject> dataIterator() throws AgentryException {
   		return _stepHandler.getDataIterator();
    }

    /* (non-Javadoc)
     * @see com.syclo.agentry.ComplexTable#deleteIterator()
     */
    public Iterator<ComplexTableObject> deleteIterator() throws AgentryException {
   		return _stepHandler.getDeleteIterator();
    }
}

