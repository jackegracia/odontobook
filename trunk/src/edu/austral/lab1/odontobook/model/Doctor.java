package edu.austral.lab1.odontobook.model;

import java.util.ArrayList;

public class Doctor {

	private String nombre;
	private String matricula;
	private int edad;
	private String direccion;
	private int telefono;
	private String apellido;
	private int dni;
	private ArrayList<Paciente> pacientes;
	
	public Doctor(String nombre, String apellido,String matricula,int edad, int telefono,
			int dni, String direccion){
		this.nombre = nombre;
		this.matricula = matricula;
		this.edad = edad;
		this.apellido = apellido;
		this.direccion = direccion;
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public ArrayList<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(ArrayList<Paciente> pacientes) {
		this.pacientes = pacientes;
	}
	
}
