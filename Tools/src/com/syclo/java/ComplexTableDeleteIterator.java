package com.syclo.java;

public class ComplexTableDeleteIterator extends ComplexTableIterator {

	public ComplexTableDeleteIterator(ComplexTableStepHandler handler) {
		super(handler);
	}

	/* (non-Javadoc)
	 * @see java.util.Iterator#hasNext()
	 */
	public boolean hasNext() {
		boolean hasNextRecord = _handler.hasNextDeletedRecord();
		return hasNextRecord;
	}
	
	/* (non-Javadoc)
	 * @see java.util.Iterator#next()
	 */
	public ComplexTableObject next() {
		ComplexTableObject obj = _handler.nextDeletedRecord();
		return obj;
	}
	
}
