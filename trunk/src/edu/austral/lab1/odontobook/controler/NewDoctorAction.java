package edu.austral.lab1.odontobook.controler;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import edu.austral.lab1.odontobook.graphicInterface.DoctorTabbedPane;
import edu.austral.lab1.odontobook.model.Consultorio;
import edu.austral.lab1.odontobook.model.Doctor;
import edu.austral.lab1.odontobook.model.HibernateUtil;
import edu.austral.lab1.odontobook.model.dao.BaseDao;
import edu.austral.lab1.odontobook.model.dao.DoctorDao;

public class NewDoctorAction extends AbstractAction {
	
	private JDialog nuevoDialogo;
	private Frame frame;
	private Consultorio consultorio;
	
	
	
	public NewDoctorAction(Consultorio consultorio){
		super("Doctor");
		putValue(SHORT_DESCRIPTION,"Agrega un Doctor");
		this.consultorio=consultorio;
		
	}
	
	
	public Doctor crearDialogo() {
		nuevoDialogo = new JDialog(frame,"Nuevo Doctor" ,true);
		JLabel nombre= new JLabel("Nombre");
		JLabel apellido= new JLabel("Apellido");
		JLabel edad= new JLabel("edad");
		JLabel direccion= new JLabel("Direccion");
		JLabel matricula= new JLabel("Matricula");
		JLabel dni= new JLabel("Dni");
		JLabel telefono= new JLabel("Telefono");

		final JTextField jNombre = new JTextField("");
		final JTextField jApellido = new JTextField("");
		final JTextField jEdad = new JTextField("");
		final JTextField JDireccion = new JTextField("");
		final JTextField jMatricula = new JTextField("");
		final JTextField jDni = new JTextField("");
		final JTextField jTelefono = new JTextField("");

		JButton aceptar = new JButton("Aceptar");
		JButton cancelar = new JButton("Cancelar");
		GridLayout layout = new GridLayout(8,4);
		jNombre.setPreferredSize(new Dimension(280, 25));
		
		//Seteo los componentes a la Ventana.
		nuevoDialogo.getContentPane().setLayout(layout);
		
		nuevoDialogo.getContentPane().add(nombre);
		nuevoDialogo.getContentPane().add(jNombre);

		nuevoDialogo.getContentPane().add(apellido);
		nuevoDialogo.getContentPane().add(jApellido);

		nuevoDialogo.getContentPane().add(edad);
		nuevoDialogo.getContentPane().add(jEdad);

		nuevoDialogo.getContentPane().add(direccion);
		nuevoDialogo.getContentPane().add(JDireccion);

		nuevoDialogo.getContentPane().add(matricula);
		nuevoDialogo.getContentPane().add(jMatricula);

		nuevoDialogo.getContentPane().add(dni);
		nuevoDialogo.getContentPane().add(jDni);

		nuevoDialogo.getContentPane().add(telefono);
		nuevoDialogo.getContentPane().add(jTelefono);

		nuevoDialogo.getContentPane().add(aceptar);
		nuevoDialogo.getContentPane().add(cancelar);
		//SETEO EL EVENTO DEL JTextField


		//SETEO EL EVENTO DEL BOTON
		aceptar.addActionListener(new ActionListener(){


			public void actionPerformed(ActionEvent e) {
				if(!jNombre.getText().equals("")||!jApellido.getText().equals("")||!jEdad.getText().equals("")||
						!JDireccion.getText().equals("")||!jMatricula.getText().equals("")||!jDni.getText().equals("")||
						!jTelefono.getText().equals("")){
					nuevoDialogo.dispose();	
				}
			}
		});

		cancelar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){


			}
		});

		//Cambio el tamaño de la ventana.
		nuevoDialogo.setSize(300, 300);
		//Desactivo la "X" de la ventana para que al clickearla no haga nada.
		nuevoDialogo.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		//NOTA: Siempre el mostrar va al final de todo, muchas funciones no funcionan si se ponen despues de este metodo.
		nuevoDialogo.setVisible(true);


		return new Doctor(jNombre.getText(),jApellido.getText(),Integer.parseInt(jMatricula.getText()), Integer.parseInt(jEdad.getText()),Integer.parseInt( jTelefono.getText()),Integer.parseInt( jDni.getText()), JDireccion.getText());
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		 
		Doctor doc = crearDialogo();
		DoctorDao doctor = new DoctorDao();
		HibernateUtil.beginTransaction();
		doctor.makePersistent(doc);
		
        HibernateUtil.commitTransaction();
      
	//	consultorio.agregarDoctor(doc);
		
	}

}
