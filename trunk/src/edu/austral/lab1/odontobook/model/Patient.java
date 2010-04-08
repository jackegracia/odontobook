package edu.austral.lab1.odontobook.model;

public class Patient {
	private String nombre;
	private String direccion;
	private String obraSocial;
	private int edad;
	private Histograma histograma;
	private Odontograma odontograma;

	public Patient(String nombre,String direccion,String obraSocial,int edad,Histograma histograma,Odontograma odontograma){
	this.nombre=nombre;
	this.direccion=direccion;
	this.obraSocial=obraSocial;
	this.edad=edad;
	this.histograma=histograma;
	this.odontograma=odontograma;

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getObraSocial() {
		return obraSocial;
	}

	public void setObraSocial(String obraSocial) {
		this.obraSocial = obraSocial;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Histograma getHistograma() {
		return histograma;
	}

	public void setHistograma(Histograma histograma) {
		this.histograma = histograma;
	}

	public Odontograma getOdontograma() {
		return odontograma;
	}

	public void setOdontograma(Odontograma odontograma) {
		this.odontograma = odontograma;
	}
}
