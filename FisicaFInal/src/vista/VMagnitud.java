package vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class VMagnitud extends JFrame{

	private JLabel lblInfo, lblPorDiez, lblcoulomb;
	private JButton btnAceptar;
	private JComboBox<Integer> notacion;
	private JTextArea magnitud;
	private VPrincipal vPrincipal;

	private Font font1 = new Font("SansSerif", Font.BOLD, 20);

	public VMagnitud (VPrincipal vPrincipal) {

		this.vPrincipal = vPrincipal;

		setSize(330, 243);
		setLayout(null);
		setVisible(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

		lblInfo = new JLabel("Digite la magnitud de carga");
		lblInfo.setBounds(50, 20, 200, 50);
		add(lblInfo);

		btnAceptar =  new JButton("Aceptar");
		btnAceptar.setBounds(80, 155, 150, 50);
		btnAceptar.setActionCommand("AceptarMagnitud");
		btnAceptar.addActionListener(vPrincipal);
		add(btnAceptar);

		iniciarCombo();

		magnitud = new JTextArea();
		magnitud.setBounds(50, 90, 100, 30);
		magnitud.setFont(font1);
		add(magnitud);

		lblPorDiez = new JLabel("x 10^");
		lblPorDiez.setBounds(160, 90, 80, 30);
		lblPorDiez.setFont(font1);
		add(lblPorDiez);
		
		lblcoulomb = new JLabel("C");
		lblcoulomb.setBounds(290, 90, 50, 50);
		lblcoulomb.setFont(font1);
		add(lblcoulomb);

	}

	public void iniciarCombo() {
		Integer[] exponentes = new Integer[37];
		for (int i = 0; i < exponentes.length; i++) {
			exponentes[i] = -18 + i;
		}
		
		notacion = new JComboBox<Integer>(exponentes);
		notacion.setSelectedIndex(18);
		notacion.setBounds(230, 75, 50, 50);
		add(notacion);
	}

	public void reiniciar() {
		magnitud.setText("");
		notacion.setSelectedIndex(18);
	}

	public double enviarMagnitud() {
		try {
			if (notacion.getSelectedItem() != "0") {
				String mg = magnitud.getText()+"E"+notacion.getSelectedItem();
				double mgD = Double.parseDouble(mg);
				if (mgD >= 0) {
					return mgD;
				}
				else {
					return Math.PI;
				}
			}
			else {
				return 1;
			}
			
		} catch (Exception e) {
			return Math.PI;
		}
	}
	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public JComboBox<Integer> getNotacion() {
		return notacion;
	}

	public JTextArea getMagnitud() {
		return magnitud;
	}


}
