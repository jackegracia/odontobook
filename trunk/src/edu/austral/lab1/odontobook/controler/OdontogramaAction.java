package edu.austral.lab1.odontobook.controler;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import edu.austral.lab1.odontobook.graphicInterface.CheckBox;
import edu.austral.lab1.odontobook.graphicInterface.DrawTooth;
import edu.austral.lab1.odontobook.graphicInterface.GraphicInterface;
import edu.austral.lab1.odontobook.graphicInterface.MouseListenerGraphic;
import edu.austral.lab1.odontobook.graphicInterface.TabbedPane;
import edu.austral.lab1.odontobook.model.Consultorio;
import edu.austral.lab1.odontobook.model.Histograma;
import edu.austral.lab1.odontobook.model.Paciente;
import edu.austral.lab1.odontobook.model.dao.PacienteDao;


public class OdontogramaAction extends AbstractAction {
	private JPanel panelDeBotones;
	private JPanel panelDeDientes2;
	private JPanel panelDeDientes1;
	private JPanel checkBox;
	private GraphicInterface gi;


	public OdontogramaAction(Consultorio consultorio, GraphicInterface gi){
		super("Odontograma");
		putValue(SHORT_DESCRIPTION,"Odontograma");
		this.gi=gi;

	}

	public  void makeTooth(String nombre, String apellido) {
		

		PacienteDao paciente =new PacienteDao();
		Paciente pacient=paciente.getPacientebyNameAndApellido(nombre, apellido);
		List<Histograma> histo=pacient.getHistograma();
		
		JFrame frame = new JFrame("Osontograma");
		panelDeDientes1=new JPanel();
		panelDeDientes2=new JPanel();
		
	panelDeDientes1.setLayout(new GridLayout(4,16));
		int i=1;
		while (i<=64){
			if (i<=16){
				panelDeDientes1.add(new JLabel(String.valueOf("      "+i)));
				i++;
			}else if (i>32||i<=48){
				panelDeDientes1.add(new JLabel(String.valueOf("      "+(i-16))));
				i++;
			}
			
			while((i>16&&i<=32)||(i>48&&i<=64)){
			
				if(i>16&&i<=32){
					if(histo.size()==0){
						DrawTooth tooth=new DrawTooth(i-16,null,null,null,null,null);
						tooth. addMouseListener(new MouseListenerGraphic(tooth,this));
						panelDeDientes1.add(tooth);
					}else{			
						boolean tratamiento=false;
						Histograma histograma=null;
					for(int z=0;z<histo.size();z++){
						if (histo.get(z).getDientes()==i-16){
							histograma=histo.get(z);
							tratamiento=true;
								}
					}
							if(tratamiento){
								
							
							if(histograma.getTratamiento().equals("Extraccion")){
								DrawTooth tooth=new DrawTooth(i-16,Color.BLACK,Color.BLACK,Color.BLACK,Color.BLACK,Color.BLACK);
								tooth. addMouseListener(new MouseListenerGraphic(tooth,this));
								panelDeDientes1.add(tooth);
							}else if (histograma.getTratamiento().equals("Carie")){
								DrawTooth tooth=new DrawTooth(i-16,Color.BLUE,Color.BLUE,Color.BLUE,Color.BLUE,Color.BLUE);
								tooth. addMouseListener(new MouseListenerGraphic(tooth,this));
								panelDeDientes1.add(tooth);						
							}else if (histograma.getTratamiento().equals("CarieHecha")){
								DrawTooth tooth=new DrawTooth(i-16,Color.RED,Color.RED,Color.RED,Color.RED,Color.RED);
								tooth. addMouseListener(new MouseListenerGraphic(tooth,this));
								panelDeDientes1.add(tooth);
							}else{
								DrawTooth tooth=new DrawTooth(i-16,null,null,null,null,null);
								tooth. addMouseListener(new MouseListenerGraphic(tooth,this));
								panelDeDientes1.add(tooth);
							}
						}else{
							DrawTooth tooth=new DrawTooth(i-16,null,null,null,null,null);
							tooth. addMouseListener(new MouseListenerGraphic(tooth,this));
							panelDeDientes1.add(tooth);
					
						}
							
					}
					i++;
					
					
				}else if(i>48&&i<=64){
					if(histo.size()==0){
						DrawTooth tooth=new DrawTooth(i-32,null,null,null,null,null);
						tooth. addMouseListener(new MouseListenerGraphic(tooth,this));
						panelDeDientes1.add(tooth);
						
					}else{
					
						boolean tratamiento=false;
						Histograma histograma=null;
					for(int z=0;z<histo.size();z++){
						if (histo.get(z).getDientes()==i-32){
							histograma=histo.get(z);
							tratamiento=true;
								}
					}
							if(tratamiento){
																
							
							if(histograma.getTratamiento().equals("Extraccion")){
								DrawTooth tooth=new DrawTooth(i-32,Color.BLACK,Color.BLACK,Color.BLACK,Color.BLACK,Color.BLACK);
								tooth. addMouseListener(new MouseListenerGraphic(tooth,this));
								panelDeDientes1.add(tooth);
							}else if (histograma.getTratamiento().equals("Carie")){
								DrawTooth tooth=new DrawTooth(i-32,Color.BLUE,Color.BLUE,Color.BLUE,Color.BLUE,Color.BLUE);
								tooth. addMouseListener(new MouseListenerGraphic(tooth,this));
								panelDeDientes1.add(tooth);
							}else if (histograma.getTratamiento().equals("CarieHecha")){
								DrawTooth tooth=new DrawTooth(i-32,Color.RED,Color.RED,Color.RED,Color.RED,Color.RED);
								tooth. addMouseListener(new MouseListenerGraphic(tooth,this));
								panelDeDientes1.add(tooth);
							}else{
								DrawTooth tooth=new DrawTooth(i-32,null,null,null,null,null);
								tooth. addMouseListener(new MouseListenerGraphic(tooth,this));
								panelDeDientes1.add(tooth);
							}
						}else{
							DrawTooth tooth=new DrawTooth(i-32,null,null,null,null,null);
							tooth. addMouseListener(new MouseListenerGraphic(tooth,this));
							panelDeDientes1.add(tooth);
						}
							
					}
					i++;
					
				}
				
				}
			
			}
		
		

/*
		for(int k=1;k<64;k++){
			if((k>=16&&k<32)||(k>=48&&k<=64)){
				panelDeDientes1.getComponent(k).setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		}

*/
		panelDeDientes1.setBorder(BorderFactory.createLineBorder(Color.black));
		panelDeDientes2.setLayout(new BoxLayout(panelDeDientes2, BoxLayout.LINE_AXIS));
		panelDeDientes2.add(panelDeDientes1);
		panelDeDientes2.setBorder(BorderFactory.createLineBorder(Color.black));
		
		checkBox=new CheckBox().CheckBox();
		checkBox.setLayout(new BoxLayout(checkBox,BoxLayout.PAGE_AXIS));

		frame.add(panelDeDientes2);
		frame.add(checkBox,BorderLayout.EAST);
		frame.add(buttonPanel(),BorderLayout.PAGE_END);
		frame.setSize(900, 270);
		frame.setVisible(true);
	}


