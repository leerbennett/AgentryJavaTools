package com.syclo.java;

import com.syclo.java.ComplexTableIterator;

public class ComplexTableDataIterator extends ComplexTableIterator {

	public ComplexTableDataIterator(ComplexTableStepHandler handler) {
		super(handler);
	}

	/* (non-Javadoc)
	 * @see java.util.Iterator#hasNext()
	 */
	public boolean hasNext() {
		boolean hasNextRecord = _handler.hasNextDataRecord();
		return hasNextRecord;
	}
	
	/* (non-Javadoc)
	 * @see java.util.Iterator#next()
	 */
	public ComplexTableObject next() {
		ComplexTableObject obj = _handler.nextDataRecord();
		return obj;
	}
	
}
