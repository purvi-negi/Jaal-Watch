package com.dwlr.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.dwlr.dto.Alarm;
import com.dwlr.dto.DWLRData;

public class ModelClass {
	private static String URL="jdbc:mysql://localhost:3306/";
	private static String DB_NAME="minorproject";
	private static String USERNAME="root";
	private static String PASSWORD="Rupal@12";
	private static String DRIVER="com.mysql.cj.jdbc.Driver";
	private static Connection getConnection() {
		Connection con =null;
		try {
			Class.forName(DRIVER);
			con=DriverManager.getConnection(URL+DB_NAME,USERNAME,PASSWORD);
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public int checkAdmin(String uname, String pswd) {
		int i=0;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select * from loginCred where username=? and password=?");
			ps.setString(1, uname);
			ps.setString(2, pswd);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				i=1;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public int insertData(DWLRData data) {
		int i=0;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("insert into dwlrdata(dwlrId,timestamp,waterlevel,batterylevel) values(?,?,?,?)");
			ps.setString(1, data.getDwlrID());
			ps.setString(2,data.getTimestamp());
			ps.setDouble(3, data.getWater_level());
			ps.setDouble(4, data.getBattery_level());
			i=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	

	public ArrayList<DWLRData> getAllData() {
		ArrayList<DWLRData> al = new ArrayList<>();
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select * from dwlrdata");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				DWLRData data = new DWLRData(rs.getString("dwlrId"),rs.getString("timestamp"),rs.getDouble("waterlevel"),rs.getDouble("batterylevel"));
				data.setId(rs.getInt("id"));
				al.add(data);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return al;
	}
	
	public int insertAlarm(Alarm ar) {
		int i=0;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("insert into alarm(dwlrId,alarmtype , alarmMessage,alarmtime,status) values(?,?,?,?,?)");
			ps.setString(1, ar.getDwlrId());
			ps.setString(2, ar.getAlarmtype());
			ps.setString(3, ar.getAlarmMessage());
			ps.setTimestamp(4, ar.getAlarmTime());
			ps.setString(5, ar.getStatus());
			i=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	
	public ArrayList<Alarm> getAllAlarms() {

	    ArrayList<Alarm> al = new ArrayList<>();

	    try {
	        Connection conn = getConnection();

	        String sql = "SELECT * FROM alarm ORDER BY alarmid DESC";

	        PreparedStatement ps = conn.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {

	            Alarm ar = new Alarm(
	                rs.getString("dwlrId"),
	                rs.getString("alarmType"),
	                rs.getString("alarmMessage"),
	                rs.getTimestamp("alarmTime"),
	                rs.getString("status")
	            );

	            al.add(ar);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return al;
	}
	
	
	public double getMinLevel(String dwlrId) {

	    double min = 0;

	    try {
	        Connection conn = getConnection();
	        String sql = "SELECT min_level FROM dwlr_config WHERE dwlr_id=?";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setString(1, dwlrId);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            min = rs.getDouble("min_level");
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return min;
	}
	
	
	
	public double getMaxLevel(String dwlrId) {

	    double max = 0;

	    try {
	        Connection conn = getConnection();

	        String sql = "select max_level FROM dwlr_config WHERE dwlr_id=?";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setString(1, dwlrId);

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            max = rs.getDouble("max_level");
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return max;
	}
	
	
	
	
	public Timestamp getLastTimestamp(String dwlrId) {

	    Timestamp time = null;

	    try {
	        Connection conn = getConnection();

	        String sql = "SELECT timestamp FROM dwlr_data WHERE dwlr_id=? ORDER BY timestamp DESC LIMIT 1";

	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setString(1, dwlrId);

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            time = rs.getTimestamp("timestamp");
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return time;
	}
	
	 				
}