	public JPanel getCheckBox() {
		return checkBox;
	}

	public void setCheckBox(JPanel checkBox) {
		this.checkBox = checkBox;
	}

	public JPanel getPanelDeDientes1() {
		return panelDeDientes1;
	}

	public void setPanelDeDientes1(JPanel panelDeDientes1) {
		this.panelDeDientes1 = panelDeDientes1;
	}
	
	
	public JPanel buttonPanel(){
		
panelDeBotones=new JPanel();

		
		
		JButton aceptar=new JButton("Aceptar");
		JButton borrarDiente=new JButton("Borrar Diente");
		JButton colocarDiente=new JButton("Colocar Diente");
		panelDeBotones.setLayout(new BoxLayout(panelDeBotones,BoxLayout.LINE_AXIS));

		borrarDiente.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				removeTooth();
			}});

		colocarDiente.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				placeTooth();
			}});

		panelDeBotones.add(aceptar);
		panelDeBotones.add(borrarDiente);
		panelDeBotones.add(colocarDiente);
		return panelDeBotones;
		
	}
	

	public void removeTooth(){


		for(int z=1;z<64;z++){
			if((z>=16&&z<32)){
				if(panelDeDientes1.getComponent(z).isFocusable())
					paintTooth(z-15,Color.BLACK,Color.black,Color.BLACK,Color.BLACK,Color.BLACK);

			}else if((z>=48&&z<=64)){
				if(panelDeDientes1.getComponent(z).isFocusable())


					paintTooth(z-31,Color.BLACK,Color.black,Color.BLACK,Color.BLACK,Color.BLACK);


			}
		}

	}

	public void placeTooth(){


		for(int z=1;z<64;z++){
			if((z>=16&&z<32)){
				if(panelDeDientes1.getComponent(z).isFocusable())
					paintTooth(z-15,Color.WHITE,Color.WHITE,Color.WHITE,Color.WHITE,Color.WHITE);
				
			}else if((z>=48&&z<=64)){
				if(panelDeDientes1.getComponent(z).isFocusable())


					paintTooth(z-31,Color.WHITE,Color.WHITE,Color.WHITE,Color.WHITE,Color.WHITE);
				

			}
		}

	}




	public void paintTooth(int diente,Color uno,Color dos,Color tres,Color cuatro,Color cinco){

		if(diente<=16){
			panelDeDientes1.remove(panelDeDientes1.getComponent(diente+15));

			DrawTooth tooth=new DrawTooth(diente,uno,dos,tres,cuatro,cinco);
			tooth.addMouseListener(new MouseListenerGraphic(tooth,this));
			panelDeDientes1.add(tooth,diente+15);
			panelDeDientes1.getComponent(diente+15).setCursor(new Cursor(Cursor.HAND_CURSOR));
			//panelDeDientes1.repaint();


		}else{
			panelDeDientes1.remove(panelDeDientes1.getComponent(diente+31));


			DrawTooth tooth=new DrawTooth(diente,uno,dos,tres,cuatro,cinco);
			tooth.addMouseListener(new MouseListenerGraphic(tooth,this));
			panelDeDientes1.add(tooth,diente+31);
			panelDeDientes1.getComponent(diente+31).setCursor(new Cursor(Cursor.HAND_CURSOR));
			//	panelDeDientes1.repaint();

		}
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		TabbedPane tabedPane=gi.getDoctorTab();		
		String name=(String)tabedPane.getPaci().getSelectedValue();
		String[] splitName=name.split(" ");

		makeTooth(splitName[0], splitName[splitName.length-1]);

	}


}

