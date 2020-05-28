package vista;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
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
	protected JTextField magnitud;
	private VPrincipal vPrincipal;
	private final int margen;
	
	public componentesCampoMagentico(VPrincipal vPrincipal, int margenX) {
		this.vPrincipal = vPrincipal;
		
		this.margen = margenX - 40;
		
		xLblVel = new JLabel("Velocidad en X (m/s)");
		xLblVel.setBounds(margen, 0 , 200, 50);
		vPrincipal.add(xLblVel);
		
		modeloX = new SpinnerNumberModel(value, minimum, maximum, stepSize);
		xVelocidad = new JSpinner(modeloX);
		xVelocidad.setBounds(margen, 50, 200, 50);
		vPrincipal.add(xVelocidad);
		
		yLblVel = new JLabel("Velocidad en Y (m/s)");
		yLblVel.setBounds(margen, 100, 200, 50);
		vPrincipal.add(yLblVel);
		
		yVelocidad = new JSpinner();
		yVelocidad.setBounds(margen, 150, 200, 50);
		vPrincipal.add(yVelocidad);
		
		xLblCampo = new JLabel("Campo magnetico en X (T)");
		xLblCampo.setBounds(margen, 200, 200, 50);
		vPrincipal.add(xLblCampo);
		
		xCampoMagnetico = new JSpinner();
		xCampoMagnetico.setBounds(margen, 250, 200, 50);
		vPrincipal.add(xCampoMagnetico);
		
		yLblCampo = new JLabel("Campo magnetico en Y (T)");
		yLblCampo.setBounds(margen, 300, 200, 50);
		vPrincipal.add(yLblCampo);
		
		yCampoMagnetico = new JSpinner();
		yCampoMagnetico.setBounds(margen, 350, 200, 50);
		vPrincipal.add(yCampoMagnetico);
		
		lblCarga = new JLabel("Carga (c)");
		lblCarga.setBounds(margenX- 80, 400, 200, 50);
		vPrincipal.add(lblCarga);
		
		magnitud = new JTextField();
		magnitud.setBounds(margenX, 412, 50, 25);
		vPrincipal.add(magnitud);
		
		lblPorDiez = new JLabel("x10");
		lblPorDiez.setBounds(margenX + 60, 400, 50, 50);
		vPrincipal.add(lblPorDiez);
		
		Integer[] exponentes = new Integer[37];
		for (int i = 0; i < exponentes.length; i++) {
			exponentes[i] = -18 + i;
		}
		
		notacion = new JComboBox<Integer>(exponentes);
		notacion.setSelectedIndex(18);
		notacion.setBounds(margenX + 100, 410, 45, 30);
		vPrincipal.add(notacion);
		
		calcular = new JButton("Calcular");
		calcular.setActionCommand("Sofia");
		calcular.addActionListener(vPrincipal);
		calcular.setBounds(margenX-40, 460, 200, 30);
		vPrincipal.add(calcular);
		
		invisible();
		
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
