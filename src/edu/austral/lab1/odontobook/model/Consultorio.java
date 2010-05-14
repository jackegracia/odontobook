package edu.austral.lab1.odontobook.model;

import java.util.ArrayList;
import java.util.List;

import edu.austral.lab1.odontobook.model.dao.DoctorDao;
import edu.austral.lab1.odontobook.model.dao.PacienteDao;

public class Consultorio {
	
	private ArrayList<String> pacientes;
	private ArrayList<String> doctores;
	private String nombreConsultorio;
	
	public Consultorio(String nombreConsultorio){
		
		pacientes = encontrarPacientes();
		doctores = encontrarDoctores();
		this.nombreConsultorio = nombreConsultorio;
	
	}
	
	public ArrayList<String> getDoctores() {
		return doctores;
	}

	public void setDoctores(ArrayList<String> doctores) {
		this.doctores = doctores;
	}

	public ArrayList<String> getPacientes() {
		return pacientes;
	}

	public void setPacientes(ArrayList<String> pacientes) {
		this.pacientes = pacientes;
	}

	public void agregarPaciente(String p){
		pacientes.add(p);
	}
	
	public void agregarDoctores(String p){
		doctores.add(p);
	}

	
	//me devuelve la lista de pacientes cn el mismo nombre y apellido
	public ArrayList<String> encontrarPacientes(){
		ArrayList<String> p = new ArrayList<String>();
		PacienteDao paciente=new PacienteDao();
		List pacientes=paciente.getAll();
		for(int i = 0; i < pacientes.size(); i++){
			Paciente paci=(Paciente) pacientes.get(i);
			
			p.add(paci.getNombre()+" "+paci.getApellido());
			
		}
		return p;
	}
	
	
	public ArrayList<String> encontrarDoctores(){
		ArrayList<String> p = new ArrayList<String>();
		DoctorDao doctor=new DoctorDao();
		List doctores=doctor.getAll();
		for(int i = 0; i < doctores.size(); i++){
			Doctor doc=(Doctor) doctores.get(i);
			
			p.add(doc.getNombre()+" "+doc.getApellido());
			
		}
		return p;
	}
	
	
	
	
	

	public void modificarPaciente(){}
}
