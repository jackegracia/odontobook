package edu.austral.lab1.odontobook.web;

import java.io.IOException;
import java.util.Date;
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

public class CancelarTurnoServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException{	
		
	}
	
	public void doPost(HttpServletRequest rq, HttpServletResponse rp)throws ServletException, IOException {
	
		String userName = rq.getRemoteUser();
		UsuarioDao uDao = new UsuarioDao();
		Usuario user = uDao.getUsuario(userName);
		PacienteDao pDao = new PacienteDao();
		Paciente pac = pDao.getPacienteByUserID(user.getId());
		
		String auxd = (String)rq.getParameter("datepicker");
		String [] date = auxd.split("/");
		String mes = date[0];
		String dia = date[1];
		String anio = date[2];
		Date d =  DateUtils.getDate(Integer.parseInt(dia),Integer.parseInt(mes)-1, Integer.parseInt(anio) );
		TurnoDao tDao = new TurnoDao();
		List<Turno> tList = tDao.getTurnoByDateAndPaciente(d, pac.getId());
		
		rq.setAttribute("listaTurnos", tList);
		
		
		rq.getRequestDispatcher("jsp/cancelarTurno.jsp").forward(rq, rp);
	}

}
