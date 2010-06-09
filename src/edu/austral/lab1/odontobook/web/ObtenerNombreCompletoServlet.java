package edu.austral.lab1.odontobook.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.austral.lab1.odontobook.model.Paciente;
import edu.austral.lab1.odontobook.model.Usuario;
import edu.austral.lab1.odontobook.model.dao.PacienteDao;
import edu.austral.lab1.odontobook.model.dao.UsuarioDao;

public class ObtenerNombreCompletoServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException{	
		UsuarioDao aux = new UsuarioDao();
		Usuario user = aux.getUsuario(rq.getRemoteUser());
		PacienteDao pDao = new PacienteDao();
		Paciente paciente = pDao.getPacienteByUserID(user.getId());
		String nombreCompleto = paciente.getNombre()+" "+paciente.getApellido();
		PrintWriter p = rp.getWriter();
		p.print(nombreCompleto);
		
		
		rq.setAttribute("nombreCompleto", nombreCompleto);
	}
	
	public void doPost(HttpServletRequest rq, HttpServletResponse rp)throws ServletException, IOException {
		UsuarioDao aux = new UsuarioDao();
		Usuario user = aux.getUsuario(rq.getRemoteUser());
		PacienteDao pDao = new PacienteDao();
		Paciente paciente = pDao.getPacienteByUserID(user.getId());
		String nombreCompleto = paciente.getNombre()+" "+paciente.getApellido();
		PrintWriter p = rp.getWriter();
		p.print(nombreCompleto);
		
		
		rq.setAttribute("nombreCompleto", nombreCompleto);
	//	rq.getRequestDispatcher("jsp/cancelarTurno.jsp").forward(rq, rp);
	}

}
