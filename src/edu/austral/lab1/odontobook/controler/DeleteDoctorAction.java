package edu.austral.lab1.odontobook.controler;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.hibernate.Session;

import edu.austral.lab1.odontobook.model.Doctor;
import edu.austral.lab1.odontobook.model.HibernateUtil;
import edu.austral.lab1.odontobook.model.dao.DoctorDao;



public class DeleteDoctorAction extends AbstractAction{

	
	
	private Doctor doctor;
	private JDialog newDialog;
	private DoctorDao doc;
	

	public DeleteDoctorAction(){
		super("Dar de Bajar Doctor");
		putValue(SHORT_DESCRIPTION,"Borrar un doctor");
	 doc=new DoctorDao();
	}
	
	public void DeleteDoctorAndTurns(){
		newDialog = new JDialog(new JFrame(),"Borrar Doctor",true);
		JLabel newLavel = new JLabel("Nombre del Doctor a Borrar ");
		final JTextField newName = new JTextField("");
		JButton okButton = new JButton("Aceptar");
		GridBagLayout layout = new GridBagLayout();
		newName.setPreferredSize(new Dimension(280, 25));
	
		newDialog.getContentPane().setLayout(layout);
		newDialog.getContentPane().add(newLavel);
		newDialog.getContentPane().add(newName);
		newDialog.getContentPane().add(okButton);

		okButton.addActionListener(new ActionListener(){


			public void actionPerformed(ActionEvent e) {
				if(!newName.getText().equals("")){
					newDialog.dispose();	
				}
			}
		});

		newDialog.setSize(700, 150);
		newDialog.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		newDialog.setVisible(true);
		HibernateUtil.beginTransaction();
		doc.removeDoctorbyName(newName.getText());
		System.out.println(newName.getText());
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		DeleteDoctorAndTurns();        
		
			
	}

}
