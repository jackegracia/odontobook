

package edu.austral.lab1.odontobook.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="TURNO")


public class Turno implements Serializable{
	
	private Fecha fecha;
	private Hora hora;
	private boolean asistido;
	private Paciente paciente;
	
	public Turno(Fecha fecha, Hora hora, Paciente paciente){
		this.fecha = fecha;
		this.hora = hora;
		this.paciente = paciente;
	}

	@Id
	@GeneratedValue
    @OneToOne(cascade = CascadeType.ALL)
	
	public Fecha getFecha() {
		return fecha;
	}

	public void setFecha(Fecha fecha) {
		this.fecha = fecha;
	}
	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
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

}
