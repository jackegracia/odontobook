package edu.austral.lab1.odontobook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Hora {

	private int hora;
	private int minutos;
	
	public Hora(int hora, int minutos){
		this.hora = hora;
		this.minutos = minutos;
	}

	@Id
	@GeneratedValue
	@Column(name="HORA_ID")
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
	
}
