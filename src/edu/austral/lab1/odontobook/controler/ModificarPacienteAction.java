package edu.austral.lab1.odontobook.controler;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import edu.austral.lab1.odontobook.graphicInterface.TabbedPane;
import edu.austral.lab1.odontobook.graphicInterface.GraphicInterface;
import edu.austral.lab1.odontobook.model.Consultorio;
import edu.austral.lab1.odontobook.model.HibernateUtil;
import edu.austral.lab1.odontobook.model.Paciente;
import edu.austral.lab1.odontobook.model.Usuario;
import edu.austral.lab1.odontobook.model.dao.PacienteDao;
import edu.austral.lab1.odontobook.model.dao.UsuarioDao;


public class ModificarPacienteAction extends AbstractAction {
	
	private JDialog nuevoDialogo;
	private Frame frame;
	private Consultorio consultorio;
	private PacienteDao pac;
	private JDialog newDialog;
	private String name;
	private GraphicInterface gi;
	
	
	
	public ModificarPacienteAction(Consultorio consultorio,GraphicInterface gi){
		super("Modificar Paciente");
		putValue(SHORT_DESCRIPTION,"Agrega un Paciente");
		this.consultorio=consultorio;
		pac = new PacienteDao();
		this.gi=gi;
	}
	
	
	public void crearDialogo(Paciente paci) {
		nuevoDialogo = new JDialog(frame,"Modificar Paciente" ,true);
		JLabel nombre= new JLabel("Nombre");
		JLabel apellido= new JLabel("Apellido");
		JLabel edad= new JLabel("edad");
		JLabel direccion= new JLabel("Direccion");
		JLabel obraSocial= new JLabel("ObraSocial");
		JLabel dni= new JLabel("Dni");
		JLabel telefono= new JLabel("Telefono");
		JLabel usuario= new JLabel("Usuario");
		JLabel contraseña= new JLabel("Contraseña");

		final JTextField jNombre = new JTextField("");
		final JTextField jApellido = new JTextField("");
		final JTextField jEdad = new JTextField("");
		final JTextField JDireccion = new JTextField("");
		final JTextField jObraSocial = new JTextField("");
		final JTextField jDni = new JTextField("");
		final JTextField jTelefono = new JTextField("");
		final JTextField jUsuario = new JTextField("");
		final JTextField jContraseña = new JTextField("");
		
		
		
		JButton aceptar = new JButton("Aceptar");
		JButton cancelar = new JButton("Cancelar");
		GridLayout layout = new GridLayout(10,2);
		jNombre.setPreferredSize(new Dimension(280, 25));


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

		nuevoDialogo.getContentPane().add(usuario);
		nuevoDialogo.getContentPane().add(jUsuario);
		
		nuevoDialogo.getContentPane().add(contraseña);
		nuevoDialogo.getContentPane().add(jContraseña);
		
		nuevoDialogo.getContentPane().add(aceptar);
		nuevoDialogo.getContentPane().add(cancelar);
	
		
		
		jNombre.setText(paci.getNombre());
		jApellido.setText(paci.getApellido());
		jEdad.setText(String.valueOf(paci.getEdad()));
		JDireccion.setText(paci.getDireccion());
		jObraSocial.setText(paci.getObraSocial());
		jDni.setText(String.valueOf(paci.getDni()));
		jTelefono.setText(String.valueOf(paci.getTelefono()));
		jUsuario.setText(paci.getUsuario().getUsername());
		jContraseña.setText(String.valueOf(paci.getUsuario().getPassword()));
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
				nuevoDialogo.dispose();	

			}
		});

		
		
		//Cambio el tamaño de la ventana.
		nuevoDialogo.setSize(300, 300);
	
		//NOTA: Siempre el mostrar va al final de todo, muchas funciones no funcionan si se ponen despues de este metodo.
		nuevoDialogo.setVisible(true);


		        paci.setNombre(jNombre.getText());
				paci.setApellido(jApellido.getText());
				paci.setDni(Integer.parseInt(jDni.getText()));
				paci.setTelefono(Integer.parseInt( jTelefono.getText()));
				paci.setDireccion(JDireccion.getText());
				paci.setObraSocial(jObraSocial.getText());
				paci.setEdad(Integer.parseInt(jEdad.getText()));
				paci.getUsuario().setUsername(jUsuario.getText());
				paci.getUsuario().setPassword(jContraseña.getText());
				paci.getUsuario().setDni(Integer.parseInt(jDni.getText()));
				
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		TabbedPane tabedPane=gi.getDoctorTab();		
		String name=(String)tabedPane.getPaci().getSelectedValue();
		String[] splitName=name.split(" ");
		
		
		HibernateUtil.beginTransaction();
		Paciente paci=pac.getPacientebyNameAndApellido(splitName[0], splitName[1]);
		crearDialogo(paci);
		HibernateUtil.getSession().update(paci);
		HibernateUtil.commitTransaction();
	}



}