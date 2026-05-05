package com.dwlr.ctrl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import com.dwlr.dto.DWLRData;
import com.dwlr.model.ModelClass;
import com.dwlr.dto.Alarm;
@WebServlet("/ShowAlarm")
public class ShowAlarm extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModelClass ad = new ModelClass();
		ArrayList<Alarm> al = ad.getAllAlarms();
		RequestDispatcher rd = request.getRequestDispatcher("alarm.jsp");
		request.setAttribute("AlarmList", al);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
