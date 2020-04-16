package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import controlador.Controlador;

public class MainMenu extends JFrame{
	
private static final long serialVersionUID = 1L;
	
	
	private JButton start;
	private JSpinner anchura, altura;
	private SpinnerModel modeloX, sofia;
	private JLabel bigx;
	private JLabel bigy;
	private VPrincipal a;
	
	public MainMenu(Controlador q) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		setSize(660, 510);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.white);
		
		bigx = new JLabel("Ingresa un ancho para el plano");
		bigx.setBounds(80, 100, 150, 30);
		add(bigx);
		
		modeloX = new SpinnerNumberModel(400, 50, (screenSize.width - 200), 25);
		anchura = new JSpinner(modeloX);
		anchura.setBounds(80, 400, 150, 30);
		add(anchura);
		
		bigy = new JLabel("Ingresa una altura para el plano");
		bigy.setBounds(360, 100, 150, 30);
		add(bigy);
		
		sofia = new SpinnerNumberModel(350, 50, (screenSize.height) , 25);
		altura = new JSpinner(sofia);
		altura.setBounds(360, 400, 150, 30);
		add(altura);
		
		start = new JButton("Ingresar");
		start.setBounds(220, 195, 150, 50);
		start.addActionListener( new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent e)
		    {
				int equis = Integer.parseInt(anchura.getValue().toString());
				int ye = Integer.parseInt(altura.getValue().toString());
				System.out.println(equis);
				System.out.println(ye);
				dispose();
				a = new VPrincipal(q, equis, ye);
		        a.setVisible(true);
		    }
		});
			
		add(start);
		
	}


}
