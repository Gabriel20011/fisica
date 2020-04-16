package vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controlador.Controlador;

public class Mainmenu extends JFrame implements MouseMotionListener, MouseListener, ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JButton start;
	private JTextField x;
	private JTextField y;
	private JLabel bigx;
	private JLabel bigy;
	private VPrincipal a;
	
	public Mainmenu (Controlador q) {
		setSize(660, 510);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.white);
		
		bigx = new JLabel("Ingresa un ancho para el plano");
		bigx.setBounds(80, 100, 150, 30);
		add(bigx);
		
		x = new JTextField();
		x.setBounds(80, 150, 150, 30);
		add(x);
		
		bigy = new JLabel("Ingresa una altura para el plano");
		bigy.setBounds(360, 100, 150, 30);
		add(bigy);
		
		y = new JTextField();
		y.setBounds(360, 150, 150, 30);
		add(y);
		
		start = new JButton("Ingresar");
		start.setBounds(220, 195, 150, 50);
		start.addActionListener( new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent e)
		    {
				dispose();
				a = new VPrincipal(q);
		        a.setVisible(true);
		    }
		});
			
		add(start);
		
	}

	public VPrincipal getA() {
		return a;
	}

	public void setA(VPrincipal a) {
		this.a = a;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
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

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
