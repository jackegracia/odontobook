package edu.austral.lab1.odontobook.controler;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import edu.austral.lab1.odontobook.graphicInterface.TabbedPane;
import edu.austral.lab1.odontobook.graphicInterface.TurnoGraphics;
import edu.austral.lab1.odontobook.model.Consultorio;
import edu.austral.lab1.odontobook.model.Doctor;
import edu.austral.lab1.odontobook.model.HibernateUtil;
import edu.austral.lab1.odontobook.model.Histograma;
import edu.austral.lab1.odontobook.model.Paciente;
import edu.austral.lab1.odontobook.model.Turno;
import edu.austral.lab1.odontobook.model.dao.DoctorDao;
import edu.austral.lab1.odontobook.model.dao.HistogramaDao;
import edu.austral.lab1.odontobook.model.dao.PacienteDao;
import edu.austral.lab1.odontobook.model.dao.TurnoDao;
import edu.austral.lab1.odontobook.util.DateUtils;

public class NewTurnoAction extends AbstractAction {

	private static final JTextArea[] JTextArea = null;
	private Frame frame;
	private JDialog nuevoDialogo;
	private TabbedPane pane;
	private Date date;
	private JTextArea[] are;
	private TurnoGraphics tablaDeTurnos;
	private JTable table;
	private List<Turno> listaDeTurnos;

	public  NewTurnoAction (TabbedPane pane,Date date){
		super("Turnos");
		putValue(SHORT_DESCRIPTION,"Agrega un Paciente");
		this.pane=pane;
		this.date=date;

	}

	public void createTurnoTable(){
		Calendar cal = new GregorianCalendar();
		int day = cal.get(Calendar.DATE);
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		Date actual = DateUtils.getDate(day, month, year);
		if(actual.compareTo(date) > 0){
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, "Fecha invalida para sacar un turno");
		}else{
		
		System.out.print(date);
		
		String doctorName= (String) pane.getDoc().getSelectedValue();
		
		
		DoctorDao doctor=new DoctorDao();
		String[] separadas1 = doctorName.split(" ");
		Doctor doctorForDay=doctor.getDoctorbyNameAndApellido(separadas1[0], separadas1[1]);
		Long doctor_id=doctorForDay.getId();
		tablaDeTurnos=new TurnoGraphics(doctorForDay,date,doctor_id,doctorName);
		
		
		}
			}	


	public void actionPerformed(ActionEvent arg0) {
		createTurnoTable();

	} 
}
