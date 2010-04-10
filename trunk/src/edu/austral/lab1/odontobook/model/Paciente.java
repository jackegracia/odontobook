package edu.austral.lab1.odontobook.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="PACIENTE")



public class Paciente {
	private String nombre;
	private String direccion;
	private String obraSocial;
	private int edad;
	private Histograma histograma;
	private Odontograma odontograma;
	private String apellido;
	private int telefono;
	private int dni;

	
	public Paciente(String nombre,String apellido, int dni, int telefono,
			String direccion,String obraSocial,int edad){
		
	this.nombre = nombre;
	this.direccion = direccion;
	this.obraSocial = obraSocial;
	this.edad = edad;
	this.apellido = apellido;
	this.telefono = telefono;
	this.dni = dni;

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

	

    @OneToOne(cascade = CascadeType.ALL)
	public Histograma getHistograma() {
		return histograma;
	}

	public void setHistograma(Histograma histograma) {
		this.histograma = histograma;
	}
	/*
    @OneToOne(cascade = CascadeType.ALL)
	public Odontograma getOdontograma() {
		return odontograma;
	}

	public void setOdontograma(Odontograma odontograma) {
		this.odontograma = odontograma;
	}
*/
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	@Id
	@GeneratedValue
	@Column(name="DOCTOR_ID")
	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}


	
	
}
