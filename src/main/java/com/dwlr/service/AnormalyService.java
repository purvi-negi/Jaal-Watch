package com.dwlr.service;

import java.sql.Timestamp;

import com.dwlr.dto.Alarm;
import com.dwlr.model.ModelClass;

public class AnormalyService {
	
	
	public void checkLowBattery(String dwlrId, double batteryLevel) {

        if (batteryLevel < 20) {
        	String message = "Low Battery: " + batteryLevel + "%";
            ModelClass ad = new ModelClass();
            
            Timestamp currentTime = new Timestamp(System.currentTimeMillis());
            Alarm al = new Alarm(dwlrId,"LOW_BATTERY",message,currentTime,"ACTIVE");
            ad.insertAlarm(al);
        }
    }
	
	
	public void checkOutOfRange(String dwlrId, double waterLevel) {
		
	    ModelClass model = new ModelClass();
	    double min = model.getMinLevel(dwlrId);
	    double max = model.getMaxLevel(dwlrId);

	    if (waterLevel < min || waterLevel > max) {

	        String message = "Water Level Out of Range! Value: " + waterLevel +
	                         " (Allowed: " + min + " - " + max + ")";

	        Timestamp time = new Timestamp(System.currentTimeMillis());
	        Alarm al = new Alarm(dwlrId, "OUT_OF_RANGE", message, time, "ACTIVE");
	        model.insertAlarm(al);
	    }
	}
	
	
	public void checkNoData(String dwlrId) {

	    ModelClass model = new ModelClass();

	    Timestamp lastTime = model.getLastTimestamp(dwlrId);

	    if (lastTime == null) return;

	    long currentTime = System.currentTimeMillis();
	    long last = lastTime.getTime();

	    long diffHours = (currentTime - last) / (1000 * 60 * 60);

	    if (diffHours >= 24) {   

	        String message = "No Data Received for " + diffHours + " hours";

	        Timestamp now = new Timestamp(currentTime);

	        Alarm al = new Alarm(dwlrId, "NO_DATA", message, now, "ACTIVE");

	        model.insertAlarm(al);
	    }
	}
	
}
