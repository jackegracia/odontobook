package edu.austral.lab1.odontobook.model.dao;

import java.util.List;

import edu.austral.lab1.odontobook.model.Doctor;
import edu.austral.lab1.odontobook.model.HibernateUtil;

public class DoctorDao extends BaseDao{

    public List getPersonas(){
        return HibernateUtil.getSession().createCriteria(Doctor.class).list();
    }

    public static List getAll(){
        return new DoctorDao().getPersonas();
    }
}
