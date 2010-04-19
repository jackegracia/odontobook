package edu.austral.lab1.odontobook.graphicInterface;

import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import edu.austral.lab1.odontobook.model.Doctor;
import edu.austral.lab1.odontobook.model.dao.DoctorDao;



public class DoctorTabbedPane extends JTabbedPane{
	private JPanel panel;
	private JPanel panel1;
	private JPanel panel2;
	private DoctorDao doctorDao;

	public DoctorTabbedPane (){
		doctorDao =new DoctorDao();
		List doctores=doctorDao.getAll();
		if(doctores.isEmpty()){
		}else{
			for(int i=0;i<doctores.size();i++){
				this.addTab(((Doctor) doctores.get(i)).getNombre()+" "+((Doctor) doctores.get(i)).getApellido(), new JPanel().add(new JLabel("UNO")));
			}



		}
		panel1=new JPanel();
		panel2=new JPanel();
		this.addTab("sda", panel1);
		panel1.add(new JLabel("DOS"));

		this.addTab("sda", panel2);
		panel2.add(new JLabel("TRES"));

	}
}

