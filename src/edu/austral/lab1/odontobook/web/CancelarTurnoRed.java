package edu.austral.lab1.odontobook.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CancelarTurnoRed extends HttpServlet {
	
	public void doGet(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException{	
		
	}
	
	public void doPost(HttpServletRequest rq, HttpServletResponse rp)throws ServletException, IOException {
		if(rq.getRemoteUser() == null ){
			Logout out= new Logout();
			out.doPost(rq, rp);
			return;			
		}
		rq.getRequestDispatcher("jsp/cancelarTurno.jsp").forward(rq, rp);
	}
}
