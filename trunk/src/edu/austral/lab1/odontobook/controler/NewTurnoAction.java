package edu.austral.lab1.odontobook.controler;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.Date;

import javax.swing.AbstractAction;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import edu.austral.lab1.odontobook.graphicInterface.DoctorTabbedPane;
import edu.austral.lab1.odontobook.model.Consultorio;

public class NewTurnoAction extends AbstractAction {

	private static final JTextArea[] JTextArea = null;
	private Frame frame;
	private JDialog nuevoDialogo;
	private DoctorTabbedPane pane;
	private Date date;
	private JTextArea[] are;

	public  NewTurnoAction (DoctorTabbedPane pane,Date date){
		super("Turnos");
		putValue(SHORT_DESCRIPTION,"Agrega un Paciente");
		this.pane=pane;
		this.date=date;

	}

	public void createTurno(){

		nuevoDialogo = new JDialog(frame,"Nuevo Turno" ,true);
		String doctor= pane.getSelectedComponent().getName();
		GridLayout layout = new GridLayout(26,2);
		nuevoDialogo.getContentPane().setLayout(layout);

		are=new JTextArea[26];

		

		for(int i=0;i<13;i++){
			nuevoDialogo.add(new JLabel(String.valueOf(i+8)));
			
		
			nuevoDialogo.add(new JLabel(String.valueOf(i+8)+":30"));
			nuevoDialogo.add(are[i+1]=new JTextArea());
		}

		nuevoDialogo.setSize(300, 600);
		nuevoDialogo.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		nuevoDialogo.setVisible(true);

	}


	public void actionPerformed(ActionEvent arg0) {
		createTurno();

	} 
}
