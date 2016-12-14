package com.syclo.java;

import java.lang.Class;
import java.lang.reflect.Field;

/**
 * Base object class for mapping Complex table records from the backend to Agentry properties on the client
 */
public abstract class ComplexTableObject {

    /**
     * getter to return the unique ID of the object
     * @return the ID of the object
     */
    public abstract String getID();

    public String asString() throws Exception {
    	String str = "";
    	Field[] fld;
    	Class<? extends ComplexTableObject> c = this.getClass();
    	fld = c.getDeclaredFields();
    	for(int i=0;i<fld.length;i++){
    		if(i != 0){
    			str += "|";
    		}
    		try {
    			str += fld[i].getName() + "=" + (String)fld[i].get(this); 
    		}
    		catch(Exception e){

    		}
    	}
    	return str;
    }

}
