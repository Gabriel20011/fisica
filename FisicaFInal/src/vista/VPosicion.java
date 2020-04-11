package vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class VPosicion extends JFrame {
	
	private final int inicioX, finX;
	private final int inicioY, finY;
	private JLabel lblInfo, lblX, lblY;
	private JSpinner spinnerX, spinnerY;
	private JButton btnAceptar;
	private VPrincipal vPrincipal;
	private JLabel cm1, cm2;
	
	public VPosicion (VPrincipal vPrincipal) {
		
		this.vPrincipal = vPrincipal;
		
		inicioX = -205;
		inicioY = -205;
		finX = 205;
		finY = 205;
		
		setSize(330, 243);
		setLayout(null);
		setVisible(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		lblInfo = new JLabel("Digite las coordenadas en Y y en X");
		lblInfo.setBounds(50, 0, 250, 50);
		add(lblInfo);
		
		lblX = new JLabel("Eje en X");
		lblX.setBounds(80, 60, 150, 30);
		add(lblX);
		
		lblY = new JLabel("Eje en Y");
		lblY.setBounds(80, 100, 150, 30);
		add(lblY);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(80, 155, 150, 50);
		btnAceptar.addActionListener(vPrincipal);
		add(btnAceptar);
		
		cm1 = new JLabel("cm");
		cm1.setBounds(240, 60, 50, 50);
		add(cm1);
		cm2 = new JLabel("cm");
		cm2.setBounds(240, 100, 50, 50);
		add(cm2);
		
		iniciarSpinners();
		
	}
	
	public void iniciarSpinners() {
		SpinnerModel modeloX = new SpinnerNumberModel(0, inicioX, finX, 5);
		SpinnerModel modeloY = new SpinnerNumberModel(0, inicioY, finY, 5);
		
		spinnerX = new JSpinner(modeloX);
		spinnerX.setBounds(180, 60, 50, 30);
		add(spinnerX);
		spinnerY = new JSpinner(modeloY);
		spinnerY.setBounds(180, 100, 50, 30);
		add(spinnerY);
		
		
	}
	
	public void reiniciar() {
		spinnerX.setValue(0);
		spinnerY.setValue(0);
	}

	public JSpinner getSpinnerX() {
		return spinnerX;
	}

	public JSpinner getSpinnerY() {
		return spinnerY;
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}
	

}
