package vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import controlador.Controlador;

public class Mainmenu extends JFrame implements MouseMotionListener, MouseListener, ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JButton start;
	
	private VPrincipal a;
	
	private ActionListener q;
	
	public Mainmenu (Controlador q) {
		setSize(660, 510);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.white);
		start = new JButton("Aceptar");
		start.setBounds(80, 155, 150, 50);
		start.addActionListener();
		add(start);
		a = new VPrincipal(q);
		
	}

	public VPrincipal getA() {
		return a;
	}

	public void setA(VPrincipal a) {
		this.a = a;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		
	}
}
