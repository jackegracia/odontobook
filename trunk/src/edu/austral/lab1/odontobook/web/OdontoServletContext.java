package edu.austral.lab1.odontobook.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class OdontoServletContext implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent e) {
		ServletContext sc = e.getServletContext();
		
		//hago algo para obtener la base de datos (?)
		sc.getInitParameter("base de datos");
		
		sc.setAttribute("db", 0);
		//para obtenerlo en un servlet hago getServletContext().getAtribute("db")
	}

	@Override
	public void contextInitialized(ServletContextEvent e) {
		// TODO Auto-generated method stub
		
	}

}
