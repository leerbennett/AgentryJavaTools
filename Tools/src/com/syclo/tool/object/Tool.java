package com.syclo.tool.object;

import java.lang.String;

/**
 * This POJO (Plain Old Java Object) is used to map data to the Agentry object definition.
 * When the Java back end returns a set of these Tool objects the Agentry Server will map the public fields to 
 * the fields defined in the Agentry object if the names match.
 *
 */
public class Tool {

	public String toolNum;
	public double toolRate;
	public int toolQty;
	public String toolColor;
	public String description;
	public String storeRoom;
	public int id;
	
	public Tool() throws InstantiationException
	{
		toolNum="";
		toolRate=0;
		toolQty=0;
		toolColor = "Grey";
		description="";
	}
	
	public Tool(String toolNum1, double toolRate1, int toolQty1, String color, String description1, String storeRoom) throws InstantiationException
	{
		toolNum=toolNum1;
		toolRate=toolRate1;
		toolQty=toolQty1;
		toolColor=color;
		description=description1;
		this.storeRoom=storeRoom;
	}
}
