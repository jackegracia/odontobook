package edu.austral.lab1.odontobook.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.austral.lab1.odontobook.model.Usuario;
import edu.austral.lab1.odontobook.model.dao.UsuarioDao;

public class GoHomeServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException{	
		
	}
	
	public void doPost(HttpServletRequest rq, HttpServletResponse rp)throws ServletException, IOException {
		if(rq.getRemoteUser() == null ){
			Logout out= new Logout();
			out.doPost(rq, rp);
			return;			
		}
		
		UsuarioDao aux = new UsuarioDao();
		Usuario user = aux.getUsuario(rq.getRemoteUser());
		boolean esDoctor = user.isEsDoctor();
		if(esDoctor) rq.getRequestDispatcher("jsp/homeDoctor.jsp").forward(rq, rp);
		else rq.getRequestDispatcher("jsp/homePaciente.jsp").forward(rq, rp);
		
	}

}
