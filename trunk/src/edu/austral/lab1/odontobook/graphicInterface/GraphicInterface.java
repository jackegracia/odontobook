package edu.austral.lab1.odontobook.graphicInterface;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class GraphicInterface {
	private JFrame frame;
	private JPanel panel1;
	private JPanel panel2;
	private JSplitPane splitPanel1;
	private JPanel panel3;
	private JSplitPane splitPanel2;
	private JButton button1;
	private JButton button2;




	public GraphicInterface(){
		makeJframe();
		new MenuBar(this);
		makeJpanel();
		makeButtons();
		calendario cal=new calendario(panel3);
	}



	private void makeJframe() {
		frame=new JFrame();
		frame.setVisible(true);
		frame.setSize(600,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


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

		splitPanel2=new JSplitPane(JSplitPane.VERTICAL_SPLIT,panel1,panel2);
		splitPanel2.setOneTouchExpandable(false);
		splitPanel2.setEnabled(false);
		splitPanel2.setDividerLocation(300);
		splitPanel1=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,splitPanel2,panel3);
		splitPanel1.setOneTouchExpandable(false);
		splitPanel1.setEnabled(false);
		splitPanel1.setDividerLocation(175);
		frame.add(splitPanel1);


	}
	public JPanel getPanel2() {
		return panel2;
	}



	private void makeJtabbedPane() {
		// TODO Auto-generated method stub

	}
	private void makeButtons() {
		button1=new JButton("Dar de baja turno");
		button2=new JButton("Dar de Alta turno");
		panel2.add(button1);
		panel2.add(button2);
	}
}
