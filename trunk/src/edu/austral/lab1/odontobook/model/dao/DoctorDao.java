package edu.austral.lab1.odontobook.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SQLQuery;

import org.hibernate.sql.Delete;


import edu.austral.lab1.odontobook.model.Doctor;
import edu.austral.lab1.odontobook.model.HibernateUtil;
import edu.austral.lab1.odontobook.model.Histograma;

public class DoctorDao extends BaseDao{

	public Doctor getDoctorbyName(String name){
		Doctor doctor = (Doctor) HibernateUtil.getSession().createQuery(
		"from Doctor as doc where doc.nombre = ?")
		.setString(0, name)
		.uniqueResult();
		return doctor;
		
	}
	
	public void removeDoctorbyName(String name){
		Doctor doctor = getDoctorbyName(name);
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
