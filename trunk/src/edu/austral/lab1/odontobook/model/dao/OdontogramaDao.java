package edu.austral.lab1.odontobook.model.dao;

import java.util.List;


import edu.austral.lab1.odontobook.model.HibernateUtil;
import edu.austral.lab1.odontobook.model.Odontograma;


public class OdontogramaDao extends BaseDao{

    public List getPersonas(){
        return HibernateUtil.getSession().createCriteria(Odontograma.class).list();
    }

    public static List getAll(){
        return new OdontogramaDao().getPersonas();
    }
}
