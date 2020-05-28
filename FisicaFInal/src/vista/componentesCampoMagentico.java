package vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerModel;

public class componentesCampoMagentico {
	
	protected JButton calcular;
	protected SpinnerModel modeloX, modeloY;
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
		
		
	}
	
	

}
