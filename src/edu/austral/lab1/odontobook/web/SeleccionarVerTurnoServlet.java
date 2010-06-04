package edu.austral.lab1.odontobook.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.austral.lab1.odontobook.model.Doctor;
import edu.austral.lab1.odontobook.model.Paciente;
import edu.austral.lab1.odontobook.model.Turno;
import edu.austral.lab1.odontobook.model.Usuario;
import edu.austral.lab1.odontobook.model.dao.DoctorDao;
import edu.austral.lab1.odontobook.model.dao.PacienteDao;
import edu.austral.lab1.odontobook.model.dao.TurnoDao;
import edu.austral.lab1.odontobook.model.dao.UsuarioDao;
import edu.austral.lab1.odontobook.util.DateUtils;

public class SeleccionarVerTurnoServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
		
				
	}
	
	public void doPost(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException{
	
		String auxd = (String)rq.getParameter("datepicker");

		String [] date = auxd.split("/");
		String mes = date[0];
		String dia = date[1];
		String anio = date[2];


		Date d =  DateUtils.getDate(Integer.parseInt(dia),Integer.parseInt(mes)-1, Integer.parseInt(anio) );
	
		List<Turno> list = new ArrayList<Turno>();
		UsuarioDao aux = new UsuarioDao();
		Usuario user = aux.getUsuario(rq.getRemoteUser());
		int dni = user.getDni();
		boolean esDoctor = user.isEsDoctor();
		TurnoDao turno = new TurnoDao();
		

		if(esDoctor){
			
			Doctor doctor = (new DoctorDao()).getDoctorbyDNI(dni);
			
			list = turno.getTurnoByDateAndDoctor(d,doctor.getId());
			rq.setAttribute("lista", list);
			
			rq.getRequestDispatcher("jsp/verTurnosDoc.jsp").forward(rq, rp);
			
		}
		else{
		
			Paciente paciente = (new PacienteDao()).getPacientebyDNI(dni);
			list = turno.getTurnoByDateAndPaciente(d ,paciente.getId());
			rq.setAttribute("lista", list);
			
			rq.getRequestDispatcher("jsp/verTurnosPac.jsp").forward(rq, rp);
		}
		
	}
	
}
