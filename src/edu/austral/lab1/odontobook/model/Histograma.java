package edu.austral.lab1.odontobook.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="HISTOGRAMA")
public class Histograma {
	private int dientes;
	private String cara;
	private String tratamiento;
	private long id;
	private Paciente paciente;

	public Histograma(){

	}

	public Histograma(int dientes,String cara,String tratamiento,Paciente paciente){
		this.dientes=dientes;
		this.cara=cara;
		this.tratamiento=tratamiento;
		this.paciente=paciente;
	}

	public int getDientes() {
		return dientes;
	}

	public void setDientes(int dientes) {
		this.dientes = dientes;
	}

	public String getCara() {
		return cara;
	}

	public void setCara(String cara) {
		this.cara = cara;
	}

	public String getTratamiento() {
		return tratamiento;
	}

	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}

	@Id
	@GeneratedValue
	
	public long getId() {


		return id;

	}

	public void setId(long id) {

		this.id=id;


	}


}
