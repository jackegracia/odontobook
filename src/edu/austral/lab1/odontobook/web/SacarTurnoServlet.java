package edu.austral.lab1.odontobook.web;

import java.io.IOException;
import java.util.ArrayList;
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

public class SacarTurnoServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
	
		
	}
	
	public void doPost(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException{
			

		rq.getRequestDispatcher("jsp/sacarTurno.jsp").forward(rq, rp);
	}

}
