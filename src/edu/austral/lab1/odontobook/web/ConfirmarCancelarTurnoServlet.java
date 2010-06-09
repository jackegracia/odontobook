package edu.austral.lab1.odontobook.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.austral.lab1.odontobook.model.Paciente;
import edu.austral.lab1.odontobook.model.Turno;
import edu.austral.lab1.odontobook.model.Usuario;
import edu.austral.lab1.odontobook.model.dao.PacienteDao;
import edu.austral.lab1.odontobook.model.dao.TurnoDao;
import edu.austral.lab1.odontobook.model.dao.UsuarioDao;
import edu.austral.lab1.odontobook.util.DateUtils;

public class ConfirmarCancelarTurnoServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException{	
		
	}
	
	public void doPost(HttpServletRequest rq, HttpServletResponse rp)throws ServletException, IOException {
		if(rq.getRemoteUser() == null ){
			Logout out= new Logout();
			out.doPost(rq, rp);
			return;			
		}
		
		
		Calendar cal = new GregorianCalendar();
		PrintWriter p = rp.getWriter();
		int day = cal.get(Calendar.DATE);
		int month = cal.get(Calendar.MONTH)+1;
		int year = cal.get(Calendar.YEAR);
		String hora = (String)rq.getParameter("hora");
		String doctor = (String)rq.getParameter("doctor");
		String fecha = (String)rq.getParameter("date");
		p.println(doctor);
		String[] fechaS = fecha.split("/");
		int diaA = Integer.parseInt(fechaS[1]);
		int mesA = Integer.parseInt(fechaS[0]);
		int anioA = Integer.parseInt(fechaS[2]);
		boolean correcto = false;

		Date actual = DateUtils.getDate(diaA, mesA, anioA);
		Date pedido = DateUtils.getDate(day+3, month, year);
		if(pedido.compareTo(actual)==1 ){
			correcto = false;
		}else correcto = true;
		
		rq.setAttribute("fecha", fecha);
		rq.setAttribute("hora", hora);
		rq.setAttribute("doctor", doctor);
		rq.setAttribute("fechaCorrecta", correcto);
		
		
		rq.getRequestDispatcher("jsp/confirmarCancelarTurno.jsp").forward(rq, rp);
	}

}
