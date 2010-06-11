package edu.austral.lab1.odontobook.graphicInterface;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageProducer;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import edu.austral.lab1.odontobook.controler.ActionManager;
import edu.austral.lab1.odontobook.model.Consultorio;
import edu.austral.lab1.odontobook.model.Doctor;

public class GraphicInterface<panelDeBusqueda> {
	private JFrame frame;
	private JPanel panel1;
	private JPanel panel2;
	private JSplitPane splitPanel1;
	private JPanel panel3;
	private JSplitPane splitPanel2;
	private JButton button1;
	private JButton button2;
	private calendario cal;
	private GraphicInterface consultorio;
	private TabbedPane doctorTab;
	private JPanel panelDeBusqueda;


	public GraphicInterface(){
		JFrame frameAux = new JFrame("Odontobook");
		JPanel panel = new JPanel();
		JLabel label = new JLabel(new ImageIcon("icon/odontobookPresentacion.png"));
		
		
		panel.add(label);
		panel.setBorder(BorderFactory.createLineBorder(Color.black));
		frameAux.setUndecorated(true);
		frameAux.getContentPane().add(panel);
		frameAux.pack();
		frameAux.setLocationRelativeTo(null);
		frameAux.setVisible(true);
		Consultorio consultorio=new Consultorio("Consultorio");
		ActionManager am=new ActionManager(consultorio,this);
		System.out.println("nooo");
		makeJframe();
		new MenuBar(am,this);
		doctorTab=new TabbedPane();
		frameAux.dispose();
		panelDeBusqueda=new SearchName(doctorTab,consultorio);
		makeJpanel();
		cal=new calendario(panel3,doctorTab);
	
		frame.setVisible(true);
		frame.setExtendedState(frame.MAXIMIZED_BOTH);
		//frame.setResizable(false);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		


	}
	

	public TabbedPane getDoctorTab() {
		return doctorTab;
	}
	public void setDoctorTab(TabbedPane doctorTab) {
		this.doctorTab = doctorTab;
	}
	private void makeJframe() {
		frame=new JFrame("Odontobook");
		Image img = Toolkit.getDefaultToolkit().createImage("icon/logo.png");
		frame.setIconImage(img);
		frame.pack();
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}


	private void makeJpanel() {


		panel1=new JPanel();
		panel2=new JPanel();
		panel3=new JPanel();
		splitPanel2=new JSplitPane(JSplitPane.VERTICAL_SPLIT ,doctorTab,panelDeBusqueda);
		splitPanel2.setOneTouchExpandable(false);
		splitPanel2.setEnabled(false);
		splitPanel2.setDividerLocation(300);

		splitPanel1=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,splitPanel2,panel3);
		splitPanel1.setOneTouchExpandable(false);
		splitPanel1.setEnabled(false);
		splitPanel1.setDividerLocation(175);
           
		splitPanel1.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		frame.add(splitPanel1);

	}
	public JPanel getPanel2() {
		return panel2;
	}



}
