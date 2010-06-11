package edu.austral.lab1.odontobook.graphicInterface;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import edu.austral.lab1.odontobook.model.Paciente;
import edu.austral.lab1.odontobook.model.dao.PacienteDao;

public class ListaEvent {
	
	private TabbedPane pane;
	
	public ListaEvent(TabbedPane pane){
		this.pane = pane;
	}

	MouseListener clickListPac = new MouseListener(){


		public void mouseClicked(MouseEvent o) {

			System.out.println("algoo");
JSplitPane split= new JSplitPane(JSplitPane.VERTICAL_SPLIT,pane.getScrollDePaciente(), pane.crearPacientePane());
split.setDividerLocation(200);
			pane.setComponentAt(1,  split);
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

	
	
};


MouseListener clickListDoc = new MouseListener(){


	public void mouseClicked(MouseEvent o) {

		System.out.println("algoo");
		JSplitPane split= new JSplitPane(JSplitPane.VERTICAL_SPLIT,pane.getScrollDeDoctores(), pane.crearDoctorPane());
		split.setDividerLocation(200);

		pane.setComponentAt(0,  split);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



};

}
