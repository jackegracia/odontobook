package edu.austral.lab1.odontobook.graphicInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import edu.austral.lab1.odontobook.model.Consultorio;

public class SearchName extends JPanel {

	private Consultorio consultorio;
	private JTextField testArea;
	private TabbedPane tab;
	private List lista;
	private JList jlist;


	public SearchName(final TabbedPane tab,final Consultorio consultorio){
		this.tab=tab;
		this.consultorio=consultorio;
		JButton doctores=new JButton("Doctores");
		JButton pacientes=new JButton("Pacientes");
		JButton buscar=new JButton("Buscar");

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
		buttonPane.add(Box.createHorizontalGlue());
		buttonPane.add(doctores);
		buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
		buttonPane.add(pacientes);



		JPanel panel=new JPanel();
		testArea=new JTextField();
		testArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		testArea.setEnabled(false);

		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		testArea.setPreferredSize(new Dimension(100, 7));
		panel.add(testArea);
		panel.add(buscar);

		this.add(buttonPane);
		this.add(panel);

		doctores.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				testArea.setEnabled(true);
				tab.setSelectedIndex(0);
				jlist=tab.getDoc();
				lista=consultorio.getDoctores();
			}
		});

		pacientes.addActionListener(new ActionListener(){


			public void actionPerformed(ActionEvent e){
				testArea.setEnabled(true);
				tab.setSelectedIndex(1);
				jlist=tab.getPaci();
				lista=consultorio.getPacientes();
			}
		});

		buscar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){

				String name=testArea.getText();
				for(int i=0;i<lista.size();i++){				
					if(name.equals(lista.get(i))){
						jlist.setSelectedIndex(i);
					}
				}


				testArea.setText("");
				testArea.setEnabled(false);

			}
		});

	}









}
