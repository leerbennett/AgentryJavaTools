package com.syclo.tool.stephandler;

import java.util.ArrayList;

import com.syclo.java.ComplexTableObject;
import com.syclo.java.ComplexTableStepHandler;
import com.syclo.tool.object.StoreRoom;

/**
 * Simple example of returning data for a Complex Table
 * In this simple case we return a fixed set of Store room data.
 * Note this class represents interaction with the whole table.
 * The StoreRoom class is used to represent a particular record in the table.
 */
public class CTStoreroomStepHandler extends ComplexTableStepHandler {
	
	ArrayList<ComplexTableObject> _table = new ArrayList<ComplexTableObject>();
	int _index = 0;
	
	public CTStoreroomStepHandler() {
		init();
	}
	
	protected void init() {
		_table.add(new StoreRoom("22A", "North side, after electrical closet", "Building 10"));
		_table.add(new StoreRoom("22B", "South side, after electrical closet", "Building 10"));
		_table.add(new StoreRoom("21", "21 Big", "Building 10"));
		_table.add(new StoreRoom("311", "A/C storeroom", "Building 10"));
		_table.add(new StoreRoom("101", "Maintenance Office closet", "Building 10"));
	}	

	public ArrayList<ComplexTableObject> build() {
		return _table;
	}

	@Override
	public boolean hasNextDataRecord() {
		return _index < _table.size();
	}

	@Override
	public ComplexTableObject nextDataRecord() {
		ComplexTableObject obj = _table.get(_index);
		_index++;
		return obj;
	}

	@Override
	public boolean hasNextDeletedRecord() {
		return false;
	}

	@Override
	public ComplexTableObject nextDeletedRecord() {
		return null;
	}

}
