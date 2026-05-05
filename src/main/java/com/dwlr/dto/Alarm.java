package com.dwlr.dto;

import java.sql.Timestamp;

public class Alarm {
	int id;
	String dwlrId;
	String alarmtype;
	String alarmMessage;
	Timestamp alarmTime;
	String status;
	public Alarm() {
		
	}
	public Alarm(String dwlrId, String alarmtype, String alarmMessage, Timestamp alarmTime, String status) {
		super();
		this.dwlrId = dwlrId;
		this.alarmtype = alarmtype;
		this.alarmMessage = alarmMessage;
		this.alarmTime = alarmTime;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDwlrId() {
		return dwlrId;
	}
	public void setDwlrId(String dwlrId) {
		this.dwlrId = dwlrId;
	}
	public String getAlarmtype() {
		return alarmtype;
	}
	public void setAlarmtype(String alarmtype) {
		this.alarmtype = alarmtype;
	}
	public String getAlarmMessage() {
		return alarmMessage;
	}
	public void setAlarmMessage(String alarmMessage) {
		this.alarmMessage = alarmMessage;
	}
	public Timestamp getAlarmTime() {
		return alarmTime;
	}
	public void setAlarmTime(Timestamp alarmTime) {
		this.alarmTime = alarmTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
