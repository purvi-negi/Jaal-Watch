package com.dwlr.dto;

public class Devices {

	String id;
	double maxLevel;
	double minLevel;
	
	public Devices() {
		
	}
	public Devices(String id, double maxLevel, double minLevel) {
		super();
		this.id = id;
		this.maxLevel = maxLevel;
		this.minLevel = minLevel;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getMaxLevel() {
		return maxLevel;
	}
	public void setMaxLevel(double maxLevel) {
		this.maxLevel = maxLevel;
	}
	public double getMinLevel() {
		return minLevel;
	}
	public void setMinLevel(double minLevel) {
		this.minLevel = minLevel;
	}
	
}
