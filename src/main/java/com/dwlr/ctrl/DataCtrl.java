package com.dwlr.ctrl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.dwlr.dto.DWLRData;
import com.dwlr.model.ModelClass;
import com.dwlr.service.AnormalyService;

@WebServlet("/DataCtrl")
public class DataCtrl extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String dwlrID = request.getParameter("dwlr-id");
		String timestamp = request.getParameter("timestamp");
		double water_level = Double.parseDouble(request.getParameter("water-level"));
		double battery_level = Double.parseDouble(request.getParameter("battery-level"));
		DWLRData data = new DWLRData(dwlrID,timestamp,water_level,battery_level);
		ModelClass model = new ModelClass();
		int i = model.insertData(data);
		AnormalyService service = new AnormalyService();
		service.checkLowBattery(dwlrID, battery_level);
		service.checkOutOfRange(dwlrID, water_level);
		
		RequestDispatcher rd = request.getRequestDispatcher("adminDashboard.jsp");
		if(i!=0) {
			request.setAttribute("msgIn", "Record insertedd..");			
		}else {
			request.setAttribute("msgIn", "Record not inserted..");
		}
		rd.forward(request, response);
	}
}
