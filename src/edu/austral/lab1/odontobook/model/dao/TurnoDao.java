package edu.austral.lab1.odontobook.model.dao;

import java.util.List;

import org.hibernate.SQLQuery;


import edu.austral.lab1.odontobook.model.HibernateUtil;
import edu.austral.lab1.odontobook.model.Turno;

public class TurnoDao extends BaseDao{

	
	
	
    public List getPersonas(){
        return HibernateUtil.getSession().createCriteria(Turno.class).list();
    }

    public static List getAll(){
        return new TurnoDao().getPersonas();
    }
}
