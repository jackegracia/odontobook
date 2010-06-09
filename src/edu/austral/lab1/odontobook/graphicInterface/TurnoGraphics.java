package edu.austral.lab1.odontobook.graphicInterface;

import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.*;
import javax.swing.table.*;

import edu.austral.lab1.odontobook.model.Doctor;
import edu.austral.lab1.odontobook.model.HibernateUtil;
import edu.austral.lab1.odontobook.model.Histograma;
import edu.austral.lab1.odontobook.model.Paciente;
import edu.austral.lab1.odontobook.model.Turno;
import edu.austral.lab1.odontobook.model.dao.HistogramaDao;
import edu.austral.lab1.odontobook.model.dao.PacienteDao;
import edu.austral.lab1.odontobook.model.dao.TurnoDao;

public class TurnoGraphics { 

	JTable table;
	private JDialog nuevoDialogo;
	private Frame frame;
	private AbstractButton importar;
	private Doctor doctorForDay;
	private Date date;
	private Long doctorId;
	private long doctor_id;
	private List listaDeTurnos;


	public TurnoGraphics(final Doctor doctorForDay,final Date date, Long doctorId,String lavel)
	{    
		this.doctorForDay=doctorForDay;
		this.date=date;
		this.doctorId=doctorId;
		nuevoDialogo = new JDialog(frame,"Turnos del doctor: "+ lavel ,true); 


		ListModel listModel = new AbstractListModel() 

		{    

			String headers[] = 

			{"8:00","8:30","9:00","9:30","10:00","10:30",
					"11:00","11:30","12:00","12:30","13:00","13:30","14:00","14:30"
					,"15:00","15:30","16:00","16:30","17:00","17:30","18:00","18:30","19:00","19:30","20:00"};

			public int getSize() 

			{       

				return headers.length;    

			}    

			public Object getElementAt(int index)

			{        return headers[index];   

			}  

		};   

		String headers2[] = {"Pacientes"};


		DefaultTableModel defaultModel = new DefaultTableModel(headers2,listModel.getSize());  

		table = new JTable(defaultModel);   



		// Create single component to add to scrollpane  

		final JList rowHeader = new JList(listModel);   

		rowHeader.setFixedCellWidth(40);   

		rowHeader.setFixedCellHeight(table.getRowHeight());   

		rowHeader.setCellRenderer(new RowHeaderRenderer1(table));  

		JScrollPane scroll = new JScrollPane(table);  

		scroll.setRowHeaderView(rowHeader);    

		// Adds row-list left of the table  


		JButton aceptar = new JButton("Aceptar");
		JButton cancelar = new JButton("Cancelar");
		importar = new JButton("Importar");

		BorderLayout layout=new BorderLayout();

		JPanel panel1= new JPanel();
		panel1.add(scroll);
		panel1.setLayout(new BoxLayout( panel1,BoxLayout.PAGE_AXIS));


		JPanel panel2= new JPanel();
		panel2.setLayout(new BoxLayout(panel2,BoxLayout.LINE_AXIS));

		panel2.add(aceptar);
		panel2.add(cancelar);
		panel2.add(importar);

		TurnoDao turnoDao=new TurnoDao();
		listaDeTurnos = turnoDao.getTurnoByDateAndDoctor(date, doctorId);




		System.out.println(listaDeTurnos.size());



		if(listaDeTurnos.isEmpty()){

		}else{


			for(int i=0;i<listaDeTurnos.size();i++){

				Turno turno=(Turno) listaDeTurnos.get(i);

				final Paciente paciente = turno.getPaciente();




				if(turno.getMinutos()==30){

					table.getModel().setValueAt(paciente.getNombre()+" " + paciente.getApellido(), ((turno.getHora()-8)*2)+1, 0);
				}else{

					table.getModel().setValueAt(paciente.getNombre()+" " + paciente.getApellido(), (turno.getHora()-8)*2, 0);
				}
			}
		}



		nuevoDialogo.add(panel2,BorderLayout.PAGE_END);
		nuevoDialogo.add(panel1);



		rowHeader.addMouseListener(new MouseAdapter()

		{    

			public void mouseClicked(MouseEvent e) {    



				int index = rowHeader.locationToIndex(e.getPoint());   

				table.setRowSelectionInterval(index, index);    

				table.requestFocus();    

			}   

		}); 






		aceptar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				nuevoDialogo.dispose();

			}
		});







		importar.addActionListener(new ActionListener(){
			private int hour;

			public void actionPerformed(ActionEvent e){

				DefaultTableModel temp = (DefaultTableModel) table.getModel();
				String paciente =(String) temp.getValueAt(table.getSelectedRow(), 0);
				System.out.print(paciente);
				PacienteDao paci=new PacienteDao();
				Paciente pacient=paci.getPacientebyName(paciente);

				HibernateUtil.beginTransaction();
				Turno turno=new Turno(pacient,doctorForDay,date);


				final int selectedRow = table.getSelectedRow();
				final boolean evenRow = selectedRow == 0 || selectedRow%2 == 0;


				System.out.println("selectedRow: " + selectedRow);
				System.out.println("evenRow: " + evenRow);


				final int hour = evenRow ? (selectedRow/2)+8 : ((selectedRow-1)/2)+8;
				final int minutes = evenRow ? 0 : 30;


				System.out.println("hour: " + hour);
				System.out.println("minutes: " + minutes);


				turno.setHora(hour);
				turno.setMinutos(minutes);


				TurnoDao turnoDao=new TurnoDao();
				turnoDao.makePersistent(turno);
				HibernateUtil.commitTransaction();




			}
		});


		nuevoDialogo.setSize(200, 500);
		nuevoDialogo.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		nuevoDialogo.setVisible(true);
	}


	class RowHeaderRenderer1 extends JButton implements ListCellRenderer{  

		JTable table;  

		public RowHeaderRenderer1(JTable table)

		{     

			this.table = table;  

			setFont(new Font("Dialog",0,11));    

			setMargin(new Insets(0,0,0,0));   

		}   

		public Component getListCellRendererComponent(JList list, Object value,int index, boolean isSelected, boolean hasFocus)

		{     

			list.setBackground(getBackground());   

			this.setText(value.toString());    

			return this;    
		}       

		public Component getListCellRendererComponent(JList list, Object value, boolean isSelected, boolean hasFocus){    

			list.setBackground(getBackground());     

			this.setText(value.toString());    

			return this;  

		} 

	}


	public JTable getTable() {
		// TODO Auto-generated method stub
		return table;
	}




	public void setTable(JTable table) {
		this.table = table;
	}
}

