package edu.austral.lab1.odontobook.controler;
import javax.swing.UIManager;

import edu.austral.lab1.odontobook.graphicInterface.*;

public class main {
	public static void main (String[] arg0){
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch(Exception e){}
		
		GraphicInterface interfaces=new GraphicInterface();

	}
}