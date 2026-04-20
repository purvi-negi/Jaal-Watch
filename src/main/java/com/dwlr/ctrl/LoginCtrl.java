package com.dwlr.ctrl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.dwlr.model.ModelClass;

/**
 * Servlet implementation class LoginCtrl
 */
@WebServlet("/LoginCtrl")
public class LoginCtrl extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("id");
		String password = request.getParameter("password");
		ModelClass ad = new ModelClass();
		int i= ad.checkAdmin(username, password);
		if(i!=0) {
			response.sendRedirect("adminDashboard.jsp");
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			request.setAttribute("msg", "Invalid username or password....");
			rd.forward(request, response);
		}
	}
}
