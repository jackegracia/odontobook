package edu.austral.lab1.odontobook.web;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USUARIO")
public class Usuario {
	
	private String username;
	private long password;
	private long id;
	
	public Usuario(){
		
	}

	public Usuario(String username, long password){
		this.username = username;
		this.password = password;
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

	public long getPassword() {
		return password;
	}

	public void setPassword(long password) {
		this.password = password;
	}
}
