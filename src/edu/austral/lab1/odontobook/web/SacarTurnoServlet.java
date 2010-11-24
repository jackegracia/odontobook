package edu.austral.lab1.odontobook.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.austral.lab1.odontobook.model.Doctor;
import edu.austral.lab1.odontobook.model.Turno;
import edu.austral.lab1.odontobook.model.dao.DoctorDao;
import edu.austral.lab1.odontobook.model.dao.TurnoDao;
import edu.austral.lab1.odontobook.util.DateUtils;
import edu.austral.lab1.odontobook.util.Sorter;

public class SacarTurnoServlet extends HttpServlet{

	public void doGet(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {


	}

	public void doPost(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException{
		if(rq.getRemoteUser() == null ){
			Logout out= new Logout();
			out.doPost(rq, rp);
			return;			
		}
		DoctorDao doc1 = new DoctorDao();	
		List<Doctor> list = doc1.getDoctor();
		Sorter sort1 = new Sorter();
		list = sort1.ordenarDoctores(list);
		rq.setAttribute("list", list);
		
		Sorter sort = new Sorter();
		DoctorDao doc = new DoctorDao();	
		PrintWriter p = rp.getWriter();
		List<Doctor> listD = doc.getDoctor();
		rq.setAttribute("list", sort.ordenarDoctores(listD));



		String auxd = (String)rq.getParameter("datepicker");
	
	
			String doctor =  rq.getParameter("Doc");
			p.println(doctor);
			List<Turno> ocupados = new ArrayList<Turno>();

			String [] date = auxd.split("/");
			String mes = date[0];
			String dia = date[1];
			String anio = date[2];
			String dateImp = imprimirFecha(dia, mes, anio);
			Date d =  DateUtils.getDate(Integer.parseInt(dia),Integer.parseInt(mes)-1, Integer.parseInt(anio) );


			if(doctor.equals("Todos") || doctor.equals("All") ){
				List<String[]> listaTurnosDoctores = new ArrayList<String[]>();
				for(int i = 0; i<listD.size(); i++){
					String[] aux = getTurnoComparados( getTurnoPorDoctor(d, listD.get(i).getNombre()+" "+listD.get(i).getApellido()));
					listaTurnosDoctores.add(aux);
					//	listaTurnosDoctores.add(null);
				}
				rq.setAttribute("fecha", dateImp);
				rq.setAttribute("turnosList", listaTurnosDoctores);
			}else{
				ocupados = getTurnoPorDoctor(d, doctor);
				String[] listT = getTurnoComparados( ocupados);
				rq.setAttribute("fecha", dateImp);
				rq.setAttribute("turnosList", listT);
			}



			rq.getRequestDispatcher("jsp/sacarTurno.jsp").forward(rq, rp);

		
		



	}

	public String imprimirFecha(String dia,String mes, String anio){
		return mes+"/"+dia+"/"+anio;
	}

	private String[] getTodoTurnos(){
		String headers[] = 

		{"8:00","8:30","9:00","9:30","10:00","10:30",
				"11:00","11:30","12:00","12:30","13:00","13:30","14:00","14:30"
				,"15:00","15:30","16:00","16:30","17:00","17:30","18:00","18:30","19:00","19:30","20:00"};
		return headers;
	}

	private List<Turno> getTurnoPorDoctor(Date d, String doc){
		TurnoDao tDao = new TurnoDao();		
		DoctorDao dDao = new DoctorDao();
		String[] stD = doc.split(" ");
		Doctor doctor = dDao.getDoctorbyNameAndApellido(stD[0], stD[1]);
		return tDao.getTurnoByDateAndDoctor(d, doctor.getId());
	}

	private String[] getTurnoComparados(List<Turno> ocupado){
		String headers[] = 

		{"8:00","8:30","9:00","9:30","10:00","10:30",
				"11:00","11:30","12:00","12:30","13:00","13:30","14:00","14:30"
				,"15:00","15:30","16:00","16:30","17:00","17:30","18:00","18:30","19:00","19:30","20:00"};
		for(int i = 0; i<ocupado.size(); i++){
			for(int k = 0; k<headers.length; k++){
				String ocupados = null;
				if(ocupado.get(i).getMinutos()!=0){
					ocupados= String.valueOf(ocupado.get(i).getHora())+":30";
				}else {
					ocupados= String.valueOf(ocupado.get(i).getHora())+":00";
				}
				if(headers[k].equals(ocupados)){
					headers[k]="";
				}
			}
		}

		return headers;

	}


}
