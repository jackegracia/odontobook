package edu.austral.lab1.odontobook.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SQLQuery;


import edu.austral.lab1.odontobook.model.Doctor;
import edu.austral.lab1.odontobook.model.HibernateUtil;
import edu.austral.lab1.odontobook.model.Paciente;
import edu.austral.lab1.odontobook.model.Usuario;


public class PacienteDao extends BaseDao{

   

	public Paciente getPacientebyName(String name){
		Paciente Paciente =  (Paciente) HibernateUtil.getSession().createQuery(
		"from Paciente as pac where pac.nombre = ?")
		.setString(0, name)
		.uniqueResult();
		return Paciente;
		
	}
	
	
	
	public Paciente getPacientebyDNI(int dni){
		Paciente Paciente =  (Paciente) HibernateUtil.getSession().createQuery(
		"from Paciente as pac where pac.dni = ?")
		.setInteger(0, dni)
		.uniqueResult();
		return Paciente;
		
	}

	public Paciente getPacienteByUserID(long id){
		Paciente Paciente =  (Paciente) HibernateUtil.getSession().createQuery(
		"from Paciente as pac where pac.usuario = ?")
		.setLong(0, id)
		.uniqueResult();
		return Paciente;
	}
	
	
	
    public List getPaciente(){
        return HibernateUtil.getSession().createCriteria(Paciente.class).list();
    }

    public static List getAll(){
        return new PacienteDao().getPaciente();
    }
}
