package edu.austral.lab1.odontobook.util;

import java.util.ArrayList;
import java.util.List;

import edu.austral.lab1.odontobook.model.Doctor;
import edu.austral.lab1.odontobook.model.Turno;

public class Sorter {

	public Sorter(){}
	
	public List<Doctor> ordenarDoctores(List<Doctor> lista){

		int n = lista.size();
		int minimo = 0;
		for(int i = 0;i< n-1; i++){
			minimo = i;
			for(int j = i+1; j<n; j++){
				if(!lista.get(j).esMayor(lista.get(minimo))){
					minimo = j;
				}
			}
			if(i != minimo){
				Doctor d = lista.get(i);
				lista.set(i, lista.get(minimo));
				lista.set(minimo, d);
			}
			
		}
		return lista;
	}
	
	
	public List<Turno> ordenarTurnos(List<Turno> lista){

		int n = lista.size();
		int minimo = 0;
		for(int i = 0;i< n-1; i++){
			minimo = i;
			for(int j = i+1; j<n; j++){
				if(!lista.get(j).esMayorPorDoctor(lista.get(minimo))){
					minimo = j;
				}
			}
			if(i != minimo){
				Turno t = lista.get(i);
				lista.set(i, lista.get(minimo));
				lista.set(minimo, t);
			}
			
		}
		return lista;
	}
	
	public List<Turno> ordenarTurnosPorPaciente(List<Turno> lista){

		int n = lista.size();
		int minimo = 0;
		for(int i = 0;i< n-1; i++){
			minimo = i;
			for(int j = i+1; j<n; j++){
				if(!lista.get(j).esMayorPorPaciente(lista.get(minimo))){
					minimo = j;
				}
			}
			if(i != minimo){
				Turno t = lista.get(i);
				lista.set(i, lista.get(minimo));
				lista.set(minimo, t);
			}
			
		}
		return lista;
	}
	
	
}
