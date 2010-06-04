package edu.austral.lab1.odontobook.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SQLQuery;

import org.hibernate.sql.Delete;


import edu.austral.lab1.odontobook.model.Doctor;
import edu.austral.lab1.odontobook.model.HibernateUtil;
import edu.austral.lab1.odontobook.model.Histograma;

public class DoctorDao extends BaseDao{

	public Doctor getDoctorbyNameAndApellido(String name, String apellido){
		Doctor doctor = (Doctor) HibernateUtil.getSession().createQuery(
		"from Doctor as doc where doc.nombre = ? and doc.apellido = ?")
		.setString(0, name).setString(1, apellido)
		.uniqueResult();
		return doctor;
		
	}
	
	public Doctor getDoctorbyDNI(int dni){
		Doctor doctor = (Doctor) HibernateUtil.getSession().createQuery(
		"from Doctor as doc where doc.dni = ?")
		.setInteger(0, dni)
		.uniqueResult();
		return doctor;
		
	}
	
	public void removeDoctorbyNameAndApellido(String name, String apellido){
		Doctor doctor = getDoctorbyNameAndApellido(name, apellido);
		System.out.println(doctor.getNombre()+doctor.getApellido());
		HibernateUtil.getSession().delete(doctor);
		HibernateUtil.commitTransaction();
	}
	
    public List getDoctor(){
        return HibernateUtil.getSession().createCriteria(Doctor.class).list();
    }

    public static List getAll(){
        return new DoctorDao().getDoctor();
    }
}
