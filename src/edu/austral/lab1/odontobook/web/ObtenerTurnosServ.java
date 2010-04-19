package edu.austral.lab1.odontobook.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.*;
import javax.servlet.*;


public class ObtenerTurnosServ extends HttpServlet {
	
	
	public void doGet(HttpServletRequest rq, HttpServletResponse rp) {
		

		
	
		
	}
	
	
	public void doPost(HttpServletRequest rq, HttpServletResponse rp) 
		throws ServletException, IOException  {
		
		rp.setContentType("text/html");
		PrintWriter out = rp.getWriter();
		out.print("Selecionador de turnos<br>");
		String c = rq.getParameter("Mes");
		out.print("<br>Eligio el mes "+c);
		
		
	}

}
