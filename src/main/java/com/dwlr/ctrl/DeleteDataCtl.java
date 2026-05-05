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

/**
 * Servlet implementation class DeleteDataCtl
 */
@WebServlet("/DeleteDataCtl")
public class DeleteDataCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteDataCtl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ModelClass ad = new ModelClass();
		int i = ad.deletePatient(id);
		ArrayList<DWLRData> li = ad.getAllData();
		
		RequestDispatcher rd = request.getRequestDispatcher("showData.jsp");
		if(i!=0) {
			request.setAttribute("msg", "Record deleted..");			
		}else {
			request.setAttribute("msg", "Record not deleted..");
		}
		request.setAttribute("LIST", li);
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
