package edu.austral.lab1.odontobook.controler;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import edu.austral.lab1.odontobook.graphicInterface.CheckBox;
import edu.austral.lab1.odontobook.graphicInterface.DrawTooth;
import edu.austral.lab1.odontobook.graphicInterface.MouseListenerGraphic;

public class OdontogramaAction extends AbstractAction {
private JPanel panelDeBotones;
private JPanel panelDeDientes2;
private JPanel panelDeDientes1;
private JPanel checkBox;


public OdontogramaAction(){
	super("Odontograma");
	putValue(SHORT_DESCRIPTION,"Odontograma");


}
	
public  void makeTooth() {
    JFrame frame = new JFrame();
    panelDeDientes1=new JPanel();
    panelDeDientes2=new JPanel();
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
 
    
    frame.setTitle("DrawPoly");
    frame.setSize(900, 270);
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
  JPanel contentPane = panelDeDientes1;
    panelDeDientes1.setLayout(new GridLayout(4,16));
    int i=1;
    while (i<=64){
    	if (i<=16){
    	contentPane.add(new JLabel(String.valueOf("      "+i)));
    	i++;
    	}else if (i>32||i<=48){
    		contentPane.add(new JLabel(String.valueOf("      "+(i-16))));
    		i++;
    	}
    	    	
    	while((i>16&&i<=32)||(i>48&&i<=64)){
    		if(i>16&&i<=32){
    			DrawTooth tooth=new DrawTooth(i-16,null,null,null,null,null);
        		tooth. addMouseListener(new MouseListenerGraphic(tooth,this));
        		 contentPane.add(tooth);
        		
        		 i++;
    		}else if(i>48&&i<=64){
    			DrawTooth tooth=new DrawTooth(i-32,null,null,null,null,null);
        		tooth. addMouseListener(new MouseListenerGraphic(tooth,this));
        		 contentPane.add(tooth);
        		
        		 i++;
    		}
    	
    	}
    }
      
	
	for(int z=1;z<64;z++){
		if((z>=16&&z<32)||(z>=48&&z<=64)){
			contentPane.getComponent(z).setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
	}
		
	
	contentPane.setBorder(BorderFactory.createLineBorder(Color.black));
	panelDeDientes2.setLayout(new BoxLayout(panelDeDientes2, BoxLayout.LINE_AXIS));
	panelDeDientes2.add(panelDeDientes1);
	panelDeDientes2.setBorder(BorderFactory.createLineBorder(Color.black));
    checkBox=new CheckBox().CheckBox();
    
	checkBox.setLayout(new BoxLayout(checkBox,BoxLayout.PAGE_AXIS));
	
	frame.add(panelDeDientes2);
	frame.add(checkBox,BorderLayout.EAST);
	frame.add(panelDeBotones,BorderLayout.PAGE_END);
    frame.show();
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
			System.out.print("treuuuuuu");
		}else if((z>=48&&z<=64)){
			if(panelDeDientes1.getComponent(z).isFocusable())
				
				
				paintTooth(z-31,Color.WHITE,Color.WHITE,Color.WHITE,Color.WHITE,Color.WHITE);
			System.out.print("treuuuuuu");
		
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
		panelDeDientes1.repaint();

		
}else{
	panelDeDientes1.remove(panelDeDientes1.getComponent(diente+31));


     	DrawTooth tooth=new DrawTooth(diente,uno,dos,tres,cuatro,cinco);
		tooth.addMouseListener(new MouseListenerGraphic(tooth,this));
		panelDeDientes1.add(tooth,diente+31);
		panelDeDientes1.getComponent(diente+31).setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelDeDientes1.repaint();
		
}
}


@Override
public void actionPerformed(ActionEvent arg0) {
	
	makeTooth();
	
}


}

