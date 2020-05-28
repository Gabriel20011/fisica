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
	
	protected JButton calcular;
	private SpinnerModel modeloX, modeloY;
	protected JLabel xLblVel, yLblVel;
	protected JSpinner xVelocidad, yVelocidad;
	protected JLabel xLblCampo, yLblCampo;
	protected JSpinner xCampoMagnetico, yCampoMagnetico;
	protected JLabel lblCarga;
	protected JLabel lblInfo, lblPorDiez, lblcoulomb;
	protected JButton btnAceptar;
	protected JComboBox<Integer> notacion;
	protected JTextArea magnitud;
	private VPrincipal vPrincipal;
	
	public componentesCampoMagentico(VPrincipal vPrincipal, int margenX) {
		this.vPrincipal = vPrincipal;
		calcular = new JButton("Calcular");
		calcular.setActionCommand("Sofia");
		calcular.addActionListener(vPrincipal);
		xLblVel = new JLabel();
		yLblVel = new JLabel();
		xVelocidad = new JSpinner();
		yVelocidad = new JSpinner();
		xLblCampo = new JLabel();
		yLblCampo = new JLabel();
		xCampoMagnetico = new JSpinner();
		yCampoMagnetico = new JSpinner();
		lblCarga = new JLabel();
		lblInfo = new JLabel();
		lblPorDiez = new JLabel();
		lblcoulomb = new JLabel();
		btnAceptar = new JButton("Aceptar");
		notacion = new JComboBox<Integer>();
		magnitud = new JTextArea();
		modeloY = new SpinnerNumberModel();
		modeloX = new SpinnerNumberModel();

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
		lblInfo.setVisible(false);
		lblPorDiez.setVisible(false);
		lblcoulomb.setVisible(false);
		btnAceptar.setVisible(false);
		notacion.setVisible(false);
		magnitud.setVisible(false); 
	}
	public void visible() {
		calcular.setVisible(true);
		calcular.addActionListener(vPrincipal);
		xLblVel.setVisible(true);
		yLblVel.setVisible(true);
		xVelocidad.setVisible(true);
		yVelocidad.setVisible(true);
		xLblCampo.setVisible(true);
		yLblCampo.setVisible(true);
		xCampoMagnetico.setVisible(true);
		yCampoMagnetico.setVisible(true);
		lblCarga.setVisible(true);
		lblInfo.setVisible(true);
		lblPorDiez.setVisible(true);
		lblcoulomb.setVisible(true);
		btnAceptar.setVisible(true);
		notacion.setVisible(true);
		magnitud.setVisible(true); 
	}
}
