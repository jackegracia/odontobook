package edu.austral.lab1.odontobook.model.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import edu.austral.lab1.odontobook.model.HibernateUtil;
import edu.austral.lab1.odontobook.model.Turno;

public class TurnoDao extends BaseDao{


	private List<Turno> turnos;

	public List<Turno> getTurnoByDate(Date date){
		try{
			Query query = HibernateUtil.getSession().createQuery(
					"from Turno as turn where turn.fecha = ? ")
					.setDate(0, date);
			turnos = (List) query.list();
		}catch(org.hibernate.QueryException e)
		{
			e.printStackTrace();
			return new ArrayList();
		}
		
		return turnos;

	}

	public List<Turno> getTurnoByPaciente(long paciente_id){
		try{
			Query query = HibernateUtil.getSession().createQuery(
					"from Turno as turn where turn.paciente = ?")
					.setLong(0, paciente_id);
			turnos = (List) query.list();
		}catch(org.hibernate.QueryException e)
		{
			e.printStackTrace();
			return new ArrayList();
		}
		return turnos;

	}
	
	public void removeTurno(Long pacienteId,Date date,int hora,int minutos){

		List<Turno> turnos= getTurnoByDateAndPaciente(date,pacienteId);
		for(int i=0;i<turnos.size();i++){
			if((((Turno) turnos.get(i)).getHora()==hora)||(((Turno) turnos.get(i)).getMinutos()==minutos)){
				HibernateUtil.getSession().delete(turnos.get(i));
				HibernateUtil.commitTransaction();
			}
		}
		
		
	}


	public List<Turno> getTurnoByDateAndPaciente(Date date, long paciente_id){
		try{
			Query query = HibernateUtil.getSession().createQuery(
					"from Turno as turn where turn.fecha = ? and turn.paciente = ?")
					.setDate(0, date).setLong(1, paciente_id);
			turnos = (List) query.list();
		}catch(org.hibernate.QueryException e)
		{
			e.printStackTrace();
			return new ArrayList();
		}
		
		return turnos;

	}
	
	public List<Turno> getTurnoByDoctor(long doctor_id){
		try{
			Query query = HibernateUtil.getSession().createQuery(
					"from Turno as turn where turn.doctor = ?")
					.setLong(0, doctor_id);
			turnos = (List) query.list();
		}catch(org.hibernate.QueryException e)
		{
			e.printStackTrace();
			return new ArrayList();
		}
		return turnos;

	}
	
	public List<Turno> getTurnoByDateAndDoctor(Date date, long doctor_id){
		try{
			Query query = HibernateUtil.getSession().createQuery(
			"from Turno as turn where turn.fecha = ? and turn.doctor = ?")
			.setDate(0, date).setLong(1, doctor_id);
			turnos = (List) query.list();
		}catch(org.hibernate.QueryException e)
		{
			e.printStackTrace();
			return new ArrayList();
		}

		return turnos;

	}

	public List getPersonas(){
		return HibernateUtil.getSession().createCriteria(Turno.class).list();
	}

	public static List getAll(){
		return new TurnoDao().getPersonas();
	}


}
