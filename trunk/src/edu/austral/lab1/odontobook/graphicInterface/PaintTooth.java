package edu.austral.lab1.odontobook.graphicInterface;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;






import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class PaintTooth extends JPanel {

    public void paintComponent(Graphics g) {
            super.paintComponent(g); 
            Graphics2D g2d = (Graphics2D) g;

            GeneralPath polyline = 
            	new GeneralPath(GeneralPath.WIND_EVEN_ODD, 4);
            polyline.moveTo(10, 10);
            polyline.lineTo(20, 20);
            polyline.lineTo(30, 20);
            polyline.lineTo(40, 10);
            polyline.closePath();
            
            g2d.draw(polyline);
          
           
            g2d.setPaint(Color.BLUE);
            g2d.fill(polyline);
         
         
    }

    public static void main(String[] args) {

        PaintTooth rects = new PaintTooth();
        JFrame frame = new JFrame("Rectangles");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(rects);
        frame.setSize(360, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
