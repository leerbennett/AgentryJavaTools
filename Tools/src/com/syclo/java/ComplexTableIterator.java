package com.syclo.java;

import java.util.Iterator;

public abstract class ComplexTableIterator implements Iterator<ComplexTableObject> {

	protected ComplexTableStepHandler _handler = null;
	protected int _batchSize = 0;
	protected int _count = 0;
	protected int _totalCount = 0;
	protected boolean _moreToGet = true;
	
	public ComplexTableIterator(ComplexTableStepHandler handler) {
		_handler = handler;
	}

	/* (non-Javadoc)
	 * @see java.util.Iterator#hasNext()
	 */
	public boolean hasNext() {
		return false;
	}

	/* (non-Javadoc)
	 * @see java.util.Iterator#next()
	 */
	public ComplexTableObject next() {
		return null;
	}

	/* (non-Javadoc)
	 * @see java.util.Iterator#remove()
	 */
	public void remove() {
	}
}
