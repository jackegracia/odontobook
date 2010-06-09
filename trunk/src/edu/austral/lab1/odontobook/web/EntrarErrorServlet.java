package edu.austral.lab1.odontobook.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.austral.lab1.odontobook.model.dao.UsuarioDao;

public class EntrarErrorServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException{	
		rq.setAttribute("entrar", false);
		rq.getRequestDispatcher("jsp/login.jsp").forward(rq, rp);
	}
	
	public void doPost(HttpServletRequest rq, HttpServletResponse rp)throws ServletException, IOException {{
	

	rq.setAttribute("entrar", false);
	rq.getRequestDispatcher("login.jsp").forward(rq, rp);
	}
	}
}
