package edu.austral.lab1.odontobook.model.dao;

import java.util.List;


import edu.austral.lab1.odontobook.model.Fecha;
import edu.austral.lab1.odontobook.model.HibernateUtil;
import edu.austral.lab1.odontobook.model.Hora;


public class FechaDao extends BaseDao{

    public List getPersonas(){
        return HibernateUtil.getSession().createCriteria(Fecha.class).list();
    }

    public static List getAll(){
        return new FechaDao().getPersonas();
    }
}
