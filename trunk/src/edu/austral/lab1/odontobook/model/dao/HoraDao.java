package edu.austral.lab1.odontobook.model.dao;

import java.util.List;


import edu.austral.lab1.odontobook.model.HibernateUtil;
import edu.austral.lab1.odontobook.model.Hora;


public class HoraDao extends BaseDao{

    public List getPersonas(){
        return HibernateUtil.getSession().createCriteria(Hora.class).list();
    }

    public static List getAll(){
        return new HoraDao().getPersonas();
    }
}
