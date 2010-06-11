package edu.austral.lab1.odontobook.controler;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RootPaneContainer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import org.apache.log4j.Layout;

import edu.austral.lab1.odontobook.graphicInterface.TabbedPane;
import edu.austral.lab1.odontobook.graphicInterface.GraphicInterface;
import edu.austral.lab1.odontobook.model.Consultorio;
import edu.austral.lab1.odontobook.model.HibernateUtil;
import edu.austral.lab1.odontobook.model.Histograma;
import edu.austral.lab1.odontobook.model.Paciente;
import edu.austral.lab1.odontobook.model.dao.BaseDao;
import edu.austral.lab1.odontobook.model.dao.HistogramaDao;
import edu.austral.lab1.odontobook.model.dao.PacienteDao;

public class NewHistogramaAction extends AbstractAction {
	private JDialog nuevoDialogo;
	private Frame frame;
	private JDialog elegirNombre;
	private Object[][] data;
	private List<Histograma> histo;
	private AbstractButton agregar;
	private JTable table;
	private DefaultTableModel model;
	private JButton borrar;
	private JButton importar;
	private Paciente paci;
	private String name;
	private Consultorio consultorio;
	private GraphicInterface gi;




	public NewHistogramaAction(Consultorio consultorio,GraphicInterface gi){	
		super("Histograma");
		putValue(SHORT_DESCRIPTION,"Agrega un Paciente");

this.consultorio=consultorio;
this.gi=gi;
	}


	private void makeHistograma(String name, String apellido) {


		PacienteDao paciente =new PacienteDao();
		System.out.println(name);
		System.out.println(apellido);
		
		 paci=paciente.getPacientebyNameAndApellido(name, apellido);

		nuevoDialogo = new JDialog(frame,"Histograma" ,true);
		String[] columnNames = {"Diente",
				"Cara",
		"Tratamiento"};

System.out.println(paci);

	if(paci.getHistograma().isEmpty()){

			model=new	DefaultTableModel(columnNames, 1); 
			histo=new ArrayList();
		}else{
			histo=paci.getHistograma();
			model= new DefaultTableModel(columnNames,histo.size());


			for(int i=0;i<histo.size();i++){

				model.setValueAt(histo.get(i).getDientes(), i, 0);
				model.setValueAt(histo.get(i).getCara(), i, 1);
				model.setValueAt(histo.get(i).getTratamiento(), i, 2);

			}

		}
		
		table = new JTable(model);
		table.setPreferredScrollableViewportSize(new Dimension(500, 100));
		table.setFillsViewportHeight(true);

		TableColumn sportColumn = table.getColumnModel().getColumn(2);
		JComboBox comboBox = new tratamientos();
		sportColumn.setCellEditor(new DefaultCellEditor(comboBox));


		JScrollPane pane=new JScrollPane(table);
		JButton aceptar = new JButton("Aceptar");
		agregar=new JButton("Agregar");
		borrar=new JButton("Borrar");
		importar=new JButton("Importar");
		BorderLayout layout=new BorderLayout();

		JPanel panel1= new JPanel();
		panel1.add(pane);
		panel1.setLayout(new BoxLayout( panel1,BoxLayout.PAGE_AXIS));


		JPanel panel2= new JPanel();
		panel2.setLayout(new BoxLayout(panel2,BoxLayout.LINE_AXIS));

		panel2.add(aceptar);
		panel2.add(agregar);
		
		panel2.add(borrar);
		panel2.add(importar);
		nuevoDialogo.add(panel2,BorderLayout.PAGE_END);
		nuevoDialogo.add(panel1);


		//SETEO EL EVENTO DEL BOTON
		aceptar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				nuevoDialogo.dispose();

			}
		});


		agregar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				DefaultTableModel temp = (DefaultTableModel) table.getModel();
				Object nuevo[]= {"","",""};
				temp.addRow(nuevo);
			}
		});


		borrar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				DefaultTableModel temp = (DefaultTableModel) table.getModel();
				temp.removeRow(table.getSelectedRow());
			}
		});


		importar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				DefaultTableModel temp = (DefaultTableModel) table.getModel();

				String Diente =(String) temp.getValueAt(table.getSelectedRow(), 0);
				int Dientes=Integer.parseInt(Diente);
				String cara=(String) temp.getValueAt(table.getSelectedRow(), 1);
				String tratamiento=(String)  temp.getValueAt(table.getSelectedRow(), 2);
				Histograma his=new Histograma(Dientes,cara,tratamiento,paci);
				
				histo.add(his);
				HibernateUtil.beginTransaction();
				HistogramaDao dao=new HistogramaDao();
				dao.makePersistent(his);				
				paci.setHistograma(histo);
				HibernateUtil.getSession().update(paci);
			
				HibernateUtil.commitTransaction();
			}
		});


		nuevoDialogo.setSize(400, 150);
		nuevoDialogo.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		nuevoDialogo.setVisible(true);

	}




	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		TabbedPane tabedPane=gi.getDoctorTab();		
		String name=(String)tabedPane.getPaci().getSelectedValue();
		String[] splitName=name.split(" ");
		makeHistograma(splitName[0], splitName[splitName.length-1]);	
	}







}
