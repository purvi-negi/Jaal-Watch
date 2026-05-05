package com.dwlr.dto;

public class DWLRData {
	String dwlrID ;
	String timestamp ;
	double water_level;
	double battery_level;
	int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDwlrID() {
		return dwlrID;
	}
	public void setDwlrID(String dwlrID) {
		this.dwlrID = dwlrID;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public double getWater_level() {
		return water_level;
	}
	public void setWater_level(double water_level) {
		this.water_level = water_level;
	}
	public double getBattery_level() {
		return battery_level;
	}
	public void setBattery_level(double battery_level) {
		this.battery_level = battery_level;
	}
	public DWLRData() {
		
	}
	public DWLRData(String dwlrID, String timestamp, double water_level, double battery_level) {
		super();
		this.dwlrID = dwlrID;
		this.timestamp = timestamp;
		this.water_level = water_level;
		this.battery_level = battery_level;
	}
	
}
