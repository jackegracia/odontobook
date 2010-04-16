

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
	
	private Fecha fecha;
	private Hora hora;
	private boolean asistido;
	private Paciente paciente;
	private Doctor doctor;
	private long codigo;
	
	public Turno(Fecha fecha, Hora hora, Paciente paciente){
		this.fecha = fecha;
		this.hora = hora;
		this.paciente = paciente;
	}


	
	public Fecha getFecha() {
		return fecha;
	}

	public void setFecha(Fecha fecha) {
		this.fecha = fecha;
	}
	
//	@OneToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	public Hora getHora() {
		return hora;
	}

	public void setHora(Hora hora) {
		this.hora = hora;
	}

	public boolean isAsistido() {
		return asistido;
	}

	public void setAsistido(boolean asistido) {
		this.asistido = asistido;
	}
	
	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
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
