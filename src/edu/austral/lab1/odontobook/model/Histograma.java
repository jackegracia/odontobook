package edu.austral.lab1.odontobook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="HISTOGRAMA")
public class Histograma {
private int dientes;
private char[] cara;
private String tratamiento;

public Histograma(int dientes,char[] cara,String tratamiento){
	this.dientes=dientes;
	this.cara=cara;
	this.tratamiento=tratamiento;
}
@Id
@GeneratedValue
@Column(name="DIENTES_ID")
public int getDientes() {
	return dientes;
}

public void setDientes(int dientes) {
	this.dientes = dientes;
}

public char[] getCara() {
	return cara;
}

public void setCara(char[] cara) {
	this.cara = cara;
}

public String getTratamiento() {
	return tratamiento;
}

public void setTratamiento(String tratamiento) {
	this.tratamiento = tratamiento;
}
}
