package edu.austral.lab1.odontobook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Usuario {
	
	private String username;
	private String password;
	private long id;
	private boolean esDoctor;
	private int dni;

	public Usuario(){}
	
	public Usuario(String username, String password,boolean esDoctor, int dni){
		this.username = username;
		this.password = password;
		this.esDoctor=esDoctor;
		this.dni = dni;
	}
	
	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public boolean isEsDoctor() {
		return esDoctor;
	}

	public void setEsDoctor(boolean esDoctor) {
		this.esDoctor = esDoctor;
	}

	public String getUsername() {
		return username;
	}
	@Id @GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
