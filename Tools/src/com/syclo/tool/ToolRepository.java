package com.syclo.tool;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.syclo.tool.object.Tool;

/**
 * This class serves as a fake back end storage. 
 * A real example would store the data in an enterprise system.
 * This storage class provided to simplify this tutorial example, by eliminating the need to connect to another system.
 */
public class ToolRepository {
	protected List<Tool> toolList;
	private static final int  INITIAL_LIST_SIZE = 5;
	protected volatile int idCounter;  
	
	/**
	 * Create some starting data by default.
	 * @throws InstantiationException
	 */
	public void initialize() throws InstantiationException {
		toolList = new ArrayList<Tool>(INITIAL_LIST_SIZE);

		add( new Tool("Tool1", 10.0, 1, "Red", "tool #1","") );
		add( new Tool("Tool2", 15.0, 2, "Green", "tool #2",""));
		add( new Tool("Tool3", 20.0, 5, "Blue","tool #3",""));

	}
	
	public Tool[] getArray() {
		Tool[] a = new Tool[0];
		return toolList.toArray(a);
	}

	//Need to make access thread safe as multiple Users might attempt to add items at the same time.
	protected synchronized int incrementId() {
			return ++idCounter;
	}
	
	public void add(Tool t) {
		t.id = incrementId();
		toolList.add(t);
	}

	public boolean delete(int id) {
		Tool t;
		t = findToolById(id);		
		if (t != null) {
			toolList.remove(t);
			return true;
		}
		return false;
	}

	public void edit(int id, Tool updatedTool) {
		Tool t;
		t = findToolById(id);
		if (t != null) {
			toolList.set(toolList.indexOf(t), updatedTool);
		} else {
			toolList.add(updatedTool);
		}		
	}

	public Tool findToolById(int id) {
		Iterator<Tool> i = toolList.iterator();
		while (i.hasNext()) {
			Tool t = i.next();
			if (t.id == id) {
				return t;
			}
		}
		return null;
	}
}
