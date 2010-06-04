package edu.austral.lab1.odontobook.controler;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import edu.austral.lab1.odontobook.graphicInterface.TabbedPane;
import edu.austral.lab1.odontobook.graphicInterface.GraphicInterface;
import edu.austral.lab1.odontobook.model.HibernateUtil;
import edu.austral.lab1.odontobook.model.dao.DoctorDao;



public class DeleteDoctorAction extends AbstractAction{


	private JDialog newDialog;
	private DoctorDao doc;
	private GraphicInterface gi;
	private Component frame;


	public DeleteDoctorAction(GraphicInterface gi){
		super("Dar de Bajar Doctor");
		putValue(SHORT_DESCRIPTION,"Borrar un doctor");
		doc=new DoctorDao();
		this.gi=gi;
	}

	public void DeleteDoctorAndTurns(String doctorName, String doctorSurname){

		Object[] options = {"Aceptar",
		"Cancelar"};
		int n = JOptionPane.showOptionDialog(frame,
				"Quiere borrar al doctor"+" "+doctorName+" "+doctorSurname+"?",
				"A Silly Question",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,     //do not use a custom Icon
				options,  //the titles of buttons
				options[0]); //default button title


		if (n==0){
			HibernateUtil.beginTransaction();
			doc.removeDoctorbyNameAndApellido(doctorName, doctorSurname);
		}else{

		}




	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		TabbedPane pane=gi.getDoctorTab();
		String name=(String) pane.getDoc().getSelectedValue();
		String[] nombreDoctor=name.split(" ");
		DeleteDoctorAndTurns(nombreDoctor[0], nombreDoctor[1]);        
		gi.getFrame().dispose();
		gi=new GraphicInterface();

	}

}
