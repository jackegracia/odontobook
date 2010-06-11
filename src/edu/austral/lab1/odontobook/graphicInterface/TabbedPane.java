package edu.austral.lab1.odontobook.graphicInterface;

import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import edu.austral.lab1.odontobook.model.Doctor;
import edu.austral.lab1.odontobook.model.HibernateUtil;
import edu.austral.lab1.odontobook.model.Paciente;
import edu.austral.lab1.odontobook.model.dao.DoctorDao;
import edu.austral.lab1.odontobook.model.dao.PacienteDao;
import edu.austral.lab1.odontobook.util.Sorter;



public class TabbedPane extends JTabbedPane{

	private DoctorDao doctorDao;
	private JList doc;
	private PacienteDao pacienteDao;
	private JList paci;
	private JPanel infoPacientePane;
	private JPanel infoDoctorPane;
	private JScrollPane scrollDePacientes;
	private JSplitPane splitPacientes;

	

	public TabbedPane (){
		
		HibernateUtil.beginTransaction();
		doctorDao =new DoctorDao();
		List<Doctor> doctores=doctorDao.getAll();
		Sorter sort = new Sorter();
		sort.ordenarDoctores(doctores);
		System.out.print(doctores.isEmpty());
		doc=new JList();
		DefaultListModel modeloDeLista = new DefaultListModel();

		if(!doctores.isEmpty()){

			for(int i=0;i<doctores.size();i++){
				modeloDeLista.addElement(((Doctor) doctores.get(i)).getNombre()+" "+((Doctor) doctores.get(i)).getApellido());
			}
		}
		doc.setModel(modeloDeLista);
		JScrollPane scroll=new JScrollPane(doc);
		doc.setSelectedIndex(0);
		this.addTab("Doctores",scroll);
		
				
		pacienteDao =new PacienteDao();
		List<Paciente> pacientes=pacienteDao.getAll();
		sort.ordenarPacientes(pacientes);
		System.out.print(doctores.isEmpty());
		paci=new JList();
		
		DefaultListModel modeloDeListaDePacientes = new DefaultListModel();

		if(!pacientes.isEmpty()){

			for(int i=0;i<pacientes.size();i++){
				modeloDeListaDePacientes.addElement(((Paciente)pacientes.get(i)).getNombre()+" "+((Paciente) pacientes.get(i)).getApellido());
			}
		}
		paci.setModel(modeloDeListaDePacientes);
		scrollDePacientes =new JScrollPane(paci);
		ListaEvent event = new ListaEvent(this);
		MouseListener eventListP = event.clickListPac;
		paci.addMouseListener(eventListP);
		paci.setSelectedIndex(0);
	 infoPacientePane = new JPanel();
		 splitPacientes = new JSplitPane(JSplitPane.VERTICAL_SPLIT,scrollDePacientes, infoPacientePane );
		this.addTab("Pacientes",splitPacientes);

	}	
	
	public JPanel crearPacientePane(){
		
		JPanel panel = new JPanel();

		String nombreApellido = (String) paci.getSelectedValue();
		System.out.println(" dd"+ nombreApellido);
		String [] nya = nombreApellido.split(" ");
		PacienteDao pDao = new PacienteDao();
		Paciente paciente = pDao.getPacientebyNameAndApellido(nya[0], nya[1]);
		JLabel nombreLabel = new JLabel(paciente.getNombre());
		panel.add(nombreLabel);
		
		
		return panel;
		
	}

	public JList getPaci() {
		return paci;
	}
	
	
	
	public void setPaci(JList paci) {
		this.paci = paci;
	}

	public JList getDoc() {
		return doc;
	}

	public void setDoc(JList doc) {
		this.doc = doc;
	}
	
	public JPanel getInfoPacientePane() {
		return infoPacientePane;
	}

	public void setInfoPacientePane(JPanel infoPacientePane) {
		this.infoPacientePane = infoPacientePane;
	}

	public JPanel getInfoDoctorPane() {
		return infoDoctorPane;
	}

	public JScrollPane getScrollDePaciente() {
		return scrollDePacientes;
	}

	public void setScrollDePaciente(JScrollPane scrollDePaciente) {
		this.scrollDePacientes = scrollDePaciente;
	}

	public void setInfoDoctorPane(JPanel infoDoctorPane) {
		this.infoDoctorPane = infoDoctorPane;
	}

	public JSplitPane getSplitPacientes() {
		return splitPacientes;
	}

	public void setSplitPacientes(JSplitPane splitPacientes) {
		this.splitPacientes = splitPacientes;
	}
	
	
}

