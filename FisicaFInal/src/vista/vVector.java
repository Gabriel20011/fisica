package vista;

import java.awt.Point;
import javax.swing.JFrame;

public class vVector extends JFrame {
	
	private panelVector pVector;
	
	public vVector(Point dir) {
		super("Vector director...");
		setLocationRelativeTo(null);
		setLayout(null);
		pVector = new panelVector(dir);
		pVector.setBounds(0, 0, 400, 320);
		pVector.setVisible(true);
		add(pVector);
	}

	
	public panelVector getpVector() {
		return pVector;
	}

}
