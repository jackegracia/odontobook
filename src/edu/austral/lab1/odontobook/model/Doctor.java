package edu.austral.lab1.odontobook.model;

public class Doctor {

	private String nombre;
	private String matricula;
	private int edad;

	public Doctor(String nombre,String matricula,int edad){
		this.nombre=nombre;
		this.matricula=matricula;
		this.edad=edad;
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
	
}
