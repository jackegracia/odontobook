package edu.austral.lab1.odontobook.controler;

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

import edu.austral.lab1.odontobook.graphicInterface.GraphicInterface;
import edu.austral.lab1.odontobook.model.Consultorio;
import edu.austral.lab1.odontobook.model.HibernateUtil;
import edu.austral.lab1.odontobook.model.Paciente;
import edu.austral.lab1.odontobook.model.dao.PacienteDao;
import edu.austral.lab1.odontobook.model.dao.UsuarioDao;
import edu.austral.lab1.odontobook.model.Usuario;

public class NewPacienteAction extends AbstractAction {

	private JDialog nuevoDialogo;
	private Frame frame;
	private Consultorio consultorio;
	private GraphicInterface gi;


	public NewPacienteAction(GraphicInterface gi,Consultorio consultorio){
		super("Crear nuevo paciente");
		putValue(SHORT_DESCRIPTION,"Agrega un Paciente");
		this.consultorio=consultorio;
		this.gi=gi;

	}


	public Paciente crearDialogo() {
		nuevoDialogo = new JDialog(frame,"Nuevo Paciente" ,true);
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
		final JPasswordField jContraseña = new JPasswordField("");



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

		//SETEO EL EVENTO DEL JTextField


		//SETEO EL EVENTO DEL BOTON
		aceptar.addActionListener(new ActionListener(){


			public void actionPerformed(ActionEvent e) {
				UsuarioDao usuarioD = new UsuarioDao();
				boolean existeUser = usuarioD.existeUsuario(jUsuario.getText());

				if(existeUser){
					JFrame frame = new JFrame();
					JOptionPane.showMessageDialog(frame, "Ese nombre de usuario ya esta en uso");
				}else{
					nuevoDialogo.dispose();
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

		UsuarioDao usuarioD = new UsuarioDao();
		boolean existeUser = usuarioD.existeUsuario(jUsuario.getText());

		if(existeUser) return null;
		else{
			return new Paciente(jNombre.getText()
					,jApellido.getText()
					,Integer.parseInt(jDni.getText())
					,Integer.parseInt( jTelefono.getText())
					,JDireccion.getText(),jObraSocial.getText()
					,Integer.parseInt(jEdad.getText()),new Usuario(jUsuario.getText(),jContraseña.getText(),false, Integer.parseInt(jDni.getText())) );
		}}



	@Override
	public void actionPerformed(ActionEvent arg0) {
		Paciente paciente = crearDialogo();
		if(!paciente.getNombre().equals("") || !paciente.getUsuario().getUsername().equals("")){
			paciente.setHistograma(new ArrayList());
			//	consultorio.agregarPaciente(paciente);
			PacienteDao pac = new PacienteDao();
			HibernateUtil.beginTransaction();
			pac.makePersistent(paciente);
			HibernateUtil.commitTransaction();
			consultorio.agregarPaciente(paciente.getNombre()+" "+paciente.getApellido());
			gi.getFrame().dispose();
			gi=new GraphicInterface();
		}

	}

}
