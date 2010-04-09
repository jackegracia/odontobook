package edu.austral.lab1.odontobook.model;

import java.util.ArrayList;

public class Consultorio {
	
	private ArrayList<Paciente> pacientes;
	private ArrayList<Doctor> doctores;
	private String nombreConsultorio;
	
	public Consultorio(String nombreConsultorio){
		
		pacientes = new ArrayList<Paciente>();
		doctores = new ArrayList<Doctor>();
		this.nombreConsultorio = nombreConsultorio;
	
	}
	
	public void agregarPaciente(Paciente p){
		pacientes.add(p);
	}
	
	public void agregarDoctor(Doctor d){
		doctores.add(d);
	}
	
	
	//me devuelve la lista de pacientes cn el mismo nombre y apellido
	public ArrayList<Paciente> encontrarPacientes(String nombre, String apellido){
		ArrayList<Paciente> p = new ArrayList<Paciente>();
		int size = pacientes.size();
		
		for(int i = 0; i < size; i++){
			Paciente aux = pacientes.get(i);
			if(aux.getApellido().equals(apellido) && aux.getNombre().equals(nombre)){
				p.add(aux);
			}
		}
		return p;
	}
	
	

	public void modificarPaciente(){}
}
