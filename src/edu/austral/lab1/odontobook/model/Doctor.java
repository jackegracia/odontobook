package edu.austral.lab1.odontobook.model;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;



@Entity
@Table(name="DOCTOR")


public class Doctor {

	private String nombre;
	private int matricula;
	private int edad;
	private String direccion;
	private int telefono;
	private String apellido;
	private int dni;
	private Frame frame;
	//private Agenda agenda;
	private JDialog nuevoDialogo;
	
	/*public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}*/

	public Doctor(String nombre, String apellido,int matricula,int edad, int telefono,
			int dni, String direccion){
		
		this.nombre = nombre;
		this.matricula = matricula;
		this.edad = edad;
		this.apellido = apellido;
		this.direccion = direccion;
		this.dni = dni;
		HibernateUtil.beginTransaction();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
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
