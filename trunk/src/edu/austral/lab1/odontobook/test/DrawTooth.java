package edu.austral.lab1.odontobook.test;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Polygon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.GeneralPath;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DrawTooth extends JPanel {
	
	private GeneralPath caraUno;
	private GeneralPath caraDos;
	private GeneralPath caraTres;
	private GeneralPath caraCuatro;
	private GeneralPath caraCinco;
	private Object curCursor;
	private int numeroDeDiente;
	private Graphics2D g2;
	
	public Graphics2D getG2() {
		return g2;
	}


	public void setG2(Graphics2D g2) {
		this.g2 = g2;
	}


	public DrawTooth(int numeroDeDiente){
		
		 caraUno=polygon(10,20,30,40,10,20,20,10);
		 caraDos=polygon(10,20,20,10,10,20,30,40);
		 caraTres=polygon(10,20,30,40,40,30,30,40);
		 caraCuatro=polygon(40,30,30,40,40,30,20,10);
		 caraCinco=polygon(20,30,30,20,20,20,30,30);
		
		this.numeroDeDiente=numeroDeDiente;
	}
	

	   public int getNumeroDeDiente() {
		return numeroDeDiente;
	}


	public void setNumeroDeDiente(int numeroDeDiente) {
		this.numeroDeDiente = numeroDeDiente;
	}


	public GeneralPath getDos() {
		return caraDos;
	}


	public void setDos(GeneralPath dos) {
		this.caraDos = dos;
	}


	public GeneralPath getTres() {
		return caraTres;
	}


	public void setTres(GeneralPath tres) {
		this.caraTres = tres;
	}


	public GeneralPath getCuatro() {
		return caraCuatro;
	}


	public void setCuatro(GeneralPath cuatro) {
		this.caraCuatro = cuatro;
	}


	public GeneralPath getCinco() {
		return caraCinco;
	}


	public void setCinco(GeneralPath cinco) {
		this.caraCinco = cinco;
	}


	public GeneralPath getUno() {
		return caraUno;
	}




	public void setUno(GeneralPath uno) {
		this.caraUno = uno;
	}

	
	public GeneralPath polygon(int x1,int x2, int x3, int x4, int y1, int y2, int y3, int y4){
		  
	    int x1Points[] = {x1, x2, x3, x4};
	    int y1Points[] = {y1, y2, y3, y4};
	   
	    GeneralPath polygon = 
	    	new GeneralPath(GeneralPath.WIND_EVEN_ODD, x1Points.length);
	    polygon.moveTo(x1Points[0], y1Points[0]);

	    for (int index = 1; index < x1Points.length; index++) {
	            polygon.lineTo(x1Points[index], y1Points[index]);
	    };

	    polygon.closePath();
	  
	    return polygon;
	}
	
	
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g2 = (Graphics2D) g;
    
    
    BasicStroke bs1 = new BasicStroke(1, BasicStroke.CAP_ROUND, 
    	     BasicStroke.JOIN_BEVEL);
    	 g2.setStroke(bs1);
    	 
    	 g2.setColor(Color.WHITE);
    	 g2.fill(caraUno);
    	 g2.setColor(Color.BLACK);
         g2.draw(caraUno);

	    	 
    	 g2.setColor(Color.WHITE);
    	 g2.fill(caraDos);
    	 g2.setColor(Color.BLACK);
         g2.draw(caraDos);

	     	 
    	 g2.setColor(Color.WHITE);
    	 g2.fill(caraTres);
    	 g2.setColor(Color.BLACK);
         g2.draw(caraTres);

	     	 
    	 g2.setColor(Color.WHITE);
    	 g2.fill(caraCuatro);
    	 g2.setColor(Color.BLACK);
         g2.draw(caraCuatro);

	     	 
    	 g2.setColor(Color.WHITE);
    	 g2.fill(caraCinco);
    	 g2.setColor(Color.BLACK);
         g2.draw(caraCinco);



  }
  
  
  
  
  

public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setTitle("DrawPoly");
    frame.setSize(700, 250);
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    Container contentPane = frame.getContentPane();
    frame.setLayout(new GridLayout(4,16));
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
    			DrawTooth tooth=new DrawTooth(i-16);
        		tooth. addMouseListener(new MouseListenerGraphic(tooth,frame));
        		 contentPane.add(tooth);
        		
        		 i++;
    		}else if(i>48&&i<=64){
    			DrawTooth tooth=new DrawTooth(i-32);
        		tooth. addMouseListener(new MouseListenerGraphic(tooth,frame));
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
	
    	 
    	
   
    
   

    frame.show();
  }
}
          

