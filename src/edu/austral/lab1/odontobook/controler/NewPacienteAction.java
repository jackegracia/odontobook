package edu.austral.lab1.odontobook.controler;



import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import edu.austral.lab1.odontobook.model.Consultorio;
import edu.austral.lab1.odontobook.model.Doctor;
import edu.austral.lab1.odontobook.model.Paciente;

public class NewPacienteAction extends AbstractAction {
	
	private JDialog nuevoDialogo;
	private Frame frame;
	private Consultorio consultorio;
	
	
	
	public NewPacienteAction(Consultorio consultorio){
		super("Paciente");
		putValue(SHORT_DESCRIPTION,"Agrega un Paciente");
		this.consultorio=consultorio;
		
	}
	
	
	public Paciente crearDialogo() {
		nuevoDialogo = new JDialog(frame,"Nuevo Doctor" ,true);
		JLabel nombre= new JLabel("Nombre");
		JLabel apellido= new JLabel("Apellido");
		JLabel edad= new JLabel("edad");
		JLabel direccion= new JLabel("Direccion");
		JLabel obraSocial= new JLabel("ObraSocial");
		JLabel dni= new JLabel("Dni");
		JLabel telefono= new JLabel("Telefono");

		final JTextField jNombre = new JTextField("");
		final JTextField jApellido = new JTextField("");
		final JTextField jEdad = new JTextField("");
		final JTextField JDireccion = new JTextField("");
		final JTextField jObraSocial = new JTextField("");
		final JTextField jDni = new JTextField("");
		final JTextField jTelefono = new JTextField("");
		
		JButton aceptar = new JButton("Aceptar");
		JButton cancelar = new JButton("Cancelar");
		GridLayout layout = new GridLayout(8,2);
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

		nuevoDialogo.getContentPane().add(obraSocial);
		nuevoDialogo.getContentPane().add(jObraSocial);

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
				if(!jNombre.getText().equals("")){
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


		return new Paciente(jNombre.getText()
				,jApellido.getText()
				,Integer.parseInt(jDni.getText()), 
				Integer.parseInt( jTelefono.getText()),
				JDireccion.getText(),jObraSocial.getText()
				,Integer.parseInt(jEdad.getText()) );
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Paciente paciente = crearDialogo();
		consultorio.agregarPaciente(paciente);
		
	}

}
