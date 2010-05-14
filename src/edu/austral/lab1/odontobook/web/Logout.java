package edu.austral.lab1.odontobook.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JList;


import edu.austral.lab1.odontobook.model.dao.UsuarioDao;


public class Logout extends HttpServlet{
	
	public void doGet(HttpServletRequest rq, HttpServletResponse rp) {
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException  {
		
		request.getSession().invalidate();
		request.getRequestDispatcher("login.jsp").forward(request, response);
}

}
