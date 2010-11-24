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

import edu.austral.lab1.odontobook.model.Doctor;
import edu.austral.lab1.odontobook.model.HibernateUtil;
import edu.austral.lab1.odontobook.model.Paciente;
import edu.austral.lab1.odontobook.model.Turno;
import edu.austral.lab1.odontobook.model.Usuario;
import edu.austral.lab1.odontobook.model.dao.DoctorDao;
import edu.austral.lab1.odontobook.model.dao.PacienteDao;
import edu.austral.lab1.odontobook.model.dao.TurnoDao;
import edu.austral.lab1.odontobook.model.dao.UsuarioDao;
import edu.austral.lab1.odontobook.util.DateUtils;

public class ConfirmadoTurnoServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException{	
		
	}
	
	public void doPost(HttpServletRequest rq, HttpServletResponse rp)throws ServletException, IOException {
		if(rq.getRemoteUser() == null ){
			Logout out= new Logout();
			out.doPost(rq, rp);
			return;			
		}
		
		String oa = (String) rq.getParameter("oA");
		String oc = (String) rq.getParameter("oC");
		PrintWriter p = rp.getWriter();

		
		if(oa==null && oc.equals("cancelar")){
			DoctorDao doc = new DoctorDao();	

			List<Doctor> list = doc.getDoctor();
			rq.setAttribute("list", list);
			rq.getRequestDispatcher("jsp/sacarTurno.jsp").forward(rq, rp);
		}
		else if(oa.equals("aceptar") && oc==null){
			
			
			String hora = (String)rq.getParameter("hora");
			String doctor = (String)rq.getParameter("doctor");
			String fecha = (String)rq.getParameter("date");
			String[] hour = hora.split(":");
			String [] date = fecha.split("/");
			String mes = date[0];
			String dia = date[1];
			String anio = date[2];
			Date d =  DateUtils.getDate(Integer.parseInt(dia),Integer.parseInt(mes)-1, Integer.parseInt(anio) );
			String userName = rq.getRemoteUser();
			UsuarioDao uDao = new UsuarioDao();
			Usuario user = uDao.getUsuario(userName);
			PacienteDao pDao = new PacienteDao();
			Paciente pac = pDao.getPacienteByUserID(user.getId());
			DoctorDao dDao = new DoctorDao();
			String[] nameD = doctor.split(" ");

			Doctor doc = dDao.getDoctorbyNameAndApellido(nameD[0], nameD[1]);

			Turno turno = new Turno(pac,doc, d);
			turno.setHora(Integer.parseInt(hour[0]));
			turno.setMinutos(Integer.parseInt(hour[1]));
			TurnoDao turnoDao=new TurnoDao();
			turnoDao.sacarTurno(turno);
			
		}
	
		rq.getRequestDispatcher("/GoHome.do").forward(rq, rp);
	
	}
}
