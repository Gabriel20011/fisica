package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class componentesCampoMagentico {
	
	private JButton calcular;
	private SpinnerModel modeloX, modeloY, sofia;
	private JLabel xLblVel, yLblVel;
	protected JSpinner xVelocidad, yVelocidad;
	private JLabel xLblCampo, yLblCampo;
	protected JSpinner xCampoMagnetico, yCampoMagnetico;
	private JLabel lblCarga;
	private JLabel  lblPorDiez;
	protected JComboBox<Integer> notacion;
	protected JTextArea magnitud;
	private VPrincipal vPrincipal;
	
	public componentesCampoMagentico(VPrincipal vPrincipal, int margenX) {
		this.vPrincipal = vPrincipal;
		
		
		xLblVel = new JLabel("Velocidad en X (m/s)");
		xLblVel.setBounds(margenX, 20 , 200, 50);
		vPrincipal.add(xLblVel);
		
		xVelocidad = new JSpinner();
		xVelocidad.setBounds(margenX, 70, 200, 50);
		vPrincipal.add(xVelocidad);
		
		yLblVel = new JLabel("Velocidad en Y (m/s)");
		yVelocidad = new JSpinner();
		
		xLblCampo = new JLabel("Campo magnetico en X (T)");
		xCampoMagnetico = new JSpinner();
		
		yLblCampo = new JLabel("Campo magnetico en Y (T)");
		yCampoMagnetico = new JSpinner();
		
		lblCarga = new JLabel("Magnitud Carga (c)");
		
		magnitud = new JTextArea();
		
		lblPorDiez = new JLabel("x10"); 
		
		Integer[] exponentes = new Integer[37];
		for (int i = 0; i < exponentes.length; i++) {
			exponentes[i] = -18 + i;
		}
		
		notacion = new JComboBox<Integer>(exponentes);
		notacion.setSelectedIndex(18);
		
		calcular = new JButton("Calcular");
		calcular.setActionCommand("Sofia");
		calcular.addActionListener(vPrincipal);;
		
	}
	public void invisible() {
		calcular.setVisible(false);
		xLblVel.setVisible(false);
		yLblVel.setVisible(false);
		xVelocidad.setVisible(false);
		yVelocidad.setVisible(false);
		xLblCampo.setVisible(false);
		yLblCampo.setVisible(false);
		xCampoMagnetico.setVisible(false);
		yCampoMagnetico.setVisible(false);
		lblCarga.setVisible(false);
		lblPorDiez.setVisible(false);
		notacion.setVisible(false);
		magnitud.setVisible(false); 
	}
	public void visible() {
		calcular.setVisible(true);
		xLblVel.setVisible(true);
		yLblVel.setVisible(true);
		xVelocidad.setVisible(true);
		yVelocidad.setVisible(true);
		xLblCampo.setVisible(true);
		yLblCampo.setVisible(true);
		xCampoMagnetico.setVisible(true);
		yCampoMagnetico.setVisible(true);
		lblCarga.setVisible(true);
		lblPorDiez.setVisible(true);
		notacion.setVisible(true);
		magnitud.setVisible(true); 
	}
	public void cargarSpinners() {
		
	}
}
