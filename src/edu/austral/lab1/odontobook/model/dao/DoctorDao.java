package edu.austral.lab1.odontobook.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SQLQuery;



import edu.austral.lab1.odontobook.model.Doctor;
import edu.austral.lab1.odontobook.model.HibernateUtil;

public class DoctorDao extends BaseDao{

	
	

    public List getPaises(){
        String   query = "select {pais.*} " + "from PAIS {pais}";
        SQLQuery sqlQuery = HibernateUtil.getSession().createSQLQuery(query);
        sqlQuery.addEntity("DOCTOR", Doctor.class);
        return sqlQuery.list();
    }

    public Doctor getPais(Serializable id){

        return (Doctor)HibernateUtil.getSession().get(Doctor.class, id);

    }

    public static List getAll(){
        return new DoctorDao().getPaises();
    }
}
