package edu.austral.lab1.odontobook.test;

import edu.austral.lab1.odontobook.model.HibernateUtil;
import edu.austral.lab1.odontobook.web.Logout;

/**
 * Date: 29/11/2005
 * Time: 22:59:25
 */
public class RecreateSchema {
    public static void main(String[] args) {

        HibernateUtil.createSchema();
    }
}
