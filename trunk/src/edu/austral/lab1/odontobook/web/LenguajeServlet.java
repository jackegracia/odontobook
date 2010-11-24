package edu.austral.lab1.odontobook.web;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.austral.lab1.odontobook.model.Doctor;
import edu.austral.lab1.odontobook.model.dao.DoctorDao;
import edu.austral.lab1.odontobook.util.Sorter;

public class LenguajeServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
		
		
	}
	
	public void doPost(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException{
		String pais = rq.getParameter("leng");
		if(pais == null){
			pais = "ES";
		}
		String lenguaje = null;

		if(pais.equals("ES")){
			lenguaje = "es";
		}else lenguaje = "en";
		Locale locale = new Locale(lenguaje, pais);

		Bundle.setLocale(locale);

		rq.getRequestDispatcher("/GoHome.do").forward(rq, rp);


		
	}
}
