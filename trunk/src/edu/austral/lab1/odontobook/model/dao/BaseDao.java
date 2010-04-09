package edu.austral.lab1.odontobook.model.dao;


import org.hibernate.HibernateException;

import edu.austral.lab1.odontobook.model.HibernateUtil;
import edu.austral.lab1.odontobook.model.InfrastructureException;

/**
 * Date: 30/11/2005
 * Time: 21:30:28
 */
public class BaseDao
{

    //~ Constructors .........................................................................................

    public BaseDao()
    {
        HibernateUtil.beginTransaction();
    }

    //~ Methods ..............................................................................................

    public Object makePersistent(Object pojo)
        throws InfrastructureException
    {
        try {
            HibernateUtil.getSession().saveOrUpdate(pojo);
            return pojo;
        }
        catch (HibernateException ex) {
            throw new InfrastructureException(ex);
        }
    }
}
