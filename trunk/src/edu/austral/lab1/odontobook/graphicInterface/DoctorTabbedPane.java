package edu.austral.lab1.odontobook.graphicInterface;

import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import edu.austral.lab1.odontobook.model.Doctor;
import edu.austral.lab1.odontobook.model.HibernateUtil;
import edu.austral.lab1.odontobook.model.dao.DoctorDao;



public class DoctorTabbedPane extends JTabbedPane{
	private JPanel panel;
	private JPanel panel1;
	private JPanel panel2;
	private DoctorDao doctorDao;

	public DoctorTabbedPane (){
		HibernateUtil.beginTransaction();
		doctorDao =new DoctorDao();
		List doctores=doctorDao.getAll();
		System.out.print(doctores.isEmpty());
		if(!doctores.isEmpty()){

			for(int i=0;i<doctores.size();i++){
				JPanel panel=new JPanel();

				this.addTab(((Doctor) doctores.get(i)).getNombre()+" "+((Doctor) doctores.get(i)).getApellido(),panel);
				panel.add(new JLabel(String.valueOf(((Doctor) doctores.get(i)).getDni())));
			}
		}
		this.repaint();

	}
}

