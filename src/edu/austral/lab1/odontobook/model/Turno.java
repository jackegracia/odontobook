

package edu.austral.lab1.odontobook.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table(name="TURNO")

public class Turno implements Serializable{
	
	private Date fecha;
	private boolean asistido;
	private Paciente paciente;
	private Doctor doctor;
	private long id;
	private int hora;
	private int minutos;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="DOC_ID") 
	public Doctor getDoctor() {
		return doctor;
	}


	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Turno(){
		
	}
	
	public Turno(Paciente paciente, Doctor doctor,Date date){
		this.doctor=doctor;
		this.paciente = paciente;
		this.fecha=date;
		
	}


	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}
	
	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}
	
	

	public boolean isAsistido() {
		return asistido;
	}

	public void setAsistido(boolean asistido) {
		this.asistido = asistido;
	}
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="PACIENTE_ID") 
	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	@Id
	@GeneratedValue
//    @OneToOne(cascade = CascadeType.ALL)

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	public String toString(){
		String date=fecha.toString();
		String[] splitDate=date.split("-");	
		String año=splitDate[0];		
		String mes=splitDate[1]; 
		String[] dia=splitDate[2].split(" ");
		
		if(minutos==0){
			return dia[0]+" "+mes+" "+año+" "+String.valueOf(hora)+":"+"00";
		}
		
		else return dia[0]+" "+mes+" "+año+" "+String.valueOf(hora)+":"+String.valueOf(minutos);
	}

}
