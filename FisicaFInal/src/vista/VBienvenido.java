package vista;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class VBienvenido extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField x;
	private JTextField y;
	private Button next;
	
	public VBienvenido() {
		setSize(750, 400);
		setLayout(new GridLayout(4,3));
		setBackground(Color.blue);
		x = new JTextField();
		y = new JTextField();
		next = new Button("ACEPTAR");
		add(new JLabel());
		add(new JLabel("INGRESE DIMENSIONES DEL MAPA"));
		add(new JLabel());
		add(new JLabel("DIMENSION EN X"));
		add(x);
		add(new JLabel());
		add(new JLabel("DIMENSION EN Y"));
		add(y);
		add(new JLabel());
		add(new JLabel());
		add(next);
		add(new JLabel());		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String ac = e.getActionCommand();
		if(ac.equals("ACEPTAR")) {
			
		}
	}


}
