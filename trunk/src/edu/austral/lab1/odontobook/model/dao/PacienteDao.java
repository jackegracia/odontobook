package edu.austral.lab1.odontobook.model.dao;

import java.util.List;


import edu.austral.lab1.odontobook.model.HibernateUtil;
import edu.austral.lab1.odontobook.model.Paciente;


public class PacienteDao extends BaseDao{

    public List getPersonas(){
        return HibernateUtil.getSession().createCriteria(Paciente.class).list();
    }

    public static List getAll(){
        return new PacienteDao().getPersonas();
    }
}
