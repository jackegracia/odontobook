package edu.austral.lab1.odontobook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


public class Fecha {

	private int dia;
	private int mes;
	private int anio;
	
	public Fecha(int dia, int mes, int anio){
		this.anio = anio;
		this.mes = mes;
		this.dia = dia;
	}


	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}
	
}
