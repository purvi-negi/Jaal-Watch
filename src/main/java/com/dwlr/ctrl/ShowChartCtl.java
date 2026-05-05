package com.dwlr.ctrl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

import com.dwlr.model.ModelClass;

/**
 * Servlet implementation class ShowChartCtl
 */
@WebServlet("/ShowChartCtl")
public class ShowChartCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowChartCtl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ses = request.getSession();
		ses.setAttribute("USER", "session");
		ModelClass ad =  new ModelClass();
		ArrayList<Double> waterList = ad.getWaterLevels();
		ArrayList<String> timeList = ad.getTimestamps();
RequestDispatcher rd = request.getRequestDispatcher("adminDashboard.jsp");
		request.setAttribute("waterList", waterList);
		request.setAttribute("timeList", timeList);
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
