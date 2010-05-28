package edu.austral.lab1.odontobook.test;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MouseListenerGraphic  extends MouseAdapter{
	
	private JPanel canvas;
	private JFrame frame;


	public MouseListenerGraphic(DrawTooth canvas, JFrame frame){
		this.canvas=canvas;
		this.frame=frame;
	}
	
	
	

	      public void mouseClicked(MouseEvent e) {
	        if(((DrawTooth) canvas).getUno().contains(e.getX(), e.getY())) {
	        	System.out.println("click on shape");
	        Graphics2D g2=	((DrawTooth) canvas).getG2();
	        
	        
	        
	        g2.setColor(Color.RED);
	    	 g2.fill(((DrawTooth) canvas).getUno());
	    	 g2.setColor(Color.BLACK);
	         g2.draw(((DrawTooth) canvas).getUno());
frame.repaint();
	         
	         
	        	
	        } else if(((DrawTooth) canvas).getDos().contains(e.getX(), e.getY())) {
	        	System.out.println("click on shape");
	        } else if(((DrawTooth) canvas).getTres().contains(e.getX(), e.getY())) {
	        	System.out.println("click on shape");
	        	
	        	  Container contentPane = frame.getContentPane();
	        	  DrawTooth can=(DrawTooth) canvas;
	        	  
	        	  int diente= (int) can.getNumeroDeDiente();
	        	  System.out.println(diente);
	        	  if(diente<16){
	        		  contentPane.getComponent(diente+15).setVisible(false);
	        	  }
	        
	        	  
	        	 frame.repaint();
	        	  
	        } else if(((DrawTooth) canvas).getCuatro().contains(e.getX(), e.getY())) {
	        	System.out.println("click on shape");
	        } else if(((DrawTooth) canvas).getCinco().contains(e.getX(), e.getY())) {
	        	System.out.println("click on shape");
	        }else{
	        	System.out.println("click empty");
	        }
	        canvas.repaint();
	      }
	    }

