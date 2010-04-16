

package edu.austral.lab1.odontobook.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TURNO")


public class Turno implements Serializable{
	
	private boolean asistido;
	//private Paciente paciente;
	//private Doctor doctor;
	private long codigo;
	
	public Turno( ){
		
		//this.paciente = paciente;
	}


	
	

	public boolean isAsistido() {
		return asistido;
	}

	public void setAsistido(boolean asistido) {
		this.asistido = asistido;
	}
	
	/*public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}*/
	
	@Id
	@GeneratedValue
//    @OneToOne(cascade = CascadeType.ALL)

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

}
