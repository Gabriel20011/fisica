package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.File.*;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;

import controlador.Controlador;

public class MainMenu extends JFrame{
	
private static final long serialVersionUID = 1L;
	
	
	private JButton start;
	private JSpinner anchura, altura;
	private SpinnerModel modeloX, sofia;
	private JLabel bigx;
	private JLabel bigy;
	private VPrincipal a;

	
	private File fbackground;
	
	public MainMenu(Controlador q) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setResizable(false);
		setSize(660, 510);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.white);
		
		fbackground = new File("Imagenes\\menuimg.png");
		setContentPane(new JLabel(new ImageIcon(fbackground.getAbsolutePath())));

			
		bigx = new JLabel("Ingresa un ancho para el plano");
		bigx.setFont(new Font("Serif", Font.ITALIC, 15));
		bigx.setForeground(new Color(175, 239, 247));
		bigx.setBounds(60, 100, 200, 30);
		add(bigx);
		
		modeloX = new SpinnerNumberModel(400, 50, (screenSize.width - 200), 25);
		anchura = new JSpinner(modeloX);
		anchura.setBounds(80, 130, 150, 30);
		add(anchura);
		
		bigy = new JLabel("Ingresa una altura para el plano");
		bigy.setFont(new Font("Serif", Font.ITALIC, 15));
		bigy.setForeground(new Color(175, 239, 247));
		bigy.setBounds(340, 250, 210, 30);
		add(bigy);
		
		sofia = new SpinnerNumberModel(350, 50, (screenSize.height) , 25);
		altura = new JSpinner(sofia);
		altura.setBounds(360, 280, 150, 30);
		add(altura);
		
		start = new JButton("Ingresar");
		start.setFont(new Font("Serif", Font.ITALIC, 15));
		start.setBounds(220, 195, 150, 50);
		start.setBackground(new Color(175, 239, 247));
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
