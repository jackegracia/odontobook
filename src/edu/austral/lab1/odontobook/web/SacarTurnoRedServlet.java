package edu.austral.lab1.odontobook.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.austral.lab1.odontobook.model.Doctor;
import edu.austral.lab1.odontobook.model.dao.DoctorDao;
import edu.austral.lab1.odontobook.util.Sorter;


public class SacarTurnoRedServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
		
		
	}
	
	public void doPost(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException{
		if(rq.getRemoteUser() == null ){
			Logout out= new Logout();
			out.doPost(rq, rp);
			return;			
		}
		DoctorDao doc = new DoctorDao();	

		List<Doctor> list = doc.getDoctor();
		Sorter sort = new Sorter();
		list = sort.ordenarDoctores(list);
		rq.setAttribute("list", list);
		rq.getRequestDispatcher("jsp/sacarTurno.jsp").forward(rq, rp);
	}

}
