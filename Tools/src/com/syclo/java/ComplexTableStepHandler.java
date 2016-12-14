package com.syclo.java;

/**
 * The Agentry Complex Table with a Java connection will reference a subclass of this StepHandler to retrieve updates for the complex table.
 */
public abstract class ComplexTableStepHandler {

	protected ComplexTableDataIterator _ctDataIterator = new ComplexTableDataIterator(this);
	protected ComplexTableDeleteIterator _ctDeleteIterator = new ComplexTableDeleteIterator(this);

	public ComplexTableStepHandler() {
		
	}
	
	public abstract boolean hasNextDataRecord();
	public abstract ComplexTableObject nextDataRecord();

	public abstract boolean hasNextDeletedRecord();
	public abstract ComplexTableObject nextDeletedRecord();
	
	/**
	 * @return Iterator for new data that client should add or update
	 */
	public ComplexTableDataIterator getDataIterator() {
		return _ctDataIterator;
	}

	/**
	 * @return Iterator for data that client should delete
	 */
	public ComplexTableDeleteIterator getDeleteIterator() {
		return _ctDeleteIterator;
	}
}
