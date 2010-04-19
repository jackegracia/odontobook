package edu.austral.lab1.odontobook.graphicInterface;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class TurnoGraphic {

	private JTextField jtextField[];

	public TurnoGraphic (JFrame frame){
		
		frame.setLayout(new GridLayout(26,2));



		jtextField=new JTextField[26];
		
		for (int k=0;k<26;k++){
			jtextField[k]=new JTextField("");
		}
		for (int i=8;i<=20;i++){
			if (i==8||i==9){
				frame.add(new JLabel("0"+String.valueOf(i)+":00 hs"));
				frame.add(jtextField[i-8]);
				frame.add(new JLabel("0"+String.valueOf(i)+":30 hs"));
				frame.add(jtextField[i-7]);
			}else if(i<20){
				frame.add(new JLabel(String.valueOf(i)+":00 hs"));
				frame.add(jtextField[i-8]);
				frame.add(new JLabel(String.valueOf(i)+":30 hs"));
				frame.add(jtextField[i-7]);
			}else {
				frame.add(new JLabel(String.valueOf(i)+":00 hs"));
				frame.add(jtextField[i-8]);
			}
		}
	}
}