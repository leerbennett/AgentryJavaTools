package com.syclo.tool.object;

import com.syclo.java.ComplexTableObject;

/**
 * Represents a single StoreRoom record within a Complex Table. 
 */
public class StoreRoom extends ComplexTableObject {

	public StoreRoom() {
	}
	
	public StoreRoom(String room, String desc, String loc) {
		super();
		StoreRoomID = room;
		Description = desc;
		Location = loc;
	}
	
	// Preferably would be private, but required by Agentry to be public for now
	public String StoreRoomID;
	public String Description;
	public String Location;
	
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public String getStoreRoomID() {
		return StoreRoomID;
	}
	public void setStoreRoomID(String storeRoomID) {
		StoreRoomID = storeRoomID;
	}

	@Override
	public String getID() {
		return getStoreRoomID();
	}
}
