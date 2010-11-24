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
import edu.austral.lab1.odontobook.util.Sorter;

public class RedirectHomeServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException{	
		UsuarioDao aux = new UsuarioDao();
		String name = rq.getRemoteUser();
		Usuario usuario = aux.getUsuario(name);
		boolean esDoctor = usuario.isEsDoctor();
		if(esDoctor){
			DoctorDao dDao = new DoctorDao();
			Doctor doctor = dDao.getDoctorByUserID(usuario.getId());
			Calendar cal = new GregorianCalendar();
			int day = cal.get(Calendar.DATE);
			int month = cal.get(Calendar.MONTH)+1;
			int year = cal.get(Calendar.YEAR);
			Date actual = DateUtils.getDate(day, month-1, year);
			TurnoDao tDao = new TurnoDao();
			List<Turno> lista = tDao.getTurnoByDateAndDoctor(actual, doctor.getId());
			Sorter sort = new Sorter();
			sort.ordenarTurnos(lista);
			rq.setAttribute("lista", lista);
			rq.setAttribute("dia", day);
			rq.setAttribute("mes", month);
			rq.setAttribute("anio", year);

			rq.getRequestDispatcher("jsp/homeDoctor.jsp").forward(rq, rp);
		}
		else{
			PacienteDao pDao = new PacienteDao();
			Paciente paciente = pDao.getPacienteByUserID(usuario.getId());
			Calendar cal = new GregorianCalendar();
			int day = cal.get(Calendar.DATE);
			int month = cal.get(Calendar.MONTH);
			int year = cal.get(Calendar.YEAR);
			Date actual = DateUtils.getDate(day, month, year);
			TurnoDao tDao = new TurnoDao();
			List<Turno> auxLista = tDao.getTurnoByPaciente(paciente.getId());
			List<Turno> lista = new ArrayList<Turno>();
			for(int i = 0; i < auxLista.size(); i++){
				if(auxLista.get(i).getFecha().compareTo(actual) >=0){
					lista.add(auxLista.get(i));
				}
			}
			rp.getWriter().print(lista.size());
			Sorter sort = new Sorter();
			sort.ordenarTurnos(lista);
			rq.setAttribute("lista", lista);
			rq.setAttribute("dia", day);
			rq.setAttribute("mes", month);
			rq.setAttribute("anio", year);
			rq.getRequestDispatcher("jsp/homePaciente.jsp").forward(rq, rp);
		}
	}
	
	public void doPost(HttpServletRequest rq, HttpServletResponse rp)throws ServletException, IOException {
		
			
	}
}
