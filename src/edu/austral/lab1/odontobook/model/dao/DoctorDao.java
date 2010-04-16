package edu.austral.lab1.odontobook.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SQLQuery;



import edu.austral.lab1.odontobook.model.Doctor;
import edu.austral.lab1.odontobook.model.HibernateUtil;
import edu.austral.lab1.odontobook.model.Histograma;

public class DoctorDao extends BaseDao{

	
	

    public List getDoctor(){
        return HibernateUtil.getSession().createCriteria(Doctor.class).list();
    }

    public static List getAll(){
        return new DoctorDao().getDoctor();
    }
}
