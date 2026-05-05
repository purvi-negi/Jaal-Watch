package com.dwlr.ctrl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import com.dwlr.dto.Devices;
import com.dwlr.model.ModelClass;
import com.dwlr.service.AnormalyService;

@WebServlet("/ShowDevices")
public class ShowDevicesCtl extends HttpServlet {
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModelClass ad = new ModelClass();
		ArrayList<Devices> al = ad.getAllDevices();
		RequestDispatcher rd = request.getRequestDispatcher("showDevices.jsp");
		
		
	
		
		request.setAttribute("LIST", al);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
