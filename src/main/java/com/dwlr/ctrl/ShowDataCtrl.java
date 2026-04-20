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
import com.dwlr.service.AnormalyService;

@WebServlet("/ShowDataCtrl")
public class ShowDataCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModelClass ad = new ModelClass();
		ArrayList<DWLRData> al = ad.getAllData();
		RequestDispatcher rd = request.getRequestDispatcher("showData.jsp");
		
		AnormalyService service = new AnormalyService();
		service.checkNoData("DWLR001"); 
		
		request.setAttribute("LIST", al);
		rd.forward(request, response);
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
