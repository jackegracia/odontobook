package edu.austral.lab1.odontobook.controler;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import edu.austral.lab1.odontobook.graphicInterface.TabbedPane;
import edu.austral.lab1.odontobook.graphicInterface.GraphicInterface;
import edu.austral.lab1.odontobook.model.Consultorio;
import edu.austral.lab1.odontobook.model.Doctor;
import edu.austral.lab1.odontobook.model.HibernateUtil;
import edu.austral.lab1.odontobook.model.Usuario;
import edu.austral.lab1.odontobook.model.dao.BaseDao;
import edu.austral.lab1.odontobook.model.dao.DoctorDao;
import edu.austral.lab1.odontobook.model.dao.UsuarioDao;
import edu.austral.lab1.odontobook.util.Sorter;

public class NewDoctorAction extends AbstractAction {

	private JDialog nuevoDialogo;
	private Frame frame;
	private Consultorio consultorio;
	private GraphicInterface gi;
	private Doctor doc;


	public NewDoctorAction(Consultorio consultorio, GraphicInterface gi){
		super("Nuevo Doctor");
		putValue(SHORT_DESCRIPTION,"Agrega un Doctor");
		this.consultorio=consultorio;
		this.gi=gi;

	}


	public Doctor crearDialogo() {
		//Doctor q voy a devolver para usar el cancelar bien
		Doctor nuevoDoctor = new Doctor();
		nuevoDialogo = new JDialog(frame,"Nuevo Doctor" ,true);
		JLabel nombre= new JLabel("Nombre");
		JLabel apellido= new JLabel("Apellido");
		JLabel edad= new JLabel("edad");
		JLabel direccion= new JLabel("Direccion");
		JLabel matricula= new JLabel("Matricula");
		JLabel dni= new JLabel("Dni");
		JLabel telefono= new JLabel("Telefono");
		JLabel usuario= new JLabel("Usuario");
		JLabel contraseña= new JLabel("Contraseña");
		JLabel confContraseña= new JLabel("Confirmar contraseña");


		final JTextField jNombre = new JTextField("");
		final JTextField jApellido = new JTextField("");
		final JTextField jEdad = new JTextField("");
		final JTextField JDireccion = new JTextField("");
		final JTextField jMatricula = new JTextField("");
		final JTextField jDni = new JTextField("");
		final JTextField jTelefono = new JTextField("");
		final JTextField jUsuario = new JTextField("");
		final JPasswordField jContraseña = new JPasswordField("");
		final JPasswordField jConfContraseña = new JPasswordField("");

		JButton aceptar = new JButton("Aceptar");
		JButton cancelar = new JButton("Cancelar");
		GridLayout layout = new GridLayout(11,4);
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

		nuevoDialogo.getContentPane().add(usuario);
		nuevoDialogo.getContentPane().add(jUsuario);

		nuevoDialogo.getContentPane().add(contraseña);
		nuevoDialogo.getContentPane().add(jContraseña);
		nuevoDialogo.getContentPane().add(confContraseña);
		nuevoDialogo.getContentPane().add(jConfContraseña);

		nuevoDialogo.getContentPane().add(telefono);
		nuevoDialogo.getContentPane().add(jTelefono);

		nuevoDialogo.getContentPane().add(aceptar);
		nuevoDialogo.getContentPane().add(cancelar);
		//SETEO EL EVENTO DEL JTextField


		//SETEO EL EVENTO DEL BOTON
		aceptar.addActionListener(new ActionListener(){


			public void actionPerformed(ActionEvent e) {

				UsuarioDao usuarioD = new UsuarioDao();
				boolean existeUser = usuarioD.existeUsuario(jUsuario.getText());
				int n = jContraseña.getPassword().length;
				int z = jConfContraseña.getPassword().length;
				boolean pass = true;
				
				if(n==z){
					for(int i = 0; i<n; i++){
						if(jContraseña.getPassword()[i] != jConfContraseña.getPassword()[i]){
							pass= false;
						}
					}
				}

				if(existeUser){
					JFrame frame = new JFrame();
					JOptionPane.showMessageDialog(frame, "Ese nombre de usuario ya esta en uso");
				}

				else if(n != z){
					JFrame frame = new JFrame();
					JOptionPane.showMessageDialog(frame, "Las contrasenias deben ser iguales");

				}else if(pass == false) {
					JFrame frame = new JFrame();
					JOptionPane.showMessageDialog(frame, "Las contrasenias deben ser iguales");
				}


				else{
					try{
						doc = new Doctor(jNombre.getText(),jApellido.getText(),Integer.parseInt(jMatricula.getText()), Integer.parseInt(jEdad.getText()),Integer.parseInt(jTelefono.getText()),Integer.parseInt( jDni.getText()), JDireccion.getText(),new Usuario(jUsuario.getText(),jContraseña.getText(),true, Integer.parseInt(jDni.getText())) );
						nuevoDialogo.dispose();
					}catch(NumberFormatException ex){
						JFrame frame = new JFrame();
						JOptionPane.showMessageDialog(frame, "Algun dato es invalido");
						
					}
				
				}
			}
		});

		cancelar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				jNombre.setText(null);
				jUsuario.setText(null);
				nuevoDialogo.dispose();	

			}
		});

		//Cambio el tamaño de la ventana.
		nuevoDialogo.setSize(300, 300);

		//NOTA: Siempre el mostrar va al final de todo, muchas funciones no funcionan si se ponen despues de este metodo.
		nuevoDialogo.setVisible(true);
		
		return doc;
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {

		Doctor doc = crearDialogo();
		System.out.println(doc.getNombre());
		System.out.println(doc.getUsuario().getUsername());
		if(!doc.getNombre().equals("") || !doc.getUsuario().getUsername().equals("")){
			nuevoDialogo.dispose();	
			DoctorDao doctor = new DoctorDao();
			HibernateUtil.beginTransaction();
			doctor.makePersistent(doc);
			HibernateUtil.commitTransaction();
			consultorio.agregarDoctores(doc.getNombre()+" "+doc.getApellido());
			Sorter sort = new Sorter();
			sort.ordenarString(consultorio.getDoctores());
			 ((TabbedPane) gi.getDoctorTab()).getModeloDeLista().clear();
			 ArrayList<String> nombres=consultorio.getDoctores();
				for(int i=0;i<consultorio.getDoctores().size();i++){
					 ((TabbedPane) gi.getDoctorTab()).getModeloDeLista().addElement(nombres.get(i));
									}
			 gi.getSplitPanel2().repaint();
		}
		
		//	consultorio.agregarDoctor(doc);

	}

}
