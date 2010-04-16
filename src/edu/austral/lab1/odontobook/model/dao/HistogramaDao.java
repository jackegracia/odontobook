package edu.austral.lab1.odontobook.model.dao;

import java.util.List;



import edu.austral.lab1.odontobook.model.HibernateUtil;
import edu.austral.lab1.odontobook.model.Histograma;



public class HistogramaDao extends BaseDao{

    public List getPersonas(){
        return HibernateUtil.getSession().createCriteria(Histograma.class).list();
    }

    public static List getAll(){
        return new HistogramaDao().getPersonas();
    }
}
