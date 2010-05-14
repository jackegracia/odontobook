package edu.austral.lab1.odontobook.test;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;

import edu.austral.lab1.odontobook.model.Doctor;
import edu.austral.lab1.odontobook.model.HibernateUtil;
import edu.austral.lab1.odontobook.model.dao.DoctorDao;

public class DoctorDAOTest {
	
	@Test
	public void test_DoctorCreation()
	{
		/*Doctor d = new Doctor("b", "z", 0, 0, 0, 8, "a","a","a");
		DoctorDao doctorDAO = new DoctorDao();
		
		
		Doctor persistedDoctor = (Doctor) doctorDAO.makePersistent(d);   
		Doctor d2 = new Doctor("b2", "zz2", 0, 0, 0, 8, "a");*/
	/*	doctorDAO.makePersistent(d2);
	
		HibernateUtil.commitTransaction();
        assertTrue(persistedDoctor.getApellido() == d.getApellido());	*/
	}
	
	@Test
	public void testDoctorExist(){
		DoctorDao doctorDAO = new DoctorDao();
		Doctor doc=	doctorDAO.getDoctorbyName("a");
		
		assertNotNull(doc);
		
	}
	
	@Test
	public void testDoctorDelete(){
		DoctorDao doctorDAO = new DoctorDao();
	
		doctorDAO.removeDoctorbyName("a");
		Doctor doc=	doctorDAO.getDoctorbyName("a");
		assertNull(doc);
		
	}
	
	@AfterClass
	public static void closeSession() {
		HibernateUtil.closeSession();
	}
	
	
	public void rollback() {
		HibernateUtil.rollbackTransaction();
	}

}
