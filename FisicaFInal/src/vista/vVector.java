package vista;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class vVector extends JFrame {
	
	private panelVector pVector;
	
	public vVector(Point dir) {
		super("Verctor director...");
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
